package lahjaArpoja.logiikka;

import java.util.Objects;



public class Henkilo {

    private String nimi;
    private String lahjatoive;
    private String kysymykset = "Esitetyt kysymykset: \n";

    public Henkilo(String nimi, String toive) {
        this.nimi = nimi;
        this.lahjatoive = toive;
    }
    
    public String getName() {
        return this.nimi;
    }
    
    public String getToive() {
        return this.lahjatoive;
    }
    
    public void setKysymykset(String kysymys) {
        kysymykset+=kysymys + "\n";
    }
    
    public String getKysymykset() {
        return this.kysymykset;
    }
    
    @Override
    public String toString() {
        return this.getName();
    }
    
}
