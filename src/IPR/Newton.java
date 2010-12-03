/**
 * @class     RootN
 * @version   0.02
 * @date      12 November 2010
 * @author    Sergey Khechumov, Team B
*/

package IPR;

// This version (0.02) of the class uses BigDecimal class to calculate a root.
// Old name: RootN.

import java.math.BigDecimal;// To use BigDecimals class.
import java.math.RoundingMode;// To indicate a rounding mode.
import javax.swing.JOptionPane;// To use JOptionPane message box.

public class Newton {
    private String sRootNResult;

    private double GetInitValue(int iRadicand, int iDegree) {
        double dResult=0;
        final int iInitialAccuracy = 0;

        /** Digit by digit algorithm as you can see from the name calculates the root digit by digit.
         *  Here we will use it to get an initial value for the Newton's algorithm
         *  (for not to have a huge table of initial values).
         */

        DigitByDigit DigitByDigitInstance = new DigitByDigit();

        DigitByDigitInstance.SetPower(iDegree);
        DigitByDigitInstance.SetRadicand(iRadicand);
        DigitByDigitInstance.SetAccuracy(iInitialAccuracy);
        dResult = Double.parseDouble(DigitByDigitInstance.RootN());

        return dResult;
    }

    // Enumeration of error codes for CalculateRootN function.
    public enum eErrorCode {
        OK,// No error.
        CONVERGE_ERROR,// Newton's method does not converge.
        EXCEPTION_ERROR// Other errors (exception occured).
    }

    // Calculates root of degree iDegree and radicand iRadicand using Newton's method.
    public eErrorCode CalculateRootN(int iRadicand, int iDegree, int iAccuracy) {
        BigDecimal bdXCur = new BigDecimal(0);// X (result) of this iteration.
        BigDecimal bdXNext = new BigDecimal(0);// X (result) of the next iteration.

        BigDecimal bdAccuracyOld = new BigDecimal(100);// An accuracy of the previous iteration.

        BigDecimal bdAccuracy = new BigDecimal(0);// An accuracy of this iteration.
        bdAccuracy = Accuracy.ModifyAccuracyToBigDecimal(iAccuracy);

        bdXNext = BigDecimal.valueOf(this.GetInitValue(iRadicand, iDegree));// Sets an initial value.

        try {
            long lStartTime = System.currentTimeMillis();// Get a time of start of an operation.

            // Main cycle
            do {
                bdXCur = bdXNext;
                // TODO: Here we can do it more general if we describe our function in a separate class and we will have another which will compute a derivative.
                // XNext = XCur - ((XCur^degree - radicand) / degree * XCur);
                bdXNext = bdXCur.subtract( ((bdXCur.pow(iDegree).subtract(BigDecimal.valueOf(iRadicand))).divide(BigDecimal.valueOf(iDegree).multiply(bdXCur), iAccuracy*2, RoundingMode.HALF_UP)) );

                // Verify if the result does not converges.
                if((bdXNext.subtract(bdXCur).abs().compareTo(bdAccuracyOld)>=0) || ((System.currentTimeMillis() - lStartTime) > 1000)) {
                    return eErrorCode.CONVERGE_ERROR;
                }
            } while ((bdXNext.subtract(bdXCur).abs().compareTo(bdAccuracy)) >= 0); // Repeat while we have not a result with a necessary accuracy.

            // Round our result to a needed accuracy.
            bdXCur = bdXCur.setScale(iAccuracy, RoundingMode.HALF_UP);
            sRootNResult = bdXCur.toString();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "The program was enable to calculate this root.\r\n" + e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
            return eErrorCode.EXCEPTION_ERROR;
        }

        return eErrorCode.OK;
    }

    // Returns a result: calculated root.
    public String GetRootN() {
        return sRootNResult;
    }
}
