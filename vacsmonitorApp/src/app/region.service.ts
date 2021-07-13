import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http'
import { Region } from './region';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class RegionService {

  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getRegions(): Observable<Region[]> {
    return this.http.get<Region[]>(`${this.apiServerUrl}/region/all`);
  }

  public addRegion(region: Region): Observable<Region> {
    return this.http.post<Region>(`${this.apiServerUrl}/region/add`,region);
  }

  public getRegion(regionId: number): Observable<Region> {
    return this.http.get<Region>(`${this.apiServerUrl}/region/find/${regionId}`);
  }
}
