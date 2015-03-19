
import java.util.ArrayList;
import lahjaArpoja.logiikka.Arvonta;



public class lahjaArpoja {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> nimet = new ArrayList<>();
        
        nimet.add("kissa");
        nimet.add("koira");
        nimet.add("hamsteri");
        nimet.add("virtahepo");
        nimet.add("kultakala");
        
        
        Arvonta arvonta = new Arvonta(nimet);
        arvonta.parienArvonta();
        
    }
    
}
