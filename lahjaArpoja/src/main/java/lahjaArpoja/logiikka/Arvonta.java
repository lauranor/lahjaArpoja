package lahjaArpoja.logiikka;
/* *
 * Luokka 
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Arvonta {

    private HashMap<String, String> arvotut;                                    //Valmis HashMap, jossa pareina lahjan antaja ja saaja
    private ArrayList<String> osallistujat;                                     //Arvontaan osallistuvat
    private int[] indeksit;                                                     //Arvottujen parien indeksit välillä 1..osallistujat.size+1

    public Arvonta(ArrayList osallistujat) {
        this.osallistujat = osallistujat;
        this.indeksit = new int[osallistujat.size()];
    }

    /**
     * Arpoo osallistujille pariksi indeksin, jonka perusteella jokainen osallistuja saa
     * parikseen toisen listan osallistujista.
     */
    public void parienArvonta() {

        if (osallistujat.size() == 0) {
            System.out.println("Ei annettuja osallistujia.");
        }

        for (String osallistuja : osallistujat) {                               //Jokaiselle osallistujalle saadaan
            int random = getRandom(osallistujat.size());                    //pari arpomalla indeksi.

            while (onkoListalla(random)) {                                      //Tarkistetaan ettei indeksi ole vielä arvottujen joukossa
                random = getRandom(osallistujat.size());                    //Jos on, arvotaan uusi random.
            }

            indeksit[osallistujat.indexOf(osallistuja)] = random;

        }

        if (!onkoItseParina()) {
            System.out.println("\nArvotaan uudestaan");
            tyhjennaIndeksit();
            parienArvonta();                                                    //jos itsensä parina, uusi arvonta.

        } else if (onkoItseParina()) {
            System.out.println("Arvonta suoritettu onnistuneesti.");

            ArvottuLista lista = new ArvottuLista(osallistujat, indeksit);
            arvotut = lista.laitaListalle();
        }

    }
    
    /**
    * Arpoo luvun väliltä 1 - osallistujien määrä.
    * @param montako osallistujien määärä
    * @return random luku väliltä 1 - osallistujien määrä
    */
    private int getRandom(int montako) {
        Random random = new Random();
        int i = random.nextInt(montako) + 1;
        return i;
    }

    /**
     * tarkistaa onko arvottu indeksi uusi
     * @param r arvottu indeksi
     * @return  false jos listalla ei ole parametrina annettua indeksiä, muuten true.
     */
    private boolean onkoListalla(int r) {
        if (indeksit.length == 0) {
            return false;
        }

        for (int numero : indeksit) {
            if (numero == r) {
                return true;
            }
        }

        return false;
    }

    /**
     * Tarkistaa onko arvonnassa joku saanut itse itsensä parikseen
     * @return  false jos jollakulla on itsensä parina, muuten true
     */
    private boolean onkoItseParina() {
        for (int n = 0; n < indeksit.length; n++) {
            if (n == (indeksit[n] - 1)) {
                return false;                                                 
            }
        }
        return true;
    }

    private void tyhjennaIndeksit() {
        for (int i = 0; i < indeksit.length; i++) {
            indeksit[i] = 0;
        }

    }

    /**
     * Palauttaa antajalle arvotun parin
     * @param antaja 
     * @return lahjan saajan nimi
     */
    public String getPari(String antaja) {
        if (!arvotut.containsKey(antaja)) {
            return "Et ole mukana arvonnassa :(";
        }
        return "Sinun lahjan saajasi on " + arvotut.get(antaja);
    }

}
