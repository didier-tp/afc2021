package fr.afcepf.al35.tp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * classe d'entité persistante (en base de données)
 * qui sera prise en charge par JPA/Hibernate (@Entity, @Id, ...)
 */

@Getter @Setter @NoArgsConstructor //de lombok

@Entity //de JPA (javax.persistence)
@Table(name="compte") //par défaut
@NamedQueries({
		@NamedQuery(name="Compte.findByClientNumero" , 
		query="SELECT cpt FROM Compte cpt JOIN cpt.client cli WHERE cli.numero = :numClient"),
		@NamedQuery(name="Compte.findAll" , 
		query="SELECT cpt FROM Compte cpt")
})
public class Compte {
	
	@Id //idenfiant (primary key)
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto_incr coté base qui remonte mémoire java
	//@Column(name="numero")
	private Long numero;                             
	
	@Column(length = 64)
	private String label;
	
	private Double solde;
	
	@ManyToOne()
	@JoinColumn(name="num_client") //nom de la colonne clef etrangère
	                              //qui va référencer un client dans la table Compte
	@JsonIgnore
	private Client client;
	
	public Compte(Long numero, String label, Double solde) {
		super();
		this.numero = numero;
		this.label = label;
		this.solde = solde;
	}

	@Override
	public String toString() {
		return "Compte [numero=" + numero + ", label=" + label + ", solde=" + solde + "]";
	}

	
	
	
}
