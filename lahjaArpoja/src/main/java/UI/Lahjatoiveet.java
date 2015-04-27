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
import javax.swing.WindowConstants;
import lahjaArpoja.logiikka.Henkilo;

/**
 *
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
    
    //Tässä aukeaa ikkuna, joka mahdollistaa lahjatoiveiden katsomisen, kommentoinnin
    //ja toiveiden täydentämisen.
    
    @Override
    public void run() {
        frame = new JFrame("Lahjatoiveet");
        frame.setPreferredSize(new Dimension(800, henkilot.size()*100));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }
    
    private void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(henkilot.size(), 4);
        container.setLayout(layout);
        
        for (Henkilo h : henkilot) {
            JLabel nimi = new JLabel(h.getName());
            JLabel toive = new JLabel(h.getToive());
            JLabel esitetyt = new JLabel(h.getKysymykset());
            kysymys = new JTextField("oma kysymyksesi:");
            
            JButton kysy = new JButton("Kysy!");
            kysy.addActionListener(kuuntelija);
            
            container.add(nimi);
            container.add(toive);
            container.add(esitetyt);
            container.add(kysymys);
            container.add(kysy);
            
        }
        
        
//        JLabel nimiTeksti = new JLabel("Nimesi: ");
//        nimi = new JTextField();
//        lahjakuuntelija.setNimi(nimi);
//        
//        JButton nappi = new JButton("Näytä lahjaparini");
//        nappi.addActionListener(lahjakuuntelija);
//        JButton toiveet = new JButton("Näytä lahjatoiveet");
//        
//        container.add(nimiTeksti);
//        container.add(nimi);
//        container.add(nappi);
//        container.add(toiveet);
    }
    
    public String getKysymysKentta() {
        return kysymys.getText();
    }
    
}
