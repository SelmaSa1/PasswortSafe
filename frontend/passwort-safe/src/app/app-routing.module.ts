import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from "./login/login.component";
import {TableComponent} from "./table/table.component";


const routes: Routes = [
  { path: 'login', component: LoginComponent},
  { path: 'dashboard', component: TableComponent},
  { path: '', redirectTo: 'login', pathMatch: 'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
