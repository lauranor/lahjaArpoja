package lahjaArpoja.logiikka;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Arvonta {

    private HashMap<String, String> arvotutParit = new HashMap<>();
    private ArrayList<String> henkilot;
    private ArrayList<String> arvottavat;
    private ArrayList<String> arvotut;

    public Arvonta(ArrayList henkilot) {
        this.henkilot = henkilot;

    }

    public void arpoja(ArrayList arvottavat) {
        this.arvottavat = arvottavat;
        int montako = arvottavat.size();

        for (String henkilo : henkilot) {
            System.out.println(henkilo);
            int r = getRandom(montako);
            montako--;
            
            System.out.println(arvottavat.get(r));
            
            
            System.out.println("");

            if (henkilo.equals(arvottavat.get(r))) {
                arpoja(henkilot);
                System.out.println("uusiks!\n");
            }
//
//            arvotutParit.put(henkilo, (String) arvottavat.get(r));
//            arvottavat.remove(r);
        }

        System.out.println("Arvonta valmis.");

    }

    public void tulostaParit() {
        for (int i = 0; i < arvotutParit.size(); i++) {
            System.out.println(arvotutParit.keySet());
        }
    }

    public int getRandom(int montako) {
        Random random = new Random();
        int i = random.nextInt(montako);
        System.out.println(i);
        return i;
    }
}
