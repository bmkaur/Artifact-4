package IPR;
import junit.framework.TestCase;

public class AccuracyTest extends TestCase{

    public void testVerifyAccuracy() {
    	int iAcc = 100;
        //boolean bResult = false;

        // DECISION SOURCE COVERAGE FOR THIS IF CONDITION
        // TRUE
        if (iAcc > 0 && iAcc <= 200) { // accuracy value max is 200
            assertTrue(true);
        }

        // FALSE
        iAcc = -100;
        if (iAcc > 0 && iAcc <= 200) { // accuracy value max is 200
        	assertTrue("Bad Accuracy", false);
        }
        
        //return bResult;
    }
	
}
