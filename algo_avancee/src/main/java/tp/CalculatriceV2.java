package tp;

import javax.swing.JOptionPane;

/**
 * 
 * @author Didier (et Axel)
 * version 2 avec sommet de pile à l'indice taillePile-1 et sans décalages (plus astucieux que l'énoncé)
 * operateurs de calcul possibles : + - *  /
 * operateurs spéciaux:
 *    q : quitter (pile à taille -1 detectée)
 *    c : clear / vider la pile (RAZ)
 *    d : drop / effacer/annuler dernier opérande
 *    s : swap / inverser 2 derniers opérandes (pour future opérateur non communtatif)
 */

public class CalculatriceV2 {
	
	public static final int TAILLE_MAX=5;

	public static void main(String[] args) {

		double[] pile = new double[TAILLE_MAX]; //le sommet de pile est à l'indice taillePile-1 si pile pas vide
		int taillePile = 0;
		String saisie;

		do {
			for (int i = taillePile -1 ; i >=0 ; i--) {
				System.out.println(pile[i]); //afficher toute la pile (du sommet vers le bas)
			}
			saisie = JOptionPane.showInputDialog("Entrez votre saisie");
			try {
				double reel = Double.parseDouble(saisie);
				taillePile = empilage(pile, taillePile, saisie);
			} catch (NumberFormatException e) {
				System.out.println(saisie);//afficher l'operateur saisi pour la compréhension du calcul qui sera effectué
				taillePile = traitementOperateur(pile, taillePile, saisie);
			}
			System.out.println("-------------------------------");
		} while (taillePile > -1);
		System.out.println("Sortie de la calculatrice.");

	}
	
	public static void swapInTab(double[] tableau, int i, int j) {
		double memo = tableau[i];
		tableau[i] = tableau[j];
		tableau[j] = memo;
	}

	public static int traitementOperateur(double[] tableau, int taillePile, String saisie) {
		boolean depilement = true;//par défaut

		if (taillePile > 1) {
			switch (saisie.charAt(0)) {
			case '+':
				tableau[taillePile-2] = tableau[taillePile-1] + tableau[taillePile-2];
				break;
			case '-':
				tableau[taillePile-2] = tableau[taillePile-1] - tableau[taillePile-2];
				break;
			case '*':
				tableau[taillePile-2] = tableau[taillePile-1] * tableau[taillePile-2];
				break;
			case '/':
				if (tableau[taillePile-2] != 0) {
					tableau[taillePile-2] = tableau[taillePile-1] / tableau[taillePile-2];
					break;
				} else {
					System.out.println("Division par 0 impossible.");
					depilement = false;
					break;
				}
			case 'c' :
				taillePile = 0;
				depilement = false;
				break;
			case 'd':
				/* depilement=true; déjà par défaut */
				break;
			case 's':
				swapInTab(tableau,taillePile-2,taillePile-1);
				depilement = false;
				break;
			case 'q' :
				taillePile = -1;
				depilement = false;
				break;
			default:
				depilement = false;
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
				depilement = false;
				break;
			case 'c' :
				taillePile = 0;
				depilement = false;
				break;
			case 'd':
				if (taillePile == 0) {
					depilement = false;
				}
				break;
			case 'q' :
				taillePile = -1;
				depilement = false;
				break;
			default:
				depilement = false;
				break;
			}
		}
		if (depilement) {
			taillePile -= 1;
		}
		return taillePile;
	}

	public static int empilage(double[] tableauPile, int taillePile, String saisie) {
		if(taillePile < TAILLE_MAX) {
			tableauPile[taillePile] = Double.parseDouble(saisie);
			taillePile += 1;
		}
		else {
			System.err.println("ERREUR: DEBORDEMENT DE PILE !!!!");
		}
		return taillePile;
	}	
}
