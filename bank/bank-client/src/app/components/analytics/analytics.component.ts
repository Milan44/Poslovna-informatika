import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import {AnalyticsService} from '../../services/analytics.service'

@Component({
  selector: 'app-analytics',
  templateUrl: './analytics.component.html',
  styleUrls: ['./analytics.component.css']
})
export class AnalyticsComponent implements OnInit {

  constructor( private router : Router, private analyticsService: AnalyticsService) { }

  ngOnInit() {
  }

  getAnalytics(){

    let putanja = document.getElementById("putanjaInput") as HTMLInputElement;
    console.log(putanja.value);
    this.analyticsService.loadAnalytics(putanja.value).subscribe( data => {
      console.log(data);
    });
    this.router.navigateByUrl('/home');
  }
}
