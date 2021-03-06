package fr.afcepf.al35.tp.web.mvc;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.afcepf.al35.tp.dto.Devise;
import fr.afcepf.al35.tp.service.ConversionServiceDelegate;
import fr.afcepf.al35.tp.service.DeviseServiceDelegate;

@Controller 
public class AppCtrl {
	
	@Autowired
	private ConversionServiceDelegate conversionServiceDelegate;
	
	@Autowired
	private DeviseServiceDelegate deviseServiceDelegate;
	
	@ModelAttribute("idSession")
	public String idSession(HttpSession session) {
		return session.getId();
	}
	
	@RequestMapping("/to-welcome") //forEveryBody (permitAll)
	String toWelcome(Model model) {
		model.addAttribute("message", "bienvenu(e)");
		model.addAttribute("title","welcome");
		
		try {
		//Essai de conversion via WS SOAP
		//si le serveur serverSoap est démarré
		double montantDollar = 
				conversionServiceDelegate.convertir(100.0, "EUR", "USD");
		model.addAttribute("montantDollar",montantDollar);
		
		String dev = 
				conversionServiceDelegate.getDev();
		model.addAttribute("dev",dev);
		}catch(Exception ex) {
			System.err.println("pas de ws saop accessible");
		}
		
		try {
			//essai de conversion avec WS REST
			//si le serveur restServer est démarré
			double montantDollar = 
					deviseServiceDelegate.convertir(100.0, "EUR", "USD");
			model.addAttribute("montantDollar",montantDollar);
			
			List<Devise> devises = deviseServiceDelegate.listeDevises();
			model.addAttribute("dev",devises.toString());
		} catch (Exception e) {
			System.err.println("pas de ws rest accessible");
			//e.printStackTrace();
		}
		
	    return "welcome"; 
	}
	
	@RequestMapping("/to-welcome-authenticated")//automatic auth Required
	String toWelcomeAuthenticated(Model model) {
		model.addAttribute("message", "bienvenu(e)");
		model.addAttribute("title","welcome-authenticated");
	    return "welcomeAuth"; 
	}
	
	@RequestMapping("/to-login")
	String toLogin(Model model) {
		model.addAttribute("title","login");
	    return "login"; 
	}
	
	@RequestMapping("/to-login-springSecurity")
	String toLoginSpringSecurity(Model model) {
		model.addAttribute("title","loginSpringSecurity");
	    return "loginSpringSecurity"; 
	}
	
	@RequestMapping("/with-login-error")
	String withLoginError(Model model) {
		model.addAttribute("title","loginSpringSecurity");
		model.addAttribute("loginError", true);
	    return "loginSpringSecurity"; 
	}
	
	@PreAuthorize("hasRole('ADMIN')") //check if ROLE_ADMIN
	@RequestMapping("/to-for-admin")
	String toForAdmin(Model model) {
		model.addAttribute("title","for-admin");
	    return "for-admin"; 
	}
	
	@RequestMapping("/to-carousel")
	String toCarousel(Model model) {
		model.addAttribute("title","carousel");
	    return "carousel_slideshow.html"; 
	}
	
	@RequestMapping("/to-ex-ajax")
	String toExAjax(Model model) {
		model.addAttribute("title","ex-ajax");
	    return "ex-ajax"; 
	}
	
	@RequestMapping("/session-end")
    public String finSession(Model model,HttpSession session) {
	    SecurityContextHolder.clearContext(); //RAZ context Spring security
	    session.invalidate();
        model.addAttribute("message", "session terminée");
        model.addAttribute("title","welcome");
        return "welcome"; 
    }
}
