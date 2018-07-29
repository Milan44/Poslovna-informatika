import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class UploadFileService {
  constructor(private httpClient: HttpClient) { }

  pushFileToStorage(file: File): Observable<HttpEvent<{}>> {
    const formdata: FormData = new FormData();

    formdata.append('file', file);

    const req = new HttpRequest('POST', 'http://localhost:8080/public/upload/post', formdata, {
      reportProgress: true,
      responseType: 'text'
    });

    return this.httpClient.request(req);
  }

  getFiles(routePart: string): Observable<any> {
    //'upload' za zoriceve fajlove
    //'dailyAccountBalance' za jovicine xml generisane fajlove
    return this.httpClient.get('http://localhost:8080/'+ routePart + '/getallfiles');
  }
}