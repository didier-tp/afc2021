package fr.afcepf.al35.tp.web.mvc.form.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class Customer {
	private Long id;
	private String nom;
	private String prenom;
	//...
	public Customer(Long id, String nom, String prenom) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}
	
}
