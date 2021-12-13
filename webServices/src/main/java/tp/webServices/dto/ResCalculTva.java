package tp.webServices.dto;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//DTO = data transfert object
//sur version WS SOAP : sera converti en XML via JAX-WS et JAXB2 (javax.xml.bind...)
//sur version WS REST : sera converti en JSON via jackson-databind

@XmlType(namespace="http://dto.webServices.tp/") //namespace xml (package a l'envers)
@XmlRootElement(name="resCalculTva") //nom de balise xml (pour conv java --> xml)
@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class ResCalculTva {
	
	private double tva;
	private double ttc;

}
