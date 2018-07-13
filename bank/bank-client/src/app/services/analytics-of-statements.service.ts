import { Injectable } from '@angular/core';

import { Observable } from 'rxjs/Observable';


import {Http, Headers } from "@angular/http";
import {HttpErrorResponse} from '@angular/common/http';

import 'rxjs/Rx'


import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/toPromise';
@Injectable()
export class AnalyticsOfStatementsService {

  constructor(private http: Http) { }

  getAnalyticsForClearing(){

    const headers = new Headers();
    headers.append('Content-Type', 'application/json');

    return this.http.get("http://localhost:8080/analytics/getAllForClearing", {headers:headers}).map(data => data.json())

    .catch((err:HttpErrorResponse) =>
    {
        return Observable.throw(err);
    });
  
  }
}
