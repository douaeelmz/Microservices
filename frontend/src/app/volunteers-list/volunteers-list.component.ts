import { Component, OnInit } from '@angular/core';
import { VolunteerService } from '../volunteer.service'; // Import your service

@Component({
  selector: 'app-volunteer-list',
  templateUrl: './volunteers-list.component.html',
  styleUrls: ['./volunteers-list.component.css']
})
export class VolunteersListComponent implements OnInit {
  volunteers: any[] = []; // Define the array to hold volunteer data

  constructor(private volunteerService: VolunteerService) { }

  ngOnInit(): void {
    // Call the service method to fetch volunteers upon component initialization
    this.getVolunteers();
  }

  getVolunteers(): void {
    // Assuming your service has a method called 'getVolunteers()' that returns volunteer data
    this.volunteerService.getAllVolunteers().subscribe(
      (data: any[]) => {
        this.volunteers = data; // Assign the fetched volunteer data to the local array
      },
      (error) => {
        console.error('Error fetching volunteers:', error);
        // Handle error fetching data
      }
    );
  }
}
