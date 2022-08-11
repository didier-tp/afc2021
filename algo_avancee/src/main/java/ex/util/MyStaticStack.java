package ex.util;


//LIFO with internal array of fixed maximum size
public class MyStaticStack<T extends Object> {
	public static final int DEFAULT_MAX_SIZE = 256;
	protected int maxSize;
	protected T internalArray[]=null;
	protected int indexTop = -1; //-1 if empty
	
	public MyStaticStack(int maxSize) {
		this.maxSize = maxSize;
		internalArray = (T[]) new Object[maxSize];
	}
	
	public MyStaticStack() {
		this(DEFAULT_MAX_SIZE);
	}
	
	
	public void add(T val) {
		if(indexTop<maxSize-1) {
			indexTop++;
			internalArray[indexTop]=val;
		}else {
			System.out.println("error: stack if full, no more place");
		}
	}
	
	//pop() retourne la valeur de l'élément au sommet de la pile
	//et enleve le sommet de la pile
	public T pop() {
		if(indexTop>=0)
			return internalArray[indexTop--];
		else
			return null;
	}
	
	//peek() retourne la valeur de l'élément au sommet de la pile sans l'enlever
	public T peek() {
			return (indexTop>=0)?internalArray[indexTop]:null;
	}
	
	//peek() retourne la valeur d'un élément en dessous du sommet de la pile sans l'enlever
	//si delta = 1 ou -1 , on retourne l'élément juste en dessous du sommet
	//si delta = 2 ou -2 , on retourne l'élément 2 positions en dessous du sommet
	public T peek(int delta) {
		if(delta<0) delta = -delta; //interpréter -n comme n
		return (indexTop - delta >=0)?internalArray[indexTop-delta]:null;
	}
}
