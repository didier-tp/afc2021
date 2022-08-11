package ex.arbre;

//implementation Simple de BTree (avec valeurs de Type T=String)
public class MyBTree {

    protected Noeud<KeyValue> bTreeRoot = null;

    //version basique sans equilibrage:
    public void ajouterNoeudDansSousArbre(Noeud<KeyValue> noeudExistant , KeyValue kv){
        int comparaison = kv.getKey().compareTo(noeudExistant.getVal().getKey());
        if(comparaison <0 ){
            //plus petit et donc à ranger à gauche
            if(noeudExistant.getFg()==null){
                //le noeud courant n'a pas encore de fils gauche direct
                //on peut donc créer et ranger le nouveau noeud directement à cet endroit:
                noeudExistant.setFg(new Noeud(kv));
            }else{
                //le noeud courant a dejà un fils gauche direct
                //on doit donc ranger le nouveau noeud en dessous celui ci (plus en profondeur)
                //via un appel récursif:
                ajouterNoeudDansSousArbre(noeudExistant.getFg(),kv);
            }
        }else{
            //plus grand (ou égal) et à ranger à droite
            if(noeudExistant.getFd()==null){
                //le noeud courant n'a pas encore de fils droit direct
                //on peut donc créer et ranger le nouveau noeud directement à cet endroit:
                noeudExistant.setFd(new Noeud(kv));
            }else{
                //le noeud courant a dejà un fils droit direct
                //on doit donc ranger le nouveau noeud en dessous celui ci (plus en profondeur)
                //via un appel récursif:
                ajouterNoeudDansSousArbre(noeudExistant.getFd(),kv);
            }
        }
    }


    //version basique sans equilibrage:
    public void ajouterNoeud(KeyValue kv){
        if(bTreeRoot == null){
            bTreeRoot = new Noeud<>(kv);
        }else{
            ajouterNoeudDansSousArbre(bTreeRoot,kv);
        }
    }

    /*
    Arbre AVL (Andelson Velskii, Landis)
    On a un équilibre au sens AVL si en tout nœud la hauteur du SAG et la hauteur du SAD
    diffèrent au plus de 1 avec SAG=SousArbreGauche et SAD=SousArbreDroit
    balance=hauteur(SAD)-hauteur(SAG) = normalement/idéalement -1 , 0 ou 1
    */

    public void reEquilibrerSuiteAjoutGauche(Noeud<KeyValue> currNoeud) {
    	//cote fg beaucoup plus haut que cote fd
    	Noeud<KeyValue> currentFg = currNoeud.getFg();
    	if(currentFg.getFd()==null) {
    		//de la place pour ré-arranger currNoeud et currentFg:
    		//currNoeud va devenir le fils droit de currentFg qui prendra sa place
    		//autrement dit, après inversion currentFg transformé sera placé à droite de currNoeud transformé
    		currNoeud.permuterValeursInternes(currentFg);
    		currNoeud.setFd(currentFg);
    		currentFg.setFg(null);
    	}else {
    		//il faut commencer par trouver le premier descendant le plus à droite de currentFg
    		//pour lequel .getFd() est null de façon à placer currNoeud en dessous à droite ou bien effectuer une autre permutation
    		//....A_COMPLETER_DANS_FUTURE_VERSION....
    	}
    }
    
    public void reEquilibrerSuiteAjoutDroit(Noeud<KeyValue> currNoeud) {
    	//cote fd beaucoup plus haut que cote fg
    	Noeud<KeyValue> currentFd = currNoeud.getFd();
    	if(currentFd.getFg()==null) {
    		//de la place pour ré-arranger currNoeud et currentFd:
    		//currNoeud va devenir le fils gauche de currentFd qui prendra sa place
    		//autrement dit, après inversion currentFd transformé sera placé à gauche de currNoeud transformé
    		currNoeud.permuterValeursInternes(currentFd);
    		currNoeud.setFg(currentFd);
    		currentFd.setFd(null);
    	}
    	else {
    		//il faut commencer par trouver le premier descendant le plus à gauche de currentFd
    		//pour lequel .getFg() est null de façon à placer currNoeud en dessous à gauche ou bien effectuer une autre permutation
    		//....A_COMPLETER_DANS_FUTURE_VERSION....
    	}
    }
    
