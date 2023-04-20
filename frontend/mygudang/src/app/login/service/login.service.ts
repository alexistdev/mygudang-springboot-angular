/**
* author: AlexistDev
* github: https://github.com/alexistdev
* email: alexistdev@gmail.com
*/
import {LocalStorageService} from "../../config/service/local-storage.service";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";




@Injectable()
export class LoginService {

  constructor(
    private http: HttpClient,
    private localStorageService: LocalStorageService
  ) {
  }

  doUserLogin(userName: string, userPwd: string): Observable<boolean>{
    return Observable.create((obs) =>{
      // this.http.post('/iam/login', {'un': userName , 'pw' : userPwd})
      //   .map((resp:Response) => resp.json()).subscribe((res):void => {
      //     if(res){
      //       obs.next(true);
      //     } else {
      //       obs.next(false);
      //     }
      // }, (err):void =>{
      //     obs.next(false);
      //   });
    });
  }
}
