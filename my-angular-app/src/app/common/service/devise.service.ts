import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Devise } from '../data/devise';

@Injectable({
  providedIn: 'root'
})
export class DeviseService {

  //private _apiBaseUrl ="http://localhost:8585/serverRest/devise-api-rest/public/devise"; 
  private _apiBaseUrl ="./devise-api-rest/public/devise"; //with ng serve --proxy-config proxy.conf.json

  constructor(private http : HttpClient) { }

  searchDeviseByCode$(code: string): Observable<Devise>{
    let url = this._apiBaseUrl + "/" +code ;
     console.log( "in searchDeviseByCode , url = " + url);
    return this.http.get<Devise>(url);
  }
}
