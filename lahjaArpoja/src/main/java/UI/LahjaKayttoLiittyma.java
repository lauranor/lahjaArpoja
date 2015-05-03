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

    public LahjaKayttoLiittyma(ArrayList h, Kayttoliittyma k, HenkilonLisaysKuuntelija hlk) {
        this.henkilot = h;
        this.kayttoliittyma = k;
        this.henkilokuuntelija = hlk;
        lahjakuuntelija = new LahjaKuuntelija(this);
    }

    @Override
    public void run() {
        frame = new JFrame("Lahjatoiveet");
        frame.setPreferredSize(new Dimension(1000, 400));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);

    }

    public void luoKomponentit(Container container) {
//        GridLayout layout = new GridLayout(2, 4, 5, 10);
//        container.setLayout(layout);

//        JPanel parinKysely = new JPanel(new GridLayout(2, 4, 5, 10));
//        JLabel nimiTeksti = new JLabel("Anna oma nimesi: ");
//        nimi = new JTextField();
//        lahjakuuntelija.setNimi(nimi);
//
//        JButton muokkaus = new JButton("Muokkaa");
//        muokkaus.addActionListener(lahjakuuntelija);
//        JLabel toiveTeksti = new JLabel("Uusi toiveesi:");
//        toive = new JTextField();
        container.add(firstPanel(), BorderLayout.NORTH);
        container.add(secondPanel(), BorderLayout.CENTER);
        container.add(thirdPanel(), BorderLayout.SOUTH);
//        container.add(nimi);
//
//        container.add(toiveTeksti);
//        container.add(toive);
//        container.add(muokkaus);
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
        muokkaus.setPreferredSize(new Dimension(10, 10));

        JButton kysymykset = new JButton("Näytä kysymykseni");
        kysymykset.addActionListener(lahjakuuntelija);

        muokkauskysely.add(toiveTeksti);
        muokkauskysely.add(toive);
        muokkauskysely.add(muokkaus);

        return muokkauskysely;
    }

    private JPanel thirdPanel() {
        JPanel lahjatoiveet = new JPanel(new GridLayout(henkilot.size(), 3));

        for (Henkilo h : henkilot) {
            JLabel nimi = new JLabel(h.getName());
            nimi.setPreferredSize(new Dimension(50, 50));

            JLabel toive = new JLabel("lahjatoive: " + h.getToive());
            JLabel esitetyt = new JLabel(h.getKysymykset());
//            kysymys = new JTextField("oma kysymyksesi:");

//            JButton kysy = new JButton("Kysy!");
//            kysy.addActionListener(new Kysymyskuuntelija(nimi.getText(), h, this));
            lahjatoiveet.add(nimi);
            lahjatoiveet.add(toive);
            lahjatoiveet.add(esitetyt);

        }
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

    public void tyhjennaKentta() {
        this.nimi.setText("");
    }

    public JFrame getFrame() {
        return this.frame;
    }
    
    private Henkilo getHenkilo() {
        if (nimi.getText().isEmpty()) {
            JOptionPane.showMessageDialog(getFrame(), "Anna ensin nimesi!");
        }
        for (Henkilo h : henkilot) {
            
            if (h.getName().equals(nimi.getText())) {
                return h;
            }
        }
        return null;
    }
}
