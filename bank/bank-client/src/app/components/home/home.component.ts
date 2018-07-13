import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MatDialog, MatDialogRef } from '@angular/material';

import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';

import { FormsModule } from '@angular/forms';

import { SuspendAccountComponent } from '../../components/suspend-account/suspend-account.component';
import {BankAccountService} from '../../services/bank-account.service';
import {ClientService} from '../../services/client.service';
import {BankService} from '../../services/bank.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {


  private bankAccounts : any[] = [];
  private clients : any[] = [];
  private banks : any[] = [];
  private suspendDialogRef: MatDialogRef<SuspendAccountComponent>;


  constructor(private router : Router , private modalService: NgbModal, private bankAccountService : BankAccountService, private clientService : ClientService, private bankService : BankService, private suspendDialog: MatDialog) { }

  ngOnInit() {

    this.getBankAccounts();
    this.getClients();
    this.getBanks();

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
}
