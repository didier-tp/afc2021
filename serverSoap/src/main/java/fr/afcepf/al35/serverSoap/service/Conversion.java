package fr.afcepf.al35.serverSoap.service;

public interface Conversion {
    double convertir(double montant,String codeDeviseSource,String codeDeviseCible);
    public String getDev();
    //...
}
