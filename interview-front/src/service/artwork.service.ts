import {Injectable, OnInit} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from '../environments/environment.development';
import {Observable} from 'rxjs';
import {ArtWork, ArtWorkList} from '../types/artwork';

@Injectable({
  providedIn: 'root'
})
export class ArtworkService{


  httpOptions = new HttpHeaders({
    'Authorization': environment.backend_auth
  });
  constructor(private http: HttpClient) {}
  getArtWorkById(id: number): Observable<ArtWork> {
    return this.http.get<ArtWork>(environment.backend_baseUrl + `/${id}`, {
      headers: this.httpOptions
    });
  }
  getArtWorks(pageNumber: number): Observable<ArtWorkList> {
    return this.http.get<ArtWorkList>(environment.backend_baseUrl, {
      headers: this.httpOptions,
      params: {
        page: pageNumber
      }
    });
  }
  findArtWork(query: string, pageNumber: number): Observable<ArtWorkList> {
    return this.http.get<ArtWorkList>(environment.backend_baseUrl + "/search/" + query, {
      headers: this.httpOptions,
      params: {
        page: pageNumber
      }
    });
  }
}
