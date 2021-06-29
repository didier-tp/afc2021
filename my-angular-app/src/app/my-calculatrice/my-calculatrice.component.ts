import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-my-calculatrice',
  templateUrl: './my-calculatrice.component.html',
  styleUrls: ['./my-calculatrice.component.scss']
})
export class MyCalculatriceComponent implements OnInit {

  a : number = 0;
  b : number = 0;
  res : number = 0;

  onAddition(){
    this.res = Number(this.a) + Number(this.b); 
  }

  constructor() { }

  ngOnInit(): void {
  }

}
