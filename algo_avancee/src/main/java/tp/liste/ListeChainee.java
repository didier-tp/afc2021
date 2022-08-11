package tp.liste;

//public class ListeChainee<T> {

//<T extends Comparable> signifie T est un Type de données (String ou Integer ou Double ou Personne)
// ou la classe T est obligée d'implémenter l'interface Comparable comportant la méthode .compareTo()

public class ListeChainee<T extends Comparable> {
    protected Cellule<T> first=null;//indispensable
    protected Cellule<T> last=null;//faculatif mais pratique pour insérer rapidement à la fin

    public ListeChainee(){
    }

    public void displayAll(){
        Cellule<T> currentCell = this.first;
        while (currentCell !=null){
            System.out.println(currentCell.val);
            currentCell = currentCell.next;
        }
    }

    //ajout simple à la fin
    public void add(T val){
        if(last==null){
            //liste vide (aucune cellule)
            first=last=new Cellule(val,null);
        }else{
            //last référence une cellule existante (qui est pour l'instant la derniere avant l'ajout à effectuer)
            Cellule<T> nouvelleCellule = new Cellule(val,null);
            last.next = nouvelleCellule; // nouvelleCellule après l'avant dernière
            last = nouvelleCellule; //nouvelle derniere cellule
        }
    }

    //ajout quelquefois au milieu selon ordre alphabetique
    public void addInOrder(T val){
        if(first==null){
            //liste vide (aucune cellule)
            first=last=new Cellule(val,null);
        }else{
            //liste pas vide (au moins un élément)
            Cellule<T> currentCell = this.first;
            Cellule<T> prevCell = null;
            /* xxx.compareTo(yyy) renvoie 0 si valeur identique pour xxx et yyy
                                         <0 si xxx plus petit que yyy
                                         >0 si xxx plus grand que yyy
             */
            int derniereComparaison ;

            while( (derniereComparaison = val.compareTo(currentCell.val ) ) >=0){
                if(currentCell.next != null) {
                    prevCell = currentCell;
                    currentCell = currentCell.next;
                }else{
                    break ; //on arrête la boucle car on est arrivé en fin de liste
                }
            }

            if(derniereComparaison < 0  ){
                //besoin de créer une nouvelle cellule et de l'inserer avant:
                Cellule<T> nouvelleCellule = new Cellule(val,currentCell);
                if(prevCell == null){
                    this.first = nouvelleCellule;
                }else{
                    prevCell.next = nouvelleCellule;
                }
            }else{
                //besoin de créer une nouvelle cellule et de l'insérer après la cellule courante
                Cellule<T> nouvelleCellule = new Cellule(val,currentCell.next);
                currentCell.next = nouvelleCellule;
                if(nouvelleCellule.next==null){
                    last = nouvelleCellule;
                }
            }
        }
    }

    public Cellule<T> getFirst() {
        return first;
    }

    public void setFirst(Cellule<T> first) {
        this.first = first;
    }

    public Cellule<T> getLast() {
        return last;
    }

    public void setLast(Cellule<T> last) {
        this.last = last;
    }
}
