package UI;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import lahjaArpoja.logiikka.Arvonta;



public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private HenkilonLisaysKuuntelija kuuntelija;
    private Arvonta arvonta;
    private JTextField nimikentta;
    private JTextField toivekentta;


    public Kayttoliittyma() {
        kuuntelija = new HenkilonLisaysKuuntelija(this);
    }

    @Override
    public void run() {
        frame = new JFrame("Lahja-arpoja");
        frame.setPreferredSize(new Dimension(400, 400));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);

    }

    private void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(4, 2);
//        FlowLayout layout = new FlowLayout(2, 3, 4);
        container.setLayout(layout);
        
       
        JLabel nimiTeksti = new JLabel("Anna nimesi: ");
        nimikentta = new JTextField();
        kuuntelija.setNimikentta(nimikentta);
        JLabel toiveTeksti = new JLabel("Lahjatoiveesi: ");
        toivekentta = new JTextField();
        kuuntelija.setToivekentta(toivekentta);
        

        JButton arvontaNappi = new JButton("Suorita arvonta");
        arvontaNappi.addActionListener(kuuntelija);
        
        JButton lisaysNappi = new JButton("Lisää arvontaan!");
        lisaysNappi.addActionListener(kuuntelija);
        
        JButton naytaNappi = new JButton("Näytä osallistujat");
        naytaNappi.addActionListener(kuuntelija);
        
        JButton annaParitNappi = new JButton("Näytä arvotut parit");
        annaParitNappi.addActionListener(kuuntelija);

        container.add(nimiTeksti);
        container.add(nimikentta);
        container.add(toiveTeksti);
        container.add(toivekentta);
        container.add(arvontaNappi);
        container.add(lisaysNappi);
        container.add(naytaNappi);
        container.add(annaParitNappi);

        
    }

    public JFrame getFrame() {
        return frame;
    }
    
    public void tyhjennaNapit() {
        nimikentta.setText("");
        toivekentta.setText("");
    }
    
    public void arvoParit(ArrayList henkilot) {
        arvonta = new Arvonta(henkilot);
        arvonta.parienArvonta();
    }
    
    public Arvonta getArvonta() {
        return arvonta;
    }
}
