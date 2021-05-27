package fr.afcepf.al35.tp.web.mvc.form.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class Produit {
	private Long ref;
	private String label;
	private Double prix;
	
	
	public Produit(Long ref, String label, Double prix) {
		super();
		this.ref = ref;
		this.label = label;
		this.prix = prix;
	}
	
}
