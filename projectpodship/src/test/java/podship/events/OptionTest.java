/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package podship.events;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tgtapio
 */
public class OptionTest {

    public OptionTest() {
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
    // @Test
    // public void hello() {}
    @Test
    public void unlockListIsEmptyAtStart() {
        Option o = new Option();
        assertEquals(0, o.getUnlocks().size());
    }

    @Test
    public void defaultStatAdjustmentsAreZeros() {
        Option o = new Option();
        for (int i : o.getStatAdjustments()) {
            assertEquals(0, i);
        }
    }
    
    @Test
    public void defaultDescIsEmpty() {
        Option o = new Option();
        assertEquals("", o.getDesc());
    }
    
    @Test
    public void unlocksCanBeAdded() {
        Option o = new Option();
        o.addUnlock(25);
        assertEquals(25, (int) o.getUnlocks().get(0));
    }
    
    @Test
    public void parametersWorksWithConstructor () {
        Option o = new Option("testink", new int[]{3, 3, 3, 3, 3, 3, 3}, new ArrayList<>());
        assertArrayEquals(new int[]{3, 3, 3, 3, 3, 3, 3}, o.getStatAdjustments());
        assertEquals("testink", o.getDesc());
    }
}
