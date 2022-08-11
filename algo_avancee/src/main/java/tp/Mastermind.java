package tp;

import javax.swing.JOptionPane;

/**
 * 
 * @author Estelle et Axel
 * B=Bleu, J=Jaune, V=Vert, R=Rouge, M=Marron et N=Noir
 *
 */

public class Mastermind {

	public static void main(String[] args) {
		String combinaison = "";
		String proposition = "";
		String propositionModifiee = "";
		String couleursNonTrouvees = "";
		int trouves = 0;
		int places = 0;
		int trouvesMaisNonPlaces = 0;
		int nbMaxEssais = 6;
		int nbEssais = 0;
		boolean correspondance;
		String continuer = "";

		do {
			combinaison = JOptionPane.showInputDialog("Tapez une combinaison de 4 couleurs (BRVJMN) :");
			proposition = JOptionPane.showInputDialog("Faites votre proposition de 4 couleurs (BRVJMN) :");
			nbEssais = 0;
			do {
				places = 0;
				trouves = 0;
				propositionModifiee = proposition;
				for (int i = 0; i < combinaison.length(); i++) {
					if (combinaison.charAt(i) == propositionModifiee.charAt(i)) {
						places++;
					}
				}
				for (int i = 0; i < combinaison.length(); i++) {
					correspondance = false;
					for (int j = 0; j < propositionModifiee.length(); j++) {
						if (combinaison.charAt(i) == propositionModifiee.charAt(j) && correspondance == false) {
							trouves++;
							correspondance = true;
						} else {
							couleursNonTrouvees += propositionModifiee.charAt(j);
						}
					}
					propositionModifiee = couleursNonTrouvees;
					couleursNonTrouvees = "";
				}
				trouvesMaisNonPlaces = trouves - places;
				nbEssais++;
				System.out.print("Essai " + nbEssais + "/" + nbMaxEssais + " : ");
				System.out.println(proposition + " -> " + places + " placés et " + trouvesMaisNonPlaces + " trouvés ");
				if (places != combinaison.length()) {
					proposition = JOptionPane.showInputDialog("Faites une nouvelle proposition (BRVJMN) :");
				}
			} while (places != combinaison.length() && nbEssais <= nbMaxEssais);
			if (places == combinaison.length()) {
				System.out.println("Partie gagnée !");
			} else {
				System.out.println("Vous avez perdu. La bonne combinaison était " + combinaison);
			}
			continuer = JOptionPane.showInputDialog("Voulez-vous continuer ? (o/n)");

		} while (continuer.equalsIgnoreCase("o"));

	}

}
