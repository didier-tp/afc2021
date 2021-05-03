package tp.core.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

//objet de donnees vehicule via RMI = doit absolument etre Serializable
@XmlType(namespace="http://dto.core.tp/")
@XmlRootElement(name="resCalculTva")
//namespace par defaut = "http:// package_java_en_verlan /"
// "toc, toc, toc ! qui est ce ? une poule qui parle en verlan "
public class ResCalculTva implements Serializable{

	private static final long serialVersionUID = 1L;
	
		private double tva;
		private double ttc;
		
		public ResCalculTva() {
			super();
		}
		
		public ResCalculTva(double tva, double ttc) {
			super();
			this.tva = tva;
			this.ttc = ttc;
		}
		public final double getTva() {
			return tva;
		}
		public final void setTva(double tva) {
			this.tva = tva;
		}
		public final double getTtc() {
			return ttc;
		}
		public final void setTtc(double ttc) {
			this.ttc = ttc;
		}
		
}
