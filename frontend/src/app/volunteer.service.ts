import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VolunteerService {
  private baseUrl = 'http://localhost:8083'; // Replace with your backend URL
  
  constructor(private http: HttpClient) { }
  
  // POST request to add a new volunteer
  addVolunteer(volunteerData: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/volunteers`, volunteerData);
  }
  
  // GET request to fetch all volunteers
  getAllVolunteers(): Observable<any> {
    return this.http.get(`${this.baseUrl}/volunteers`);
  }
}
