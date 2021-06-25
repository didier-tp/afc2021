import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-xy',
  templateUrl: './xy.component.html',
  styleUrls: ['./xy.component.scss']
})
export class XyComponent implements OnInit {
  listeCouleurs =  [ "blue" , "red" , "black" ];
  couleur : string ="black";
  message : string = "quelques valeurs au carré";
  values :number[] = [1,2,4,10,25];

  nouvelleValeur : number | undefined;

  onAjoutNouvelleValeur(){
    this.values.push(Number(this.nouvelleValeur));
  }

	constructor(){
  }

  ngOnInit(): void {
  }

}
