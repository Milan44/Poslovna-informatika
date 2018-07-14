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
export class CurrencyService {

  constructor(private http: Http) { }

  getCurrencies(){

    const headers = new Headers();
    headers.append('Content-Type', 'application/json');

    return this.http.get("http://localhost:8080/public/currencies/getAll", {headers:headers}).map(data => data.json())

    .catch((err:HttpErrorResponse) =>
    {
        return Observable.throw(err);
    });
  
  }

  registerCurrency(currencyDTO : any) {

    console.log(currencyDTO.id);
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http.post('http://localhost:8080/public/currencies/registerCurrency', 
      JSON.stringify(currencyDTO), { headers : headers }).map((data : Response) => data.json());
  }

  updateCurrency(currencyDTO : any) {

    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http.put('http://localhost:8080/public/currencies/updateCurrency', 
      JSON.stringify(currencyDTO), { headers : headers }).map((data : Response) => data.json());

  }

  deleteCurrency(currencyID : any) {  
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');

    return this.http.delete("http://localhost:8080/public/currencies/deleteCurrency/"+
    currencyID,
    {headers:headers})
    .map((data) => data.json())
    .catch((err:HttpErrorResponse) =>
    {
        alert(err.status + " " + err.error.error + " \n" + err.error.message);
        return Observable.throw(err);
    });

  }

}
