import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DashboardComponent } from './component/dashboard/dashboard.component';
import {MyMenuModule} from "../my-menu/my-menu.module";



@NgModule({
  declarations: [
    DashboardComponent
  ],
  exports: [
    DashboardComponent
  ],
    imports: [
        CommonModule,
        MyMenuModule
    ]
})
export class AdministrationModule { }
