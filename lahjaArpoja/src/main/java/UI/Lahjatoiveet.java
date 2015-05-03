/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import lahjaArpoja.logiikka.Henkilo;

/**
 * Tässä aukeaa ikkuna, joka mahdollistaa lahjatoiveiden katsomisen, kommentoinnin
 * ja toiveiden täydentämisen.
 * @author lauranor
 */
public class Lahjatoiveet implements Runnable {

    private ArrayList<Henkilo> henkilot;
    private JFrame frame;
    private ActionListener kuuntelija;
    private JTextField kysymys;

    public Lahjatoiveet(ArrayList h) {
        this.henkilot = h;
    }


    @Override
    public void run() {
        frame = new JFrame("Lahjatoiveet");
        frame.setPreferredSize(new Dimension(800, henkilot.size() * 100));

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    /**
     * luo jokaiselle osallistuvalle henkilölle rivin, jolla on tiedot
     * toivotusta lahjasta, sekä mahdollisuus esittää tarkentavia kysmyksiä.
     * @param container 
     */
    private void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(henkilot.size() +1, 3);
        container.setLayout(layout);

        for (Henkilo h : henkilot) {
            JLabel nimi = new JLabel(h.getName());
            JLabel toive = new JLabel(h.getToive());
            JLabel esitetyt = new JLabel(h.getKysymykset());
//            kysymys = new JTextField("oma kysymyksesi:");

//            JButton kysy = new JButton("Kysy!");
//            kysy.addActionListener(new Kysymyskuuntelija(nimi.getText(), h, this));

            container.add(nimi);
            container.add(toive);
            container.add(esitetyt);
//            container.add(kysymys);
//            container.add(kysy);
        }

        
//        JButton muokkaus = new JButton("Muokkaa omaa toivettasi");
//        container.add(muokkaus);


    }

    public String getKysymysKentta() {
        return kysymys.getText();
    }

}
