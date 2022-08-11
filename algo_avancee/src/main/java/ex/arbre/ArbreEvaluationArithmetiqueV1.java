package ex.arbre;

public class ArbreEvaluationArithmetiqueV1 {


    static Noeud<String> buildArbre(){
        //V1 y= (3 + 5*x ) - (2 * (x^2))
        Noeud<String> noeudRacine = null;

        Noeud<String> noeud5foisX = new Noeud<String>("*");
        noeud5foisX.setFg(new Noeud<String>("5"));
        noeud5foisX.setFd(new Noeud<String>("x"));

        Noeud<String> noeud3plus5foisX = new Noeud<String>("+");
        noeud3plus5foisX.setFg(new Noeud<String>("3"));
        noeud3plus5foisX.setFd(noeud5foisX);

        Noeud<String> noeud_xAuCarre = new Noeud<String>("^");
        noeud_xAuCarre.setFg(new Noeud<String>("x"));
        noeud_xAuCarre.setFd(new Noeud<String>("2"));

        Noeud<String> noeud_2FoisXauCarre = new Noeud<String>("*");
        noeud_2FoisXauCarre.setFg(new Noeud<String>("2"));
        noeud_2FoisXauCarre.setFd(noeud_xAuCarre);


        noeudRacine = new Noeud<String>("-");
        noeudRacine.setFg(noeud3plus5foisX);
        noeudRacine.setFd(noeud_2FoisXauCarre);

        return noeudRacine;
    }

    //fonction d'évaluation récursive sur fd et fg
    static String evaluerArbre(Noeud<String> noeud, double x){
       String res = null;
       double evalSousArbreGauche = 0;
       double evalSousArbreDroit = 0;
       if(noeud.getFg()!=null)
           evalSousArbreGauche = Double.parseDouble(evaluerArbre(noeud.getFg(),x));
       if(noeud.getFd()!=null)
           evalSousArbreDroit = Double.parseDouble(evaluerArbre(noeud.getFd(),x));
       switch(noeud.getVal()) {
           case "+":
               res = String.valueOf(evalSousArbreGauche + evalSousArbreDroit);
               break;
           case "*":
               res = String.valueOf(evalSousArbreGauche * evalSousArbreDroit);
               break;
           case "-":
               res = String.valueOf(evalSousArbreGauche - evalSousArbreDroit);
               break;
           case "/":
               res = String.valueOf(evalSousArbreGauche / evalSousArbreDroit);
               break;
           case "^":
               res = String.valueOf(Math.pow(evalSousArbreGauche ,evalSousArbreDroit));
               break;
           case "x":
               res = String.valueOf(x);
               break;
           default :
               res = noeud.getVal();
       }
       /*
        System.out.println("x="+x + " evalSousArbreGauche=" + evalSousArbreGauche +
                                    " evalSousArbreDroit=" + evalSousArbreDroit +
                                    " val=" + noeud.getVal() + " res=" + res);
       */
       return res;
    }

    public static void main(String[] args) {
        Noeud noeudRacineExpressionArithmetique = buildArbre();
        String y = evaluerArbre(noeudRacineExpressionArithmetique , 2.0);
        System.out.println("pour x=" + 2 + " y= (3 + 5*x ) - (2 * (x^2)) =" + y);
        y = evaluerArbre(noeudRacineExpressionArithmetique , 3.0);
        System.out.println("pour x=" + 3 + " y= (3 + 5*x ) - (2 * (x^2)) =" + y);
        //et avec plein de (x,y) on calcule les points d'une courbe à tracer
    }

}
