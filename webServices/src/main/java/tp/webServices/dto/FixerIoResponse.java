package tp.webServices.dto;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//type de réponse brute attendue:
/*
	{"success":true,"timestamp":1635959583,"base":"EUR","date":"2021-11-03",
	"rates":{"AED":4.254663,"AFN":105.467869,..., "EUR":1 , ...}}
*/


@Getter @Setter @ToString
@NoArgsConstructor
public class FixerIoResponse {
	
	private Boolean success;
	private Long timestamp;
	private String base; //ex: "EUR"
	private String date; //ex: "2021-11-03"
	private Map<String,Double> rates = new HashMap<>();

}
