package fr.afcepf.al35.tp.service;

import fr.afcepf.al35.tp.entity.Client;

public interface ClientService {
	Client sauvegarderClient(Client client);
	Client rechercherClientParNumero(long numero);
	Client nouveauClientAvecNouveauxComptesParDefaut(Client client);
}
