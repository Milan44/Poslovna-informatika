import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  userEmail : string = "";
  userPassword : string = "";

  emailError : boolean;
  passwordError : boolean;

  wrongEmail : boolean;
  wrongPassword : boolean;

  constructor(private userService : UserService, private router : Router) { }

  ngOnInit() {

    this.wrongEmail = false;
    this.wrongPassword = false;

    this.emailError = false;
    this.passwordError = false;
  }


  login() {

    if (this.userPassword.trim() == "") {

      this.wrongPassword = true;
      this.wrongEmail = false;

    }

    if (this.userEmail.trim() == "") {

      this.wrongEmail = true;
      this.wrongPassword = false;

    }
    
    if (this.userEmail.trim() != "" && this.userPassword.trim() != "") {

      this.userService.loginUser({email : this.userEmail, password : this.userPassword}).subscribe(data => {
      
      
      
        console.log(data);
  
        if (data == 'SUCCESS') {
  
          this.router.navigateByUrl('/home');
          this.wrongEmail = false;
          this.wrongPassword = false;
  
        }  else if (data == 'WRONG_MAIL') {
  
          this.wrongEmail = true;
          this.wrongPassword = false;
  
        } else if (data == 'WRONG_PASSWORD') {
  
          this.wrongPassword = true;
          this.wrongEmail = false;
  
        }
  
         
  
      });


    }

    
  }

}
