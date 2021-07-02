package fr.afcepf.al35.serverRest.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString @NoArgsConstructor
public class Pays {
	@Id
	private String code; //"fr" , "de" , "es" , "it"
	
	@Length(min=3, max=20, message = "Nom trop long ou trop court")
	private String nom;// "France" 
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="deviseRef")
	private Devise devise;

	public Pays(String code,  String nom) {
		super();
		this.code = code;
		this.nom = nom;
	}
	
	

}
