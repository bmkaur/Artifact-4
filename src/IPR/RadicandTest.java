package IPR;
import junit.framework.TestCase;

public class RadicandTest extends TestCase{

    public void testVerifyRadicand() {
    	int iRad = 100;
    	final int iMaxRadicand = 2147454997;

        // DECISION SOURCE COVERAGE FOR THIS IF CONDITION
        // TRUE
        if (iRad > 0 && iRad <= iMaxRadicand) { // accuracy value max is 200
            assertTrue(true);
        }

        // FALSE
        iRad = -100;
        if (iRad > 0 && iRad <= iMaxRadicand) { // accuracy value max is 200
        	assertTrue("Bad Accuracy", false);
        }
    }
}
