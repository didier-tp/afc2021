package fr.afcepf.al35.tp.dto;

import lombok.Data;

//DTO = Data Transfert Object (converti de java en Json)
@Data //@Data = @Getter + @Setter + @ToString + @...Constructor
public class ResConversion /*implements Serializable*/ {
	private Double amount; //ex: 200
	private String source; //ex: "EUR"
	private String target; //ex: "USD"
	private Double result; //ex: 220
}
