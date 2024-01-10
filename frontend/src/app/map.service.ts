import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

declare const maplibregl: any; // Import Mapbox library

export interface Geometry {
  coordinates: [number, number];
}

export interface Event {
  title: string;
  geometries: Geometry[];
}

export interface DisasterData {
  events: Event[];
}


@Injectable({
  providedIn: 'root',
})
export class MapService {
  private map: any;

  constructor(private http: HttpClient) {}

  initMap() {
    const key = '0W9jYNITUhwWML3M9EUO';

    this.map = new maplibregl.Map({
      container: 'map',
      style: `https://api.maptiler.com/maps/basic-v2/style.json?key=${key}`,
      center: [0.11, 51.49],
      zoom: 2,
    });

    this.fetchDataAndCreateMarkers('https://eonet.gsfc.nasa.gov/api/v2.1/categories/8?status=open', 'assets/images/fire-station.png');
    this.fetchDataAndCreateMarkers('https://eonet.gsfc.nasa.gov/api/v2.1/categories/12?status=open', 'assets/images/earthquake.png');
    this.fetchDataAndCreateMarkers('https://eonet.gsfc.nasa.gov/api/v2.1/categories/10?status=open', 'assets/images/storm.png');
  }

  getMap() {
    return this.map;
  }

  getDisasters(): Observable<DisasterData> {
    const apiUrl = 'https://eonet.gsfc.nasa.gov/api/v2.1/events';

    return this.http.get<DisasterData>(apiUrl);
  }

  private fetchDataAndCreateMarkers(categoryApi: string, markerImage: string) {
    this.getDisasters().subscribe(
      (data: DisasterData) => {
        const events = data.events;

        events.forEach(event => {
          const geometries = event.geometries;

          geometries.forEach((geometry: Geometry) => {
            const coordinates = geometry.coordinates;

            const marker = new maplibregl.Marker({
              element: this.createCustomMarker(markerImage, event.title),
            })
              .setLngLat(coordinates)
              .setPopup(new maplibregl.Popup().setHTML(`<b>${event.title}</b><br><a href="#"  style="color: black; margin: 0 10px;" onclick="openForm('${event.title}', 'volunteer')">Volunteer</a> | <a style="color: black; margin: 0 10px;" href="#" onclick="openForm('${event.title}', 'offer')">Offer</a>`))
              .addTo(this.map);
          });
        });
      },
      (error) => {
        console.error(`Error fetching data from EONET API (${categoryApi}):`, error);
      }
    );
  }

  private createCustomMarker(imagePath: string, title: string) {
    const customMarker = document.createElement('div');
    customMarker.innerHTML = `<img src="${imagePath}" alt="Custom Marker">`;
    customMarker.style.width = '25px';
    customMarker.style.height = '25px';
    customMarker.setAttribute('data-title', title);

    return customMarker;
  }
}
