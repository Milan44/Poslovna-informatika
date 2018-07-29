import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MatDialog, MatDialogRef } from '@angular/material';

import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import {NgbModal, NgbModalRef, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';

import { FormsModule } from '@angular/forms';


import {BankAccountService} from '../../services/bank-account.service'
import {ClientService} from '../../services/client.service'
import {BankService} from '../../services/bank.service'
import {CurrencyService} from '../../services/currency.service'

import {PlaceService} from '../../services/place.service'
import{CountryService} from '../../services/country.service'

import {AnalyticsService} from '../../services/analytics.service';

import { SuspendAccountComponent } from '../../components/suspend-account/suspend-account.component';
import {AnalyticsOfStatementsService} from '../../services/analytics-of-statements.service'




@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {


  private bankAccounts : any[] = [];
  private clients : any[] = [];
  private banks : any[] = [];
  private places : any[] = [];

  private currencies : any[] = [];
  private countries : any[] = [];

  private accountNumber : any;
  private money : any;
  private dateOfOpening : any;
  private dateOfOpeningSearch: any;
  private selectedClient : any;
  private selectedBank : any;
  private selectedCurrency : any;

  private suspendDialogRef: MatDialogRef<SuspendAccountComponent>;
  private clearingItems : any[] = [];

  private clientTypes = ["fizicko lice", "pravno lice"];

  private client_id : any;
  private client_name : any;
  private client_address : any;
  private client_phone : any;
  private client_fax : any;
  private client_email : any;
  private client_addressForStatements : any;
  private client_emailStatements = false;
  private client_jmbg : any;
  private client_typeOfClient : any;
  private client_residence : any;     // misli se na ID residence
  private client_pib : any;

  private currency_id : any;
  private currency_official_code : any;
  private currency_name : any;
  private currency_domicilna : any;
  private currency_countryID : any;

  private isFizicko = false;

  private startDate : any;
  private endDate : any;
  private selectedBankAccount : any;

  private bank_name: any;
  private bank_code: any;
  private bank_pib: any;
  private bank_address: any;

  private action: string;
  private actionId: number;
  private modalRef: NgbModalRef;
 

  constructor(private router : Router , private modalService: NgbModal, private bankAccountService : BankAccountService, private clientService : ClientService,
              private bankService : BankService, private currencyService: CurrencyService, private countryService:CountryService, private suspendDialog: MatDialog, private placeService : PlaceService,
              private analyticsOfStatementsService :AnalyticsOfStatementsService, private analyticService:AnalyticsService) { }

    

  ngOnInit() {
    
    this.getBankAccounts();
    this.getClients();
    
    this.getBanks();
    this.getCurrencies();
    this.getPlaces();
    this.getCountries();

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

  getCountries(){
    this.countryService.getCountries().subscribe(data=> {   
      this.countries = data;
      console.log(this.currencies);
    });

  }

  getPlaces() {
    this.placeService.getPlaces().subscribe(data=> {   
      this.places = data;
      console.log(this.places);
    });
  }


  openAddBankAccountModal(addBankAccountModal) {

    this.action="Add";
    this.actionId = 0;
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



  deleteClient(clientID : any){
      this.clientService.deleteClient(clientID).subscribe(data=> {
  
        if(data){
          alert("You have successfully deleted a client!");
          this.getClients();

        } else {
          alert("You can't delete this client.");
        }

      });

  }

  openAddClientModal(addClientModal) {

    this.action = "Add"
    this.actionId = 0;

    this.modalService.open(addClientModal).result.then((result) => {
      
    }, (reason) => {
      
    });
    
  }


  addClient() {    

    this.clientService.registerClient(
      {name:this.client_name, address:this.client_address, phone:this.client_phone, fax:this.client_fax, email:this.client_email,
        addressForStatements:this.client_addressForStatements, emailStatements:this.client_emailStatements, jmbg:this.client_jmbg,
        typeOfClient:this.client_typeOfClient, residenceID:this.client_residence, pib:this.client_pib}).subscribe(data => {
      
      if(data){
        alert("You have successfully registered a client!");
        this.getClients();

        this.client_id = null;
        this.client_name = null;
        this.client_address = null;
        this.client_phone = null;
        this.client_fax = null;
        this.client_email = null;
        this.client_addressForStatements = null;
        this.client_emailStatements = false;
        this.client_jmbg = null;
        this.client_typeOfClient = null;
        this.client_residence = null;
        this.client_pib = null;

      } 
      else {
        alert("An error has occurred.");
      }

    });
  }


  selectTypeOfClient(){

    console.log(this.client_typeOfClient);

    if(this.client_typeOfClient === "fizicko"){
      this.isFizicko = true;
      this.client_pib = null;
    }
    else{
      this.isFizicko = false;
    }
  }

  openUpdateClientModal(UpdateClientModal, client) {

    console.log(client);
    this.client_id = client.id;
    this.client_name = client.name;
    this.client_address = client.address;
    this.client_phone = client.phone;
    this.client_fax = client.fax;
    this.client_email = client.email;
    this.client_addressForStatements = client.addressForStatements;
    this.client_emailStatements = client.emailStatements;
    this.client_jmbg = client.jmbg;
    this.client_typeOfClient = client.typeOfClient;
    this.client_residence = client.residence.id;
    this.client_pib = client.pib;

    this.modalService.open(UpdateClientModal).result.then((result) => {
      
    }, (reason) => {
      
    });
    
  }


  updateClient(){
    this.clientService.updateClient(
      {id:this.client_id, name:this.client_name, address:this.client_address, phone:this.client_phone, fax:this.client_fax, email:this.client_email,
        addressForStatements:this.client_addressForStatements, emailStatements:this.client_emailStatements, jmbg:this.client_jmbg,
        typeOfClient:this.client_typeOfClient, residenceID:this.client_residence, pib:this.client_pib}).subscribe(data => {
      
      if(data){
        alert("You have successfully updated a client!");
        this.getClients();

      } 
      else {
        alert("An error has occurred.");
      }

    });
  }

  deleteCurrency(currencyID : any){
    this.currencyService.deleteCurrency(currencyID).subscribe(data=> {

      if(data){
        alert("You have successfully deleted a currency!");
        this.getCurrencies();

      } else {
        alert("You can't delete this currency.");
      }

    });

  }

  openAddCurrencyModal(addCurrencyModal) {

    this.modalService.open(addCurrencyModal).result.then((result) => {
      
    }, (reason) => {
      
    });
    
  }

  openUpdateCurrencyModal(updateCurrencyModal, currency) {

    this.currency_id = currency.id;
    this.currency_official_code = currency.official_code;
    this.currency_name = currency.name;
    this.currency_domicilna = currency.domicilna;
    this.currency_countryID = currency.country.id;

    this.modalService.open(updateCurrencyModal).result.then((result) => {
      
    }, (reason) => {
      
    });
    
  }

  addCurrency() {

    console.log(this.currency_countryID);
    this.currencyService.registerCurrency(
      {name:this.currency_name, official_code:this.currency_official_code, countryID:this.currency_countryID, domicilna:this.currency_domicilna}).subscribe(data => {
      
      if(data){
        alert("You have successfully added a currecny!");
        this.getCurrencies();

        this.currency_id = null;
        this.currency_official_code = null;
        this.currency_name = null;
        this.currency_domicilna = false;
        this.currency_countryID = null;

      } 
      else {
        alert("An error has occurred.");
      }

    });
  }

  updateCurrency() {

    this.currencyService.updateCurrency(
      {id:this.currency_id, name:this.currency_name, official_code:this.currency_official_code, countryID:this.currency_countryID, domicilna:this.currency_domicilna}).subscribe(data => {
      
      if(data){
        alert("You have successfully udpated a currecny!");
        this.getCurrencies();

      } 
      else {
        alert("An error has occurred.");
      }
    });
  }


  getClearingItems() {

    this.analyticsOfStatementsService.getAnalyticsForClearing().subscribe(data=> {   
      this.clearingItems = data;
      console.log(data);
    });
  }

  loadClearingItems() {

    this.clearingItems = [];
    this.getClearingItems();
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


  openExportXmlModal(exportXmlModal, account) {

    this.selectedBankAccount = account;
    this.modalService.open(exportXmlModal).result.then((result) => {
      
    }, (reason) => {
      
    });
    
  }

  exportXML(){
    let startDateModified = ""+this.startDate.year + "-";
    if(this.startDate.month<10)
    startDateModified += "0"+this.startDate.month + "-";
    else
    startDateModified += this.startDate.month + "-";

    if(this.startDate.day<10)
    startDateModified += "0"+this.startDate.day;
    else
    startDateModified += this.startDate.day;


    let endDateModified = ""+this.endDate.year + "-";
    if(this.endDate.month<10)
    endDateModified += "0"+this.endDate.month + "-";
    else
    endDateModified += this.endDate.month + "-";

    if(this.endDate.day<10)
    endDateModified += "0"+this.endDate.day;
    else
    endDateModified += this.endDate.day;

    this.bankAccountService.exportBankAccountXml(
      startDateModified,endDateModified, this.selectedBankAccount).subscribe(data => {
      
      if(data){
        alert("You have successfully added a currecny!");
        this.getCurrencies();

        this.currency_id = null;
        this.currency_official_code = null;
        this.currency_name = null;
        this.currency_domicilna = false;
        this.currency_countryID = null;

      } 
      else {
        alert("An error has occurred.");
      }

    });
  }

  openSearchBankAccountModal(modal){
    this.action = "Search"
    this.actionId = 1;
    this.modalRef = this.modalService.open(modal);
  }

  searchBankAccount(){
    this.modalRef.close();

    this.bankAccountService.searchBankAccount({accountNumber:this.accountNumber, money: this.money,
    clientID:this.selectedClient, bankID:this.selectedBank, currencyID:this.selectedCurrency}).subscribe(data => this.bankAccounts = data);

    this.accountNumber = null;
    this.money = null;   
    this.selectedClient = null;
    this.selectedBank = null;
    this.selectedCurrency = null;

  }
  resetSearchBankAccount(){
    this.getBankAccounts(); 
  }

  openSarchClientsModal(modal){
    this.action = "Search"
    this.actionId = 1;
    this.modalRef = this.modalService.open(modal);
  }

  searchClient(){
    this.modalRef.close();

    this.clientService.searchClient(
      {name:this.client_name, address:this.client_address, phone:this.client_phone, fax:this.client_fax, email:this.client_email,
        addressForStatements:this.client_addressForStatements, emailStatements:this.client_emailStatements, jmbg:this.client_jmbg,
        typeOfClient:this.client_typeOfClient, residenceID:this.client_residence, pib:this.client_pib}).subscribe(data=>{
          this.clients = data;
        });

        this.client_id = null;
        this.client_name = null;
        this.client_address = null;
        this.client_phone = null;
        this.client_fax = null;
        this.client_email = null;
        this.client_addressForStatements = null;
        this.client_emailStatements = false;
        this.client_jmbg = null;
        this.client_typeOfClient = null;
        this.client_residence = null;
        this.client_pib = null;
  }

  resetSarchClientsModal(){
    this.getClients();
  }

  openSearchBankModal(modal){
    this.action = "Search";
    this.actionId = 1;
    this.modalRef = this.modalService.open(modal);
  }

  searchBank(){

    this.modalRef.close();

    this.bankService.searchBanks({bankCode: this.bank_code, pib:this.bank_pib, name: this.bank_name, address: this.bank_address}).subscribe(data => {
      this.banks = data;
    });

    this.bank_code = null;
    this.bank_pib = null;
    this.bank_address = null;
    this.bank_name = null;
  }

  resetSearchBank(){
    this.getBanks();
  }
}
