import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-basic',
  templateUrl: './basic.component.html',
  styleUrls: ['./basic.component.scss']
})
export class BasicComponent implements OnInit {

  username : string | undefined;
  message : string | undefined;

  onAction(){
     this.message ="Hello " + this.username;
  }

  constructor() { }

  ngOnInit(): void {
  }

}
