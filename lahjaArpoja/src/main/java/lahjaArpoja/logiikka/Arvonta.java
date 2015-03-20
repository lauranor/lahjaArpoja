package lahjaArpoja.logiikka;

import java.util.ArrayList;
import java.util.Random;

public class Arvonta {

    private ArrayList<String> osallistujat;                                     //Arvontaan osallistuvat
    private int[] indeksit;                                                     //Arvottujen parien indeksit välillä 1..osallistujat.size+1

    public Arvonta(ArrayList osallistujat) {
        this.osallistujat = osallistujat;
        this.indeksit = new int[osallistujat.size()];
    }

    public void parienArvonta() {

        for (String osallistuja : osallistujat) {                               //Jokaiselle osallistujalle saadaan
            int random = getRandom(osallistujat.size());                    //pari arpomalla indeksi.

            while (onkoListalla(random)) {                                      //Tarkistetaan ettei indeksi ole vielä arvottujen joukossa
                random = getRandom(osallistujat.size());                    //Jos on, arvotaan uusi random.
            }

            indeksit[osallistujat.indexOf(osallistuja)] = random;    
            System.out.print(osallistuja + " - " + osallistujat.indexOf(osallistuja)+ " - " + random + "\n");                             //kun indeksi on "vapaana", se lisätään listalle

        }
        
        System.out.println("onkoItseParina:" + onkoItseParina());

        if (!onkoItseParina()) {
            System.out.println("Arvotaan uudestaan.");
            tyhjennaIndeksit();
            parienArvonta();                                                    //jos itsensä parina, uusi arvonta.

        } else if (onkoItseParina()) {
            System.out.println("Arvonta suoritettu onnistuneesti.");
            
//            ArvottuLista lista = new ArvottuLista(osallistujat, indeksit);
//            lista.laitaListalle();
        }

    }

    public int getRandom(int montako) {
        Random random = new Random();
        int i = random.nextInt(montako) + 1;
//        System.out.println(i);
        return i;
    }

    public boolean onkoListalla(int r) {
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

    public boolean onkoItseParina() {
        for (int n = 0; n < indeksit.length; n++) {
            if (n == (indeksit[n]- 1)) {
                return false;                                                   //käydään läpi taulukon alkiot, 
            }                                                                   //jos joku alkio yhtä suurin kuin indeksinsä + 1, return false.
            
        }
        return true;
    }

    public void tyhjennaIndeksit() {
        for (int i = 0; i < indeksit.length; i++) {
            indeksit[i] = 0;
            System.out.println(indeksit[i]);
        }

    }


}
