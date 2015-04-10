package UI;

import lahjaArpoja.logiikka.Henkilo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import lahjaArpoja.logiikka.Arvonta;
import lahjaArpoja.logiikka.HenkilotTallessa;

public class HenkilonLisaysKuuntelija implements ActionListener {

    private JTextField nimiKentta;
    private JTextField lahjatoiveKentta;
    private HenkilotTallessa ht;
    private Arvonta arvonta;

    public HenkilonLisaysKuuntelija() {
        ht = new HenkilotTallessa();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String nappi = ae.getActionCommand();

        if (nappi.equals("Suorita arvonta")) {
            System.out.println("arvotaan parit.");
            arvonta = new Arvonta(ht.getLista());
        } else if (nappi.equals("Lisää arvontaan!")) {
            if (nimiKentta.getText().equals("")) {
                System.out.println("Et antanut oikeaa nimeä, yritä uudelleen.");
            } else {
                System.out.println("lisätään henkilö arvontaan.");
                Henkilo henkilo = new Henkilo(nimiKentta.getText(), lahjatoiveKentta.getText());
                ht.lisaa(henkilo);
            }
        } else if (nappi.equals("Näytä osallistujat")) {
            ht.tulostaOsallistujat();
        }

    }

    public void setNimikentta(JTextField nimi) {
        this.nimiKentta = nimi;
    }

    public void setToivekentta(JTextField toive) {
        this.lahjatoiveKentta = toive;
    }

}
