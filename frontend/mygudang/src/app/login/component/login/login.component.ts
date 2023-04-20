import {AfterViewInit, Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {LoginService} from "../../service/login.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: [
    './login.component.css',
  ],
})
export class LoginComponent implements OnInit, AfterViewInit{

  loginForm: FormGroup;

  error: boolean  = false;

  constructor(
              private route: ActivatedRoute,
              private router: Router,
              private formBuilder: FormBuilder,
              private loginService: LoginService) {
  }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      emailUn: ['', Validators.required],
      pw: ['', Validators.required]
    });
  }

  ngAfterViewInit(): void {
  }

  doLogin():void {
    if(this.loginForm.valid){
      this.loginForm.disable();
      this.loginService.doUserLogin(this.loginForm.controls['emailUn'].value, this.loginForm.controls['pw'].value).subscribe(
        (res) => {
          if(res){
            this.router.navigate(['/home'])
          } else {
            this.error = true;
          }
          this.loginForm.enable();
          this.doReset();
        },(err)=>{
          this.error = true;
          this.loginForm.enable();
          this.doReset();
        }
      );
      this.error = false;
    } else {
      this.doReset();
      this.error = true;
    }
  }

  doReset():void {
    if(this.loginForm != undefined){
      this.loginForm.reset();
    }
  }
}
