package fr.afcepf.al35.injection.tp;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import fr.afcepf.al35.injection.ds.PseudoDataSource;
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
	
	@Autowired
	private PseudoDataSource pseudoDataSource;

	public Demo() {
		//dans le constructeur appelé avant les injections
		//les références traducteur et afficheur sont à null
		//et inutilisables.
	}
	
	@PostConstruct //pour marquer une méthode qui sera
	//automatiquement appelée juste après toutes les injections
	public void apresInitialisation() {
		String msgTrad = traducteur.traduire("essai injection v1 (via @Autowired) ");
		afficheur.afficher(msgTrad);
		System.out.println(pseudoDataSource.getConnection());
	}

}
