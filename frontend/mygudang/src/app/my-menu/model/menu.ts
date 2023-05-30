import {MenuItem} from "./menu-item";

export class Menu {
  id: string;
  title: string;
  menuItem: MenuItem[]


  constructor(id: string, title: string, menuItem: MenuItem[]) {
    this.id = id;
    this.title = title;
    this.menuItem = menuItem;
  }
}
