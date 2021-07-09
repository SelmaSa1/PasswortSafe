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
  loggedIn: boolean;
  private options = { headers: new HttpHeaders().set('Content-Type', 'application/json') };

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
    const json = JSON.stringify(userPassword);
    console.log(json);
    this.httpClient.post('http://localhost:8080/login', json, this.options).subscribe((data) => {
      if (data) {
        this.loggedIn = true;
        this.router.navigate(['/dashboard']);
      }
    }, (error) => {
      console.log(error);
    });
  }

  getAllPassword(): Observable<Password[]> {
    if (this.loggedIn) {
      const headers = this.getHeaders();
      return this.httpClient.get<Password[]>('http://localhost:8080/getAll', {headers: headers});
    } else {
      this.router.navigate(['/login']);
    }
  }

  deletePassword(passwordId: number) {
    if (this.loggedIn) {
      const headers = this.getHeaders();
      return this.httpClient.delete<Password>('http://localhost:8080/delete/' + passwordId, {headers: headers});
    }
  }

  createPassword(passwordCreate: PasswordCreateTo) {
    if (this.loggedIn) {
      const json = JSON.stringify(passwordCreate);
      return this.httpClient.post('http://localhost:8080/add', json , this.options);
    }
  };

  logout() {
    this.loggedIn = false;
    this.router.navigate(['/login']);
  }
}
