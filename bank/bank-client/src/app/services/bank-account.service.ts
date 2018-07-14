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
export class BankAccountService {

  constructor(private http: Http) { }


  getBankAccounts(){

    const headers = new Headers();
    headers.append('Content-Type', 'application/json');

    return this.http.get("http://localhost:8080/public/bankAccounts/getAll", {headers:headers}).map(data => data.json())

    .catch((err:HttpErrorResponse) =>
    {
        return Observable.throw(err);
    });
  
  }

  exportAccount(bank){
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');

    return this.http.get("http://localhost:8080/public/bankAccounts/pdf/" + bank.id, {headers:headers});
  }
  
  // .map(data:Response => data.json()

  registerBankAccount(bankAccountDTO : any) {
    console.log(bankAccountDTO);
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http.post('http://localhost:8080/public/bankAccounts/registerBankAccount', 
      JSON.stringify(bankAccountDTO), { headers : headers }).map((data : Response) => data.json());

  }

}
