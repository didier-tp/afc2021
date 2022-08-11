package ex;

public class RechercheDichotomique {
	
	public static int generateRandomValue(int maxi) {
		return (int) (maxi * Math.random());
	}

	public static void main(String[] args) {
		int aDeviner = generateRandomValue(100); //entre 0 et 100
		System.out.println("aDeviner="+aDeviner);
		int nbEssais = trouverSansFinesseEntreMinEtMax(aDeviner,0,100);
		System.out.println("Sans astuce, trouver aDeviner="+aDeviner + " au bout de " + nbEssais + " essais");
		nbEssais = trouverParDichotomieEntreMinEtMax(aDeviner,0,100);
		System.out.println("Pas dichotomie , trouver aDeviner="+aDeviner + " au bout de " + nbEssais + " essais");
	}
	
	//en retour nbEssais
	public static int  trouverSansFinesseEntreMinEtMax(int aDeviner,int borneMin , int borneMax ){
	   int n =0;
	   for(int i=borneMin;i<=borneMax;i++) {
		   n++;
		   if(i==aDeviner) {
			   break; //trouvé
		   }
	   }
	   return n;
	}
	
	//en retour nbEssais
	public static int  trouverParDichotomieEntreMinEtMax(int aDeviner, int borneMin , int borneMax){
		   int pivot = borneMin + (borneMax - borneMin) / 2;
		   System.out.print("pivot="+pivot + " ");
		   if(pivot == aDeviner) {
			   System.out.println(" trouvé assez rapidement");
			   return 1 ; //trouver en un essai relatif (selon niveau de recurssivité)
		   }else {
			   if(pivot > aDeviner) {
				   System.out.println(" trop grand donc recherche entre " + borneMin + " et " + (pivot-1));
				   return 1 + trouverParDichotomieEntreMinEtMax(aDeviner, borneMin,pivot-1);
			     }
			   else {
				   System.out.println(" trop petit donc recherche entre " + (pivot+1) + " et " + borneMax );
				   return 1 + trouverParDichotomieEntreMinEtMax(aDeviner, pivot+1,borneMax);
			   }
		   }
			   
		}

}
