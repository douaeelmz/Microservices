import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class NeedingService {
  private baseUrl = 'http://localhost:8082/needing'; // Adjust URL as per your backend

  constructor(private http: HttpClient) {}

  createNeeding(needingData: any): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}`, needingData);
  }

  getNeedingById(id: number): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/${id}`);
  }

  getAllNeedings(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}`);
  }

  updateNeeding(id: number, needingData: any): Observable<any> {
    return this.http.put<any>(`${this.baseUrl}/${id}`, needingData);
  }

  deleteNeedingById(id: number): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/delete/${id}`);
  }
}
