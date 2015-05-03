
package lahjaArpoja.logiikka;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Luokka luo HashMapin, jossa on avaimena konstruktorissa listana saadut Henkilöt,
 * ja arvona on konstruktorissa saadun taulukon arvojen indeksiä vastaavat henkilöt.
 * @author lauranor
 */
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
     * @return HashMap jossa valmiit parit.
     */
    public HashMap laitaListalle() {                                            
        for (int i = 0; i < antajat.size(); i++) {
            lista.put(antajat.get(i), antajat.get(saajat[i]-1));
        }
        
        return lista;
    }
    
}
