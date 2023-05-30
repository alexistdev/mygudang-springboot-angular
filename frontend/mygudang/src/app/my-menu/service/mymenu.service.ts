import {Injectable} from "@angular/core";
import {LocalStorageService} from "../../config/service/local-storage.service";

import {Menu} from "../model/menu";
import {of} from "rxjs";
import {MenuItem} from "../model/menu-item";

/**
* Author: AlexistDev
* Email: alexistdev@gmail.com
* github: https://github.com/alexistdev
* date: 09/05/2023
**/

@Injectable()
export class MymenuService{
  constructor(private localStorageService:LocalStorageService) {
  }

  getUserMenu() {
    // let myMenu: Menu[] = this.localStorageService.getItem("menu");
    let myObject = JSON.parse(this.localStorageService.getItem("menu"));
    let myMenu: MenuItem[] = myObject;
    // console.log(typeof myMenu);
    return of(myMenu);
  }
}
