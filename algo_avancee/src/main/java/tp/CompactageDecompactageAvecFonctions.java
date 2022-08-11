package tp;

import javax.swing.JOptionPane;

/**
 * 
 * @author Didier Defrance
 *
 */

public class CompactageDecompactageAvecFonctions {
	
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

		String chaineCompacteeParFonction = compactage(chaine) ;
		System.out.println("Chaîne compactée :\t" + chaineCompacteeParFonction);

		String chaineDecompacteeParFonction = decompactage(chaineCompacteeParFonction) ;
		System.out.println("Chaine décompactée :\t" + chaineDecompacteeParFonction);
	}

	/*
	public static String compactageV1(String chaineACompacter) {

		String chaineCompactee = "";
		char caractereCourant;
		char caracterePrecedent;
		
		int nbRepetionsContigues = 1; //au moins 1 caractère au début
		
		caracterePrecedent = chaineACompacter.charAt(0);//prochain et premier au début
		
		for(int i = 1; i < chaineACompacter.length(); i++ ) {
			caractereCourant = chaineACompacter.charAt(i);
			if (caracterePrecedent == caractereCourant && nbRepetionsContigues<9) {
				nbRepetionsContigues++;
			} else {
				chaineCompactee  = chaineCompactee + caracterePrecedent + intToNumericChar(nbRepetionsContigues);
				nbRepetionsContigues = 1; //pour prochaine itération
			} 
			caracterePrecedent=caractereCourant; //pour prochaine itération
		}
		//après derniére iteration:
		chaineCompactee  = chaineCompactee + caracterePrecedent + intToNumericChar(nbRepetionsContigues);
		return chaineCompactee;
	}
	*/
	
	public static String compactage(String chaineACompacter) {

		String chaineCompactee = "";
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
			chaineCompactee  = chaineCompactee + caractereCourant + intToNumericChar(d);
			i=i+d; //nouvel indice principal = (premiere lettre du bloc d'après en sautant tous les caractères contigues)
		}
		return chaineCompactee;
	}

	public static String decompactage(String chaineADecompacter) {
		String chaineDecompactee = "";
		int nbRepetitions;
		for (int i = 0; i < chaineADecompacter.length(); i += 2) {
			nbRepetitions = numericCharToInt(chaineADecompacter.charAt(i + 1)); 
			for (int j = 0; j < nbRepetitions; j++) {
				chaineDecompactee += chaineADecompacter.charAt(i);
			}
		}
		return chaineDecompactee;
	}
}