import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomePageComponent } from './home-page/home-page.component';
import {AdministrationModule} from "../administration/administration.module";



@NgModule({
  declarations: [
    HomePageComponent
  ],
    imports: [
        CommonModule,AdministrationModule
    ],
  exports:[
    HomePageComponent
  ]
})
export class HomeModule { }
