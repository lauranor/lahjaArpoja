/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 *
 * @author lauranor
 */
public class PariRuudulla implements Runnable {    
    private JFrame frame;
    private String nimi;
    
    public PariRuudulla(String nimi) {
        this.nimi = nimi;
    }

    @Override
    public void run() {
        frame = new JFrame("Lahjansaaja");
        frame.setPreferredSize(new Dimension(300, 100));

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }
    
    private void luoKomponentit(Container container){
        GridLayout layout = new GridLayout(4, 2);
        container.setLayout(layout);
        
        JLabel teksti = new JLabel(nimi);
        container.add(teksti);
    }
}
