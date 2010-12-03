package IPR;
import junit.framework.TestCase;

public class DegreeTest extends TestCase{

    public void testVerifyDegree() {
    	int iDeg = 100;
    	final int iMaxDegree = 200;// max is 200

        // DECISION SOURCE COVERAGE FOR THIS IF CONDITION
        // TRUE
        if (iDeg > 0 && iDeg <= iMaxDegree) {
            assertTrue(true);
        }

        // FALSE
        iDeg = -100;
        if (iDeg > 0 && iDeg <= iMaxDegree) {
        	assertTrue("Bad degree", false);
        }
    }
}
