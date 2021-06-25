import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class MyAuthInterceptor implements HttpInterceptor {

  constructor() {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler)
  :Observable<HttpEvent<unknown>> {
//récupération du jeton:             
let token = sessionStorage.getItem('authToken');

//ajout du jeton dans le champ Authorization 
//de l'entête de la requête HTTP enrichie
//selon les spécifications "Bearer token" du protocole HTTP :
const authReq = request.clone({headers: 
       request.headers.set('Authorization', 'Bearer ' + token)});
return next.handle(authReq);
}
}
