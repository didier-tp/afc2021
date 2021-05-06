package fr.afcepf.al35.injection.tp;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import fr.afcepf.al35.injection.gui.Afficheur;
import fr.afcepf.al35.injection.trad.Traducteur;

@Component
public class DemoV2 {
	
	private Afficheur afficheur;
	
	private Traducteur traducteur;

	//injection par constructeur
	
	//public DemoV2(@Autowired @Qualifier("text")Afficheur afficheur,@Autowired Traducteur traducteur) {
	public DemoV2(@Qualifier("text")Afficheur afficheur, Traducteur traducteur) {
		this.afficheur = afficheur;
		this.traducteur = traducteur;
	}


	@PostConstruct
	public void apresInitialisation() {
		String msgTrad = traducteur.traduire("essai injection v2 (via constructeur)");
		afficheur.afficher(msgTrad);
	}

}
