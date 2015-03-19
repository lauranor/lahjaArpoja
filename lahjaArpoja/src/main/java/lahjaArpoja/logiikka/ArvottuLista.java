
package lahjaArpoja.logiikka;

import java.util.HashMap;


public class ArvottuLista {
    private HashMap<String, String> lista = new HashMap<>();
    
    
    public void lisaaListalle(String antaja, String saaja) {
        lista.put(antaja, saaja);
    }
    
    public String kenelleAnnan(String antaja) {
        return lista.get(antaja);
    }
    
}
