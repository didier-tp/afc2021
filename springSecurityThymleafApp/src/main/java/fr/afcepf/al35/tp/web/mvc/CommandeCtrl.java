package fr.afcepf.al35.tp.web.mvc;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.afcepf.al35.tp.web.mvc.form.CommandeForm;
import fr.afcepf.al35.tp.web.mvc.form.ThActions;
import fr.afcepf.al35.tp.web.mvc.form.data.Commande;
import fr.afcepf.al35.tp.web.mvc.form.data.Customer;
import fr.afcepf.al35.tp.web.mvc.form.data.Produit;

@Controller 
@RequestMapping("/commande")
public class CommandeCtrl {
		
	public Commande buildInitialCommande() {
		Commande cmde = new Commande(1L,"2021-05-27");
		Customer cli = new Customer(1L,"Bon","Jean");
		cmde.setClient(cli);
		cmde.addProduit(new Produit(1L,"produit1",5.5));
		cmde.addProduit(new Produit(2L,"produit2",6.6));
		return cmde;
	}
	
	@RequestMapping("/aff-commande")
    public String affCommande(Model model){
		Commande cmde = buildInitialCommande() ;
		System.out.println("initial_commande (before update):" + cmde);
		CommandeForm cmdeF = new CommandeForm(cmde);
		model.addAttribute("cmdeF",cmdeF);
	   return "commande"; 
    }
	
	@RequestMapping("/update-commande")
    public String updateCommande(Model model,
    		                 @ModelAttribute("cmdeF") CommandeForm cmdeF , 
    		                 HttpSession session) {
		System.out.println("actionsOnProductsOfCmde="+cmdeF.getProdActions());
		int nbNew = cmdeF.getProdActions().getNbNew();
		if(nbNew>0) {
			for(int i=0;i<nbNew;i++) {
				cmdeF.getCmde().getProduits().add(new Produit());
			}
		}
		cmdeF.resetThActions();
		System.out.println("updated cmde="+cmdeF.getCmde());
		model.addAttribute("cmdeF",cmdeF);
		return "commande"; 
	}
	
}
