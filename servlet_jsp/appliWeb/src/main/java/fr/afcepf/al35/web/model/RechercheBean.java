package fr.afcepf.al35.web.model;

public class RechercheBean {
	
	private String nomPays; //nom pays à rechercher
	private Pays pays;//resultat de la recherche
	private String messagePrive;

	public RechercheBean() {
	}
	
	public boolean rechercherPays() {
		boolean ok = true;
		messagePrive="pays existant";
		switch(nomPays.toLowerCase()) {
		case "france" : 
			this.pays = new Pays ("France" , "Paris" , 65000000L);
			break;
		case "allemagne" : 
			this.pays = new Pays ("Alemagne" , "Berlin" , 85000000L);
			break;
		default :
			messagePrive="pays inconnu";
			ok = false;
		}
		return ok;
	}

	public String getNomPays() {
		return nomPays;
	}

	public void setNomPays(String nomPays) {
		this.nomPays = nomPays;
	}

	public Pays getPays() {
		return pays;
	}

	public void setPays(Pays pays) {
		this.pays = pays;
	}

	public String getMessage() {
		return messagePrive;
	}

	public void setMessage(String message) {
		this.messagePrive = message;
	}
	
	

}
