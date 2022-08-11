package ex.arbre;

public class TpVille {

    int nbVilles=0 ;
    Ville[] tabVilles = new Ville[100]; //tableau de capacité maximum = 100
    Noeud<IndexNom> arbreRecherche =null ;

    void addVille(Ville v){
        tabVilles[nbVilles]=v;
        nbVilles++;
    }

    //nom = nom da la ville que l'on recherche
    //sousArbreRecherche = soit l'arbre complet , soit une sous partie
    public Integer rechercherIndexViaArbre(Noeud<IndexNom> sousArbreRecherche , String nom){
        if(sousArbreRecherche==null) return null;
        int comparaison = nom.compareTo(sousArbreRecherche.getVal().getNom());
        if(comparaison == 0){
            //on a deja trouvé ce que l'on recherche et on le retourne:
            return sousArbreRecherche.getVal().getIndex();
        }else {
            if (comparaison < 0) {
                //plus petit donc a rechercher coté gauche:
                return rechercherIndexViaArbre(sousArbreRecherche.getFg(), nom);
            } else {
                //plus grand donc a rechercher coté droit:
                return rechercherIndexViaArbre(sousArbreRecherche.getFd(), nom);
            }
        }
    }

    public void rangerIndexNomDansNouveauNoeud(Noeud<IndexNom> sousArbreRecherche , IndexNom indexNom){
        int comparaison = indexNom.getNom().compareTo(sousArbreRecherche.getVal().getNom());
        if(comparaison <0 ){
            //plus petit et donc à ranger à gauche
            if(sousArbreRecherche.getFg()==null){
                //le noeud courant n'a pas encore de fils gauche direct
                //on peut donc créer et ranger le nouveau noeud directement à cet endroit:
                sousArbreRecherche.setFg(new Noeud(indexNom));
            }else{
                //le noeud courant a dejà un fils gauche direct
                //on doit donc ranger le nouveau noeud en dessous celui ci (plus en profondeur)
                //via un appel récursif:
                rangerIndexNomDansNouveauNoeud(sousArbreRecherche.getFg(),indexNom);
            }
        }else{
            //plus grand (ou égal) et à ranger à droite
            if(sousArbreRecherche.getFd()==null){
                //le noeud courant n'a pas encore de fils droit direct
                //on peut donc créer et ranger le nouveau noeud directement à cet endroit:
                sousArbreRecherche.setFd(new Noeud(indexNom));
            }else{
                //le noeud courant a dejà un fils droit direct
                //on doit donc ranger le nouveau noeud en dessous celui ci (plus en profondeur)
                //via un appel récursif:
                rangerIndexNomDansNouveauNoeud(sousArbreRecherche.getFd(),indexNom);
            }
        }
    }

    public void ajouterNoeud(int index,Ville v){
        IndexNom indexNom = new IndexNom(v.getNom(), index);
        if(arbreRecherche == null){
            arbreRecherche = new Noeud<>(indexNom);
        }else{
            rangerIndexNomDansNouveauNoeud(arbreRecherche,indexNom);
        }
    }

    public void creerArbreRecherche(){
        //une methode ordinaire (pas static) peut accéder aux attributs de la classe courante
        for(int i =0; i< nbVilles ; i++){
            ajouterNoeud(i,tabVilles[i]);
        }

        //afficher temporairement l'arbre construit pour vérifier/debug (en tp):
        StringBuilder sb = new StringBuilder();
        Noeud.subTreeAsString(sb,"",arbreRecherche); //avec .toString() codé sur classe IndexNom
        System.out.println("tree=\n" + sb.toString());
    }

    public static void main(String[] args) {
        TpVille tpVille = new TpVille();
        tpVille.addVille(new Ville("Paris",1000000));
        tpVille.addVille(new Ville("Lyon",300000));
        tpVille.addVille(new Ville("Toulouse",200000));
        tpVille.addVille(new Ville("Brest",100000));
       // tpVille.addVille(new Ville("Amiens",10000));
       // tpVille.addVille(new Ville("Marseille",50000));
       // tpVille.addVille(new Ville("Lille",50000));
        tpVille.creerArbreRecherche();
        System.out.println("Lyon est a l'index " +
                tpVille.rechercherIndexViaArbre(tpVille.arbreRecherche,"Lyon"));
        Integer indexToulouse = tpVille.rechercherIndexViaArbre(tpVille.arbreRecherche,"Toulouse");
        if(indexToulouse!=null)
           System.out.println("Population de Toulouse=" + tpVille.tabVilles[indexToulouse].getPopulation());

        //int h = tpVille.arbreRecherche.hauteur();
        int h = Noeud.calculHauteur(tpVille.arbreRecherche);
        System.out.println("la hauteur de l'arbre est " + h + " en nombre de niveaux");

        int nbNoeuds = Noeud.calculNombreNoeudsDansBranche(tpVille.arbreRecherche);
        System.out.println("le nombre de noeuds de l'arbre est " + nbNoeuds );
        //normalement nbNoeuds = nombre de Villes ajoutées si fonction calculNombreNoeudsDansBranche
        //codée par un developpeur qui n'est pas noeud-noeud
    }
}
