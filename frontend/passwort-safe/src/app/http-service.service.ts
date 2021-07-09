import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Router} from "@angular/router";
import {UserPasswordCredentials} from "./UserPasswordCredentials";
import {Password} from "./Password";
import {PasswordCreateTo} from "./PasswordCreateTo";

@Injectable({
  providedIn: 'root'
})
export class HttpServiceService {

  constructor(private httpClient: HttpClient, private router: Router) {
  }

  getHeaders():HttpHeaders {
    const headers = new HttpHeaders();
    headers.set('Access-Control-Allow-Origin', '*');
    headers.set('Access-Control-Allow-Methods', '*');
    headers.set('Content-Type', 'application/json');
    headers.set('Access-Control-Allow-Headers', 'Access-Control-Allow-Origin, Content-Type, Accept, Accept-Language, Origin, User-Agent');
    return headers;
  }

  login(userPassword: UserPasswordCredentials) {
    const headers = this.getHeaders();
    this.httpClient.post('http://localhost:8080/login', userPassword, {headers: headers}).subscribe((data) => {
      console.log()
      if (data) {
        this.router.navigate(['/dashboard']);
      }
    }, (error) => {
      console.log(error);
    });
  }

  getAllPassword(): Observable<Password[]> {
    const headers = this.getHeaders();
    return this.httpClient.get<Password[]>('http://localhost:8080/getAll', {headers: headers});
  }

  deletePassword(passwordId: number) {
    const headers = this.getHeaders();
    return this.httpClient.delete<Password>('http://localhost:8080/delete/' + passwordId, {headers: headers});
  }

  createPassword(passwordCreate: PasswordCreateTo) {
    const headers = this.getHeaders();

    return this.httpClient.post('http://localhost:8080/add', JSON.stringify(passwordCreate), {headers: headers});
  };
}
