import { Injectable } from '@angular/core';

import { Observable } from 'rxjs/Observable';


import {Http, Response, Headers } from "@angular/http";

import { BehaviorSubject } from 'rxjs/BehaviorSubject';

import 'rxjs/Rx'


import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/toPromise';
import { HttpHeaders, HttpClient, HttpErrorResponse, HttpParams  } from '@angular/common/http';

@Injectable()
export class ClientService {

  constructor(private http: Http) { }


  getClients(){

    const headers = new Headers();
    headers.append('Content-Type', 'application/json');

    return this.http.get("http://localhost:8080/public/clients/getAll", {headers:headers}).map(data => data.json())

    .catch((err:HttpErrorResponse) =>
    {
        return Observable.throw(err);
    });
  
  }

  registerClient(clientDTO : any) {

    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http.post('http://localhost:8080/public/clients/registerClient', 
      JSON.stringify(clientDTO), { headers : headers }).map((data : Response) => data.json());
  }

  updateClient(client : any) {

    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http.put('http://localhost:8080/public/clients/updateClient', 
      JSON.stringify(client), { headers : headers }).map((data : Response) => data.json());

  }

  deleteClient(clientID : any) {  
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');

    return this.http.delete("http://localhost:8080/public/clients/deleteClient/"+
    clientID,
    {headers:headers})
    .map((data) => data.json())
    .catch((err:HttpErrorResponse) =>
    {
        alert(err.status + " " + err.error.error + " \n" + err.error.message);
        return Observable.throw(err);
    });

  }

}
