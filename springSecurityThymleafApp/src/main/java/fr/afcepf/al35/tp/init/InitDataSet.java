package fr.afcepf.al35.tp.init;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import fr.afcepf.al35.tp.entity.Client;
import fr.afcepf.al35.tp.entity.Compte;
import fr.afcepf.al35.tp.service.ClientService;
import fr.afcepf.al35.tp.service.CompteService;



@Profile("initData") //code ci-dessus activé que si le profile "initData" est choisi (parmis d'autres)
                     //au démarrage d'un test ou de l'application
@Component
//@Scope("singleton") par defaut
public class InitDataSet {
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Autowired
	CompteService compteService;
	
	@Autowired
	ClientService clientService;
	
	@PostConstruct
	public void initJeuxDeDonneesQueJaime() {
		
		Client client1 = clientService.sauvegarderClient(new Client(1L,"Bon", "jean",passwordEncoder.encode("pwd1")));
		Compte cA = new Compte(null,"compte A", 234.0);
		cA.setClient(client1);compteService.sauvegarderCompte(cA);
		Compte cB = new Compte(null,"compte B", 567.0);
		cB.setClient(client1);compteService.sauvegarderCompte(cB);
		
		Client client2 = clientService.sauvegarderClient(new Client(2L,"Therieur", "alex",passwordEncoder.encode("pwd2")));
		Compte cC = new Compte(null,"compte C", 56.0);
		cC.setClient(client2);compteService.sauvegarderCompte(cC);
		Compte cD = new Compte(null,"compte D", 76.0);
		cD.setClient(client2);compteService.sauvegarderCompte(cD);
	}

}
