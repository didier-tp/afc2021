package fr.afcepf.al35.web.model;

public class Pays {
	
	private String nom;
	private String capitale;
	private Long population;
	//...

	public Pays() {
	}
	
	
	public Pays(String nom, String capitale, Long population) {
		super();
		this.nom = nom;
		this.capitale = capitale;
		this.population = population;
	}


	@Override
	public String toString() {
		return "Pays [nom=" + nom + ", capitale=" + capitale + ", population=" + population + "]";
	}



	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCapitale() {
		return capitale;
	}

	public void setCapitale(String capitale) {
		this.capitale = capitale;
	}

	public Long getPopulation() {
		return population;
	}

	public void setPopulation(Long population) {
		this.population = population;
	}
	
	

}
