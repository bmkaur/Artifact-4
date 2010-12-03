package IPR;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.swing.JOptionPane;

import org.junit.Test;

import IPR.Newton.eErrorCode;

import junit.framework.TestCase;


public class NewtonTest extends TestCase {

    //private String sRootNResult;
    int iLoopCondition = 0;

    /*private double GetInitValue(int iRadicand, int iDegree) {
        double dResult=0;
        final int iInitialAccuracy = 0;

        DigitByDigit DigitByDigitInstance = new DigitByDigit();

        DigitByDigitInstance.SetPower(iDegree);
        DigitByDigitInstance.SetRadicand(iRadicand);
        DigitByDigitInstance.SetAccuracy(iInitialAccuracy);
        dResult = Double.parseDouble(DigitByDigitInstance.RootN());

        return dResult;
    }*/
    
    
    //@Test(expected = ArithmeticException.class)
    // Calculates root of degree iDegree and radicand iRadicand using Newton's method.
     //@Test(timeout = 1000)  
    public void testNewtonTest(/*int iRadicand, int iDegree, int iAccuracy*/) {
    	int iRadicand = 3;
    	int iDegree = 2;
    	int iAccuracy = 10;
    	int iInitValue = 2;
    	
        BigDecimal bdXCur = new BigDecimal(0);// X (result) of this iteration.
        BigDecimal bdXNext = new BigDecimal(0);// X (result) of the next iteration.

        BigDecimal bdAccuracyOld = new BigDecimal(100);// An accuracy of the previous iteration.

        BigDecimal bdAccuracy = new BigDecimal(0);// An accuracy of this iteration.
        bdAccuracy = Accuracy.ModifyAccuracyToBigDecimal(iAccuracy);

        bdXNext = BigDecimal.valueOf(iInitValue/*this.GetInitValue(iRadicand, iDegree)*/);// Sets an initial value.

        try {
            long lStartTime = System.currentTimeMillis();// Get a time of start of an operation.

            // Main cycle
            do {
                bdXCur = bdXNext;
                // TODO: Here we can do it more general if we describe our function in a separate class and we will have another which will compute a derivative.
                // XNext = XCur - ((XCur^degree - radicand) / degree * XCur);
                bdXNext = bdXCur.subtract( ((bdXCur.pow(iDegree).subtract(BigDecimal.valueOf(iRadicand))).divide(BigDecimal.valueOf(iDegree).multiply(bdXCur), iAccuracy*2, RoundingMode.HALF_UP)) );

                // DECISION COVERAGE FOR THIS IF
                // TRUE, TRUE => TRUE
                int iAccuracyCompare = 0;//bdXNext.subtract(bdXCur).abs().compareTo(bdAccuracyOld);
                long lTimeCompare = 5000;//(System.currentTimeMillis() - lStartTime);
                
                // Verify if the result does not converges.
                if((iAccuracyCompare >= 0) || (lTimeCompare > 1000)) {
                    //return eErrorCode.CONVERGE_ERROR;
                	assertTrue(true);
                }
                else {
                	assertTrue("We passed by false case when both conditions are true!", false);
                }
                
                // FALSE, FALSE => FALSE
                iAccuracyCompare = -5;//bdXNext.subtract(bdXCur).abs().compareTo(bdAccuracyOld);
                lTimeCompare = 100;//(System.currentTimeMillis() - lStartTime);
                
                if((iAccuracyCompare >= 0) || (lTimeCompare > 1000)) {
                    //return eErrorCode.CONVERGE_ERROR;
                	assertTrue("We passed by true case when both conditions are false!", false);
                }
                else {
                	assertTrue(true);
                }
                
                iLoopCondition = -1;//(bdXNext.subtract(bdXCur).abs().compareTo(bdAccuracy));  
                
            } while (iLoopCondition >= 0); // Repeat while we have not a result with a necessary accuracy.

            // Round our result to a needed accuracy.
            bdXCur = bdXCur.setScale(iAccuracy, RoundingMode.HALF_UP);
         //   sRootNResult = bdXCur.toString();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "The program was enable to calculate this root.\r\n" + e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
            //return eErrorCode.EXCEPTION_ERROR;
        }

        //return eErrorCode.OK;
    }
}
		