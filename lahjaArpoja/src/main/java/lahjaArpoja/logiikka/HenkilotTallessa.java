package lahjaArpoja.logiikka;

import java.util.ArrayList;
import java.util.HashMap;

public class HenkilotTallessa {

    private ArrayList<Henkilo> henkilot;

    public HenkilotTallessa() {
        henkilot = new ArrayList();
    }

    public void lisaa(Henkilo h) {
        henkilot.add(h);
    }
    
    public ArrayList getLista() {
        return this.henkilot;
    }

    public void tulostaOsallistujat() {
        if (henkilot.size() == 0) {
            System.out.println("lista on tyhjä.");
        }
        
        for (Henkilo h : henkilot) {
            System.out.println(h.getName());
        }

    }

}
