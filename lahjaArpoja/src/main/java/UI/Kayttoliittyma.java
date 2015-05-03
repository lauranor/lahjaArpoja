package UI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import lahjaArpoja.logiikka.Arvonta;

/**
 * Luokka on uusi käyttöliittymä, johon voidaan syöttää nimiä ja lahjatoiveita
 * sekä käynnistää arvonta mukaa ilmoitettujen henkilöiden välillä.
 *
 * @author lauranor
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private HenkilonLisaysKuuntelija kuuntelija;
    private Arvonta arvonta;
    private JTextField nimikentta;
    private JTextField toivekentta;
    private Image img = Toolkit.getDefaultToolkit().createImage("background.jpg");
    private Graphics g;

    public Kayttoliittyma() {
        kuuntelija = new HenkilonLisaysKuuntelija(this);
    }

    @Override
    public void run() {
        frame = new JFrame("Lahja-arpoja");
        frame.setPreferredSize(new Dimension(400, 500));
        ;

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        try {
            luoKomponentit(frame.getContentPane());
        } catch (IOException ex) {
            Logger.getLogger(Kayttoliittyma.class.getName()).log(Level.SEVERE, null, ex);
        }

        frame.pack();
        frame.setVisible(true);

    }

    private void luoKomponentit(Container container) throws IOException {

        GridLayout layout = new GridLayout(4, 2, 5, 10);
        container.setLayout(layout);

        JLabel nimiTeksti = new JLabel("Anna nimesi: ");
        nimikentta = new JTextField();
        kuuntelija.setNimikentta(nimikentta);
        JLabel toiveTeksti = new JLabel("Lahjatoiveesi: ");
        toivekentta = new JTextField();
        kuuntelija.setToivekentta(toivekentta);

        JPanel panel = new JPanel(new GridLayout(1, 1));
//        JLabel kuva = new JLabel();
//        kuva.setPreferredSize(new Dimension(150, 50));
//
//        try {
//            Image paketti = ImageIO.read(getClass().getResource("/paketti.jpg"));
//            kuva.setIcon(new ImageIcon(paketti));
//        } catch (IOException e) {
//            //ei tehdä mitään jos kuvan lataaminen epäonnistuu
//        }
//        panel.add(kuva);

        JButton arvontaNappi = new JButton("Arvo parit");
        arvontaNappi.addActionListener(kuuntelija);

        JButton lisaysNappi = new JButton("Lisää arvontaan!");
        lisaysNappi.addActionListener(kuuntelija);

//        JButton naytaNappi = new JButton("Näytä osallistujat");
//        naytaNappi.addActionListener(kuuntelija);
        container.add(nimiTeksti);
        container.add(nimikentta);
        container.add(toiveTeksti);
        container.add(toivekentta);
        container.add(arvontaNappi);
        container.add(lisaysNappi);
        container.add(panel, BorderLayout.SOUTH);
//        container.add(naytaNappi);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void tyhjennaNapit() {
        nimikentta.setText("");
        toivekentta.setText("");
    }

    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }

    /**
     * Käynnistää uuden arvonnan, jolle annetaan parametrina saatu ArrayList.
     *
     * @param henkilot
     */
    public void arvoParit(ArrayList henkilot) {
        arvonta = new Arvonta(henkilot);
        arvonta.parienArvonta();
    }

    public Arvonta getArvonta() {
        return arvonta;
    }

}
