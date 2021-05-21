package fr.afcepf.al35.tp.web.mvc;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import fr.afcepf.al35.tp.service.CompteService;
import fr.afcepf.al35.tp.web.mvc.form.VirementForm;

@Controller 
@RequestMapping("/virement")
//stateless
@SessionAttributes( value={"numClient","listeCpt"} ) //noms des "modelAttributes" qui sont EN PLUS récupérés/stockés en SESSION HTTP
                 //au niveau de la page de rendu --> visibles en requestScope ET en sessionScope
public class VirementCtrl {
	
	//pour  form:form , form:select , ...
    @ModelAttribute("virementForm")
	public VirementForm addConvAttributeInModel() {
	        return new VirementForm();
	}

	
	@Autowired
	private CompteService compteService;
	
	
	@RequestMapping("/to-virement")
    public String toVirment(){
	   return "virement"; 
    }
	
	@RequestMapping("/doVirement")
    public String doVirement(Model model,
    		                 @ModelAttribute("virementForm") @Valid VirementForm virementForm , 
    		                 BindingResult bindingResult,
    		                 HttpSession session) {
	if (bindingResult.hasErrors()) {
		    // form validation error
			System.out.println("form validation error: " + bindingResult.toString());
			return "virement";
		} else {
		    // form input is ok*/
		Long numClientIdentifie = (Long) session.getAttribute("numClient");
	    System.out.println("virement montant="+virementForm.getMontant() 
	                           + " numCptDeb="+virementForm.getNumCptDeb() 
	                           +" numCptCred="+virementForm.getNumCptCred());
       
	    compteService.transferer(virementForm.getNumCptDeb(), virementForm.getNumCptCred(), virementForm.getMontant());
	    
	    //reactualiser les valeurs des comptes en session http:
	    model.addAttribute("listeCpt", this.compteService.comptesDuClient(numClientIdentifie));
	    model.addAttribute("message", "virement bien effectue");
        return "comptes"; 
		}
    }
	
	
}
