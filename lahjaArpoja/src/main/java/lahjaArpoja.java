
import UI.Kayttoliittyma;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.SwingUtilities;
import lahjaArpoja.logiikka.Arvonta;

public class lahjaArpoja {

    public static void main(String[] args) {
        
        Kayttoliittyma kl = new Kayttoliittyma();
        SwingUtilities.invokeLater(kl);
//        Scanner scanner = new Scanner(System.in);
//        ArrayList<String> nimet = new ArrayList<>();
//        System.out.println("Anna osallistujan nimi, enter lopettaa:");
//        int monesko = 1;
//        while (true) {
//            
//            System.out.print(monesko + ". nimi: ");
//            monesko++;
//            String nimi = scanner.nextLine();
//            if (nimi.isEmpty()) {
//                break;
//            }
//            nimet.add(nimi);
//        }
//
//        Arvonta arvonta = new Arvonta(nimet);
//        arvonta.parienArvonta();
//        
//        
//
//        while (true) {
//            System.out.println("Kenelle annan lahjan? Oma nimesi: ");
//            String kuka = scanner.nextLine();
//
//            if (kuka.isEmpty()) {
//                break;
//            }
//            
//            System.out.println(arvonta.getPari(kuka));
//        }

    }

}
