package lahjaArpoja.logiikka;

import java.util.ArrayList;
import java.util.Collection;

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
}
