package fr.afcepf.al35.serverSoap.service;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService //pour WebService SOAP
public interface Conversion {
    double convertir(@WebParam(name="montant")double montant,
    		@WebParam(name="codeDeviseSource")String codeDeviseSource,
    		@WebParam(name="codeDeviseCible")String codeDeviseCible);
    public String getDev();
    //...
}
