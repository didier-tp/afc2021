package ex.util;


//FIFO / Queue with in and out reference on internal linkedList
//cells/items are linked from out side to input side
//output side is the begin of internal linkedList , input side is the end of internal linkedList
public class MyDynQueue<T> {
	public NLElt<T> out =null; //reference to output side of queue (null if empty)
	public NLElt<T> in =null; //reference to input side of queue (last inserted , null if empty)
	
	public void add(T val) {
		if(in==null) {
			out = in = new NLElt<T>(val);
		}else {
			in.addAfter(val);
			in=in.getNext();
		}
	}
	
	//pop() retourne la valeur de l'élément en sortie de file
	//et enleve cet élément de la file
	public T pop() {
		T outVal = null;
		if(out!=null) {
			outVal = out.val;
			out = out.next;
			if(out==null) in=null;
		}
		return outVal;
	}
	
	//peek() retourne la valeur de l'élément à la fin de la file sans l'enlever
	public T peek() {
			return (out!=null)?out.val:null;
	}
}
