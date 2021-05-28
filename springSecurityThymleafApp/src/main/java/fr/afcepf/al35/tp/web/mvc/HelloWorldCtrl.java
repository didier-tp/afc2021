package fr.afcepf.al35.tp.web.mvc;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.afcepf.al35.tp.entity.Compte;
import fr.afcepf.al35.tp.service.CompteService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Controller 
public class HelloWorldCtrl {
	
	@RequestMapping("/hello-world")
	@ResponseBody //si @ResponseBody , génération directe de la réponse
	String say_hello() {
	    return "Hello World!";
	}
}
