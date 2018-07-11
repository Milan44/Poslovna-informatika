import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MatDialog, MatDialogRef } from '@angular/material';

import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';

import { FormsModule } from '@angular/forms';

import { SuspendAccountComponent } from '../../components/suspend-account/suspend-account.component';
import {BankAccountService} from '../../services/bank-account.service'
import {ClientService} from '../../services/client.service'

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {


  private bankAccounts : any[] = [];
  private clients : any[] = [];
  private suspendDialogRef: MatDialogRef<SuspendAccountComponent>;


  constructor(private router : Router , private modalService: NgbModal, private bankAccountService : BankAccountService, private clientService : ClientService, private suspendDialog: MatDialog) { }

  ngOnInit() {

    this.getBankAccounts();
    this.getClients();

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
  suspend(account) {

    console.log(account);
    var countryId = localStorage.setItem("client", account.client.id)
    this.suspendDialogRef = this.suspendDialog.open(SuspendAccountComponent, {
      height: '200px',
      width: '400px',
    });
  }
}
