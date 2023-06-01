/**
* Author: AlexistDev
* Email: alexistdev@gmail.com
* github: https://github.com/alexistdev
* date: 09/05/2023
**/

export class MenuItem {
  label: string;
  url: string;
  description: string;
  name: string


  constructor(label: string, url: string, description: string, name: string) {
    this.label = label;
    this.url = url;
    this.description = description;
    this.name = name;
  }
}
