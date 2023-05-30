import {AfterViewInit, Component, Input, OnInit} from '@angular/core';
import {Menu} from "../../model/menu";
import {MymenuService} from "../../service/mymenu.service";
import {MenuItem} from "../../model/menu-item";

@Component({
  selector: 'app-my-menu-component',
  templateUrl: './my-menu-component.component.html',
  styleUrls: ['./my-menu-component.component.css']
})
export class MyMenuComponentComponent implements OnInit,AfterViewInit{
  @Input()
  activeMenu: String = '';

  menus: MenuItem[];


  constructor(private myMenuService: MymenuService) {
  }

  ngOnInit(): void {
      this.myMenuService.getUserMenu()
        .subscribe((menus):void => {
          this.menus = menus;
        });
  }



  ngAfterViewInit(): void {
  }



}
