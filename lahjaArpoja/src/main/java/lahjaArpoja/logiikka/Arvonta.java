package lahjaArpoja.logiikka;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
/* *
 * Luokka arpoo sille parametrina annetulla listalla olevien henkilöiden
 * välisesti lahjan saajan jokaiselle osallistujalle.
 */
public class Arvonta {

    private HashMap<Henkilo, Henkilo> arvotut;                                  //Valmis HashMap, jossa pareina lahjan antaja ja saaja
    private ArrayList<Henkilo> osallistujat;                                    //Arvontaan osallistuvat
    private int[] indeksit;                                                     //Arvottujen parien indeksit välillä 1..osallistujat.size+1

    public Arvonta(ArrayList osallistujat) {
        this.osallistujat = osallistujat;
        this.indeksit = new int[osallistujat.size()];
    }

    /**
     * Arpoo osallistujille pariksi indeksin, jonka perusteella jokainen osallistuja saa
     * parikseen yhden osallistujalistan henkilöistä.
     */
    public void parienArvonta() {

        if (osallistujat.size() <= 1) {
            return;
        }

        for (Henkilo osallistuja : osallistujat) {                              //Jokaiselle osallistujalle saadaan
            int random = getRandom(osallistujat.size());                        //pari arpomalla indeksi.

            while (onkoListalla(random)) {                                      //Tarkistetaan ettei indeksi ole vielä arvottujen joukossa
                random = getRandom(osallistujat.size());                        //Jos on, arvotaan uusi random.
            }

            indeksit[osallistujat.indexOf(osallistuja)] = random;

        }

        if (!onkoItseParina()) {
            tyhjennaIndeksit();
            parienArvonta();                                                    //jos itsensä parina, uusi arvonta.

        } else if (onkoItseParina()) {

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
        for (Henkilo h : arvotut.keySet()) {
            if (h.getName().equals(antaja)) {
                return "Annat lahjan henkilölle " + arvotut.get(h).toString();
            }
        }
        
        return "Et ole mukana arvonnassa :(";
    }
    
    /**
     * Palauttaa HashMapin, jossa avaimena lahjan antaja, ja arvona lahjan saaja.
     * @return HashMap lahjan antaja - saaja -pareista
     */
    public HashMap<Henkilo, Henkilo> getArvotut() {
        return arvotut;
    }
    
    private boolean onkoArvonnassa(String nimi) {
        for (Henkilo h : arvotut.keySet()) {
            if (h.getName().equals(nimi)) {
                return true;
            }
        }
        
        return false;
    }

}
