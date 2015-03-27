package UI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Lahja-arpoja");
        frame.setPreferredSize(new Dimension(400, 200));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);

    }

    private void luoKomponentit(Container container) {
//        JButton nappi = new JButton("Viestitä!");
//        nappi.addActionListener(new ViestiKuuntelija());
//
//        container.add(nappi);

        GridLayout layout = new GridLayout(3, 2);
        container.setLayout(layout);
        
        JLabel nimiTeksti = new JLabel("Anna nimesi: ");
        JTextField nimikentta = new JTextField();
        JLabel toiveTeksti = new JLabel("Lahjatoiveesi: ");
        JTextField toivekentta = new JTextField();
        
        JButton nappi = new JButton("Lisää arvontaan!");
        
        container.add(nimiTeksti);
        container.add(nimikentta);
        container.add(toiveTeksti);
        container.add(toivekentta);
        container.add(new JLabel(""));
        container.add(nappi);
    }

    public JFrame getFrame() {
        return frame;
    }
}
