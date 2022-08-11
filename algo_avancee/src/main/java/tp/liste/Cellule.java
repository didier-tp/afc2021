package tp.liste;

//En version générique , la lettre T (comme Type)
//sera plus automatiquement remplacée par String ou bien Double ou Long ou Personne
public class Cellule<T> {
    protected T val;
    protected Cellule<T> next;

    public Cellule(){
        //this(null,null);
    }

    public Cellule(T val){
        this(val,null);
    }

    public Cellule(T val, Cellule<T> next) {
        this.val = val;
        this.next = next;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public Cellule<T> getNext() {
        return next;
    }

    public void setNext(Cellule<T> next) {
        this.next = next;
    }
}
