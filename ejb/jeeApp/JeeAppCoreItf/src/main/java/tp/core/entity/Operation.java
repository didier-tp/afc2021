package tp.core.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;//JPA
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="operation")
public class Operation {
	
	@Id //identificateur (pk)
	@GeneratedValue(strategy = GenerationType.IDENTITY) //IDENTITY ok pour H2 , Mysql 
	//@GeneratedValue pour que la veaur de la pk auto-incrémentée par
	//mysql remonte bien en mémoire dans l'objet persitent
	private Long numOp;
	
	@Column(name="label",length = 64)
	private String label;
	
	private Double montant;
	
	@Temporal(TemporalType.DATE)
	private Date dateOp;
	
	@ManyToOne()
	  @JoinColumn(name="numCompte")
	private Compte compte;

	public Operation() {
		super();
	}
	
	

	@Override
	public String toString() {
		return "Operation [numOp=" + numOp + ", label=" + label + ", montant=" + montant + ", dateOp=" + dateOp + "]";
	}






	public Long getNumOp() {
		return numOp;
	}

	public void setNumOp(Long numOp) {
		this.numOp = numOp;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public Date getDateOp() {
		return dateOp;
	}

	public void setDateOp(Date dateOp) {
		this.dateOp = dateOp;
	}



	public Compte getCompte() {
		return compte;
	}



	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
	
	
}
