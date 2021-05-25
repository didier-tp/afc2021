package fr.afcepf.al35.tp.web.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import fr.afcepf.al35.tp.entity.Compte;
import fr.afcepf.al35.tp.service.CompteService;
import lombok.NoArgsConstructor;

@Controller 
@RequestMapping("/compte")
//avec session
@NoArgsConstructor
@SessionAttributes( value={"numClient","listeCpt"} ) //noms des "modelAttributes" qui sont EN PLUS récupérés/stockés en SESSION HTTP
                //au niveau de la page de rendu --> visibles en requestScope ET en sessionScope
public class CompteCtrl {

	
	@Autowired
	private CompteService compteService ;
	
	
	@RequestMapping(value="/login" )
    public String doLogin(Model model,@RequestParam("numClient")Long numClient) {
	    
	    List<Compte> listeCpt = this.compteService.comptesDuClient(numClient);
	    if(listeCpt!=null && !listeCpt.isEmpty()){
	          model.addAttribute("numClient",numClient);
              model.addAttribute("listeCpt",listeCpt);
              model.addAttribute("title","comptes");
	    }
        return "comptes"; 
    }
}
