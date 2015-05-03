/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import lahjaArpoja.logiikka.Henkilo;

/**
 *
 * @author lauranor
 */
public class Kysymyskuuntelija implements ActionListener {
    private Henkilo henkilo;
    private String nimi;
    private Lahjatoiveet toiveet;

    public Kysymyskuuntelija(String text, Henkilo h, Lahjatoiveet toiveet) {
        this.nimi = text;
        this.henkilo = h;
        this.toiveet = toiveet;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String esitettyKysymys = toiveet.getKysymysKentta();
        henkilo.setKysymykset(esitettyKysymys);
        System.out.println(esitettyKysymys);
    }

}
