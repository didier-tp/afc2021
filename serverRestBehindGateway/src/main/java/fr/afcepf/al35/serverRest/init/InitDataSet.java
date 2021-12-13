package fr.afcepf.al35.serverRest.init;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import fr.afcepf.al35.serverRest.dao.DaoDevise;
import fr.afcepf.al35.serverRest.dao.DaoPays;
import fr.afcepf.al35.serverRest.entity.Devise;
import fr.afcepf.al35.serverRest.entity.Pays;

@Component
@Profile({"initDataSet"})
public class InitDataSet {
	
	@Autowired
	private DaoDevise daoDevise;
	
	@Autowired
	private DaoPays daoPays;
	
	@PostConstruct
	public void init() {
		Devise eur = daoDevise.save(new Devise("EUR","Euro",1.0));
		daoDevise.save(new Devise("USD","Dollar",1.1));
		daoDevise.save(new Devise("GBP","Livre",0.9));
		daoDevise.save(new Devise("JPY","Yen",123.6));
		daoDevise.save(new Devise("Ma","MonnaieA",1.23));
		daoDevise.save(new Devise("Mb","MonnaieB",1.56));
		daoDevise.save(new Devise("Mc","MonnaieC",1.9));
		daoDevise.save(new Devise("Md","MonnaieD",0.956));
		
		Pays paysFr = new Pays("fr" , "france");
		paysFr.setDevise(eur); daoPays.save(paysFr);
		
		Pays paysDe = new Pays("de" , "Allemagne");
		paysDe.setDevise(eur); daoPays.save(paysDe);
		
		Pays paysEs = new Pays("es" , "Espagne");
		paysEs.setDevise(eur); daoPays.save(paysEs);
		//...
		
	}
	

}