    //version améliorée avec equilibrage:
    //cette fonction renvoie en valeur de retour le niveau de profondeur où l'ajout a été effectué
    public int ajouterNoeudDansSousArbreEq(Noeud<KeyValue> noeudExistant , KeyValue kv,int profondeur){
        int profondeurAjoutEffectue = profondeur + 1;
        int hauteurAutreSousArbre = 0;
        int comparaison = kv.getKey().compareTo(noeudExistant.getVal().getKey());
        if(comparaison <0 ){
            //plus petit et donc à ranger à gauche
            if(noeudExistant.getFg()==null){
                //le noeud courant n'a pas encore de fils gauche direct
                //on peut donc créer et ranger le nouveau noeud directement à cet endroit:
                noeudExistant.setFg(new Noeud(kv));
            }else{
                //le noeud courant a dejà un fils gauche direct
                //on doit donc ranger le nouveau noeud en dessous celui ci (plus en profondeur) via un appel récursif:
                profondeurAjoutEffectue = ajouterNoeudDansSousArbreEq(noeudExistant.getFg(),kv,profondeur+1);
                hauteurAutreSousArbre=(noeudExistant.getFd()!=null)?noeudExistant.getFd().hauteur():0;
                //System.out.println("profondeurAjoutEffectue="+profondeurAjoutEffectue);
                int profondeurRelativeAjoutEffectue = profondeurAjoutEffectue-profondeur;
                //System.out.println("profondeurRelativeAjoutEffectue="+profondeurRelativeAjoutEffectue);
                //System.out.println("hauteurAutreSousArbre="+hauteurAutreSousArbre);
                if(profondeurRelativeAjoutEffectue-hauteurAutreSousArbre>1) {
                	System.out.println("besoin_re_eq_suite_a_ajoute_cote_gauche detecte dans noeud de clef="+noeudExistant.getVal());
                	reEquilibrerSuiteAjoutGauche(noeudExistant);
                }
            }
        }else{
            //plus grand (ou égal) et à ranger à droite
            if(noeudExistant.getFd()==null){
                //le noeud courant n'a pas encore de fils droit direct
                //on peut donc créer et ranger le nouveau noeud directement à cet endroit:
                noeudExistant.setFd(new Noeud(kv));
            }else{
                //le noeud courant a dejà un fils droit direct
                //on doit donc ranger le nouveau noeud en dessous celui ci (plus en profondeur) via un appel récursif:
                profondeurAjoutEffectue = ajouterNoeudDansSousArbreEq(noeudExistant.getFd(),kv,profondeur+1);
                hauteurAutreSousArbre=(noeudExistant.getFg()!=null)?noeudExistant.getFg().hauteur():0;
                int profondeurRelativeAjoutEffectue = profondeurAjoutEffectue-profondeur;
                if(profondeurRelativeAjoutEffectue-hauteurAutreSousArbre>1) {
                	System.out.println("besoin_re_eq_suite_a_ajoute_cote_droit detecte dans noeud de clef="+noeudExistant.getVal());
                	reEquilibrerSuiteAjoutDroit(noeudExistant);
                }
            }
        }
        return profondeurAjoutEffectue;
    }


    //version amelioree avec Eq/equilibrage:
    public void ajouterNoeudEq(KeyValue kv){
        if(bTreeRoot == null){
            bTreeRoot = new Noeud<>(kv);
        }else{
            int profondeurAjoutEffectue = ajouterNoeudDansSousArbreEq(bTreeRoot,kv,1);
            System.out.println("ajout effectue en hauteur/profondeur = " + profondeurAjoutEffectue);
        }
    }

    public String getValueFromKey(String k) {
    	return searchValueForKey(this.bTreeRoot,k);
    }
    
    private String searchValueForKey(Noeud<KeyValue> sousArbreRecherche , String k) {
    	if(sousArbreRecherche==null) return null;
        int comparaison = k.compareTo(sousArbreRecherche.getVal().getKey());
        if(comparaison == 0){
            //on a deja trouvé ce que l'on recherche et on le retourne:
            return sousArbreRecherche.getVal().getValue();
        }else {
            if (comparaison < 0) {
                //plus petit donc a rechercher coté gauche:
                return searchValueForKey(sousArbreRecherche.getFg(), k);
            } else {
                //plus grand donc a rechercher coté droit:
                return searchValueForKey(sousArbreRecherche.getFd(), k);
            }
        }

    }
    
    public void displayBTree(){
        StringBuilder sb = new StringBuilder();
        Noeud.subTreeAsString(sb,"",this.bTreeRoot); //avec .toString() codé sur classe IndexNom
        System.out.println("bTree=\n" + sb.toString());
    }

    public Noeud<KeyValue> getbTreeRoot() {
        return bTreeRoot;
    }


}
