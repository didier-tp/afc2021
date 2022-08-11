package tp.liste;

import java.util.LinkedList;
import java.util.List;

public class TestListChaineeV1 {

    public static void main(String[] args) {


        List<String> listeJava = new LinkedList<>();
        listeJava.add("un");
        listeJava.add("trois");
        listeJava.add("cinq");
        System.out.println(listeJava);


        ListeChaineeV1 listeChainee =  new ListeChaineeV1();
        listeChainee.add("un");
        listeChainee.add("trois");
        listeChainee.add("cinq");

        listeChainee.displayAll();

        ListeChaineeV1 listeChaineeOrdonnee =  new ListeChaineeV1();
        listeChaineeOrdonnee.addInOrder("Amiens");
        listeChaineeOrdonnee.addInOrder("Paris");
        listeChaineeOrdonnee.addInOrder("Brest");
        listeChaineeOrdonnee.addInOrder("Marseille");
        listeChaineeOrdonnee.addInOrder("Toulouse");
        listeChaineeOrdonnee.addInOrder("brest");
        listeChaineeOrdonnee.displayAll();

    }
}
