import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from "@angular/router";
import {LoginComponent} from "../login/component/login/login.component";
import {DashboardComponent} from "../administration/component/dashboard/dashboard.component";
import {HomePageComponent} from "../home/home-page/home-page.component";
import {TransaksiComponent} from "../administration/component/transaksi/transaksi.component";
import {AdministrationModule} from "../administration/administration.module";

export const routes: Routes = [
  {path: '', redirectTo:'/login', pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
  {
    path: 'staff',
    loadChildren: () => import('../administration/administration.module').then(m=>m.AdministrationModule),
  },
  // {
  //   path: 'staff', component: HomePageComponent,
  //   children : [
  //     {
  //       path: 'dashboard',
  //       loadChildren: () => import('../administration/administration.module').then(m=>m.AdministrationModule)
  //     }
  //   ]
  // },
];

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports:[RouterModule]
})
export class AppRouteModule { }
