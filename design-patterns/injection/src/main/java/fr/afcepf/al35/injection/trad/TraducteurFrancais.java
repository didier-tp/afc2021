package fr.afcepf.al35.injection.trad;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
//il existe des cas particuliers de @Component (@Service , @Repository, ...)
@Profile({"francais"})
//Cette classe sera prise en charge par spring
//seulement si un des profiles indiqués par @Profiles() est activé 
//au démarrage de l'application
public class TraducteurFrancais implements Traducteur {

	public TraducteurFrancais() {
	}

	@Override
	public String traduire(String msg) {
		return "traduction francaise de " + msg;
	}

}
