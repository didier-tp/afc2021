package tp.core.entity;

import javax.persistence.Entity;//JPA
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="compte")
public class Compte {
	
	@Id //identificateur (pk)
	@GeneratedValue(strategy = GenerationType.IDENTITY) //IDENTITY ok pour H2 , Mysql 
	//@GeneratedValue pour que la veaur de la pk auto-incrémentée par
	//mysql remonte bien en mémoire dans l'objet persitent
	private Long numero;
	
	private String label;
	
	private Double solde;
	//...

	public Compte() {
		super();
	}
	
	
	
	@Override
	public String toString() {
		return "Compte [numero=" + numero + ", label=" + label + ", solde=" + solde + "]";
	}



	public Compte(Long numero, String label, Double solde) {
		super();
		this.numero = numero;
		this.label = label;
		this.solde = solde;
	}



	public Long getNumero() {
		return numero;
	}

	

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Double getSolde() {
		return solde;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
	}

	
}
