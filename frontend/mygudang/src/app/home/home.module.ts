import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomePageComponent } from './home-page/home-page.component';
import {RouterOutlet} from "@angular/router";



@NgModule({
  declarations: [
    HomePageComponent
  ],
    imports: [
        CommonModule,
        RouterOutlet
    ]
})
export class HomeModule { }
