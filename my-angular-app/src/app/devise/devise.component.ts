import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
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

  montant : number = 200;
  codeDeviseSource : string = "EUR";
  codeDeviseCible : string = "USD";
  montantConverti : number = 0;

  listeDevises! : Devise[]; //à choisir dans liste déroulante.

  constructor(private deviseService : DeviseService,
              private router : Router) { }

  searchByCode(){
    this.devise = null;
    this.deviseService.searchDeviseByCode$(this.code).subscribe(
      { next : (d)=> { this.devise = d; this.message ="ok"},
        error : (error)=> { console.log(error); this.message ="erreur: " + error.message}
      });
  }

  onConvertir(){
    console.log("debut de onConvertir")
    this.deviseService.convertir$(this.montant,
                                  this.codeDeviseSource,
                                  this.codeDeviseCible)
            .subscribe({
                next : (res :number) => { this.montantConverti = res;
                         console.log("resultat obtenu en différé")} ,
                error : (err) => { console.log("error:"+err)}
               });
    console.log("suite immédiate (sans attente) de onConvertir");
    //Attention : sur cette ligne, le résultat n'est 
    // à ce stade pas encore connu car appel asynchrone
    // non bloquant et réponse ultérieure via callback
}


initListeDevises(tabDevises : Devise[]){
this.listeDevises = tabDevises;
if(tabDevises && tabDevises.length > 0){
  this.codeDeviseSource = tabDevises[0].code; //valeur par défaut
  this.codeDeviseCible = tabDevises[0].code; //valeur par défaut
}
}

//ngOnInit() est automatiquement appelée 
//par le framework Angular après le constructeur
//et après la prise en compte des injections 
//et des éventuels @Input
ngOnInit(): void {
  /*
this.deviseService.getAllDevises$()
     .subscribe({
        next: (tabDev : Devise[])=>{ 
                this.initListeDevises(tabDev); },
        error: (err) => { console.log("error:"+err)}
     });*/
     this.deviseService.getAllDevises$()
     .subscribe({
        next: (tabDev:Devise[])=>{ this.listeDevises = tabDev; },
        error: (err) => { console.log("error:"+err)}
     });
}

modifierDevise(){
  //naviguer vers le composant modifDevise en passant un paramètre "codeDevise"
  //en fin d'url:
  //Rappel dans app-routing.module.ts : { path: 'ngr-modif-devise/:codeDevise', component: ModifDeviseComponent },
  this.router.navigateByUrl("ngr-modif-devise/"+this.code);
}

  

}
