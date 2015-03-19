package lahjaArpoja.logiikka;

import java.util.ArrayList;
import java.util.Random;

public class Arvonta {

    private ArrayList<String> osallistujat;                                     //Arvontaan osallistuvat
    private int[] indeksit;                                                     //Arvottujen parien indeksit

    public Arvonta(ArrayList osallistujat) {
        this.osallistujat = osallistujat;
        this.indeksit = new int[osallistujat.size()];
    }

    public void parienArvonta() {

        for (String osallistuja : osallistujat) {                               //Jokaiselle osallistujalle saadaan
            int random = getRandom(osallistujat.size() + 1);                    //pari arpomalla indeksi.

            while (onkoListalla(random)) {                                      //Tarkistetaan ettei indeksi ole vielä arvottujen joukossa
                random = getRandom(osallistujat.size() + 1);                    //Jos on, arvotaan uusi random.
            }

            indeksit[osallistujat.indexOf(osallistuja)] = random;               //kun indeksi on "vapaana", se lisätään listalle

        }

        if (!onkoItseParina()) {
            parienArvonta();                                                    //jos itsensä parina, uusi arvonta.

        } else if (onkoItseParina()) {
            System.out.println("Arvonta suoritettu onnistuneesti.");
            
            ArvottuLista lista = new ArvottuLista(osallistujat, indeksit);
            lista.laitaListalle();
        }

    }

    private int getRandom(int montako) {
        Random random = new Random();
        int i = random.nextInt(montako);
//        System.out.println(i);
        return i;
    }

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

    private boolean onkoItseParina() {
        for (String osallistuja : osallistujat) {
            if (osallistujat.indexOf(osallistuja) == indeksit[osallistujat.indexOf(osallistuja)] + 1) {
                return false;                                                   //käydään läpi taulukon alkiot, 
            }                                                                   //jos joku alkio yhtä suurin kuin indeksinsä + 1, return false.
            
        }
        return true;
    }

    private void tyhjennaIndeksit() {
        for (int i = 0; i <= indeksit.length; i++) {
            indeksit[i] = 0;
        }

    }


}
