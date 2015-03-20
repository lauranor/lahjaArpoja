
package lahjaArpoja.logiikka;

import java.util.ArrayList;
import java.util.HashMap;


public class ArvottuLista {
    private HashMap<String, String> lista = new HashMap<>();
    private ArrayList<String> antajat;
    private int[] saajat;
    
    public ArvottuLista(ArrayList antajat, int[] saajat) {
        this.antajat = antajat;
        this.saajat = saajat;
    }
    
    public void laitaListalle() {
        for (String antaja : antajat) {
            int i = antajat.indexOf(antaja);
            
            lista.put(antaja, antajat.get(saajat[i] -1) );

        }
        
    }
    
    public String kenelleAnnan(String antaja) {
        return lista.get(antaja);
    }
    
}
