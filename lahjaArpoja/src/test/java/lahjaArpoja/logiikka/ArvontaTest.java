/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lahjaArpoja.logiikka;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lauranor
 */
public class ArvontaTest {

    private ArrayList<Henkilo> osallistujat;
    private Arvonta a;

    public ArvontaTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        osallistujat = new ArrayList();
    }

    @After
    public void tearDown() {
    }
    
    //Testeissä vähän ongelmia, ilmeisesti koska melkein kaikki palautettava tulee uudelle ruudulle, eikä
    //ohjelmalle palauteta enää, en osaa siis tehdä testejä tälläsille.
    
    


    @Test
    public void PalauttaaOikeinKunHenkiloEiMukana() {
        osallistujat.add(new Henkilo("Paavo", "kissa"));
        osallistujat.add(new Henkilo("Pekka", "koira"));
        osallistujat.add(new Henkilo("Marjukka", "kala"));
        osallistujat.add(new Henkilo("Paavo", "sitruuna"));
        
        a = new Arvonta(osallistujat);
        a.parienArvonta();
        

        assertEquals("Et ole mukana arvonnassa :(", a.getPari("Riitta"));    
    }
    
    @Test
    public void palauttaaOikeinKunKaksiOsallistujaa() {
        osallistujat.add(new Henkilo("Ykkönen", ""));
        osallistujat.add(new Henkilo("Kakkonen", ""));
        
        a = new Arvonta(osallistujat);
        a.parienArvonta();
        
        assertEquals("Annat lahjan henkilölle Ykkönen", a.getPari("Kakkonen"));
        assertEquals("Annat lahjan henkilölle Kakkonen", a.getPari("Ykkönen"));
    }
    
    @Test
    public void arvotuillaEiItseaParina() {
        osallistujat.add(new Henkilo("Kirsi", ""));
        osallistujat.add(new Henkilo("Pekka", ""));
        osallistujat.add(new Henkilo("Marjukka", ""));
        osallistujat.add(new Henkilo("Paavo", ""));
        
        a = new Arvonta(osallistujat);
        a.parienArvonta();
        
        for (Henkilo henkilo : a.getArvotut().keySet()) {
            assertFalse(henkilo.getName().equals(a.getArvotut().get(henkilo.getName())));
        }
        
        
    }
    
    
    
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
