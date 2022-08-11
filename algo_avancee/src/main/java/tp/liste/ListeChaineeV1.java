package tp.liste;

public class ListeChaineeV1 {
    protected CelluleV1 first=null;//indispensable
    protected CelluleV1 last=null;//faculatif mais pratique pour insérer rapidement à la fin

    public ListeChaineeV1(){
    }

    public void displayAll(){
        CelluleV1 currentCell = this.first;
        while (currentCell !=null){
            System.out.println(currentCell.val);
            currentCell = currentCell.next;
        }
    }

    //ajout simple à la fin
    public void add(String val){
        if(last==null){
            //liste vide (aucune CelluleV1)
            first=last=new CelluleV1(val,null);
        }else{
            //last référence une CelluleV1 existante (qui est pour l'instant la derniere avant l'ajout à effectuer)
            CelluleV1 nouvelleCelluleV1 = new CelluleV1(val,null);
            last.next = nouvelleCelluleV1; // nouvelleCelluleV1 après l'avant dernière
            last = nouvelleCelluleV1; //nouvelle derniere CelluleV1
        }
    }

    //ajout quelquefois au milieu selon ordre alphabetique
    public void addInOrder(String val){
        if(first==null){
            //liste vide (aucune CelluleV1)
            first=last=new CelluleV1(val,null);
        }else{
            //liste pas vide (au moins un élément)
            CelluleV1 currentCell = this.first;
            CelluleV1 prevCell = null;
            /* xxx.compareTo(yyy) renvoie 0 si valeur identique pour xxx et yyy
                                         <0 si xxx plus petit que yyy
                                         >0 si xxx plus grand que yyy
             */
            int derniereComparaison ;

            while( (derniereComparaison = val.compareToIgnoreCase(currentCell.val) ) >=0){
                if(currentCell.next != null) {
                    prevCell = currentCell;
                    currentCell = currentCell.next;
                }else{
                    break ; //on arrête la boucle car on est arrivé en fin de liste
                }
            }

            if(derniereComparaison < 0  ){
                //besoin de créer une nouvelle CelluleV1 et de l'inserer avant:
                CelluleV1 nouvelleCelluleV1 = new CelluleV1(val,currentCell);
                if(prevCell == null){
                    this.first = nouvelleCelluleV1;
                }else{
                    prevCell.next = nouvelleCelluleV1;
                }
            }else{
                //besoin de créer une nouvelle CelluleV1 et de l'insérer après la CelluleV1 courante
                CelluleV1 nouvelleCelluleV1 = new CelluleV1(val,currentCell.next);
                currentCell.next = nouvelleCelluleV1;
                if(nouvelleCelluleV1.next==null){
                    last = nouvelleCelluleV1;
                }
            }
        }
    }

    public CelluleV1 getFirst() {
        return first;
    }

    public void setFirst(CelluleV1 first) {
        this.first = first;
    }

    public CelluleV1 getLast() {
        return last;
    }

    public void setLast(CelluleV1 last) {
        this.last = last;
    }
}
