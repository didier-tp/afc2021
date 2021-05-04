package tp.web.mbean;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import tp.core.bs.CompteService;
import tp.core.entity.Compte;

@ManagedBean //de JSF
@RequestScoped
public class CompteMBean {
	
	private Compte compte = new Compte(); //à saisir et ajouter
	
	private List<Compte> listeComptes ; //à afficher
	
	public String recuperListeComptes() {
		this.listeComptes = this.compteService.rechercherComptes();
		return null;//pour rester sur meme page .xhtml
	}
	
	public String sauvegarderNouveauCompte() {
		this.compte = this.compteService.ajouterCompte(this.compte);
		return null;//pour rester sur meme page .xhtml
	}
	
	//@EJB
	@Inject
	private CompteService compteService;

	public CompteMBean() {
		// TODO Auto-generated constructor stub
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public List<Compte> getListeComptes() {
		return listeComptes;
	}

	public void setListeComptes(List<Compte> listeComptes) {
		this.listeComptes = listeComptes;
	}
	
	

}
