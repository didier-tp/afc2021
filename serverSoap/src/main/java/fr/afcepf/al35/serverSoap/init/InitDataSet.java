package fr.afcepf.al35.serverSoap.init;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.afcepf.al35.serverSoap.dao.DaoDevise;
import fr.afcepf.al35.serverSoap.entity.Devise;

@Component
//@Profile({"initDataSet"})
public class InitDataSet {
	
	@Autowired
	private DaoDevise daoDevise;
	
	@PostConstruct
	public void init() {
		daoDevise.save(new Devise("EUR","Euro",1.0));
		daoDevise.save(new Devise("USD","Dollar",1.1));
		daoDevise.save(new Devise("GBP","Livre",0.9));
		daoDevise.save(new Devise("JPY","Yen",123.6));
	}
	

}
