import domaine.Number;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class NumberTest {

    protected Number numberTest;

    @Before
    public void setUp(){
        numberTest = new Number("Test","01.23.45.67");
    }

    @After
    public void tearDown(){
        numberTest = null;
    }

    @Test
    public void testEquals(){
        assertEquals(numberTest, new Number("Test", "01.23.45.67"));
    }

}
