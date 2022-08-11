package tp;


/**
 * 
 * @author Didier Defrance
 *
 */
public class JustificationV1 {
	
	public static final int NB_COLS=80;
	

	public static void main(String[] args) {
		int mg = 4; //taille marge gauche
		int md = 4; //taille marge droite
		
		String tabChaines[] = 
			{ "Bonjour Monsieur Dupond,  vous semblez en   forme.", 
		      "un deux trois nous irons au bois",
		      "  quatre cinq six cueillir   des cerises  ",
		      "nous irons tous au paradis",
		      "nou nou",
		      "houbi houba     et       hop    hop",
		      " motUnique ",
		      "chaine trop longue pour etre justifiee sur 80 colonnes en tentant compte des marges gauches et droites"
			};
		
		
		String tabChainesJusfifiees[] = new String[tabChaines.length];
		for(int i = 0; i< tabChaines.length; i++) {
			tabChainesJusfifiees[i]=justifierLigneAvecMarges(tabChaines[i],mg,md);
		}
		for(int i = 0; i< tabChainesJusfifiees.length; i++) {
			System.out.println(tabChainesJusfifiees[i]);
		}
	}
	
	public static String erreurInjustifiable(String chaine) {
		return ">>>>" + chaine + "<<<< PAS JUSTIFIABLE";
	}
	
	public static String justifierLigneAvecMarges(String chaine,int mg,int md) {
		int nbColsMoinsMarges=NB_COLS - mg - md;
		//System.out.println("Sur nbColsMoinsMarges=" +nbColsMoinsMarges  + ", ligne à justifier de longueur="+  chaine.length()  + " : " + chaine);
		if(nbColsMoinsMarges<=0) return erreurInjustifiable(chaine); //pas justifiable
		//System.out.println("nbColsMoinsMarges="+nbColsMoinsMarges); //80-4-4=72
		
		String chaineJustifieeSansMarge = justifierLigneSansMarge(chaine,nbColsMoinsMarges);
		
		String chaineJustifieeAvecMarge = "";
		
		//marge gauche (paquets d'espaces) au début la chaine justifiée:
		for (int j = 0; j < mg; j++) {
			chaineJustifieeAvecMarge += " ";
		}
		
		chaineJustifieeAvecMarge += chaineJustifieeSansMarge;
		
		//marge droite (paquets d'espaces) à la fin de la chaine justifiée:
		for (int i = 0; i < md; i++) {
			chaineJustifieeAvecMarge += " ";
		}
				
		//System.out.println("ligneJustifiee="+chaineJustifieeAvecMarge);
		
		return chaineJustifieeAvecMarge;
	}
	
	public static String justifierLigneSansMarge(String chaine,int nbColsMoinsMarges) {
		
		//ETAPE 1 (PREPARATION) : compter les éléments (espaces , mots , ....)
		//******************************************************************************
		
		int nbEspaces = 0;//nombre total d'occurence du caractere espace
		int nbCaracteresUtiles = 0; //nombre de caracteres utiles (différents de espaces)
		int nbMots = 0; //nombre de mots
		
		boolean motDejaCommence = false;
		boolean intervalleDejaCommence = false;
		
		for (int i = 0; i < chaine.length(); i++) {
			if (chaine.charAt(i) == ' ') {
				//le ieme caractere est un espace
				nbEspaces += 1;
				motDejaCommence = false;
				if(!intervalleDejaCommence) intervalleDejaCommence=true;
			} else {
				//le ieme caractere n'est pas un espace (donc une partie d'un mot
				nbCaracteresUtiles++;
				if (!motDejaCommence) {
					//premièreLettre d'un nouveau mot
					nbMots += 1;
					motDejaCommence=true;
				}else {
					//mot déjà commencé (et aucune variable à modifier)
				}
				intervalleDejaCommence=false;
			}
		}
		
		//System.out.println("nbMots=" +nbMots +  ", nbEspaces(utiles ou pas)="+nbEspaces + ", nbCaracteresUtiles="+nbCaracteresUtiles);
		int nbIntervalles = nbMots - 1;
		int tailleMini = nbCaracteresUtiles + nbIntervalles;
		if(tailleMini > nbColsMoinsMarges ) return erreurInjustifiable(chaine); //pas justifiable
		if(nbMots <= 1) return erreurInjustifiable(chaine); //pas justifiable
		
		int nbEspacesARepartir = nbColsMoinsMarges - nbCaracteresUtiles;
		int lgIntervalle = nbEspacesARepartir / nbIntervalles;
		
	
		int reste = nbEspacesARepartir -  lgIntervalle * nbIntervalles;
		
		/*
		 System.out.println("nbIntervalles=" + nbIntervalles + " de longueur=" + lgIntervalle + " avec reste=" + reste
				          + " longueur totale prevue=" + (nbCaracteresUtiles + lgIntervalle * nbIntervalles + reste) ); 
	     */
		  //longueur totale prevue == nbColsMoinsMarges == 72 = 80-4_4 ????
	
		
		//ETAPE 2 (CONSTRUCTION) : placer des paquets d'espaces aux endroits appropriées:
		//******************************************************************************
		
		String chaineJustifiee = "";
		intervalleDejaCommence=false;
		for (int i = 0; i < chaine.length(); i++) {
			if (chaine.charAt(i) != ' ') {
				//le ieme caractere n'est pas est un espace
				chaineJustifiee += chaine.charAt(i); //caractere utile à replacer dans chaine justifiee
				intervalleDejaCommence=false;
			}
			else {
				//le ieme caractere  est un espace
				if (chaineJustifiee.length() != 0  &&  !intervalleDejaCommence ) {
					//chaine justifiée commencée (de longueur non nulle) et donc sans blanc inutile au début
					// ET intervalle pas Deja Commencé (à remplacer par un interface de longueur >= lgIntervalle)
					for (int j = 0; j < lgIntervalle; j++) {
						chaineJustifiee += " ";
					}
					if (reste != 0) {
						//répartition du reste dès le premier intervalle et tant qu'il en reste
						chaineJustifiee += " ";
						reste -= 1;
					}
					
				}
				intervalleDejaCommence=true;
			}
			
		}
		
		//System.out.println("ligneJustifieeSansMarge de longueur="+  chaineJustifiee.length()  + " : " + chaineJustifiee);
		return chaineJustifiee;
		
	}
	
	/*
	public static void oldMain(String[] args) {
		String chaine = "Bonjour Monsieur Dupond,  vous semblez en   forme.";//JOptionPane.showInputDialog("Tapez la chaîne.");
		String mg_ch = "4";//JOptionPane.showInputDialog("Tapez la longueur de la marge gauche.");
		String md_ch = "4";//JOptionPane.showInputDialog("Tapez la longueur de la marge droite.");
		int mg = Integer.parseInt(mg_ch);
		int md = Integer.parseInt(md_ch);
		String  chaineJustifiee = justifierLigne(chaine,mg,md);
		//System.out.println("ligneJustifiee="+chaineJustifiee);
	}*/

}
