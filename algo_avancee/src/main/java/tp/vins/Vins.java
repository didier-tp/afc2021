package tp.vins;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author Meryem et Axel et Didier
 */

public abstract class Vins {

    public static final String SEQ_FILE_NAME = "mesFichiers/VINstp.don"; //Fichier sequentiel de depart
    public static final String RAF_FILE_NAME = "mesFichiers/listeVins.bin"; //Fichier binaire/RAF a generer/trier et relire

    //NB: Cette classe abstraite comporte le code commun (herite) par les parties VinsP1 et VinsP2
    //********************************************************************************************

    //structure de la classe Vin :
    //nom du vin, appellation, region, nom du proprietaire, surface en hectares, numero de stand



    //listeVins recupere et affiche a la console toutes les donnees du fichier binaire/raf
    //eventuellement deja trie au prealable
    public static void listeVins(int compteurVins, RandomAccessFile raf) {
        try {
            raf.seek(0);
            for (int j = 0; j < compteurVins; j++) {
             Vin vin = new Vin();
             vin.readFromRaf(raf);
             System.out.println(vin.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //tri par extraction (ici via algo du tri a bulles) effectue directement sur le fichier binaire
    //sans tout remonter globalement en memoire ---> mauvaises performances (mais conforme a l'enonce)
    public static void triParExtraction(int longueurVin, int compteurVin, RandomAccessFile raf) {
        try {
            for (int i = 0; i < compteurVin - 1; i++) {
                int imini = i;
                raf.seek(i * Vin.TAILLE_VIN);
                String nomVinMini = "";
                nomVinMini = RafUtil.lectureStringInRaf(Vin.TAILLE_NOMVIN, raf);

                for (int j = i + 1; j < compteurVin; j += 1) {
                    raf.seek(j * Vin.TAILLE_VIN);
                    String nomVinCourant = "";
                    nomVinCourant = RafUtil.lectureStringInRaf(Vin.TAILLE_NOMVIN, raf);

                    if (nomVinCourant.compareTo(nomVinMini) < 0) {
                        imini = j;
                        nomVinMini = nomVinCourant;
                    }
                }
                permuter(imini * Vin.TAILLE_VIN, i * Vin.TAILLE_VIN, raf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void permuter(int pos1, int pos2, RandomAccessFile raf) {
        byte[] buffer1 = new byte[Vin.TAILLE_VIN];
        byte[] buffer2 = new byte[Vin.TAILLE_VIN];
        try {
            raf.seek(pos1); raf.read(buffer1);
            raf.seek(pos2); raf.read(buffer2);
            raf.seek(pos1); raf.write(buffer2);
            raf.seek(pos2); raf.write(buffer1);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }



}
