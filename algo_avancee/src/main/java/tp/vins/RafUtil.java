package tp.vins;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RafUtil {

    /*
     * la fonction lectureStringInRaf va lire une partie d'un enregistrement du fichier binaire a la position courante
     * de raf (qui doit etre prealablement initialisee via un appel a raf.seek(position_a_lire)
     * Le resultat de la lecture sera une chaine de caractere à reinterpreter
     */
    public static String lectureStringInRaf(int longueurChaine, RandomAccessFile raf) {
        String chaine = "";
        try {
            for (int i = 0; i < longueurChaine; i++) {
                chaine += raf.readChar();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return chaine;
    }

    public static String completerV1(String mot, int taille) {
        //completer si besoin par des espaces a la fin une chaine de caracteres
        //de maniere a ce quelle soit de la taille fixe souhaitee
        int nbEspace = taille - mot.length();
        for (int i = 0; i < nbEspace; i++) {
            mot += " ";
        }
        return mot;
    }


    public static String completer(String mot, int taille) {
        return String.format("%-"+taille+"s", mot);
    }

}
