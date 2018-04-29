package podship.travel;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import podship.events.BuildEvent;
import podship.travel.EventDeck;

public class EventDeckTest {
    
    public EventDeckTest() {
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
    public void EventDeckIsEmptyWhenCreated() {
        EventDeck deck = new EventDeck();
        assertEquals(0, deck.getDeckSize());
    }
    
    @Test
    public void eventsCanBeAdded() {
        EventDeck deck = new EventDeck();
        deck.addEvent(new BuildEvent());
        assertEquals(1, deck.getDeckSize());
    }
    
    @Test
    public void drawnEventIsRemoved() {
        EventDeck deck = new EventDeck();
        deck.addEvent(new BuildEvent());
        deck.getNextEvent();
        assertEquals(0, deck.getDeckSize());
    }
    
    @Test
    public void deckCanHoldMultipleEvents() {
        EventDeck deck = new EventDeck();
        deck.addEvent(new BuildEvent());
        deck.addEvent(new BuildEvent());
        deck.addEvent(new BuildEvent());
        deck.addEvent(new BuildEvent());
        deck.addEvent(new BuildEvent());
        deck.addEvent(new BuildEvent());
        deck.addEvent(new BuildEvent());
        deck.getNextEvent();
        assertEquals(6, deck.getDeckSize());
    }
    
    @Test
    public void sameObjectIsReturned() {
        EventDeck deck = new EventDeck();
        deck.addEvent(new BuildEvent("specific", new ArrayList<>()));
        assertEquals("specific", deck.getNextEvent().getEventText());
    }
    
    @Test
    public void randomEventIsDrawn() {
        // 1/10000 chance this test is a false negative!
        EventDeck deck = new EventDeck();
        for(int i = 0; i < 10000; i++) {
            deck.addEvent(new BuildEvent("#" + i, new ArrayList<>()));
        }
        assertNotSame("#0", deck.getNextEvent().getEventText());
    }
}
