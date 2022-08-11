package ex;

public class MyQuickSortAlgo {
	
	static void echanger(double[] tableau ,int indice1 ,int indice2){
	     double temp = tableau[indice1];
		 tableau[indice1] = tableau[indice2];
		 tableau[indice2] = temp;
	  }
	
	static int  partition(double[] tableau,int deb,int fin){
       int indicePivot=deb; //au sens indice initial qui va évoluer
       double valeurPivot=tableau[deb];//valeur du pivot (= arbitrairement valeur en première position du tableau)
		                         //via une future permutation , cette valeur sera à une future autre position
       
       for(int i=deb+1;i<=fin;i++){
           if (tableau[i]<valeurPivot){
               indicePivot++; //nouvelle valeur pour le futur indice du pivot (qui peut encore évoluer selon boucle en cours)
               echanger(tableau,indicePivot,i); //pour placer à la "future gauche" de l'indice provisoire du pivot tous les éléments plus petits que le pivot
            }
       }
       echanger(tableau,deb,indicePivot); //permutation pour que la valeur du pivot soit rangée à sa place (précédemment calculée)
		                                   //et pour qu'un des éléments plus petits soit placé au début (à gauche )
       return indicePivot;
       }

     static void tri_rapide(double[] tableau,int deb,int fin){
       if(deb<fin){
			 //partitionner le tableau en 2 parties partiellement ré-arrangées .
			 //d'un coté tous les éléments plus petits que le pivot , de l'autre coté tous les éléments plus grands:
           int positionPivot=partition(tableau,deb,fin);
			
           tri_rapide(tableau,deb,positionPivot-1); //trier le sous tableau des plus petits éléments que le pivot
           tri_rapide(tableau,positionPivot+1,fin); //trier le sous tableau des plus grands éléments que le pivot
           }
       }
	  
     static void quick_sort(double[] tableau){
		 tri_rapide(tableau, 0, tableau.length - 1 );
	  }
	 
     //autre algorithme de tri (simple mais moins performant):
     static void tri_a_bulles(double[] tableau){
    	int n=tableau.length;
		for(int i=0;i<n-1;i++) {
			for(int j=i+1;j<n;j++) {
				if(tableau[j]<tableau[i])
					 echanger(tableau,i,j); //les bulles legères remontent en relatives premières positions
			}
		}
	  }
     

}
