
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
    
    public HashMap laitaListalle() {                                            //Palauttaa valmiin HashMapin
        for (int i = 0; i < antajat.size(); i++) {
            lista.put(antajat.get(i), antajat.get(saajat[i]-1));
        }
        
        return lista;
        
    }
    
}
