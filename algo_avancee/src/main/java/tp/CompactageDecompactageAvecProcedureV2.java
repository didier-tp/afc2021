package tp;

import javax.swing.JOptionPane;

/**
 * 
 * @author Didier Defrance
 *
 */

class ChaineCompactable {
	public String chaineCompactee="";
	public String chainePasCompactee="";
	//ou bien avec private +get/set
}

public class CompactageDecompactageAvecProcedureV2 {
	
	//pour convertir '1' en 1 , '8' en 8
	public static int numericCharToInt(char numChar) {
		return (numChar - '0'); // pour convertir un char numerique en int.
		//return Integer.parseInt(String.valueOf(numChar));
	}
	
	//pour convertir 1 en '1' , 8 en '8'
	public static char  intToNumericChar(int val) {
		 return Character.forDigit(val, 10);
		 //ou bien autre façon
	}

	public static void main(String[] args) {

		String chaine = JOptionPane.showInputDialog("chaineACompacter avec quelques caractères répétés");
		System.out.println("Chaîne initiale :\t" + chaine);

		ChaineCompactable chaineCompactableACompacter = new ChaineCompactable();
		chaineCompactableACompacter.chainePasCompactee=chaine;
		effectuerCompactage(chaineCompactableACompacter) ;
		System.out.println("Chaîne compactée :\t" + chaineCompactableACompacter.chaineCompactee );

		ChaineCompactable chaineCompactableADeCompacter = new ChaineCompactable();
		chaineCompactableADeCompacter.chaineCompactee = chaineCompactableACompacter.chaineCompactee;
		effectuerDecompactage(chaineCompactableADeCompacter) ;
		System.out.println("Chaine décompactée :\t" + chaineCompactableADeCompacter.chainePasCompactee);
	}

	
	/*
	 * Procédure qui construit et place dans chaineCompactable.chaineCompactee
	 * et version compactée de la chaine trouvée dans chaineCompactable.chainePasCompactee
	 */
	public static void effectuerCompactage(ChaineCompactable chaineCompactable) {
		chaineCompactable.chaineCompactee="";
		int n = chaineCompactable.chainePasCompactee.length(); //taille
		int i = 0; //indice principal (premiere lettre)
	
		while(i < n) {
			char caractereCourant = chaineCompactable.chainePasCompactee.charAt(i); //premier d'un bloc avec repetition
			int d = 0; //delta (i+d);
			char caractereSuivant = caractereCourant;//avant sous boucle pour d==0
			while(caractereCourant == caractereSuivant && d<9) {
					d++; //nbRepetionsContigues 
					if(i+d<n)
						caractereSuivant = chaineCompactable.chainePasCompactee.charAt(i+d);//en position (i+d) avec d=1 ou 2 ou ...
					else
						caractereSuivant = '\0'; //fin de chaine
			}
			chaineCompactable.chaineCompactee = chaineCompactable.chaineCompactee + caractereCourant + intToNumericChar(d);
			i=i+d; //nouvel indice principal = (premiere lettre du bloc d'après en sautant tous les caractères contigues)
		}
	}

	/*
	 * Procédure qui construit et place dans chaineCompactable.chainePasCompactee 
	 * et version décompactée de la chaine trouvée dans chaineCompactable.chaineCompactee
	 */
	public static void effectuerDecompactage(ChaineCompactable chaineCompactable) {
		chaineCompactable.chainePasCompactee="";
		int nbRepetitions;
		for (int i = 0; i < chaineCompactable.chaineCompactee.length(); i += 2) {
			nbRepetitions = numericCharToInt(chaineCompactable.chaineCompactee.charAt(i + 1)); 
			for (int j = 0; j < nbRepetitions; j++) {
				chaineCompactable.chainePasCompactee += chaineCompactable.chaineCompactee.charAt(i);
			}
		}
	}
}