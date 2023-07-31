import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DashboardComponent } from './component/dashboard/dashboard.component';
import {MyMenuModule} from "../my-menu/my-menu.module";
import { TransaksiComponent } from './component/transaksi/transaksi.component';
import {AdministrationRoutingModule} from "./administration-routing.module";
import { WelcomeStaffComponent } from './component/welcome-staff/welcome-staff.component';
import { HomeStaffComponent } from './component/home-staff/home-staff.component';
import { RoleAdminComponent } from './component/role-admin/role-admin.component';

// @ts-ignore
@NgModule({
  declarations: [
    DashboardComponent,
    TransaksiComponent,
    WelcomeStaffComponent,
    HomeStaffComponent,
    RoleAdminComponent,

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
