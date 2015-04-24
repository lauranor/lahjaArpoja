
package lahjaArpoja.logiikka;

import java.util.ArrayList;
import java.util.HashMap;


public class ArvottuLista {
    private HashMap<Henkilo, Henkilo> lista = new HashMap<>();
    private ArrayList<Henkilo> antajat;
    private int[] saajat;
    
    public ArvottuLista(ArrayList antajat, int[] saajat) {
        this.antajat = antajat;
        this.saajat = saajat;
    }
    
    
    /**
     * Palauttaa HashMapin, jossa avaimena Henkilö, ja arvona arvonnassa 
     * kyseiselle henkilölle arvottua indeksiä vastaava toinen Henkilö.
     * @return lista 
     */
    public HashMap laitaListalle() {                                            //Palauttaa valmiin HashMapin
        for (int i = 0; i < antajat.size(); i++) {
            lista.put(antajat.get(i), antajat.get(saajat[i]-1));
        }
        
        return lista;
        
    }
    
}
