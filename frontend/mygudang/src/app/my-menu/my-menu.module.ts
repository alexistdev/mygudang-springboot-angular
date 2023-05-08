import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MenuItemComponent } from './component/menu-item/menu-item.component';
import { MyMenuComponentComponent } from './component/my-menu-component/my-menu-component.component';



@NgModule({
  declarations: [
    MenuItemComponent,
    MyMenuComponentComponent
  ],
  imports: [
    CommonModule
  ],
  exports:[
    MyMenuComponentComponent
  ]
})
export class MyMenuModule { }
