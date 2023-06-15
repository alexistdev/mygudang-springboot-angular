import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DashboardComponent } from './component/dashboard/dashboard.component';
import {MyMenuModule} from "../my-menu/my-menu.module";
import { TransaksiComponent } from './component/transaksi/transaksi.component';
import {AdministrationRoutingModule} from "./administration-routing.module";
import { WelcomeStaffComponent } from './component/welcome-staff/welcome-staff.component';
import { HomeStaffComponent } from './component/home-staff/home-staff.component';




@NgModule({
  declarations: [
    DashboardComponent,
    TransaksiComponent,
    WelcomeStaffComponent,
    HomeStaffComponent,

  ],
  exports: [
    DashboardComponent
  ],
    imports: [
        CommonModule,
        MyMenuModule,
        AdministrationRoutingModule,
    ]
})
export class AdministrationModule { }
