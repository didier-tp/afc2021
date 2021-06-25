import { Component, OnInit } from '@angular/core';
import { Devise } from '../common/data/devise';
import { DeviseService } from '../common/service/devise.service';


@Component({
  selector: 'app-devise',
  templateUrl: './devise.component.html',
  styleUrls: ['./devise.component.scss']
})
export class DeviseComponent implements OnInit {

  code : string = "EUR"; 
  devise : Devise | null = null;
  message ="";

  constructor(private deviseService : DeviseService) { }

  ngOnInit(): void {
  }

  searchByCode(){
    this.devise = null;
    this.deviseService.searchDeviseByCode$(this.code).subscribe(
      { next : (d)=> { this.devise = d; this.message ="ok"},
        error : (error)=> { console.log(error); this.message ="erreur: " + error.message}
      });
  }

}
