import IPR.CheckForPrimalityTest_Prime;
import IPR.CheckForPrimalityTest_NotPrime;
import IPR.NewtonTest;
import IPR.AccuracyTest;
import IPR.DigitByDigitPrepareRadicandTest;
import IPR.RadicandTest;
import IPR.DegreeTest;
import IPR.RootNTest;
import IPR.SaveResultTest;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for default package");
		//$JUnit-BEGIN$
		
		suite.addTestSuite(CheckForPrimalityTest_Prime.class);// Primality test case, prime number
		suite.addTestSuite(CheckForPrimalityTest_NotPrime.class);// Primality test case, not a prime number
		suite.addTestSuite(NewtonTest.class);
		suite.addTestSuite(AccuracyTest.class);
		suite.addTestSuite(DigitByDigitPrepareRadicandTest.class);
		suite.addTestSuite(DegreeTest.class);
		suite.addTestSuite(RadicandTest.class);
		suite.addTestSuite(RootNTest.class);
		suite.addTestSuite(SaveResultTest.class);
		//$JUnit-END$
		return suite;
	}
	
}
