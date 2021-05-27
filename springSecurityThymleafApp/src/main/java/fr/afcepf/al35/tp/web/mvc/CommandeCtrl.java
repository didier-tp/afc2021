package fr.afcepf.al35.tp.web.mvc;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.afcepf.al35.tp.web.mvc.form.CommandeForm;
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
		cmde.addProduit(new Produit(3L,"produit3",7.7));
		return cmde;
	}
	
	
	@RequestMapping("/update-commande")
    public String updateCommande(Model model,
    		                 @ModelAttribute("cmdeF") CommandeForm cmdeF , 
    		                 HttpSession session) {
		if(cmdeF.getCmde()==null) {
			Commande cmde = buildInitialCommande() ;
			System.out.println("initial_commande (before update):" + cmde);
			cmdeF = new CommandeForm(cmde);
		}
		cmdeF.adjustCommandeFromThActions();
		System.out.println("updated cmde="+cmdeF.getCmde());
		model.addAttribute("cmdeF",cmdeF);
		return "commande"; 
	}
	
}
