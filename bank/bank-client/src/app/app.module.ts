import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { routing } from './app.routing';
import { MatDialogModule } from '@angular/material';  
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { SuspendAccountComponent } from './components/suspend-account/suspend-account.component'

import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import { HttpModule } from '@angular/http';


import { FormsModule } from '@angular/forms';

import {BankAccountService} from '../app/services/bank-account.service'

import {ClientService} from '../app/services/client.service'
import {BankService} from '../app/services/bank.service'
import {CurrencyService} from '../app/services/currency.service'

import { SuspendAccountService } from './services/suspend-account.service';
import { LoginComponent } from './components/login/login.component'
import { AnalyticsComponent } from './components/analytics/analytics.component'


import { UserService } from './services/user.service';
import { AnalyticsService } from './services/analytics.service'
import { PlaceService } from './services/place.service'
import { CountryService } from './services/country.service'

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    SuspendAccountComponent,
    LoginComponent,
    AnalyticsComponent
  ],
  imports: [
    BrowserAnimationsModule,
    MatDialogModule,
    BrowserModule,
    routing,
    NgbModule.forRoot(),
    HttpModule,
    FormsModule,
    HttpClientModule
  ],

  providers: [BankAccountService, ClientService, BankService, CurrencyService, SuspendAccountService, UserService, AnalyticsService, PlaceService,CountryService],

  entryComponents: [SuspendAccountComponent],


  bootstrap: [AppComponent]
})
export class AppModule { }
