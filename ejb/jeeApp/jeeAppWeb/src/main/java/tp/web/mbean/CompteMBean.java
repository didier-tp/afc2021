package tp.web.mbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
//import javax.annotation.ManagedBean;
//import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import tp.core.bs.CompteService;
import tp.core.entity.Compte;

@ManagedBean //de JSF
@RequestScoped
public class CompteMBean {
	
	//@EJB
	@Inject
	private CompteService compteService=null;
	
	@PostConstruct
	public void init() {
		recuperListeComptes();
	}

	public CompteMBean() {
	}
	
	private Compte compte = new Compte(); //à saisir et ajouter
	private String message = ""; //à aficher
	private List<Compte> listeComptes ; //à afficher
	
	public String recuperListeComptes() {
		this.listeComptes = this.compteService.rechercherComptes();
		return null;//pour rester sur meme page .xhtml
	}
	
	public String sauvegarderNouveauCompte() {
		try {
			this.compte = this.compteService.ajouterCompte(this.compte);
			this.message = "nouveau compte " + compte.toString();
			recuperListeComptes();
		} catch (Exception e) {
			this.message="echec ajout" ;
			e.printStackTrace();
		}
		return null;//pour rester sur meme page .xhtml
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
