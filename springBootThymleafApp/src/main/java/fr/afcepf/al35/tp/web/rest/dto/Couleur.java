package fr.afcepf.al35.tp.web.rest.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//DTO : Data Transfert Object

@Getter @Setter @ToString 
@NoArgsConstructor
public class Couleur {
	private String name; //ex: "red"
	private String code; //ex: "#ff0000"
	
	public Couleur(String name, String code) {
		super();
		this.name = name;
		this.code = code;
	}
	
	
}
