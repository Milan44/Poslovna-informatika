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
import {ClientService} from '../app/services/client.service';
import { SuspendAccountService } from './services/suspend-account.service';
import { LoginComponent } from './components/login/login.component'

import { UserService } from './services/user.service';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    SuspendAccountComponent,
    LoginComponent
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
  entryComponents: [SuspendAccountComponent],
  providers: [BankAccountService, ClientService, SuspendAccountService, UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
