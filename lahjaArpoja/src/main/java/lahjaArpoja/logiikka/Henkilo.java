
package lahjaArpoja.logiikka;

import java.util.ArrayList;

public class Henkilo implements HenkiloVarasto{
    private ArrayList<Henkilo> henkilot;
    
    @Override
    public void talleta(Henkilo henkilo) {
        henkilot.add(henkilo);
    }
    
}
