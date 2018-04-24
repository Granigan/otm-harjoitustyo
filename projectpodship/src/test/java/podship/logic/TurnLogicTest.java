package podship.logic;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import podship.travel.TravelStats;

public class TurnLogicTest {

    private TurnLogic tl = new TurnLogic();

    public TurnLogicTest() {
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
    public void noTurnsLeft() {
        tl.setTurnCount(0);
        assertTrue(tl.checkForLaunch());
    }
    

}
