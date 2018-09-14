import { Component, OnInit } from '@angular/core';
import { SuspendAccountService } from '../../services/suspend-account.service'
import { Account } from '../../models/Account';
import { Router } from '@angular/router';


@Component({
  selector: 'app-suspend-account',
  templateUrl: './suspend-account.component.html',
  styleUrls: ['./suspend-account.component.css']
})
export class SuspendAccountComponent implements OnInit {

  client: any;
  accounts: Account[];
  account: any;

  constructor(private suspendAccountService: SuspendAccountService, private router: Router) { }

  ngOnInit() {
    this.client = localStorage.getItem("client");
    console.log("Id klenta je: " + this.client);

    this.account = localStorage.getItem("account");
    console.log("Id accounta za brisanje je: " + this.account);

    this.suspendAccountService.getClientAccounts(this.client, this.account).subscribe(data => {
      this.accounts = data.filter(account => account.valid);
      // this.accounts = this.accounts.filter(account => account.valid)
      console.log("nalozi");
      console.log(this.accounts);
    });
  }

  confirm() {
    let selector = document.getElementById("accountSelect") as HTMLSelectElement;
    let accountTransfer = selector.options[selector.selectedIndex].text;

    console.log(accountTransfer);

    this.suspendAccountService.suspendAccount(this.account, accountTransfer).subscribe(data => {
      console.log(data);
      this.router.navigateByUrl('/home');
    });
  }

}
