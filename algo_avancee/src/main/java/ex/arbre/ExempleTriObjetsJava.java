package ex.arbre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ExempleTriObjetsJava {

    public static void triListJava5ouplus(){
        List<Ville> listeVilles = new ArrayList<Ville>();
        listeVilles.add(new Ville("Paris",1000000));
        listeVilles.add(new Ville("Lyon",300000));
        listeVilles.add(new Ville("Toulouse",200000));
        listeVilles.add(new Ville("Brest",100000));
        listeVilles.add(new Ville("Amiens",10000));
        listeVilles.add(new Ville("Marseille",50000));
        listeVilles.add(new Ville("Lille",50000));

        //tri en java 5ou+
        listeVilles.sort(new Comparator<Ville>() {
            public int compare(Ville v1, Ville v2) {
                //return v1.getPopulation().compareTo(v2.getPopulation()); //pour tri selon selon population
                return v1.getNom().compareTo(v2.getNom()); //pour tri selon selon nom
            }
        });

        //affichage de la liste triée:
        for(Ville v : listeVilles){
            System.out.println(v.getNom() +  " " + v.getPopulation());
        }
    }

    public static void triTableauJava5ouplus(){
        Ville[] tabVilles = new Ville[7];
        tabVilles[0]=new Ville("Paris",1000000);
        tabVilles[1]=new Ville("Lyon",300000);
        tabVilles[2]=new Ville("Toulouse",200000);
        tabVilles[3]=new Ville("Brest",100000);
        tabVilles[4]=new Ville("Amiens",10000);
        tabVilles[5]=new Ville("Marseille",50000);
        tabVilles[6]=new Ville("Lille",50000);

        //tri en java 5ou+
        Arrays.sort(tabVilles , new Comparator<Ville>() {
            public int compare(Ville v1, Ville v2) {
                //return v1.getPopulation().compareTo(v2.getPopulation()); //pour tri selon selon population
                return v1.getNom().compareTo(v2.getNom()); //pour tri selon selon nom
            }
        });

        //Avec java8ou plus:
        //Arrays.sort(tabVilles , (v1,v2) -> v1.getNom().compareTo(v2.getNom()));

        //si besoin de trier qu'une partie d'un grand tableau il existe
        //java.util.Arrays.sort(tableau, indexDebut, indexFin, comparateur );



        //affichage de la liste triée:
        for(int i =0; i< tabVilles.length; i++){
            System.out.println(tabVilles[i].getNom() +  " " + tabVilles[i].getPopulation());
        }
    }

    public static void triListJava8ouplus(){
        List<Ville> listeVilles = new ArrayList<Ville>();
        listeVilles.add(new Ville("Paris",1000000));
        listeVilles.add(new Ville("Lyon",300000));
        listeVilles.add(new Ville("Toulouse",200000));
        listeVilles.add(new Ville("Brest",100000));
        listeVilles.add(new Ville("Amiens",10000));
        listeVilles.add(new Ville("Marseille",50000));
        listeVilles.add(new Ville("Lille",50000));

        //tri en java 8ou+ et lambda expression:
        listeVilles.sort((v1,v2) -> v1.getNom().compareTo(v2.getNom()) ); //pour tri selon selon nom


        //affichage de la liste triée:
        for(Ville v : listeVilles){
            System.out.println(v.getNom() +  " " + v.getPopulation());
        }
    }


    public static void main(String[] args) {
        triListJava5ouplus();
        System.out.println("--------------------");
        triTableauJava5ouplus();
        System.out.println("--------------------");
        triListJava8ouplus();
    }
}
