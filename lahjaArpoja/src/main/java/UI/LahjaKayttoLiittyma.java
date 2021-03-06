/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import lahjaArpoja.logiikka.Henkilo;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import lahjaArpoja.logiikka.Arvonta;

/**
 * Luokka on uusi käyttöliittymä, jossa on mahdollista selvittää arvottuja
 * henkilöpareja sekä kaikkia lahjatoiveita.
 *
 * @author lauranor
 */
public class LahjaKayttoLiittyma implements Runnable {

    private JFrame frame;
    private ArrayList<Henkilo> henkilot;
    private Kayttoliittyma kayttoliittyma;
    private HenkilonLisaysKuuntelija henkilokuuntelija;
    private LahjaKuuntelija lahjakuuntelija;
    private JTextField nimi;
    private JTextField toive;
    private JTextField uusiToive;
    private JTextField kenen;
    private JTextField kommentti;

    public LahjaKayttoLiittyma(ArrayList h, Kayttoliittyma k, HenkilonLisaysKuuntelija hlk) {
        this.henkilot = h;
        this.kayttoliittyma = k;
        this.henkilokuuntelija = hlk;
        lahjakuuntelija = new LahjaKuuntelija(this);
    }

    
    @Override
    public void run() {
        frame = new JFrame("Lahjatoiveet");
        frame.setPreferredSize(new Dimension(1500, (henkilot.size()+1)*100));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);

    }

    /**
     * lisää kolme uutta paneelia käyttöliittymään:
     * firstPanel mahdollistaa oman parin kysymisen,
     * secondPanel mahdollistaa oman lahjatoiveen muokkauksen ja
     * thirdPanel näyttää kaikkien lahjatoiveet, esitetyt kommentit sekä
     * mahdollistaa lahjatoiveiden kommentoinnin.
     * @param container 
     */
    public void luoKomponentit(Container container) {

        container.add(firstPanel(), BorderLayout.NORTH);
        container.add(secondPanel(), BorderLayout.CENTER);
        container.add(thirdPanel(), BorderLayout.SOUTH);

    }

    private JPanel firstPanel() {
        JPanel parinkysely = new JPanel(new GridLayout(1, 3, 20, 20));

        JLabel nimiTeksti = new JLabel("Anna oma nimesi: ");
        nimi = new JTextField();
        lahjakuuntelija.setNimi(nimi);

        JButton nappi = new JButton("Näytä lahjaparini");
        nappi.addActionListener(lahjakuuntelija);
        nappi.setPreferredSize(new Dimension(50, 50));

        parinkysely.add(nimiTeksti);
        parinkysely.add(nimi);
        parinkysely.add(nappi);

        return parinkysely;
    }

    private JPanel secondPanel() {
        JPanel muokkauskysely = new JPanel(new GridLayout(1, 3, 20, 20));

        JLabel toiveTeksti = new JLabel("Tarkennettu toiveesi:");
        toive = new JTextField();
        uusiToive = toive;
        JButton muokkaus = new JButton("Muokkaa");
        muokkaus.addActionListener(lahjakuuntelija);
        muokkaus.setPreferredSize(new Dimension(50, 50));

        muokkauskysely.add(toiveTeksti);
        muokkauskysely.add(toive);
        muokkauskysely.add(muokkaus);

        return muokkauskysely;
    }

    private JPanel thirdPanel() {
        JPanel lahjatoiveet = new JPanel(new GridLayout(henkilot.size() +1, 3));

        for (Henkilo h : henkilot) {
            JLabel nimi = new JLabel(h.getName());
            nimi.setPreferredSize(new Dimension(50, 50));

            JLabel toive = new JLabel("lahjatoive: " + h.getToive());
            JLabel esitetyt = new JLabel(h.getKysymykset());

            lahjatoiveet.add(nimi);
            lahjatoiveet.add(toive);
            lahjatoiveet.add(esitetyt);

        }
        kenen = new JTextField("Kenen toive?");
        kommentti = new JTextField("Kirjoita kommentti tähän");
        JButton kommentoi = new JButton("Kommentoi");
        kommentoi.addActionListener(lahjakuuntelija);
        lahjatoiveet.add(kenen);
        lahjatoiveet.add(kommentti);
        lahjatoiveet.add(kommentoi);
        return lahjatoiveet;
    }

    public Arvonta getArvonta() {
        return kayttoliittyma.getArvonta();
    }

    public String getNimi() {
        return this.nimi.getText();
    }

    public ArrayList getHenkilot() {
        return henkilokuuntelija.getHenkilot();
    }

    /**
     * tyhjentää nimikentän.
     */
    public void tyhjennaKentta() {
        this.nimi.setText("");
    }

    public JFrame getFrame() {
        return this.frame;
    }
    
    public String getKenen() {
        return this.kenen.getText();
    }
    
    public String getKommentti() {
        return this.kommentti.getText();
    }
    
    public String getUusiToive() {
        return uusiToive.getText();
    }

    /**
     * Etsii arvontaan osallistuneista parametrina annettua nimeä vastaavan.
     * @param annettuNimi
     * @return henkilö jonka getNimi() on annettuNimi.
     */
    public Henkilo getHenkilo(String annettuNimi) {
        if (annettuNimi.isEmpty()) {
            JOptionPane.showMessageDialog(getFrame(), "Anna ensin nimesi!");
        } else {
        for (Henkilo h : henkilot) {

            if (h.getName().equals(annettuNimi)) {
                return h;
            }
        }
    }
        return null;
    }
    
    /**
     * tietojen muututtua päivittää ruudun, eli käynnistää uuden ruudun jolla
     * päivitetyt tiedot näkyvät. Ei sulje edellistä ikkunaa, en osannut.
     */
    public void paivita() {
        run();
    }
}
