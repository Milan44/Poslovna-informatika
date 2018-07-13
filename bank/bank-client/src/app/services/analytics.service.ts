import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import {Http, Response, Headers } from "@angular/http";
import { HttpHeaders, HttpClient, HttpErrorResponse, HttpParams  } from '@angular/common/http';

@Injectable()
export class AnalyticsService {

    accoutns: Account[];

    constructor(private httpClient: HttpClient, private http: Http) { }

    loadAnalytics(putanja: any){

        const headers = new Headers();
        headers.append('Content-Type', 'application/json');

        console.log("PUANJA JE:::" + putanja);

        console.log("Salje zahtev na server")
        return this.http.post("http://localhost:8080/public/analytics/load/", putanja , {headers:headers}).map(data => data.json());
    }
  
}