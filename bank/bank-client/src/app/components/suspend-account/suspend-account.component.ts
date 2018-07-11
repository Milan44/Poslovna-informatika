import { Component, OnInit } from '@angular/core';
import { SuspendAccountService } from '../../services/suspend-account.service'
import { Account } from '../../models/Account';


@Component({
  selector: 'app-suspend-account',
  templateUrl: './suspend-account.component.html',
  styleUrls: ['./suspend-account.component.css']
})
export class SuspendAccountComponent implements OnInit {

  client: any;
  accounts: Account[];

  constructor(private suspendAccountService: SuspendAccountService) { }

  ngOnInit() {
    this.client = localStorage.getItem("client");
    console.log("Id klenta je: " + this.client);
    this.suspendAccountService.getClientAccounts(this.client).subscribe(data => {
      this.accounts = data;
      console.log(this.accounts);
    });
  }

}
