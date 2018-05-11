package podship.logic;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import podship.events.BuildEvent;
import podship.events.Option;
import podship.travel.TravelStats;

public class GameLogicTest {

    GameLogic logic = new GameLogic();

    public GameLogicTest() {
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
    public void newGameCreatesTravelStatsWithMatchingParameters1() {
        logic.newGame("Granigan", new int[]{10, 10, 10, 10, 10, 10, 10});
        assertTrue(logic.getStats().hasEnoughResources(new int[]{10, 10, 10, 10, 10, 10, 10}));
        Assert.assertEquals("Granigan", logic.getStats().getDirectorName());
    }

    @Test
    public void newGameCreatesTravelStatsWithMatchingParameters2() {
        logic.newGame("Granigan", new int[]{10, 10, 10, 10, 10, 10, 10});
        assertFalse(logic.getStats().hasEnoughResources(new int[]{11, 10, 10, 10, 10, 10, 10}));
        assertEquals("Granigan", logic.getStats().getDirectorName());
    }

    @Test
    public void formattingEntriesWorks() {
        logic.newGame("Granigan", new int[]{10, 10, 10, 10, 10, 10, 10});
        logic.setTravelLogic(new TravelLogic());
        logic.getTravelLogic().setDistance(3);
        String s = "asd";
        assertEquals("2178: asd\n\n3 turns until arrival.\n\n\n", logic.formatEntry(s));
    }

    @Test
    public void formattingFinalEntriesWorks() {
        logic.newGame("Granigan", new int[]{10, 10, 10, 10, 10, 10, 10});
        String s = "asd";
        assertEquals("2178: asd", logic.formatFinalEntry(s));
    }
    


//    @Test
//    public void selectionMadeModifiesStatsBasedOnCorrectOption() {
//        logic.newGame("Granigan", new int[]{0, 0, 0, 0, 0, 0, 0});
//
//        logic.setTurnScene(new TurnScene());
//        logic.setCurrentEvent(new BuildEvent("", options));
//        logic.selectionMade(2); // = third
//        System.out.println(logic.getStats().toString());
//        assertTrue(logic.getStats().hasEnoughResources(new int[]{7,6,5,4,3,2,1}));
//    }
}
