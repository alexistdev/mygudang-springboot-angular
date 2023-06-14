import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DashboardComponent } from './component/dashboard/dashboard.component';
import {MyMenuModule} from "../my-menu/my-menu.module";
import { TransaksiComponent } from './component/transaksi/transaksi.component';
import {AdministrationRoutingModule} from "./administration-routing.module";



@NgModule({
  declarations: [
    DashboardComponent,
    TransaksiComponent
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
