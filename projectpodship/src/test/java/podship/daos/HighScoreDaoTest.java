package podship.daos;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class HighScoreDaoTest {

    HighScoreDao hsDao = new HighScoreDao();

    public HighScoreDaoTest() {
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
    public void newEntryKeepsListAtFiveOrLessAtStart() {
        assertTrue(hsDao.getHiscores().size()<=5);
    }
    
    @Test
    public void newEntryKeepsListAtFiveOrLessAfterAddition() {
        hsDao.addNewEntry("test", 200);
        hsDao.addNewEntry("test", 200);
        hsDao.addNewEntry("test", 200);
        hsDao.addNewEntry("test", 200);
        assertTrue(hsDao.getHiscores().size()<=5);
    }
    
    @Test
    public void sortWorksAndToStringFormatsCorrectly() {
        hsDao.addNewEntry("3", 3000);
        hsDao.addNewEntry("1", 5000);
        hsDao.addNewEntry("4", 2000);
        hsDao.addNewEntry("5", 1000);
        hsDao.addNewEntry("2", 4000);
        
        assertEquals("1) 5000\t1\n"
                + "2) 4000\t2\n"
                + "3) 3000\t3\n"
                + "4) 2000\t4\n"
                + "5) 1000\t5\n"
                , hsDao.toString());
    }
}
