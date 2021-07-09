import { Injectable } from '@angular/core';
import { Router, CanActivate } from '@angular/router';
import {HttpServiceService} from "./http-service.service";
import {Observable} from "rxjs";


@Injectable({
  providedIn: 'root'
})
export class AuthService implements CanActivate  {
  //isAuthenticated: Observable<boolean> = false;

  constructor() {}

  async canActivate(): Promise<boolean> {
    //if (!await this.authService.checkAuthenticated()) {
    //  await this.router.navigate(['login']);
    //  return false;
    //}
    return true;
  }

  // async login(username: any, password: any) {
  //   const userPasswordCredentials = UserPasswordCredentials(username, password);
  //   this.httpservie.login(userPasswordCredentials)
  // }
//async checkAuthenticated() {
    //  return true;
    //}
}






