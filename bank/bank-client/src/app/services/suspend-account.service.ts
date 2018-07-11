import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import {Http, Response, Headers } from "@angular/http";
import { HttpHeaders, HttpClient, HttpErrorResponse, HttpParams  } from '@angular/common/http';

import {Account} from '../models/Account'

@Injectable()
export class SuspendAccountService {

    accoutns: Account[];

    constructor(private httpClient: HttpClient, private http: Http) { }

    public getClientAccounts(id:any){

      //  const headers = new Headers();
       // headers.append('Content-Type', 'application/json');
    
        return this.httpClient.get<Account[]>("http://localhost:8080/public/bankAccounts/getClientAccounts/"+id)        

    /*const headers = new Headers();
    headers.append('Content-Type', 'application/json');

    return this.http.get("http://localhost:8080/public/bankAccounts/getClientAccounts/"+ id , {headers:headers}).map(data => data.json())

    .catch((err:HttpErrorResponse) =>
    {
        return Observable.throw(err);
    });*/
  
  }
    
}