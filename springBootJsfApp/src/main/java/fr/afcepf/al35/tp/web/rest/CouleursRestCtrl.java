package fr.afcepf.al35.tp.web.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.afcepf.al35.tp.web.rest.dto.Couleur;

@RestController //Composant spring de type controlleur rest (pour appels ajax)
@RequestMapping(value="/rest/couleur" , headers="Accept=application/json")
public class CouleursRestCtrl {
	
	private List<Couleur> listeCouleurs;
	private List<Couleur> listeCouleursFr;
	
	//Autowired (si besoin)
	//private ... ....;
	
	@PostConstruct
	public void init() {
		listeCouleurs = new ArrayList<Couleur>();
		listeCouleurs.add(new Couleur("red","#ff0000"));
		listeCouleurs.add(new Couleur("green","#00ff00"));
		listeCouleurs.add(new Couleur("blue","#0000ff"));
		
		listeCouleursFr = new ArrayList<Couleur>();
		listeCouleursFr.add(new Couleur("rouge","#ff0000"));
		listeCouleursFr.add(new Couleur("vert","#00ff00"));
		listeCouleursFr.add(new Couleur("bleu","#0000ff"));
	}


	//URL de déclenchement: 
	//http://localhost:8080/myJsfSpringBootApp/rest/couleur/selonLangue
	//http://localhost:8080/myJsfSpringBootApp/rest/couleur/selonLangue?langue=fr
	@GetMapping(value="/selonLangue")
	public List<Couleur> getCouleursSelonLangue(
			@RequestParam(value="langue",required=false) String langue
			){
		if(langue !=null && langue.contentEquals("fr")) {
			return this.listeCouleursFr;
		}else {
		    return this.listeCouleurs;
		}
	}
	
	/*
	@GetMapping(value="/byZzzz")
	public ... getXyzByZzz(...){
		return .....
	}
	*/
	

}
