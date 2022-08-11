package ex.essais;

import java.util.Queue;

import ex.util.MyDynQueue;

public class TestDynQueue {
	
	public static void main(String[] args) {
		MyDynQueue<String> file = new MyDynQueue<String>();
		file.add("un"); file.add("deux"); file.add("trois"); 
		System.out.println(file.peek()); //un
		System.out.println(file.pop()); //un
		System.out.println(file.pop()); //deux
		System.out.println(file.pop()); //trois
		file.add("quatre"); file.add("cinq"); file.add("six"); 
		System.out.println(file.pop()); //quatre
		file.add("sept"); 
		System.out.println(file.pop()); //cinq
		file.add("huit"); 
		System.out.println(file.pop()); //six
		System.out.println(file.pop()); //sept
		System.out.println(file.pop()); //huit
		System.out.println(file.pop()); //null
		
		System.out.println("------------------");
		//idem via predefined Deque classe of java:
		Queue<String> file2 = new java.util.ArrayDeque<String>(256);//default initSize=16
		file2.add("un"); file2.add("deux");
		System.out.println(file2.poll()); //un
		file2.add("trois");
		System.out.println(file2.poll()); //deux
		System.out.println(file2.poll()); //trois
	}

}
