package tp.webServices.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@NoArgsConstructor 
public class Currency {
	
	private String code;
	private String name;
	
	@Schema(example = "1.1" , description = "nb unite pour 1 euro")
	private Double rate;
	
	public Currency(String code, String name, Double rate) {
		super();
		this.code = code;
		this.name = name;
		this.rate = rate;
	}
	
	//...
    
    

}
