/**
* author: AlexistDev
* github: https://github.com/alexistdev
* email: alexistdev@gmail.com
*/
import {LocalStorageService} from "../../config/service/local-storage.service";
import {Observable, Observer} from "rxjs";
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
    return new Observable((observer: Observer<any>) => {
      this.http.post('http://localhost:8082/api/auth/login', {'un': userName , 'pw' : userPwd})
        .subscribe((res)=>{
          if(res){
            let myjson = JSON.parse(JSON.stringify(res));
            console.log(myjson.data.role.id);
            this.localStorageService.setItem("role",myjson.data.role.id);
            observer.next(true);
          } else {
            observer.next(false);
          }
        },(error) => {
          observer.next(false);
        });
    });
  }
}
