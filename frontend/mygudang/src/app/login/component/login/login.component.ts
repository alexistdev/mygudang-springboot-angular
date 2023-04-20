import {AfterViewInit, Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";

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
              private formBuilder: FormBuilder) {
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
