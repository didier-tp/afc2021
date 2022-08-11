package tp.vins;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 
 * @author Meryem et Axel et Didier
 *
 */

public class VinsP1  extends Vins {
	
	//Partie1 (generation du fichier trie listeVins.bin)

	public static Vin vinFromLineOfCsvFile(String ligne){
		String separateur="\t"; //caractère tabulation
		String[] tabParts = ligne.split("\t");
		//System.out.println("*** tabParts="+tabParts[0] + " " + tabParts[1] + " " + tabParts[2] + " " + tabParts[3]  + " " + tabParts[4] + " " + tabParts[5]);
		return new Vin(tabParts[0] ,
				       tabParts[1] ,
				       tabParts[2],
				       tabParts[3] ,
				       Integer.parseInt(tabParts[4]) ,
				       tabParts[5]);
	}
	
	public static void main(String[] args) {

		String ligne = "";
		int compteurVins = 0;

		RandomAccessFile raf;
		try {
			raf = new RandomAccessFile(RAF_FILE_NAME, "rw");

			//ETAPE1: lecture du fichier sequentiel et ecriture du fichier binaire/raf
			FileReader fichierOriginal = new FileReader(SEQ_FILE_NAME);
			BufferedReader bf = new BufferedReader(fichierOriginal);

			while ((ligne = bf.readLine()) != null) {
				Vin vin = vinFromLineOfCsvFile(ligne);
				vin.writeInRaf(raf);
				compteurVins += 1;
			}
			System.out.println("fichier normalement genere (pour l'instant pas encore trie): mesFichiers/listeVins.bin");
			
			//ETAPE 2: tri par extraction très lent :
			System.out.println("tri en cours , veuillez patienter SVP ...");
			triParExtraction(Vin.TAILLE_VIN, compteurVins, raf);
			System.out.println("fichier normalement maintenant trie: mesFichiers/listeVins.bin");
			
			System.out.println("contenu trie du fichier mesFichiers/listeVins.bin :");
			listeVins(compteurVins, raf);

			//ETAPE 3 : recherche rapide d'un des vins --> au sein de la classe VinsP2
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}
