package tp.vins;

import javax.swing.JOptionPane;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 
 * @author Meryem et Axel et Didier
 *
 */

public class VinsP2 extends Vins {
	//PARTIE2 : recherche rapide d'un des vins dans fichier RAF préparé par partie1

	public static void main(String[] args) {
		
		RandomAccessFile raf;
		try {
			raf = new RandomAccessFile(RAF_FILE_NAME, "rw");
			int compteurVins = (int) raf.length() / Vin.TAILLE_VIN;
			
			System.out.println("contenu trie du fichier mesFichiers/listeVins.bin :");
			listeVins(compteurVins, raf);
			
			System.out.println("compteurVins="+compteurVins);
			
			//ETAPE 3 : recherche rapide d'un des vins:
			System.out.println("Recherche d'un des vins du fichier:");
			String rechercheVin = JOptionPane.showInputDialog("Veuillez entrer le nom d'un vin");
			rechercheVin = RafUtil.completer(rechercheVin, Vin.TAILLE_NOMVIN);
			rechercheDichotomique(0, compteurVins, raf, rechercheVin);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	

	//fonction recursive de rechercheDichotomique operant directement/efficacement sur un fichier binaire/raf
	//devant absolument etre préalablement trie.
	public static void rechercheDichotomique(int borneInf, int borneSup, RandomAccessFile raf, String nomVinRecherche) {
		int pivot = 0;
		String nomVinCourant = "";
		try {
			
			if (borneInf <= borneSup) {
				pivot = (borneInf + borneSup) / 2;
				raf.seek(pivot * Vin.TAILLE_VIN);
				nomVinCourant = RafUtil.lectureStringInRaf(Vin.TAILLE_NOMVIN, raf);
				if (nomVinRecherche.compareToIgnoreCase(nomVinCourant) == 0) {
					raf.seek(pivot * Vin.TAILLE_VIN);
					Vin vin = new Vin();
					vin.readFromRaf(raf);
					System.out.println("----------------------------------------------------\r\n"
							+ "Voici les informations concernant le vin recherche :\r\n" + vin.toString());
				} else {
					if (nomVinRecherche.compareToIgnoreCase(nomVinCourant) < 0) {
						rechercheDichotomique(borneInf, pivot - 1, raf, nomVinRecherche);
					} else {
						rechercheDichotomique(pivot + 1, borneSup, raf, nomVinRecherche);
					}
				}
			} else {
				System.out.println("------------------------------\r\nVin introuvable.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
