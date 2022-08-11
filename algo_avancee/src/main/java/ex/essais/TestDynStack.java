package ex.essais;

import ex.util.MyDynStack;

public class TestDynStack {
	
	public static void main(String[] args) {
		MyDynStack<Integer> pileEntiers = new MyDynStack<Integer>();
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
