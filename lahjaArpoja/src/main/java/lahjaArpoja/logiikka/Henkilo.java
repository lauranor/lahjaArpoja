package lahjaArpoja.logiikka;

import java.util.Objects;



public class Henkilo {

    private String nimi;
    private String lahjatoive;

    public Henkilo(String nimi, String toive) {
        this.nimi = nimi;
        this.lahjatoive = toive;
    }
    
    public String getName() {
        return this.nimi;
    }
    
    @Override
    public String toString() {
        return this.getName();
    }
    
}
