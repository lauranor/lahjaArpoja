import lahjaArpoja.logiikka.Arvonta;
import java.util.ArrayList;
import lahjaArpoja.logiikka.Arvonta2;



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
        
        
        Arvonta2 arvonta = new Arvonta2(nimet);
        arvonta.parienArvonta();
        
    }
    
}
