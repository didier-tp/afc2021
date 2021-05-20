package fr.afcepf.al35.tp.web;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import fr.afcepf.al35.tp.entity.Compte;
import fr.afcepf.al35.tp.service.CompteService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ManagedBean
@RequestScoped
@Getter @Setter @NoArgsConstructor
public class VirementMBean {
	
	private Long numCptDeb;
	private Long numCptCred;
	private Double montant;
	
	private String message="";
	
	@Inject //ou @Autowired
	private CompteService compteService;
	
	@Inject //ou @Autowired
	private CompteMBean compteMBean;
	
	
	@PostConstruct
	public void init() {
		
	}
	
	public String doVirement() {
		String suite=null;
		try {
			compteService.transferer(numCptDeb, numCptCred, montant);
			suite=compteMBean.doRecupComptesDuClient();
			//suite = "comptes.xhtml"; //naviguer vers liste des comptes à jour
		} catch (Exception e) {
			e.printStackTrace();
			this.message=e.getMessage();
		}
		return suite;
	}
}
