package fr.afcepf.al35.serverRest.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@Length(min=3, max=20, message = "Nom trop long ou trop court")
	private String nom;
	
	@Column(name="echange")
	@Min(0)
	@Max(2345)
	private Double change;
	
	@JsonIgnore
	@OneToMany(mappedBy="devise")
	public List<Pays> pays;
	
	
	public Devise(String code, String nom, Double change) {
		super();
		this.code = code;
		this.nom = nom;
		this.change = change;
	}
	
	

}
