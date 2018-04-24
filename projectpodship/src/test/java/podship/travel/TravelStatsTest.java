package podship.travel;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import podship.travel.TravelStats;

public class TravelStatsTest {
    
    public TravelStatsTest() {
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
    public void constructorSetsStatsToZeroWhenNoParameter() {
        TravelStats stats = new TravelStats();
        String expectedReturn = "Flight statistics are:\n"
                +"0 units of air\n"
                +"0 units of energy\n"
                +"0 units of faith\n"
                +"0 units of food\n"
                +"0 units of morale\n"
                +"0 units of population\n"
                +"0 units of water\n";
        assertEquals(expectedReturn, stats.toString());
    }
    
    @Test
    public void constructorSetsRightValues() {
        TravelStats stats = new TravelStats(new int[]{5, 5, -5, 10, 0, 77, 20});
        String expectedReturn = "Flight statistics are:\n"
                +"5 units of air\n"
                +"5 units of energy\n"
                +"-5 units of faith\n"
                +"10 units of food\n"
                +"0 units of morale\n"
                +"77 units of population\n"
                +"20 units of water\n";
        assertEquals(expectedReturn, stats.toString());
    }
    
    @Test
    public void minimumRequirementsChecksValuesCorrectly1() {
        TravelStats stats = new TravelStats(new int[]{5, 5, -5, 10, 0, 77, 20});
        assertTrue(stats.hasEnoughResources(new int[]{5, 0, -6, 10, -5, 2, 2}));
    }

    @Test
    public void minimumRequirementsChecksValuesCorrectly2() {
        TravelStats stats = new TravelStats(new int[]{5, 5, -5, 10, 0, 77, 20});
        assertFalse(stats.hasEnoughResources(new int[]{15, 0, 0, 11, -5, 2, 2}));
    }
    
    @Test
    public void resourcesAreAboveZeroCheck() {
        TravelStats stats = new TravelStats(new int[]{1, 5, 15, 10, 3007, 77, 20});
        assertTrue(stats.hasAllResources());
    }
    
    @Test
    public void aResourceIsBelowOneCheck() {
        TravelStats stats = new TravelStats(new int[]{1, 5, 15, 10, 3007, 0, 20});
        assertFalse(stats.hasAllResources());
    }
    
    @Test
    public void aResourceIsBelowZeroCheck() {
        TravelStats stats = new TravelStats(new int[]{1, 5, 15, 10, 3007, -42, 20});
        assertFalse(stats.hasAllResources());
    }
    
    @Test
    public void adjustmentWorksCorrectly() {
        TravelStats stats = new TravelStats();
        stats.adjustResources(new int[]{5, 5, -5, 10, 0, 77, 20});
        String expectedReturn = "Flight statistics are:\n"
                +"5 units of air\n"
                +"5 units of energy\n"
                +"-5 units of faith\n"
                +"10 units of food\n"
                +"0 units of morale\n"
                +"77 units of population\n"
                +"20 units of water\n";
        assertEquals(expectedReturn, stats.toString());
    }
}
