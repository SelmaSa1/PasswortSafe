import { Injectable } from '@angular/core';
import { Router, CanActivate } from '@angular/router';
import {HttpServiceService} from "./http-service.service";


@Injectable({
  providedIn: 'root'
})
export class AuthService implements CanActivate  {

  constructor(public authService: AuthService, public router: Router, private httpservie: HttpServiceService) {}

  async canActivate(): Promise<boolean> {
    if (!await this.authService.checkAuthenticated()) {
      await this.router.navigate(['login']);
      return false;
    }
    return true;
  }

  async login(username: any, password: any) {
    const userPasswordCredentials = UserPasswordCredentials(username, password);
    this.httpservie.login(userPasswordCredentials)
  }
}






