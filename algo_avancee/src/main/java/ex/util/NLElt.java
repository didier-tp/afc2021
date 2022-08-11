package ex.util;

//Chaque ELEMENT (alias Cellule) d'une liste simplement chaînée
//comportera une référence sur l'élément/cellule suivante (éventuellement "null" si rien après )
//et une valeur interne de type T (ou T est un type gérérique qui sera ultérieurement remmplacé
//par un type concret : String , Integer , Double , Personne , Produit, ...)

//NextLinkElt
public class NLElt<T> {
	protected T val; //valeur
	protected NLElt<T> next; //reference sur prochain element (ou null si fin)
	//rappel : en java , les éléments "protected" sont dirrectement accessibles
	//depuis les sous classes (par héritage) et aussi depuis toutes les classes du meme package
	
	public NLElt(T val,NLElt<T> next){
		this.val = val;
		this.next = next;
	}
	
	public NLElt(T val){
		this(val,null);
	}
	
	public NLElt(){
		this(null,null);
	}
	
	//méthode qui insère un élément avant la cellule courante
	//et qui retourne une référence sur la nouvelle cellule créée et chainée avec la cellule courante
	public NLElt<T> addBefore(T val) {
		return new NLElt<T>(val,this /* next of newBefore */);
	}
	
	//méthode qui insère un élément après la cellule courante
	//en réadaptant si besoin l'ancien chaînage
	public void addAfter(T val) {
		this.next = new NLElt<T>(val,this.next /* old this.next will be next of next */);
	}
	
	//Attention: on peut éviter d'appeler cette méthode pas très performante 
	//si l'on maintient à la fois une référence sur le début de la liste
	//et à la fois une référence sur le dernier élément de la liste.
	public void addLastWhenNotLastRef(T val) {
		NLElt<T> currLastElt = this;
		while(currLastElt.next !=null) {
			currLastElt = currLastElt.next;
		}
		currLastElt.next = new NLElt<T>( val , null);
	}

	public T getVal() {
		return val;
	}

	public void setVal(T val) {
		this.val = val;
	}

	public NLElt<T> getNext() {
		return next;
	}

	public void setNext(NLElt<T> next) {
		this.next = next;
	}
	

}

/*
//PreviousLinkElt (liste simplement chainée à chainage arrière : assez rare)
class PLElt<T> {
	protected T val; //valeur
	protected NLElt<T> prev; //reference sur element précédent (ou null si aucun)
	//...
}

//PrevNextLinkElt (liste doublement chaînée : parcours possible en avant et en arrière mais consommant plus de mémoire)
class PNLElt<T> {
	protected T val; //valeur
	protected NLElt<T> next; //reference sur prochain element (ou null si aucun)
	protected NLElt<T> prev; //reference sur element précédent (ou null si aucun)
	//...
}
*/
