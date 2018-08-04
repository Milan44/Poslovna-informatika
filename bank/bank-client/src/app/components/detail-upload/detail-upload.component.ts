import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-detail-upload',
  templateUrl: './detail-upload.component.html',
  styleUrls: ['./detail-upload.component.css']
})
export class DetailUploadComponent implements OnInit {

  @Input() fileUpload: string;
  public fileUploadName: string;
  constructor() { }

  ngOnInit() {
    let splitedString = this.fileUpload.split("/");
    this.fileUploadName = splitedString[splitedString.length - 1];
    console.log(this.fileUploadName);
  }

}
