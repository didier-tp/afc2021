package tp.pile;

public class MyStack<T> {
    public static final int MAX_SIZE=256;
    protected T[] tab;
    protected int indexTop=-1; //-1 pour file vide au départ

    public MyStack() {
        this.tab = (T[]) new Object[MAX_SIZE];
    }

    //ajout en empilant
    public void add(T val){
        if(indexTop<MAX_SIZE-1){
            indexTop++;
            tab[indexTop]=val;
        }
    }

    //retourne la valeur en sommet de la pile
    //et enleve cet element (on dépile)
    public T pop(){
        T res = null;
        if(indexTop>=0) {
            res = tab[indexTop];
            indexTop--;
        }
        return res;
    }

    //retourne la valeur en sommet de la pile
    //mais sans l'enlever
    public T peek(){
        T res = null;
        if(indexTop>=0) {
            res = tab[indexTop];
        }
        return res;
    }

    //retourne la valeur un peu en dessous du sommet de la pile mais sans l'enlever
    // si delta=1 on récupere la valeur en position indexTop -1
    public T peek(int delta){
        T res = null;
        if( (indexTop - delta)>=0) {
            res = tab[indexTop-delta];
        }
        return res;
    }


}
