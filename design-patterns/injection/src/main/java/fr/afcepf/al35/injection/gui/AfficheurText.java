package fr.afcepf.al35.injection.gui;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("text")
public class AfficheurText implements Afficheur {

	public AfficheurText() {
	}

	@Override
	public void afficher(String message) {
		System.out.println("####" + message);
	}

}
