package fr.afcepf.al35.injection.tp;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.afcepf.al35.injection.gui.Afficheur;

@Component
public class Demo {
	
	@Autowired
	private Afficheur afficheur=null;

	public Demo() {
	}
	
	@PostConstruct
	public void apresInitialisation() {
		afficheur.afficher("essai injection");
	}

}
