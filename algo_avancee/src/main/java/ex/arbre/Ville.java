package ex.arbre;

public class Ville {
    private String nom;
    private Integer population;

    public Ville(){
    }


    public Ville(String nom, Integer population) {
        this.nom = nom;
        this.population = population;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }
}
