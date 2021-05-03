package tp.client;

import tp.core.bs.CalculTva;

public class SoapClientApp {

	public static void main(String[] args) {
		
		CalculTva calculateurTva = new CalculTvaDeleguate();
		
		double resTva = calculateurTva.ttc(200.0, 20.0);
		System.out.println("SoapClientApp (dyn , sans wsimport)\n********");
		System.out.println("resTva="+resTva);
		System.out.println("Auteur="+calculateurTva.getAuteur());
	}

}
