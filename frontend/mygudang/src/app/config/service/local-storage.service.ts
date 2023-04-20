
export class LocalStorageService {
  setItem(key: string, val:string):void {
    sessionStorage.setItem(key,val);
  }

  getItem(key:string):string {
    return sessionStorage.getItem(key);
  }

  clearItem():void {
    sessionStorage.clear();
  }
}
