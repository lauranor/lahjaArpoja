/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import lahjaArpoja.logiikka.Henkilo;

/**
 * Luokka kuuntelee nappien painamiset.
 *
 * @author lauranor
 */
public class LahjaKuuntelija implements ActionListener {

    private LahjaKayttoLiittyma lahjakl;
    private String nimi;

    public LahjaKuuntelija(LahjaKayttoLiittyma lkl) {
        this.lahjakl = lkl;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nappi = e.getActionCommand();

        if (nappi.equals("Näytä lahjaparini")) {
            String pari = lahjakl.getArvonta().getPari(lahjakl.getNimi());
            JOptionPane.showMessageDialog(lahjakl.getFrame(), pari);
            lahjakl.tyhjennaKentta();
        } else if (nappi.equals("Näytä lahjatoiveet")) {
            Lahjatoiveet toiveet = new Lahjatoiveet(lahjakl.getHenkilot());
            toiveet.run();
        } else if (nappi.equals("Muokkaa")) {
            Henkilo h = lahjakl.getHenkilo(lahjakl.getNimi());
            if (h == null) {
                System.out.println("henkilö null!");
            } else {
            h.setToive(lahjakl.getUusiToive());
            lahjakl.paivita();
            }
        } else if (nappi.equals("Kommentoi")) {
            Henkilo h = lahjakl.getHenkilo(lahjakl.getKenen());
            if (h == null) {
                JOptionPane.showMessageDialog(lahjakl.getFrame(), "Nappi ei toimi! Annoitko varmasti lahjan saajan nimen?");
            } else {
                String kommentti = lahjakl.getKommentti();
                h.setKysymykset(kommentti);
                lahjakl.paivita();
            }

        }

    }

    public void setNimi(JTextField n) {
        this.nimi = n.getText();
    }

//    /**
//    * Avaa uuden ruudun, jolla näkyy annetun nimen arvottu pari.
//    * @param nimi oma nimi
//    */
//    private void naytaPariRuudulla(String nimi) {
//        PariRuudulla ruutu = new PariRuudulla(nimi);
//        ruutu.run();
//        
//    }
}
