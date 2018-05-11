package podship.logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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

//    @Test
//    public void selectionMadeModifiesStatsBasedOnCorrectOption() {
//        logic.newGame("Granigan", new int[]{0, 0, 0, 0, 0, 0, 0});
//
//        logic.setTurnScene(new TurnScene());
//        ArrayList<Option> options = new ArrayList<>();
//        options.add(new Option("first", new int[]{1,2,3,4,5,6,7}, new ArrayList<Integer>()));
//        options.add(new Option("second", new int[]{1,2,3,4,5,6,7}, new ArrayList<Integer>()));
//        options.add(new Option("third", new int[]{7,6,5,4,3,2,1}, new ArrayList<Integer>()));
//        logic.setCurrentEvent(new BuildEvent("", options));
//        logic.selectionMade(2); // = third
//        System.out.println(logic.getStats().toString());
//        assertTrue(logic.getStats().hasEnoughResources(new int[]{7,6,5,4,3,2,1}));
//    }

}
