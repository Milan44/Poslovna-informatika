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


import { UserService } from './services/user.service';

import {AnalyticsOfStatementsService} from './services/analytics-of-statements.service';
import { AnalyticsService } from './services/analytics.service'
import { PlaceService } from './services/place.service'
import { CountryService } from './services/country.service';
import { UploadFileService } from './services/upload.service';
import { UploadComponent } from './components/upload/upload.component'
import { FormUploadComponent } from './components/form-upload/form-upload.component';
import { DetailUploadComponent } from './components/detail-upload/detail-upload.component';



@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    SuspendAccountComponent,
    LoginComponent,
    UploadComponent,
    FormUploadComponent,
    DetailUploadComponent,
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


  providers: [BankAccountService, ClientService, BankService, CurrencyService, SuspendAccountService, UserService, AnalyticsService, AnalyticsOfStatementsService,
     PlaceService,CountryService, UploadFileService],


  entryComponents: [SuspendAccountComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }
