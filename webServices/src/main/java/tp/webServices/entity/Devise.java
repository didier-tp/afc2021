package tp.webServices.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter 
@NoArgsConstructor 
public class Devise {
	
	@Id
	private String code; //ex: "EUR" , "USD" 
	
    private String nom ; //ex: "euro" , "dollar" 
    
    @Column(name="echange")
    private Double change; //nb unité pour 1 euro
    
    @OneToMany(mappedBy ="devise")
    @JsonIgnore  //un peu comme @XmlTransient
    private List<Pays> pays;
    
    

	public Devise(String code, String nom, Double change) {
		super();
		this.code = code;
		this.nom = nom;
		this.change = change;
	}



	@Override
	public String toString() {
		return "Devise [code=" + code + ", nom=" + nom + ", change=" + change + "]";
	}
    
    

}
