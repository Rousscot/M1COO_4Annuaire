import domaine.Number;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NumberTest {

    protected Number numberTest;

    @Before
    public void setUp(){
        numberTest = new Number("Test","01.23.45.67", null);
    }

    @After
    public void tearDown(){
        numberTest = null;
    }

    @Test
    public void testEquals(){
        Number numberTest2 = new Number("Test", "01.23.45.67", null);
        Assert.assertEquals("The Numbers are not equals ?", numberTest, numberTest2);
        int oneCode = numberTest.hashCode();
        Assert.assertEquals("Hash code not equal ?", oneCode, numberTest2.hashCode());
        Assert.assertEquals("Hash code changed ?", oneCode, numberTest.hashCode());
    }

}
