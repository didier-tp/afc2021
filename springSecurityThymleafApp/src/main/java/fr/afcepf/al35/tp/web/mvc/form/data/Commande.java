package fr.afcepf.al35.tp.web.mvc.form.data;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class Commande {
	private Long numero;
	private String sDate;
	private Customer client;
	private List<Produit> produits=new ArrayList<>();
	public Commande(Long numero, String sDate) {
		super();
		this.numero = numero;
		this.sDate = sDate;
	}
	
	public void addProduit(Produit p) {
		produits.add(p);
	}
	
}
