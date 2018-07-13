import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { routing } from './app.routing';

import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';

import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import { HttpModule } from '@angular/http';


import { FormsModule } from '@angular/forms';

import {BankAccountService} from '../app/services/bank-account.service'
import {ClientService} from '../app/services/client.service'
import {BankService} from '../app/services/bank.service'
import {CurrencyService} from '../app/services/currency.service'


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    routing,
    NgbModule.forRoot(),
    HttpModule,
    FormsModule
  ],
  providers: [BankAccountService, ClientService, BankService, CurrencyService],
  bootstrap: [AppComponent]
})
export class AppModule { }
