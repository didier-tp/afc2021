package ex.essais;

import ex.util.MyStaticStack;

public class TestStaticStack {
	
	public static void main(String[] args) {
		MyStaticStack<Integer> pileEntiers = new MyStaticStack<Integer>(24);
		pileEntiers.add(5); pileEntiers.add(8); pileEntiers.add(3); 
		System.out.println(pileEntiers.peek(-3)); //null
		System.out.println(pileEntiers.peek(-2)); //5
		System.out.println(pileEntiers.peek(-1)); //8
		System.out.println(pileEntiers.peek()); //3
		System.out.println(pileEntiers.pop()); //3
		System.out.println(pileEntiers.pop()); //8
		System.out.println(pileEntiers.pop()); //5
		System.out.println(pileEntiers.pop()); //null
		
	}

}
