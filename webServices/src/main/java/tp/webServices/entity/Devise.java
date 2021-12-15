package tp.webServices.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString 
@NoArgsConstructor @AllArgsConstructor
public class Devise {
	
	@Id
	private String code; //ex: "EUR" , "USD" 
	
    private String nom ; //ex: "euro" , "dollar" 
    
    @Column(name="echange")
    private Double change; //nb unité pour 1 euro
    


}
