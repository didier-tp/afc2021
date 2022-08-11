package ex.arbre;

public class MyBTreeTest {


    public static void main(String[] args) {

    
        String[] tabKeys= { "Orange" , "Red"  , "Silver" }; //penche naturellement à droite
        String[] tabVals= { "Orange" , "Rouge" , "Argent"  }; //et avec re-équilibrage simple réussi

        //String[] tabKeys= { "Silver" , "Red" , "Orange" };  //penche naturellement à gauche
        //String[] tabVals= { "Argent" , "Rouge", "Orange" }; //et avec re-équilibrage simple réussi
    	
    	//String[] tabKeys= { "Silver" , "Red" , "Orange" ,"Green","Blue","Black","Yellow" }; //penche naturellement à gauche
        //String[] tabVals= { "Argent" , "Rouge", "Orange" , "Vert","Bleu","Noir","Jaune" };
    	
        int nbKeys=tabKeys.length ;

        System.out.println("-------------- version basique sans equilibrage --------");
        MyBTree myBTree = new MyBTree();
        for(int i=0;i<nbKeys;i++){
            myBTree.ajouterNoeud(new KeyValue(tabKeys[i],tabVals[i]));
        }
        myBTree.displayBTree();

        System.out.println("\n-------------- version avec equilibrage (comme réel BTree) --------");
        MyBTree myBTreeEq = new MyBTree();
        for(int i=0;i<nbKeys;i++){
            myBTreeEq.ajouterNoeudEq(new KeyValue(tabKeys[i],tabVals[i]));
        }
        myBTreeEq.displayBTree();
        String searchKey="Red";
        String associatedValue = myBTreeEq.getValueFromKey(searchKey);
        System.out.println("La valeur associée à " + searchKey + " est " + associatedValue);

    }
}
