import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {AdministrationModule} from "./administration/administration.module";
import {RouterModule} from "@angular/router";
import {AppRouteModule} from "./app-route/app-route.module";
import {LoginModule} from "./login/login.module";

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    AdministrationModule,
    RouterModule,
    AppRouteModule,
    LoginModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
