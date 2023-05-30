/**
* author: AlexistDev
* github: https://github.com/alexistdev
* email: alexistdev@gmail.com
*/
import {LocalStorageService} from "../../config/service/local-storage.service";
import {Observable, Observer, map} from "rxjs";
// import { map } from 'rxjs/operators'
import {HttpClient} from "@angular/common/http";
import {Injectable, Provider} from "@angular/core";
import {LoginComponent} from "../component/login/login.component";

@Injectable()
export class LoginService {
  private  menuList:[] ;
  constructor(
    private http: HttpClient,
    private localStorageService: LocalStorageService
  ) {
  }

  doUserLogin(userName: string, userPwd: string): Observable<boolean>{
    return new Observable((observer: Observer<any>) => {
      this.http.post('http://localhost:8084/api/auth/login', {'un': userName , 'pw' : userPwd})
        .pipe(map((response: Response) => response.json()))
        .subscribe({
          next: (res) => {
            if(!res){
              let stringifiedData = JSON.stringify(res);
              let parsedJson = JSON.parse(stringifiedData);
              let data = parsedJson.data;
              this.menuList = data.menuList[0];
              this.localStorageService.setItem("menu",JSON.stringify(this.menuList));
              observer.next(false);
            }
            observer.next(true);
          },
          error: () => {
            observer.next(false);
          },
        });
    });
  }
}
