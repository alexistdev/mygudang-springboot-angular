import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MenuItemComponent } from './component/menu-item/menu-item.component';
import { MyMenuComponentComponent } from './component/my-menu-component/my-menu-component.component';
import {SharedModule} from "../shared/shared.module";
import {MymenuService} from "./service/mymenu.service";



@NgModule({
  declarations: [
    MenuItemComponent,
    MyMenuComponentComponent
  ],
  imports: [
    CommonModule,
    SharedModule
  ],
  exports:[
    MyMenuComponentComponent,
  ],
  providers:[
    MymenuService
  ]
})
export class MyMenuModule { }
