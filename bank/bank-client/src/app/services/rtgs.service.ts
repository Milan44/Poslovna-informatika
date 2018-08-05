import { Injectable } from '@angular/core';
import {Http, Response, Headers} from "@angular/http";
import { Observable } from 'rxjs/Observable';

import {HttpErrorResponse} from '@angular/common/http';

import 'rxjs/Rx'


import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/toPromise';

@Injectable()
export class RtgsService {

  constructor(private http: Http) { }

  getRtgs() {
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');

    return this.http.get("http://localhost:8080/rtgs/getAll", {headers:headers}).map(data => data.json())

    .catch((err:HttpErrorResponse) =>
    {
        return Observable.throw(err);
    });
  
  }
  
}
