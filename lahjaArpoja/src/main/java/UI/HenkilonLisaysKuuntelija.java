
package UI;

import lahjaArpoja.logiikka.HenkiloVarasto;
import lahjaArpoja.logiikka.Henkilo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class HenkilonLisaysKuuntelija implements ActionListener{
    private HenkiloVarasto varasto;
    private JTextField nimiKentta;
    private JTextField lahjatoiveKentta;

    
    public HenkilonLisaysKuuntelija(HenkiloVarasto v, JTextField nimi, JTextField toive) {
        this.varasto = v;
        this.nimiKentta = nimi;
        this.lahjatoiveKentta = toive;
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        Henkilo henkilo = new Henkilo(nimiKentta.getText(), lahjatoiveKentta.getText());
        this.varasto.talleta(henkilo);
    }
    
}
