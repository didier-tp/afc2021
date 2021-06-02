package fr.afcepf.al35.serverRest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString @NoArgsConstructor
@Table(name="devise")
public class Devise {
	@Id
	private String code; //"EUR" , "USD" , "GBP" , "JPY"
	
	private String nom;
	
	@Column(name="echange")
	private Double change;
	
	public Devise(String code, String nom, Double change) {
		super();
		this.code = code;
		this.nom = nom;
		this.change = change;
	}
	
	

}
