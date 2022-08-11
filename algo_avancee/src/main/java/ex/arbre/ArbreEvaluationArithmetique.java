package ex.arbre;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class ArbreEvaluationArithmetique {


    
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
    
    public static String enleverEspace(String chaine){
    	return chaine.replaceAll(" ", "");
    }
    
    //principaux operateurs mathematiques dans l'ordre inverse des priorites mathematiques:
    private static String[] operateurs = { "+" , "-" , "/" , "*" , "^" };   
    
    private static String[] variables = { "x" , "y" , "z" , "t"  };  
    
    public static String sansParenthese(String expr) {
    	//expr = expression arithmetique a analyser (comportant potentiellement des parentheses)
    	//exprSansParentese  = expression partielle ou les blocs entre parenthese (a traiter plus tard) sont remplaces par des blancs
    	StringBuilder sb = new StringBuilder(expr.length());
    	int nbParenthesesOuvertesEtPasRefermees = 0;
    	for(int i=0;i<expr.length();i++) {
    		char c = expr.charAt(i);
    		if(c=='(')
    			nbParenthesesOuvertesEtPasRefermees++;
    		else if(c==')')
    			nbParenthesesOuvertesEtPasRefermees--;
    		
    		if(nbParenthesesOuvertesEtPasRefermees>0)
    			sb.append(' ');
    		else
    			sb.append(c);
    	}
    	return sb.toString();
    }
    
    public static boolean avecBlocParentheseRemplace(String subExpression) {
    	return subExpression != null && subExpression.length() > 0 && subExpression.charAt(0)==' ' ;
    	//une sousExpression correspond a un bloc de parenthese remplace par un paquet d'espaces
    	//si celle ci comporte au moins un espace sachant que l'expression originale ne comporte aucun espace
    }
    
    public static String sousExpressionGaucheSelonParenthese(String expr, String exprSansParenthese , int pos) {
    	String sousExprGauche= expr.substring(0,pos);
    	String sousExprGaucheSansParenthese = exprSansParenthese.substring(0,pos);
    	if(avecBlocParentheseRemplace(sousExprGaucheSansParenthese)) {
    		return sousExprGauche.substring(1, sousExprGauche.length()-1); //on enleve les parentheses a chaque extremite
    	}else {
    		return sousExprGauche;
    	}
    }
    
    public static String sousExpressionDroiteSelonParenthese(String expr, String exprSansParenthese , int pos) {
    	String sousExprDroite= expr.substring(pos+1);
    	String sousExprDroiteSansParenthese = exprSansParenthese.substring(pos+1);
    	if(avecBlocParentheseRemplace(sousExprDroiteSansParenthese)) {
    		return sousExprDroite.substring(1, sousExprDroite.length()-1); //on enleve les parentheses a chaque extremite
    	}else {
    		return sousExprDroite;
    	}
    }
    
    //méthode recursive qui analyse une expression arithmetique (complete ou partielle)
    //et qui construit une partie de l'arbre binaire correspondant
    //hypothese la chaine a analyser est sans espace inutile (prealablement traitee par enleverEspace())
    public static Noeud<String> parseExpr(String expr){
    	Noeud<String> noeud = null;
    	
    	//expr = expression arithmetique a analyser (comportant potentiellement des parentheses)
    	//exprSansParentese  = expression partielle ou les blocs entre parenthese (a traiter plus tard) sont remplaces par des blancs
    	
    	String exprSansParenthese = sansParenthese(expr); //NB: exprSansParenthese est de meme longueur que expr et caracteres utiles aux memes positions
    	
    	//1.recherche des operateurs dans l'ordre inverse des priorites mathematiques:
    	for(String op : operateurs) {
    	    int pos = exprSansParenthese.indexOf(op);
    	    if(pos>0) {
    	    	//un des operateurs trouve et au moins un caractere avant pour former fg.
    	    	noeud = new Noeud<String>(op);
    	    	noeud.setFg(parseExpr(sousExpressionGaucheSelonParenthese(expr,exprSansParenthese,pos)));
    	    	noeud.setFd(parseExpr(sousExpressionDroiteSelonParenthese(expr,exprSansParenthese,pos)));
    	    	break;
    	    }
    	}
    	if(noeud==null) {
        	//2.recherche des noms de variables ("x" , "y" , ...}
    		for(String v : variables) {
        	    int pos = exprSansParenthese.indexOf(v);
        	    if(pos>=0) {
        	    	noeud = new Noeud<String>(v);
        	    	break;
        	    }
        	 }
    	}
    	if(noeud==null) {
        	//3.recherche des valeurs numeriques:
    		double val = 0;
    		try {
    		  val = Double.parseDouble(exprSansParenthese) ;
    		  noeud= new Noeud<String>(expr);
    		}catch(NumberFormatException nfe) {
    			//pas numerique, pas grave, on aura au moins essaye 
    		}
    	}
    	return noeud;
    }
    
    public static void genererGraphiqueSvg(String aExpr,double xMin,double xMax,double coeff) {
    	int nbPoints=100;
        
        //1. analyse de l'expression arithmetique et construction de l'arbre:
        aExpr=enleverEspace(aExpr);//si besoin (au cas ou)
        Noeud noeudRacineExpressionArithmetique = parseExpr(aExpr);
        
        /*
        //2. affichage de l'arbre construit:
        StringBuilder sb = new StringBuilder();
        Noeud.subTreeAsString(sb,"",noeudRacineExpressionArithmetique);
        System.out.println("arbre=\n" + sb.toString());
        */
        
        //3. evaluations de l'arbre (effectuer calculs) pour coords points de la courbe
        int tabX[]=new int[nbPoints];
        int tabY[]=new int[nbPoints];
        double delta = (xMax-xMin)/nbPoints;
        for(int i=0; i<nbPoints; i++) {
        	double x=xMin+i*delta;
        	String sy = evaluerArbre(noeudRacineExpressionArithmetique , x);
        	double y=Double.parseDouble(sy);
        	tabX[i]=(int)(x*coeff); tabY[i]=(int)(y*coeff);
        }
        
        //4. generation du fichier svg (a afficher avec un navigateur internet)
        try {
			PrintStream ps=new PrintStream(new FileOutputStream("graphique.svg"));
			ps.println("<svg xmlns='http://www.w3.org/2000/svg' width='600' height='600' >");
			ps.printf("<line x1='%d' y1='%d' x2='%d' y2='%d' style='stroke:black;'/>",0,300,600,300);
			ps.printf("<line x1='%d' y1='%d' x2='%d' y2='%d' style='stroke:black;'/>",300,0,300,600);
			int x1=300+tabX[0];
			int y1=300-tabY[0];
			for(int i=1;i<nbPoints;i++) {
				int x2=300+tabX[i];
				int y2=300-tabY[i];
			    ps.printf("<line x1='%d' y1='%d' x2='%d' y2='%d' style='stroke:blue;'/>",x1,y1,x2,y2);
			    //pour prochaine interation:
			    x1=x2; y1=y2;
			}
			ps.println("</svg>");
			ps.close();
			System.out.println("fichier graphique.svg ok pour firefox ou chrome");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        
    }
    

    public static void main(String[] args) {
    	testCalculViaArbre();
    	String aExpr = "x^2-3*x+4";
    	double coeff=10.0; //zoom
        genererGraphiqueSvg(aExpr,-30,+30,coeff);
    }


    public static void testCalculViaArbre() {
        Noeud noeudRacineExpressionArithmetique; 
        //String aExpr = "2+3*x";
        //String aExpr = "4*x^2-3*(x-2)";
        String aExpr = "((x^2+1)*(x-2))-3*(x-1)";
        
        //1. analyse de l'expression arithmetique et construction de l'arbre:
        aExpr=enleverEspace(aExpr);//si besoin (au cas ou)
        noeudRacineExpressionArithmetique = parseExpr(aExpr);
        
        //2. affichage de l'arbre construit:
        StringBuilder sb = new StringBuilder();
        Noeud.subTreeAsString(sb,"",noeudRacineExpressionArithmetique);
        System.out.println("arbre=\n" + sb.toString());
        
        //2. évaluation de l'arbre (effectuer calculs):
        String y = evaluerArbre(noeudRacineExpressionArithmetique , 2.0);
        System.out.println("pour x=" + 2 + " y=" + aExpr + "=" + y);
        y = evaluerArbre(noeudRacineExpressionArithmetique , 3.0);
        System.out.println("pour x=" + 3 + " y=" + aExpr + "=" + y);
        //et avec plein de (x,y) on calcule les points d'une courbe à tracer
    }

}
