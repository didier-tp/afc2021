package fr.afcepf.al35.injection.trad;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"francais"})
public class TraducteurFrancais implements Traducteur {

	public TraducteurFrancais() {
	}

	@Override
	public String traduire(String msg) {
		return "traduction francaise de " + msg;
	}

}
