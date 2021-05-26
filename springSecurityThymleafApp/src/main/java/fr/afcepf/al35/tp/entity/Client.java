package fr.afcepf.al35.tp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * classe d'entité persistante (en base de données)
 * qui sera prise en charge par JPA/Hibernate (@Entity, @Id, ...)
 */

@Getter @Setter @NoArgsConstructor //de lombok

@Entity //de JPA (javax.persistence)
@Table(name="client") //par défaut
public class Client {
	
	@Id //idenfiant (primary key)
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto_incr coté base qui remonte mémoire java
	//@Column(name="numero")
	private Long numero;                             
	
	private String nom;
	private String prenom;
	
	public Client(Long numero, String nom, String prenom) {
		super();
		this.numero = numero;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	
	
	
}
