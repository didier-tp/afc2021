package tp.vins;

import java.io.RandomAccessFile;

public class Vin {

    //NB: les constantes suivantes correspondent aux tailles fixes
    //des donnees qui seront stockees dans le fichier binaire (RAF)
    public static final int TAILLE_NOMVIN = 50;
    public static final int TAILLE_APPELLATION = 25;
    public static final int TAILLE_REGION = 20;
    public static final int TAILLE_NOMPROPRIO = 10;
    public static final int TAILLE_NUMEROSTAND = 3;
    public static final int TAILLE_VIN = ((TAILLE_NOMVIN + TAILLE_APPELLATION + TAILLE_REGION + TAILLE_NOMPROPRIO + TAILLE_NUMEROSTAND) * 2)
            + 4; // 4 representant la taille d'un int en binaire (surfaceHt)
    //*2 car un caractere java unicode est code sur 2 octets

    private String nom; //sur 50 car.
    private String appelation; //sur 25 car.
    private String region; //sur 20 car.
    private String nomProprio; //sur 10 car.
    private int surfaceHt ; //sur 4 octects
    private String numStand; //sur 3 car

    public Vin() {
    }

    public Vin(String nom, String appelation, String region, String nomProprio, int surfaceHt, String numStand) {
        this.nom = nom;
        this.appelation = appelation;
        this.region = region;
        this.nomProprio = nomProprio;
        this.surfaceHt = surfaceHt;
        this.numStand = numStand;
    }

    @Override
    public String toString() {
        return "Vin{" +
                "nom='" + nom + '\'' +
                ", appelation='" + appelation + '\'' +
                ", region='" + region + '\'' +
                ", nomProprio='" + nomProprio + '\'' +
                ", surfaceHt=" + surfaceHt +
                ", numStand='" + numStand + '\'' +
                '}';
    }



    //cette methode reajuste si besoin les tailles des chaines de
    //caracteres de maniere e ce que chaque record/objet ait globalement
    //la meme taille .
    public void adjustFixedSizes(){
        this.nom = RafUtil.completer(this.nom, TAILLE_NOMVIN);
        this.appelation = RafUtil.completer(this.appelation, TAILLE_APPELLATION);
        this.region = RafUtil.completer(this.region, TAILLE_REGION);
        this.nomProprio = RafUtil.completer(this.nomProprio , TAILLE_NOMPROPRIO);
        //rien à faire sur suraceHt qui est un int (de toujours 4 octets)
        this.numStand = RafUtil.completer(this.numStand, TAILLE_NUMEROSTAND);
    }

    public void writeInRaf(RandomAccessFile raf){
        this.adjustFixedSizes();
        try {
            raf.writeChars(this.nom);
            raf.writeChars(this.appelation);
            raf.writeChars(this.region);
            raf.writeChars(this.nomProprio);
            raf.writeInt(this.surfaceHt);//as integer
            raf.writeChars(this.numStand);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    //NB: penser a appeler si besoin raf.seek(...) avant d'appeler cette methode
    public void readFromRaf(RandomAccessFile raf){
        try {
            this.nom = RafUtil.lectureStringInRaf(TAILLE_NOMVIN, raf);
            this.appelation = RafUtil.lectureStringInRaf(TAILLE_APPELLATION, raf);
            this.region = RafUtil.lectureStringInRaf(TAILLE_REGION, raf);
            this.nomProprio =  RafUtil.lectureStringInRaf(TAILLE_NOMPROPRIO, raf);
            this.surfaceHt=raf.readInt();//as integer
            this.numStand = RafUtil.lectureStringInRaf(TAILLE_NUMEROSTAND, raf);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAppelation() {
        return appelation;
    }

    public void setAppelation(String appelation) {
        this.appelation = appelation;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getNomProprio() {
        return nomProprio;
    }

    public void setNomProprio(String nomProprio) {
        this.nomProprio = nomProprio;
    }

    public int getSurfaceHt() {
        return surfaceHt;
    }

    public void setSurfaceHt(int surfaceHt) {
        this.surfaceHt = surfaceHt;
    }

    public String getNumStand() {
        return numStand;
    }

    public void setNumStand(String numStand) {
        this.numStand = numStand;
    }
}
