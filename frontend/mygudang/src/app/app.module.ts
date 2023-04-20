import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {AdministrationModule} from "./administration/administration.module";
import {RouterModule} from "@angular/router";
import {AppRouteModule} from "./app-route/app-route.module";
import {LoginModule} from "./login/login.module";
import {HttpClientModule} from "@angular/common/http";
import {LocalStorageService} from "./config/service/local-storage.service";

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    AdministrationModule,
    RouterModule,
    AppRouteModule,
    LoginModule,
    HttpClientModule,

  ],
  providers: [
    LocalStorageService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
