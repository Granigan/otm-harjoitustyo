package podship.events;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class EventTest {
    BuildEvent e = new BuildEvent();
    
    public EventTest() {
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
    
    @Test
    public void noOptionsAtInit() {
        assertEquals(new ArrayList<Option>(), e.getOptions());
    }
    
    @Test
    public void addedOptionIsListed() {
        Option o = new Option();
        e.addOption(o);
        assertEquals(o, e.getOptions().get(0));
    }
    
    @Test
    public void textCanBeSet() {
        e.setDesc("testink");
        assertEquals("testink", e.getDesc());
    }
    
    
}
