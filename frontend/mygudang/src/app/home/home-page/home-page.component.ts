import {Component} from '@angular/core';
import {Observable, tap, timer} from "rxjs";
import {LocalStorageService} from "../../shared/service/local-storage.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent {

  constructor(private router: Router, private localStorageService: LocalStorageService) {
  }

  ngOnInit(): void {

  }

  ngAfterViewInit(): void {
    timer(300).pipe(tap(() => {

    })).subscribe();


  }

  doLogout(): void {
    this.localStorageService.clearItem();
    this.router.navigate(['/login']);
  }

}
