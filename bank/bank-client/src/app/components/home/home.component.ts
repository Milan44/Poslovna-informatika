import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MatDialog, MatDialogRef } from '@angular/material';

import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';

import { FormsModule } from '@angular/forms';


import {BankAccountService} from '../../services/bank-account.service'
import {ClientService} from '../../services/client.service'
import {BankService} from '../../services/bank.service'
import {CurrencyService} from '../../services/currency.service'
import {AnalyticsService} from '../../services/analytics.service';

import { SuspendAccountComponent } from '../../components/suspend-account/suspend-account.component';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {


  private bankAccounts : any[] = [];
  private clients : any[] = [];
  private banks : any[] = [];

  private currencies : any[] = [];

  private accountNumber : any;
  private money : any;
  private dateOfOpening : any;
  private selectedClient : any;
  private selectedBank : any;
  private selectedCurrency : any;

  private suspendDialogRef: MatDialogRef<SuspendAccountComponent>;




  constructor(private router : Router , private modalService: NgbModal, private bankAccountService : BankAccountService, private clientService : ClientService,
              private bankService : BankService, private currencyService: CurrencyService, private suspendDialog: MatDialog, private analyticService: AnalyticsService) { }



  ngOnInit() {

    this.getBankAccounts();
    this.getClients();
    this.getBanks();

    this.getCurrencies();

    const today = new Date();
    const dd = today.getDate();
    const mm = today.getMonth() + 1; // January is 0!
    const yyyy = today.getFullYear();
    this.dateOfOpening = {year: yyyy, month: mm, day: dd};



  }

  getBankAccounts() {
    this.bankAccountService.getBankAccounts().subscribe(data=> {   
      this.bankAccounts = data;
      console.log(this.bankAccounts);
    });
  }

  getClients() {
    this.clientService.getClients().subscribe(data=> {   
      this.clients = data;
      console.log(this.clients);
    });
  }

  getBanks() {
    this.bankService.getBanks().subscribe(data=> {   
      this.banks = data;
      console.log(this.banks);
    });
  }


  getCurrencies() {
    this.currencyService.getCurrencies().subscribe(data=> {   
      this.currencies = data;
      console.log(this.currencies);
    });
  }


  openAddBankAccountModal(addBankAccountModal) {

    this.modalService.open(addBankAccountModal).result.then((result) => {
      
    }, (reason) => {
      
    });
    
  }

  addBankAccount() {

    let date = ""+this.dateOfOpening.year + "-";
    if(this.dateOfOpening.month<10)
      date += "0"+this.dateOfOpening.month + "-";
    else
      date += this.dateOfOpening.month + "-";

    if(this.dateOfOpening.day<10)
      date += "0"+this.dateOfOpening.day;
    else
      date += this.dateOfOpening.day;

    console.log(date);

    // let bankAccountDTO = {accountNumber:this.accountNumber+"", money: this.money, valid:true, dateOfOpening:date, client:this.selectedClient, bank:this.selectedBank, currency:this.selectedCurrency}
    this.bankAccountService.registerBankAccount({accountNumber:this.accountNumber+"", money: this.money, valid:true, dateOfOpening:date, clientID:this.selectedClient, bankID:this.selectedBank, currencyID:this.selectedCurrency}).subscribe(data => {
      
      if(data){
        alert("You have successfully registered an account!");
        this.getBankAccounts();
      } 
      else {
        alert("An error has occurred.");
      }

     
      
    });
  }



  suspend(account) {

    console.log(account);
    localStorage.setItem("client", account.client.id);
    localStorage.setItem("account", account.id);

    this.suspendDialogRef = this.suspendDialog.open(SuspendAccountComponent, {
      height: '200px',
      width: '400px',
    });
  }

  logout() {

    this.router.navigateByUrl('/login');
  }

  // NOVO
  exportAccount(bank){
    this.bankAccountService.exportAccount(bank).subscribe( data => {
    console.log(data);
    });
  }
  // NOVO

  getAnalytics(){
    let putanja = document.getElementById("putanjaInput") as HTMLInputElement;
    console.log(putanja.value);
    this.analyticService.loadAnalytics(putanja.value).subscribe( data => {
      console.log(data);
    });
  }

}
