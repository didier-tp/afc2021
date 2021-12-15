package tp.webServices.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@NoArgsConstructor 
public class Currency {
	
	private String code;
	private String name;
	private Double rate;
	
	public Currency(String code, String name, Double rate) {
		super();
		this.code = code;
		this.name = name;
		this.rate = rate;
	}
	
	//...
    
    

}
