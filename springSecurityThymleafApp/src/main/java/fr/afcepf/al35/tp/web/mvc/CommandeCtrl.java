package fr.afcepf.al35.tp.web.mvc;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.afcepf.al35.tp.web.mvc.form.Commande;
import fr.afcepf.al35.tp.web.mvc.form.Customer;
import fr.afcepf.al35.tp.web.mvc.form.Produit;
import fr.afcepf.al35.tp.web.mvc.form.VirementForm;

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
		model.addAttribute("cmde",cmde);
	   return "commande"; 
    }
	
	@RequestMapping("/update-commande")
    public String updateCommande(Model model,
    		                 @ModelAttribute("cmde") Commande cmde , 
    		                 HttpSession session) {
		System.out.println("updated cmde="+cmde);
		model.addAttribute("cmde",cmde);
		return "commande"; 
	}
	
}
