package ex.arbre;

//Un arbre binaire est un cas pariculier d'arbre
//où chaque noeud comporte au maximum 2 fils
//qui sont appelés fils_gauche et fils_droits

public class Noeud<T> {
    protected Noeud<T> fg; //fils_gauche (éventuellement null)
    protected Noeud<T> fd; //fils_droit (éventuellement null)
    protected T val;

    /*
    // version sans récursivité (peut être possible mais pas très élégante):
    public static int calculHauteurSansRecursivite(Noeud<?> noeud) {
        int h = 1; //au minimum (en comptant le niveau courant)
      //... ???? (pas approprié)
        return h;
    }
   */



    //AUTRE TP pour s'entrainer sur recursivité et les arbres:
    public static int calculNombreNoeudsDansBranche(Noeud<?> noeud) {
        int nbNoeudTotal = 1; //au moins le noeud courant
        if(noeud.fg!=null)
            nbNoeudTotal+=calculNombreNoeudsDansBranche(noeud.fg);
        if(noeud.fd!=null)
            nbNoeudTotal+=calculNombreNoeudsDansBranche(noeud.fd);
        return nbNoeudTotal;
    }

    //    int h = Noeud.calculHauteur(tpVille.arbreRecherche);
    // version récursive (pas oriente objet)
    public static int calculHauteur(Noeud<?> noeud) {
        int hauteurSousArbreGauche=0;
        int hauteurSousArbreDroit=0;
        if(noeud.fg!=null){
            hauteurSousArbreGauche = calculHauteur(noeud.fg); //recursivité
        }
        if(noeud.fd!=null){
            hauteurSousArbreDroit = calculHauteur(noeud.fd); //recursivité
        }
        return 1 + Math.max(hauteurSousArbreGauche , hauteurSousArbreDroit);
    }

    //version récursive orientée objet:
    public int hauteur() {
        int hauteurSousArbreGauche=0;
        int hauteurSousArbreDroit=0;
        if(fg!=null){
            hauteurSousArbreGauche = fg.hauteur(); //recursivité
        }
        if(fd!=null){
            hauteurSousArbreDroit = fd.hauteur(); //recursivité
        }
        return 1 + Math.max(hauteurSousArbreGauche , hauteurSousArbreDroit);
    }

    //version récursive , orientée objet et syntaxiquement compacte
    public int hauteurV2() {
        int hg=(fg!=null)?fg.hauteur():0; //hauteur sous arbre gauche
        int hd=(fd!=null)?fd.hauteur():0; //hauteur sous arbre droit
        return 1 + Math.max(hg, hd);
    }
    
    public Noeud(){
    	this(null);
    }

    public Noeud(T val){
        this.val = val;
        this.fd = null;
        this.fg = null;
    }

    public Noeud<T> getFg() {
        return fg;
    }

    public void setFg(Noeud<T> fg) {
        this.fg = fg;
    }

    public Noeud<T> getFd() {
        return fd;
    }

    public void setFd(Noeud<T> fd) {
        this.fd = fd;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }
    
    public void permuterValeursInternes(Noeud<T> autreNoeud) {
    	T memoVal = this.val;
    	this.val = autreNoeud.val;
    	autreNoeud.val = memoVal;
    	Noeud<T> memoFg = this.fg;
    	this.fg= autreNoeud.fg;
    	autreNoeud.fg = memoFg;
    	Noeud<T> memoFd = this.fd;
    	this.fd = autreNoeud.fd;
    	autreNoeud.fd=memoFd;
    }
    

    
    //utility recursive method (for debug , ...):
    //usage :
    //  StringBuilder sb = new StringBuilder();
    //  Noeud.subTreeAsString(sb,"",rootNode);
    //  System.out.println("tree=\n" + sb.toString());
    public static void subTreeAsString(StringBuilder sb , String prefix,Noeud<?> noeud) {
    	sb.append(prefix+noeud.val+"\n");
    	if(noeud.fg!=null) subTreeAsString(sb,prefix+"g  ",noeud.fg);
    	if(noeud.fd!=null) subTreeAsString(sb,prefix+"d  ",noeud.fd);
    }


}
