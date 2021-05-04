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
import tp.core.entity.Operation;

@ManagedBean //de JSF
@RequestScoped
public class CompteMBean {
	
	//@EJB
	@Inject
	private CompteService compteService=null;
	
	@PostConstruct
	public void init() {
		recuperListeComptes();
		testTemporaire();
	}
	
	private void testTemporaire() {
		Compte cpt1 = compteService.rechercherCompteSelonNumero(1L);
		//cpt1 est ici à l'état détaché
		System.out.println("cpt1="+cpt1.toString());
		//risque de "LazyEXception" :
		for(Operation op : cpt1.getOperations()) {
			System.out.println("op="+op.toString());
		}
	}

	public CompteMBean() {
	}
	
	private Compte compte = new Compte(); //à saisir et ajouter
	private String message = ""; //à afficher
	private List<Compte> listeComptes ; //à afficher
	
	//pour le formulaire de virement:
	private Double montant;
	private Long numCptDeb;
	private Long numCptCred;
	
	public String recuperListeComptes() {
		this.listeComptes = this.compteService.rechercherComptes();
		return null;//pour rester sur meme page .xhtml
	}
	
	public String effectuerVirement() {
		try {
			this.message="";
			this.compteService.transferer(this.montant, this.numCptDeb, this.numCptCred);
			this.message="virement bien effectué";
			this.listeComptes = this.compteService.rechercherComptes();
		} catch (Exception e) {
			this.message ="echec virement " + e.getMessage();
			e.printStackTrace();
		}
		return null;//pour rester sur meme page .xhtml
	}
	
	public String sauvegarderNouveauCompte() {
		try {
			this.message="";
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public Long getNumCptDeb() {
		return numCptDeb;
	}

	public void setNumCptDeb(Long numCptDeb) {
		this.numCptDeb = numCptDeb;
	}

	public Long getNumCptCred() {
		return numCptCred;
	}

	public void setNumCptCred(Long numCptCred) {
		this.numCptCred = numCptCred;
	}
	
	

}
