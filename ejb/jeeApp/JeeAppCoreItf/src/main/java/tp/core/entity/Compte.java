package tp.core.entity;

import javax.persistence.Entity;//JPA
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="compte")
public class Compte {
	
	@Id //identificateur (pk)
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
