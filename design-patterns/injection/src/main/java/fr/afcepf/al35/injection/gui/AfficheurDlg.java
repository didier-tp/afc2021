package fr.afcepf.al35.injection.gui;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component //de Spring (pour demander à ce que la classe actuelle
//soit prise en charge comme un composant Spring)
//@Named = equivalent de @Component en version CDI/JEE
@Qualifier("dlg")
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
