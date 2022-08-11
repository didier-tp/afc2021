package ex.arbre;


public class IndexNom {
    private String nom; //nom de la chose
    private Integer index; //index ou position de la chose rangée quelquepart (dans un tableau ou dans un fichier)

    public IndexNom() {
    }

    public IndexNom(String nom, Integer index) {
        this.nom = nom;
        this.index = index;
    }

    @Override
    public String toString() {
        return "IndexNom{" +
                "nom='" + nom + '\'' +
                ", index=" + index +
                '}';
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
