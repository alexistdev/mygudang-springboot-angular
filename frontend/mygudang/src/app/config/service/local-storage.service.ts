import {Injectable} from "@angular/core";

@Injectable()
export class LocalStorageService {
  setItem(key: string, val:string):void {
    // @ts-ignore
    sessionStorage.setItem(key,val);
  }

  getItem(key:string):string {
    return sessionStorage.getItem(key);
  }

  clearItem():void {
    sessionStorage.clear();
  }
}
