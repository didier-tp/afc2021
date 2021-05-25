package fr.afcepf.al35.tp.web.mvc.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class VirementForm {
	
	@Min(value=0)
	@Max(value=999999)
	private Double montant;
	@Min(value=1)
	private Long numCptDeb;
	@Min(value=1)
	private Long numCptCred;
	
	
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
