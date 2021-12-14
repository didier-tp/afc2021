package tp.webServices.client;

import tp.webServices.service.CalculTva;

public class ClientWsSoap {

	public static void main(String[] args) {
        CalculTva calculTva = new CalcuTvaBusinessDelegate();
        //ou .getInstance() si singleton
        
		double ttc =calculTva.ttc(200.0,20.0);
		System.out.println("ttc=" + ttc);//ttc=240 si ok
	}

}
