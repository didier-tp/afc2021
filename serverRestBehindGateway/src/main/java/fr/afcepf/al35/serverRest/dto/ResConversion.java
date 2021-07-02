package fr.afcepf.al35.serverRest.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

//DTO = Data Transfert Object (converti de java en Json)
@Data //@Data = @Getter + @Setter + @ToString + @...Constructor
public class ResConversion /*implements Serializable*/ {
	@ApiModelProperty(value = "amount to convert", example = "200")
	private Double amount; //ex: 200
	
	@ApiModelProperty(value = "code monnaie source", example = "EUR")
	private String source; //ex: "EUR"
	
	@ApiModelProperty(value = "code monnaie cible", example = "USD")
	private String target; //ex: "USD"
	
	@ApiModelProperty(value = "resultat conversion (montant converti)", example = "220")
	private Double result; //ex: 220
}
