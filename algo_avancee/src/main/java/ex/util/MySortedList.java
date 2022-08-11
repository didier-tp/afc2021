package ex.util;

//liste toujours triée (au fur et à mesure des ajouts)
public class MySortedList<T extends Comparable<T>> {
	
	public NLElt<T> first =null; //first elt of empty list
	
	public void displayAllInOrder() {
		NLElt<T> nextElt = first;
		while(nextElt!=null) {
			System.out.println(nextElt.val);
			nextElt = nextElt.next;
		}
	}
	
	public void add(T newVal) {
		if(newVal==null)return;
		
		if(first==null) {
			//si liste auparavant vide , le nouvel élément est ajouté en première et unique position
			first = new NLElt<T>(newVal,null);
		}else {
			//liste exitante non vide (déjà au moins un élément)
			NLElt<T> nextElt = first;
			NLElt<T> prevElt = null;
			int derniereComparaison =0;
			while( (derniereComparaison = newVal.compareTo(nextElt.val)) >0) {
				//tant que la valeur de l'élément à ajouter est plus grande ou égale qu'un des éléments actuels
				//de la liste triée, on se déplace sur la cellule suivante de la liste chaînée.
				if(nextElt.next != null) {
					 prevElt = nextElt; //mémorisation de l'élément précédent si besoin de réadapter le chaine via une future insertion entre prevElt et nextElt
				     nextElt = nextElt.next;
				}
				else
					break;//fin anticipée de la boucle while si on est en fin de liste
			}
			//à ce stade nextElt pointe sur l'élément existant recherché de la liste
			//et il faut insérer le nouvel élément juste avant ou bien juste après selon 
			//le résultat de la dernière comparaison:
			if(derniereComparaison >= 0) {
				//nouvelle valeur plus grande ou égale , donc à insérer après et en réadaptant le chaînage existant
				nextElt.addAfter(newVal);
				  //NLElt<T>  ancientNext = nextElt.next; //this is done by .addAfter()
				  //nextElt.next = new NLElt<T>(newVal,ancientNext /*null or not*/); //this is done by .addAfter()
			}
			else {
				 //nouvelle valeur plus petite , donc à insérer avant et en réadaptant le chaînage existant
				 NLElt<T>  newElt = nextElt.addBefore(newVal);
				 if(prevElt!=null)
			    	 prevElt.next = newElt;//chainage réadapté après prevElt existant
			     else
			    	 first = newElt; //nouveau premier element de la liste
			}
		}
	}
}
