package tp.webServices.init;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import tp.webServices.dao.PaysDao;
import tp.webServices.entity.Devise;
import tp.webServices.entity.Pays;
import tp.webServices.service.DeviseService;

@Component
@Profile("initDataSet") //pour activation seulement si 
                       //le profile "initDataSet" est choisi 
                       //au démarrage
public class InitDataSet {
	
	DeviseService deviseService;
	PaysDao paysDao;

	public InitDataSet(DeviseService deviseService,
			           PaysDao paysDao) {
		//injection par constructeur
		this.deviseService = deviseService;
		this.paysDao = paysDao;
		this.initData();
	}
	
	public void initData() {
		Devise deviseEuro =  new Devise("EUR","euro",1.0);
		deviseService.sauvegarderDevise(deviseEuro);
		
		
		paysDao.save(new Pays("fr","France",deviseEuro));
		paysDao.save(new Pays("it","Italie",deviseEuro));
		paysDao.save(new Pays("de","Allemagne",deviseEuro));
		paysDao.save(new Pays("es","espagne",deviseEuro));	
		
		deviseService.sauvegarderDevise(new Devise("USD","dollar",1.1));
		deviseService.sauvegarderDevise(new Devise("GBP","livre",0.9));
		deviseService.sauvegarderDevise(new Devise("JPY","yen",120.0));
	}

}
