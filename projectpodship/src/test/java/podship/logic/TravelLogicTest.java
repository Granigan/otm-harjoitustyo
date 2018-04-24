package podship.logic;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import podship.travel.TravelStats;

public class TravelLogicTest {
    
    TravelLogic tl = new TravelLogic();
    
    public TravelLogicTest() {
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
    public void proceedJourneyReducesDistance() {
        tl.setDistance(1);
        tl.proceedJourney();
        assertEquals(0, tl.getDistance());
    }
    
    @Test
    public void proceedJourneyReducesStats() {
        TravelStats ts = new TravelStats(new int[]{1, 1, 1, 1, 1, 1, 1});
        tl = new TravelLogic(ts, new ArrayList<>());
        tl.proceedJourney();
        assertFalse(ts.hasAllResources());
    }
}
