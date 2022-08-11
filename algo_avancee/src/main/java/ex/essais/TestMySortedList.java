package ex.essais;

import ex.util.MySortedList;

public class TestMySortedList {

	public static void main(String[] args) {
		MySortedList<String> maListeChainesTriees = new MySortedList<String>();
		maListeChainesTriees.add("paris");
		maListeChainesTriees.add("bordeaux");
		maListeChainesTriees.add("rouen");
		maListeChainesTriees.add("toulouse");
		maListeChainesTriees.add("dijon");
		maListeChainesTriees.add("lyon");
		maListeChainesTriees.add("brest");
		maListeChainesTriees.displayAllInOrder();
		
		MySortedList<Double> maListeDoublesTries = new MySortedList<Double>();
		maListeDoublesTries.add(12.5);
		maListeDoublesTries.add(4.7);
		maListeDoublesTries.add(23.7);
		maListeDoublesTries.add(2.23);
		maListeDoublesTries.add(15.34);
		maListeDoublesTries.add(30.8);
		maListeDoublesTries.add(9.9);
		maListeDoublesTries.displayAllInOrder();
		
		//possibilite d'avoir une liste triée d'objets "personnes" si la classe Personne implemente l'interface Comparable
		//en effectuant par exemple des comparaisons sur l'ordre alphabetique des noms .
	}

}
