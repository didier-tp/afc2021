package tp;

import javax.swing.JOptionPane;

/**
 * 
 * @author Axel (et Didier)
 * version 1 avec sommet de pile à l'indice 0 et décalages (comme demandé dans l'énoncé)
 * operateurs de calcul possibles : + - *  /
 * operateurs spéciaux:
 *    q : quitter (pile à taille -1 detectée)
 *    c : clear / vider la pile (RAZ)
 *    d : drop / effacer/annuler dernier opérande
 *    s : swap / inverser 2 derniers opérandes (pour future opérateur non communtatif)
 */

public class Calculatrice {

	public static void main(String[] args) {

		double[] pile = new double[5]; //le sommet de pile est à l'indice 0
		int taillePile = 0;
		String saisie;

		do {
			for (int i = 0; i < taillePile; i++) {
				System.out.println(pile[i]); //afficher toute la pile (du sommet vers le bas)
			}
			saisie = JOptionPane.showInputDialog("Entrez votre saisie");
			try {
				double reel = Double.parseDouble(saisie);
				taillePile = decalage(pile, taillePile, saisie);
			} catch (NumberFormatException e) {
				System.out.println(saisie);//afficher l'operateur saisi pour la compréhension du calcul qui sera effectué
				taillePile = traitementOperateur(pile, taillePile, saisie);
			}
			System.out.println("-------------------------------");
		} while (taillePile > -1);
		System.out.println("Sortie de la calculatrice.");

	}

	public static int traitementOperateur(double[] tableau, int taillePile, String saisie) {

		boolean decalage = true;
		double memo = 0.0;

		if (taillePile > 1) {
			switch (saisie.charAt(0)) {
			case '+':
				tableau[0] = tableau[0] + tableau[1];
				break;
			case '-':
				tableau[0] = tableau[0] - tableau[1];
				break;
			case '*':
				tableau[0] = tableau[0] * tableau[1];
				break;
			case '/':
				if (tableau[1] != 0) {
					tableau[0] = tableau[0] / tableau[1];
					break;
				} else {
					System.out.println("Division par 0 impossible.");
					decalage = false;
					break;
				}
			case 'c' :
				taillePile = 0;
				decalage = false;
				break;
			case 'd':
				tableau[0] = tableau[1];
				break;
			case 's':
				memo = tableau[1];
				tableau[1] = tableau[0];
				tableau[0] = memo;
				decalage = false;
				break;
			case 'q' :
				taillePile = -1;
				decalage = false;
				break;
			default:
				decalage = false;
				break;
			}
		} else {
			switch (saisie.charAt(0)) {
			case '+':
			case '-':
			case '*':
			case '/':
			case 's':
				System.out.println("Nombre insuffisant d'opérandes.");
				decalage = false;
				break;
			case 'c' :
				taillePile = 0;
				decalage = false;
				break;
			case 'd':
				if (taillePile == 0) {
					decalage = false;
				}
				break;
			case 'q' :
				taillePile = -1;
				decalage = false;
				break;
			default:
				decalage = false;
				break;
			}
		}
		if (decalage) {
			for (int i = 2; i < taillePile; i++) {
				tableau[i - 1] = tableau[i];
			}
			taillePile -= 1;
		}
		return taillePile;
	}

	public static int decalage(double[] tableau, int taillePile, String saisie) {

		for (int i = taillePile - 1; i >= 0; i--) {
			tableau[i + 1] = tableau[i];
		}
		tableau[0] = Double.parseDouble(saisie);
		taillePile += 1;
		return taillePile;
	}	
}
