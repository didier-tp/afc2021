package tp.webServices.init;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import tp.webServices.entity.Devise;
import tp.webServices.service.DeviseService;

@Component
@Profile("initDataSet") //pour activation seulement si 
                       //le profile "initDataSet" est choisi 
                       //au démarrage
public class InitDataSet {
	
	DeviseService deviseService;

	public InitDataSet(DeviseService deviseService) {
		//injection par constructeur
		this.deviseService = deviseService;
		this.initData();
	}
	
	public void initData() {
		deviseService.sauvegarderDevise(new Devise("EUR","euro",1.0));
		deviseService.sauvegarderDevise(new Devise("USD","dollar",1.1));
		deviseService.sauvegarderDevise(new Devise("GBP","livre",0.9));
		deviseService.sauvegarderDevise(new Devise("JPY","yen",120.0));
	}

}
