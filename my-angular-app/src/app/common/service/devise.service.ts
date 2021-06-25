import { map } from 'rxjs/operators';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Devise } from '../data/devise';


export interface ConvertResult {
  source :string; //ex: "EUR",
  target :string; //ex: "USD",
  amount :number; //ex: 200.0
  result :number; //ex: 217.3913
};


@Injectable({
  providedIn: 'root'
})
export class DeviseService {

 //private _apiBaseUrl =//private _apiBaseUrl ="http://localhost:8585/serverRest/devise-api-rest"; 

 private _apiBaseUrl ="./devise-api-rest"; 
 // with prefix in proxy.conf.json 
 // (ng serve --proxy-config proxy.conf.json)
 // or other config in production mode

  constructor(private _http : HttpClient){}

  searchDeviseByCode$(code: string): Observable<Devise>{
    let url = this._apiBaseUrl + "/public/devise/" +code ;
     console.log( "in searchDeviseByCode , url = " + url);
    return this._http.get<Devise>(url);
  }

  public getAllDevises$() : Observable<Devise[]>{
    let url = this._apiBaseUrl + "/public/devise" ;
    console.log("url = " + url);
    return this._http.get<Devise[]>(url);
  }

  public convertir$(montant: number,
                   codeDeviseSrc : string, 
                   codeDeviseTarget : string
                   ) : Observable<number> {

      const params = new HttpParams()
                      .set('amount', montant.toString())
                      .set('source', codeDeviseSrc)
                      .set('target', codeDeviseTarget);
      let url = this._apiBaseUrl 
             + `/public/devise/conversion?${params.toString()}`;
      //console.log("url = " + url);
      return this._http.get<ConvertResult>(url)
            .pipe(
              map( (res:ConvertResult) => res.result)
            );
  }

  public deleteDeviseServerSide$(deviseCode:string):Observable<any>{
    let url = this._apiBaseUrl + "/private/devise/" + deviseCode ;
    console.log("deleteUrl=" + url );
    return this._http.delete(url);
  }
}

