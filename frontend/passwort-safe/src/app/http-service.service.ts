import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class HttpServiceService {

  constructor(private httpClient: HttpClient, private router: Router) {
  }

  login(userPassword: UserPasswordCredentials) {
    return this.httpClient.post('login', userPassword).subscribe((data) => {
      if (data) {
        this.loggedIn = true;

        this.setSession(data);
        this.router.navigate(['/dashboard']);
      }
    }, (error) => {
      console.log(error);
    });
  }

  getAllPassword(): Observable<Password[]> {
    return this.httpClient.get<Password[]>('get/');
  }

  deletePoll(passwordId: number) {
    return this.httpClient.delete<Password>('delete/' + passwordId);
  }

  createPoll(passwordCreate: PasswordCreate) {
    return this.httpClient.post('add', passwordCreate);
  };
}
