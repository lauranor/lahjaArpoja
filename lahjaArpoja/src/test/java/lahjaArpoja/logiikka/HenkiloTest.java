/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lahjaArpoja.logiikka;

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
public class HenkiloTest {
    private Henkilo h;
    
    public HenkiloTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        h = new Henkilo("Pekka", "kissa");
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void palauttaaNimenOikein() {
        assertEquals("Pekka" , h.getName() );
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
