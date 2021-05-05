package fr.afcepf.al35.injection.gui;

import javax.swing.JOptionPane;

import org.springframework.stereotype.Component;

@Component
public class AfficheurDlg implements Afficheur {

	public AfficheurDlg() {
	}

	@Override
	public void afficher(String message) {
		System.out.println(">>>> " + message);
		//JOptionPane.showMessageDialog(null, message);
		//le paquet javax.swing.* (du module java.desktop)
		//est devenu optionel de la JVM depuis java 9, 11
	}
}
