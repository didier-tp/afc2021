package tp.liste;

public class CelluleV1 {
    protected String val;
    protected CelluleV1 next;

    public CelluleV1(){
        //this(null,null);
    }

    public CelluleV1(String val){
        this(val,null);
    }

    public CelluleV1(String val, CelluleV1 next) {
        this.val = val;
        this.next = next;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public CelluleV1 getNext() {
        return next;
    }

    public void setNext(CelluleV1 next) {
        this.next = next;
    }
}
