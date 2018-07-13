import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import {Http, Response, Headers } from "@angular/http";
import { HttpHeaders, HttpClient, HttpErrorResponse, HttpParams  } from '@angular/common/http';

import {Account} from '../models/Account'

@Injectable()
export class SuspendAccountService {

    accoutns: Account[];

    constructor(private httpClient: HttpClient, private http: Http) { }

    public getClientAccounts(id:any, account: any){
        return this.httpClient.get<Account[]>("http://localhost:8080/public/bankAccounts/getClientAccounts/"+id + "/" + account)        
    }
    
    public suspendAccount(account:any, accountTransfer: any){
        return this.httpClient.delete<Account[]>("http://localhost:8080/public/bankAccounts/suspendAccount/" + account + "/" + accountTransfer);
    }
}