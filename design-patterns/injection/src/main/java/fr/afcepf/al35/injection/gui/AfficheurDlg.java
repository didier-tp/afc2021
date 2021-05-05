package fr.afcepf.al35.injection.gui;

import javax.swing.JOptionPane;

public class AfficheurDlg implements Afficheur {

	public AfficheurDlg() {
	}

	@Override
	public void afficher(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
}
