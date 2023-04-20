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
      this.http.post('http://localhost:8000/iam/login', {'un': userName , 'pw' : userPwd})
        .subscribe((res)=>{
          if(res){
            observer.next(true);
          } else {
            observer.next(false);
          }
        },(error) => {
          observer.next(false);
        });
    });
    // return Observable.create((obs) =>{
    //   this.http.post('http://localhost:8000/iam/login', {'un': userName , 'pw' : userPwd})
    //     .subscribe((res)=>{
    //       if(res){
    //         obs.next(true);
    //       } else {
    //         obs.next(false);
    //       }
    //     },(error) => {
    //       obs.next(false);
    //     });
    //   //   .map((resp:Response) => resp.json()).subscribe((res):void => {
    //   //     if(res){
    //   //       obs.next(true);
    //   //     } else {
    //   //       obs.next(false);
    //   //     }
    //   // }, (err):void =>{
    //   //     obs.next(false);
    //   //   });
    // });
  }
}
