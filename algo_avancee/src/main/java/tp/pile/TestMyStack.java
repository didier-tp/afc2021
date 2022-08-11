package tp.pile;

public class TestMyStack {
    public static void main(String[] args) {
        MyStack<String> pile = new MyStack<>();
        pile.add("un");
        pile.add("deux");
        pile.add("trois");
        System.out.println(pile.pop()); //"trois" en l'enlevant / depilant
        System.out.println(pile.pop()); //"deux"
        System.out.println(pile.pop()); //"un"
        System.out.println(pile.pop()); //null

        pile.add("aaa");
        pile.add("bbb");
        pile.add("ccc");
        System.out.println(pile.peek()); // recupérer "ccc" sans l'enlever , sans dépiler
        System.out.println(pile.peek(1)); // recupérer "bbb" sans l'enlever , sans dépiler
        System.out.println(pile.pop()); //"ccc" en l'enlevant / depilant

    }
}
