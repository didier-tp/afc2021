package fr.afcepf.al35.injection.tp;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import fr.afcepf.al35.injection.gui.Afficheur;
import fr.afcepf.al35.injection.trad.Traducteur;

@Component
public class Demo {
	
	@Autowired  //de Spring
	@Qualifier("text")
	//pour injecter automatiquement  composant Spring (idealment unique)
	//dont le type est compatible avec l'interface précisée.
	//@Inject = equivalent JEE/CDI de @Autowired
	private Afficheur afficheur=null;
	
	@Autowired  //de Spring
	private Traducteur traducteur;

	public Demo() {
	}
	
	@PostConstruct
	public void apresInitialisation() {
		String msgTrad = traducteur.traduire("essai injection");
		afficheur.afficher(msgTrad);
	}

}
