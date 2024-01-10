import { Component, OnInit } from '@angular/core';
import { MapService, Event, DisasterData } from '../map.service'; // Import necessary interfaces

@Component({
  selector: 'app-maps',
  templateUrl: './maps.component.html',
  styleUrls: ['./maps.component.css']
})

export class MapsComponent implements OnInit {
  disasters: Event[] = []; // Assuming Event interface is defined in map.service

  constructor(private mapService: MapService) {}

  ngOnInit() {
    this.mapService.initMap();

    // Fetch disasters data from the map service
    this.mapService.getDisasters().subscribe(
      (data: DisasterData) => {
        this.disasters = data.events; // Assigning events to the disasters array
      },
      (error) => {
        console.error('Error fetching disaster data:', error);
      }
    );
  }
}
