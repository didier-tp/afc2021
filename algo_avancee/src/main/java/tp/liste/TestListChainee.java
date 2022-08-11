package tp.liste;

import java.util.LinkedList;
import java.util.List;

public class TestListChainee {

    public static void main(String[] args) {


        List<String> listeJava = new LinkedList<>();
        listeJava.add("un");
        listeJava.add("trois");
        listeJava.add("cinq");
        System.out.println(listeJava);


        ListeChainee<String> listeChainee =  new ListeChainee<>();
        listeChainee.add("un");
        listeChainee.add("trois");
        listeChainee.add("cinq");

        listeChainee.displayAll();

        ListeChainee<String> listeChaineeOrdonnee =  new ListeChainee<String>();
        listeChaineeOrdonnee.addInOrder("Amiens");
        listeChaineeOrdonnee.addInOrder("Paris");
        listeChaineeOrdonnee.addInOrder("Brest");
        listeChaineeOrdonnee.addInOrder("Marseille");
        listeChaineeOrdonnee.addInOrder("Toulouse");
        listeChaineeOrdonnee.displayAll();

        ListeChainee<Double> listeChaineeOrdonnee2 =  new ListeChainee<Double>();
        listeChaineeOrdonnee2.addInOrder(5.5);
        listeChaineeOrdonnee2.addInOrder(4.4);
        listeChaineeOrdonnee2.addInOrder(6.6);
        listeChaineeOrdonnee2.addInOrder(2.2);
        listeChaineeOrdonnee2.addInOrder(7.7);
        listeChaineeOrdonnee2.addInOrder(1.1);
        listeChaineeOrdonnee2.displayAll();


    }
}
