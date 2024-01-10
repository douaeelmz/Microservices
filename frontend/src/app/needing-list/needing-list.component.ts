import { Component, OnInit } from '@angular/core';
import { NeedingService } from '../needing.service';

@Component({
  selector: 'app-needings-list',
  templateUrl: './needing-list.component.html',
  styleUrls: ['./needing-list.component.css']
})
export class NeedingListComponent implements OnInit {
  needings: any[] = []; // Define an array to store fetched needings

  constructor(private needingService: NeedingService) { }

  ngOnInit(): void {
    // Fetch needings when component initializes
    this.fetchNeedings();
  }

  fetchNeedings(): void {
    this.needingService.getAllNeedings().subscribe(
      (data) => {
        this.needings = data; // Assign fetched needings to the needings array
      },
      (error) => {
        console.error('Error fetching needings:', error);
      }
    );
  }
}
