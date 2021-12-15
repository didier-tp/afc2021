package tp.webServices.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Devise {
	
	@Id
	private String code; //ex: "EUR" , "USD" 
	
    private String nom ; //ex: "euro" , "dollar" 
    private Double change; //nb unité pour 1 euro
    
    //+get/set , ...

	public Devise() {
		// TODO Auto-generated constructor stub
	}

}
