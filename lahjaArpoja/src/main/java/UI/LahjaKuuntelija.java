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
 * Luokka kuuntelee Lahjakäyttöliittymän nappien painamiset.
 *
 * @author lauranor
 */
public class LahjaKuuntelija implements ActionListener {

    private LahjaKayttoLiittyma lahjakl;
    private String nimi;

    public LahjaKuuntelija(LahjaKayttoLiittyma lkl) {
        this.lahjakl = lkl;
    }

    /**
     * metodi toteuttaa painettuja nappeja vastaavat toiminnot: näyttää annetun
     * henkilön lahjaparin, muokkaa omaa toivetta, ja lisää muiden toiveisiin
     * kommentteja.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String nappi = e.getActionCommand();

        if (nappi.equals("Näytä lahjaparini")) {
            String pari = lahjakl.getArvonta().getPari(lahjakl.getNimi());
            JOptionPane.showMessageDialog(lahjakl.getFrame(), pari);
            lahjakl.tyhjennaKentta();

        } else if (nappi.equals("Muokkaa")) {
            Henkilo h = lahjakl.getHenkilo(lahjakl.getNimi());
            if (h == null) {
                JOptionPane.showMessageDialog(lahjakl.getFrame(), "Henkilöä ei löydy! Annoitko varmasti oikean nimen?");
            } else {
                h.setToive(lahjakl.getUusiToive());
                lahjakl.paivita();
            }
        } else if (nappi.equals("Kommentoi")) {
            Henkilo h = lahjakl.getHenkilo(lahjakl.getKenen());
            if (h == null) {
                JOptionPane.showMessageDialog(lahjakl.getFrame(), "Nappi ei toimi! Annoitko varmasti lahjan saajan nimen oikein?");
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

}
