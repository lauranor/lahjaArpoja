package lahjaArpoja.logiikka;

import java.util.ArrayList;
import java.util.Random;

public class Arvonta2 {

    private ArrayList<String> osallistujat;                                     //Arvontaan osallistuvat
    private int[] indeksit;                                                     //Arvottujen parien indeksit

    public Arvonta2(ArrayList osallistujat) {
        this.osallistujat = osallistujat;
//        this.arvottavat = osallistujat;
        this.indeksit = new int[osallistujat.size()];
    }

    public void parienArvonta() {

        for (String osallistuja : osallistujat) {                               //Jokaiselle osallistujalle saadaan
            int random = getRandom(osallistujat.size() + 1);                    //pari arpomalla indeksi.

            while (onkoListalla(random)) {                                      //Tarkistetaan ettei indeksi ole vielä arvottujen joukossa
                random = getRandom(osallistujat.size() + 1);                    //Jos on, arvotaan uusi random.
            }

            indeksit[osallistujat.indexOf(osallistuja)] = random;               //kun indeksi on "vapaana", se lisätään listalle
//            System.out.println("Osallistujan indeksi: " + osallistujat.indexOf(osallistuja));                                                                    //samaan indeksiin kuin missä sillä hetkellä käsiteltävä
//            System.out.println("Arvotun indeksi: " + random);

        }

        if (!onkoItseParina()) {
            parienArvonta();                                                    //jos itsensä parina, uusi arvonta.

        } else if (onkoItseParina()) {
            System.out.println("Arvonta suoritettu onnistuneesti.");
            
//            ArvottuLista lista = new ArvottuLista();
//            
//            for (String osallistuja : osallistujat) {
//                int osallistujanPari = indeksit[osallistujat.indexOf(osallistuja)];
//                lista.lisaaListalle(osallistuja, osallistujat.get(osallistujanPari));
//               
//            }
            
            
        }

    }

    public int getRandom(int montako) {
        Random random = new Random();
        int i = random.nextInt(montako);
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
        for (String osallistuja : osallistujat) {
            if (osallistujat.indexOf(osallistuja) == indeksit[osallistujat.indexOf(osallistuja)] + 1) {
                return false;                                                   //käydään läpi taulukon alkiot, 
            }                                                                   //jos joku alkio yhtä suurin kuin indeksinsä + 1, return false.
            
        }
        return true;
    }

    public void tyhjennaIndeksit() {
        for (int i = 0; i <= indeksit.length; i++) {
            indeksit[i] = 0;
        }

    }

//    public void tulostaIndeksit() {
//        for (int i : indeksit) {
//            System.out.print(i + " ");
//        }
//        System.out.println("");
//
//    }

}
