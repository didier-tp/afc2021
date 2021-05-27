package fr.afcepf.al35.tp.web.mvc.form;

import fr.afcepf.al35.tp.web.mvc.form.data.Commande;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class CommandeForm {
	Commande cmde;
	ThActions prodActions;
	
	public CommandeForm(Commande cmde){
		this.cmde = cmde;
		this.resetThActions();
	}
	
	public void resetThActions() {
		this.prodActions= new ThActions();
	}
}
