package UI;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import lahjaArpoja.logiikka.Henkilo;
import lahjaArpoja.logiikka.HenkilotTallessa;


public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private HenkilonLisaysKuuntelija kuuntelija;


    public Kayttoliittyma() {
        kuuntelija = new HenkilonLisaysKuuntelija();
    }

    @Override
    public void run() {
        frame = new JFrame("Lahja-arpoja");
//        frame.setSize(400, 400);
        frame.setPreferredSize(new Dimension(400, 200));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);

    }

    private void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(4, 2);
        container.setLayout(layout);
        HenkilonLisaysKuuntelija hlk= new HenkilonLisaysKuuntelija();
       
        JLabel nimiTeksti = new JLabel("Anna nimesi: ");
        JTextField nimikentta = new JTextField();
        JLabel toiveTeksti = new JLabel("Lahjatoiveesi: ");
        JTextField toivekentta = new JTextField();

        JButton arvontaNappi = new JButton("Suorita arvonta");
        arvontaNappi.addActionListener(hlk);
        
        JButton lisaysNappi = new JButton("Lisää arvontaan!");
        lisaysNappi.addActionListener(hlk);
        
        JButton naytaNappi = new JButton("Näytä osallistujat");
        naytaNappi.addActionListener(hlk);

        container.add(nimiTeksti);
        container.add(nimikentta);
        container.add(toiveTeksti);
        container.add(toivekentta);
        container.add(arvontaNappi);
        container.add(lisaysNappi);
        container.add(naytaNappi);

        
    }

    public JFrame getFrame() {
        return frame;
    }
}
