package ex.util;


//LIFO with top of stack = first NLElt
public class MyDynStack<T> {
	public NLElt<T> top =null; //top of empty stack
	
	public void add(T val) {
		/*
		if(top==null) {
			top = new NLElt<T>(val);
		}else {
			top = top.addBefore(val);
		}
		*/
		top=(top==null)?(new NLElt<T>(val)):top.addBefore(val);
	}
	
	//pop() retourne la valeur de l'élément au sommet de la pile
	//et enleve le sommet de la pile
	public T pop() {
		T topVal = null;
		if(top!=null) {
			topVal = top.val;
			top = top.next;
		}
		return topVal;
	}
	
	//peek() retourne la valeur de l'élément au sommet de la pile sans l'enlever
	public T peek() {
			return (top!=null)?top.val:null;
	}
	
	//peek() retourne la valeur d'un élément en dessous du sommet de la pile sans l'enlever
	//si delta = 1 ou -1 , on retourne l'élément juste en dessous du sommet
	//si delta = 2 ou -2 , on retourne l'élément 2 positions en dessous du sommet
	public T peek(int delta) {
		if(delta<0) delta = -delta; //interpréter -n comme n
		 NLElt<T> prevElt = top;
		 for(int i=1; i<=delta;i++) {
			 prevElt = (prevElt!=null)?prevElt.next:null;
		 }
		 return (prevElt!=null)?prevElt.val:null;
	}
}
