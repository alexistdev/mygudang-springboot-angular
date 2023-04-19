import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from "@angular/router";
import {LoginComponent} from "../login/component/login/login.component";
import {DashboardComponent} from "../administration/component/dashboard/dashboard.component";

export const routes: Routes = [
  {path: '', redirectTo:'/login', pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
  {path: 'dashboard', component: DashboardComponent}
];

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports:[RouterModule]
})
export class AppRouteModule { }
