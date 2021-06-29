import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-modif-devise',
  templateUrl: './modif-devise.component.html',
  styleUrls: ['./modif-devise.component.scss']
})
export class ModifDeviseComponent implements OnInit {

  codeDevise : string = "";

  constructor(private route : ActivatedRoute) { 
    //Rappel dans app-routing.module.ts : { path: 'ngr-modif-devise/:codeDevise', component: ModifDeviseComponent },
    this.codeDevise = route.snapshot.params['codeDevise'];
  }

  ngOnInit(): void {
  }

}
