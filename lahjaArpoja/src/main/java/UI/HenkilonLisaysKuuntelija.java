package UI;

import lahjaArpoja.logiikka.Henkilo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTextField;

public class HenkilonLisaysKuuntelija implements ActionListener {

    private JTextField nimiKentta;
    private JTextField lahjatoiveKentta;
    private Kayttoliittyma kayttoliittyma;
    private ArrayList<Henkilo> henkilot;

    public HenkilonLisaysKuuntelija(Kayttoliittyma kl) {
        henkilot = new ArrayList();
        kayttoliittyma = kl;

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String nappi = ae.getActionCommand();

        if (nappi.equals("Suorita arvonta")) {
            suoritaArvonta();
            LahjaKayttoLiittyma lkl = new LahjaKayttoLiittyma(henkilot, kayttoliittyma, this);
            lkl.run();
        } else if (nappi.equals("Lisää arvontaan!")) {
            lisaaArvontaan();
        } else if (nappi.equals("Näytä osallistujat")) {
            tulostaOsallistujat();
        }

    }

    public void setNimikentta(JTextField nimi) {
        this.nimiKentta = nimi;
    }

    public void setToivekentta(JTextField toive) {
        this.lahjatoiveKentta = toive;
    }

    
    /**
     * Tulostaa arvontaan ilmoitettujen henkilöiden nimet.
     */
    public void tulostaOsallistujat() {
        for (Henkilo h : henkilot) {
            System.out.println(h.getName());
        }
    }

    
    private void suoritaArvonta() {
        System.out.println("arvotaan parit.");
        kayttoliittyma.arvoParit(henkilot);
    }
    
    /**
     * Jos nimikentässä on tekstiä, luodaan uusi Henkilö-olio, joka lisätään
     * ArrayList henkilot -listaan.
     * Jos nimi tyhjä, palataan alkuruutuun.
     */
    private void lisaaArvontaan() {
        if (nimiKentta.getText().equals("")) {
                System.out.println("Et antanut oikeaa nimeä, yritä uudelleen.");
            } else {
                System.out.println("lisätään henkilö arvontaan.");
                Henkilo henkilo = new Henkilo(nimiKentta.getText(), lahjatoiveKentta.getText());
                henkilot.add(henkilo);
                kayttoliittyma.tyhjennaNapit();
            }
    }
    
//    private void naytaParit() {
//        if (kayttoliittyma.getArvonta().getArvotut().isEmpty()) {
//            throw new IllegalArgumentException("ei arvottuja pareja");
//        }
//        HashMap<Henkilo, Henkilo> parit = kayttoliittyma.getArvonta().getArvotut();
//        
//        for (Henkilo henkilo : parit.keySet()) {
//            System.out.println(henkilo.getName() + " antaa lahjan henkilölle " + parit.get(henkilo).getName());
//        }
//    }
    
    public ArrayList getHenkilot() {
        return this.henkilot;
    }

}
