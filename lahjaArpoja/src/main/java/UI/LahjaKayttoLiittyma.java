/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import lahjaArpoja.logiikka.Henkilo;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import lahjaArpoja.logiikka.Arvonta;

/**
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
    
    
    public LahjaKayttoLiittyma(ArrayList h, Kayttoliittyma k, HenkilonLisaysKuuntelija hlk) {
        this.henkilot = h;
        this.kayttoliittyma = k;
        this.henkilokuuntelija = hlk;
        lahjakuuntelija = new LahjaKuuntelija(this);
    }
    
    @Override
    public void run() {
        frame = new JFrame("Lahjatoiveet");
        frame.setPreferredSize(new Dimension(400, 400));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);

    }
    
    public void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(4, 2);
//        FlowLayout layout = new FlowLayout(2, 3, 4);
        container.setLayout(layout);
        
        JLabel nimiTeksti = new JLabel("Nimesi: ");
        nimi = new JTextField();
        lahjakuuntelija.setNimi(nimi);
        
        JButton nappi = new JButton("Näytä lahjaparini");
        nappi.addActionListener(lahjakuuntelija);
        JButton toiveet = new JButton("Näytä lahjatoiveet");
        toiveet.addActionListener(lahjakuuntelija);
        
        container.add(nimiTeksti);
        container.add(nimi);
        container.add(nappi);
        container.add(toiveet);
        
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
}
