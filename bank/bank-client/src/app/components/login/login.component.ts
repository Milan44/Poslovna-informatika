import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  userEmail : string;
  userPassword : string;

  emailError : boolean = false;
  passwordError : boolean = false;

  constructor(private userService : UserService, private router : Router) { }

  ngOnInit() {

  }


  login() {

    this.userService.loginUser({email : this.userEmail, password : this.userPassword}).subscribe(data => {
      
      
      
      console.log(data);

      if (data == 'SUCCESS')
      this.router.navigateByUrl('/home');

    });
  }

}
