package UI;

import lahjaArpoja.logiikka.Henkilo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTextField;

/**
 * luokka kuuntelee käyttäjän syöttämät nimen sekä lahjatoiveen, ja nimen
 * ollessa oikeaa muotoa luo uuden Henkilo-olion sekä käynnistää lopuksi
 * arvonnan.
 *
 * @author lauranor
 */
public class HenkilonLisaysKuuntelija implements ActionListener {

    private JTextField nimiKentta;
    private JTextField lahjatoiveKentta;
    private Kayttoliittyma kayttoliittyma;
    private ArrayList<Henkilo> henkilot;

    public HenkilonLisaysKuuntelija(Kayttoliittyma kl) {
        henkilot = new ArrayList();
        kayttoliittyma = kl;
    }

    
    /**
    *Tarkistaa, mitä nappia on painettu. "Arvo parit" käynnistää arvonnan,  
    *"Lisää arvontaan" lisää uuden henkilön arvontaan.
    */
    @Override
    public void actionPerformed(ActionEvent ae) {
        String nappi = ae.getActionCommand();

        if (nappi.equals("Arvo parit")) {
            if (henkilot.size() < 2) {
                nimiKentta.setText("Anna lisää osallistujia!");
            } else {
                suoritaArvonta();
                LahjaKayttoLiittyma lkl = new LahjaKayttoLiittyma(henkilot, kayttoliittyma, this);
                lkl.run();
            }
        } else if (nappi.equals("Lisää arvontaan!")) {
            if (nimiKentta.getText().equals("") || nimiKentta.getText().equals("Anna ensin nimesi") || nimiKentta.getText().equals("Anna lisää osallistujia!")) {
                this.nimiKentta.setText("Anna ensin nimesi");

            } else {
                lisaaArvontaan();
            }
        }
//        } else if (nappi.equals("Näytä osallistujat")) {
//            tulostaOsallistujat();
//        }

    }

    public void setNimikentta(JTextField nimi) {
        this.nimiKentta = nimi;
    }

    public void setToivekentta(JTextField toive) {
        this.lahjatoiveKentta = toive;
    }

    private void suoritaArvonta() {
        kayttoliittyma.arvoParit(henkilot);
    }

    /**
     * Jos nimikentässä on tekstiä, luodaan uusi Henkilö-olio, joka lisätään
     * ArrayList henkilot -listaan. Jos nimi tyhjä, palataan alkuruutuun.
     */
    private void lisaaArvontaan() {
        if (nimiKentta.getText().equals("")) {
            System.out.println("Et antanut oikeaa nimeä, yritä uudelleen.");
        } else {
            Henkilo henkilo = new Henkilo(nimiKentta.getText(), lahjatoiveKentta.getText());
            henkilot.add(henkilo);
            kayttoliittyma.tyhjennaNapit();
        }
    }

    public ArrayList getHenkilot() {
        return this.henkilot;
    }

}
