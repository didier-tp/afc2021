package tp;

import javax.swing.JOptionPane;

/**
 * 
 * @author Didier Defrance
 *
 */

public class CompactageDecompactageAvecProcedureV1 {
	
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

		StringBuffer sortieCompactage = new StringBuffer();
		effectuerCompactage(chaine,sortieCompactage) ;
		String chaineCompacteeParProcedure = sortieCompactage.toString();
		System.out.println("Chaîne compactée :\t" + chaineCompacteeParProcedure );

		StringBuffer sortieDecompactage = new StringBuffer();
		effectuerDecompactage(chaineCompacteeParProcedure , sortieDecompactage) ;
		String chaineDecompacteeParProcedure = sortieDecompactage.toString();
		System.out.println("Chaine décompactée :\t" + chaineDecompacteeParProcedure);
	}

	
	
	public static void effectuerCompactage(String chaineACompacter,  StringBuffer bufferChaineCompactee) {

		int n = chaineACompacter.length(); //taille
		int i = 0; //indice principal (premiere lettre)
	
		while(i < n) {
			char caractereCourant = chaineACompacter.charAt(i); //premier d'un bloc avec repetition
			int d = 0; //delta (i+d);
			char caractereSuivant = caractereCourant;//avant sous boucle pour d==0
			while(caractereCourant == caractereSuivant && d<9) {
					d++; //nbRepetionsContigues 
					if(i+d<n)
						caractereSuivant = chaineACompacter.charAt(i+d);//en position (i+d) avec d=1 ou 2 ou ...
					else
						caractereSuivant = '\0'; //fin de chaine
			}
			bufferChaineCompactee.append(caractereCourant);
			bufferChaineCompactee.append(intToNumericChar(d));
			i=i+d; //nouvel indice principal = (premiere lettre du bloc d'après en sautant tous les caractères contigues)
		}
		
	}

	public static void effectuerDecompactage(String chaineADecompacter , StringBuffer bufferChaineDecompactee) {
		int nbRepetitions;
		for (int i = 0; i < chaineADecompacter.length(); i += 2) {
			nbRepetitions = numericCharToInt(chaineADecompacter.charAt(i + 1)); 
			for (int j = 0; j < nbRepetitions; j++) {
				bufferChaineDecompactee.append(chaineADecompacter.charAt(i));
			}
		}
	}
}