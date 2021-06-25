import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
 
  message : string = "login que j'aime"

  constructor() { }

  ngOnInit(): void {
  }

}
