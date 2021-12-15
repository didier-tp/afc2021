package tp.webServices.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString 
@NoArgsConstructor 
public class Pays {
	
	@Id
	private String code ; //ex: "fr"
	private String nom ; //ex: "France"
	//...
    
	@ManyToOne ()
	@JoinColumn(name = "code_devise")
	@JsonIgnore
	private Devise devise;
	
	public Pays(String code, String nom) {
		super();
		this.code = code;
		this.nom = nom;
	}
	
	public Pays(String code, String nom, Devise devise) {
		super();
		this.code = code;
		this.nom = nom;
		this.devise = devise;
	}
	
	

}
