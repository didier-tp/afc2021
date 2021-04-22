package fr.afcepf.al35.web.model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

public class CaddyBean {
	
	private String message;
	private List<String> caddy; //on pourrait avoir List<Selection> en mieux

	public void addProduitDansCaddy(String produit,HttpSession session) {
		this.caddy = (List<String>) session.getAttribute("caddy"); 
		if(this.caddy == null) {
			this.caddy = new ArrayList<String>();
			session.setAttribute("caddy",this.caddy); 
		}
	    this.caddy.add(produit);
	    this.message="le produit " + produit 
	    		+ " a ete ajouté au caddy. Le caddy comporte maintant " 
	    		+ this.caddy.size() + " elements";
	}
	
	public CaddyBean() {
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getCaddy() {
		return caddy;
	}

	public void setCaddy(List<String> caddy) {
		this.caddy = caddy;
	}
	
	

}
