package fr.afcepf.al35.injection.gui;

public class AfficheurText implements Afficheur {

	public AfficheurText() {
	}

	@Override
	public void afficher(String message) {
		System.out.println(message);
	}

}
