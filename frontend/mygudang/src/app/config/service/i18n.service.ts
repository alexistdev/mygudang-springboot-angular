/**
* author: AlexistDev
* github: https://github.com/alexistdev
* email: alexistdev@gmail.com
*/
import {Injectable} from "@angular/core";
import {LocalStorageService} from "./local-storage.service";

@Injectable()
export class I18nService{
  constructor(private localStorageService: LocalStorageService) {
  }

  translate(key: string, dynamicVal?:any){
    let translation: string = key;
    let currentLang: string = this.localStorageService.getItem('pl');
    // if(!currentLang){
    //   currentLang = this.config.defaultLanguage;
    // }
    return translation;
  }
}
