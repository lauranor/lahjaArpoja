/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author lauranor
 */
public class Lahjatoiveet implements Runnable {
    private ArrayList henkilot;
    private JFrame frame;
    
    public Lahjatoiveet(ArrayList h) {
        this.henkilot = h;
    }
    
    //Tässä aukeaa ikkuna, joka mahdollistaa lahjatoiveiden katsomisen, kommentoinnin
    //ja toiveiden täydentämisen.
    
    @Override
    public void run() {
        frame = new JFrame("Lahjatoiveet");
        frame.setPreferredSize(new Dimension(500, 800));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

//        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }
    
}
