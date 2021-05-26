package fr.afcepf.al35.tp.web.mvc;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
//@RequestMapping(value="/mvc/welcome" , produces = "text/html;charset=UTF-8")
@RequestMapping("/app")
public class AppCtrl {
	
	@ModelAttribute("idSession")
	public String idSession(HttpSession session) {
		return session.getId();
	}
	
	@RequestMapping("/to-welcome")
	String toWelcome(Model model) {
		model.addAttribute("message", "bienvenu(e)");
		model.addAttribute("title","welcome");
	    return "welcome"; //welcome.jsp ou ... dans src/main/resources/META-INF/resources/jsp ou ailleurs
	}
	
	@RequestMapping("/to-login")
	String toLogin(Model model) {
		model.addAttribute("title","login");
	    return "login"; //login.jsp ou ... dans src/main/resources/META-INF/resources/jsp ou ailleurs
	}
	
	@RequestMapping("/to-carousel")
	String toCarousel(Model model) {
		model.addAttribute("title","carousel");
	    return "carousel_slideshow.html"; 
	}
	
	@RequestMapping("/to-ex-ajax")
	String toExAjax(Model model) {
		model.addAttribute("title","ex-ajax");
	    return "ex-ajax"; //login.jsp ou ... dans src/main/resources/META-INF/resources/jsp ou ailleurs
	}
	
	@RequestMapping("/session-end")
    public String finSession(Model model,HttpSession session) {
	    //SecurityContextHolder.clearContext(); //RAZ context Spring security
	    session.invalidate();
        model.addAttribute("message", "session terminée");
        model.addAttribute("title","welcome");
        return "welcome"; 
    }
}
