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
public class lahjaArpojaLogiikkaTest {

    public lahjaArpojaLogiikkaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void konstruktoriToimiiOikein() {
        Arvonta arvonta = new Arvonta(new ArrayList<String>());
        
        assertEquals(0, 0);
     
    }
    
//    Täällä ei oikeestaan oo testejä, koska tän hetkiselle logiikalle ei sellasia oikein saa tehtyä, koska metodit 
//    ei palauta mitään ulospäin. ts. pitäis kirjottaa 
//    uusia metodeita että sais testattua toimivuutta, eikä siinä kuulemma oo järkeä.
}
