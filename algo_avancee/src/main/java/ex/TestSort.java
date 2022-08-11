package ex;

import java.util.Arrays;

public class TestSort {

	public static void main(String[] args) {
		System.out.println("POUR TABLEAU DE PETITE TAILLE:");
		comparaisonTris(false);
		
		System.out.println("POUR TABLEAU DE GRANDE TAILLE:");
		comparaisonTris(true);
	}
	
	public static void comparaisonTris(boolean bigTab) {
		double[] t1 = produce_init_tab(bigTab);
		double[] copyOfT1 = t1.clone();
		double[] copy2OfT1 = t1.clone();
		display_tab(t1); // display_tab(copyOfT1);
		System.out.println("## tri ordinaire (quick-sort) en java maison");
		test_tri(t1);
		System.out.println("$$ tri standard prédéfini java/c (quick-sort) ");
		test_tri_standard(copyOfT1);
		System.out.println("&& tri à bulles (simpliste) ");
		test_tri_a_bulles(copy2OfT1);
	}

	static double[] produce_init_tab(boolean bigTab) {
		double[] t;
		if(bigTab) {
			// final int taille=10; //trop petite taille 
			//final int taille = 1024 * 1024 * 8; //tres grande taille (trop grande pour tri à bulles qui s'éternise)
			final int taille = 12 * 1024 * 8; //grande taille
			t = new double[taille];
			for (int i = 0; i < taille; i++) {
				t[i] = Math.random() * taille;
			}
		}else {
			double[] smallTab = { 26,7,5,2,1,9,3,4,34,12,8,16,6,78,10,89,33,23,90,123,72,3,48 };
			t=smallTab;
		}
		return t;
	}

	static void display_tab(double[] tab) {
		if (tab.length <= 30) {
			for (double x : tab)
				System.out.print(x + " ");
			System.out.print("\n");
		} else {
			System.out.println("tableau de taille = " + tab.length);
		}
	}

	static void test_tri(double[] tab) {
		long td = System.nanoTime();
		MyQuickSortAlgo.quick_sort(tab);
		long tf = System.nanoTime();
		display_tab(tab);
		System.out.println("## " + (tf - td)  + " ns");
	}
	
	static void test_tri_a_bulles(double[] tab) {
		long td = System.nanoTime();
		MyQuickSortAlgo.tri_a_bulles(tab);
		long tf = System.nanoTime();
		display_tab(tab);
		System.out.println("&& " + (tf - td)  + " ns");
	}
	
	static void test_tri_standard(double[] tab) {
		long td = System.nanoTime();
		Arrays.sort(tab);
		long tf = System.nanoTime();
		display_tab(tab);
		System.out.println("$$ " + (tf - td)  + " ns");
	}


}
