package fr.afcepf.al35.injection.trad;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"allemand"})
public class TraducteurAllemand implements Traducteur {

	public TraducteurAllemand() {
	}

	@Override
	public String traduire(String msg) {
		return "traduction allemande de " + msg;
	}

}
