/**
 * @class     Accuracy
 * @version   0.01
 * @date      8 November 2010
 * @author    Sergey Khechumov, Jalal Noureddine (Team B)
 */

// We understand that classes Degree, Precision and Radicand have in fact the same functionality and code,
// so it could be one class, but in reason of maintainability we decided to separate them into 3 different classes.

package IPR;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Accuracy {

    private int iAccuracy;
    static final int iBaseOfCalculation = 10;
    private static final int iMaxAccuracy = 200;// max is 200

    public int GetAccuracy() {
        return iAccuracy;
    }

    // This function returns an accuracy like a double value.
    // Ex.: if accuracy is 3 the function will return 0.001 (3 digits after a point).
    public static double ModifyAccuracyToDouble(int iAcc) {
        double dResult = 1;

        for(int i=0; i<iAcc; i++) {
            dResult = dResult / 10;
        }

        return dResult;
    }

    // This function returns the accuracy like a BigDecimal value.
    // Ex.: if accuracy is 3 the function will return 0.001 (3 digits after the point).
    public static BigDecimal ModifyAccuracyToBigDecimal(int iAcc) {
        BigDecimal bdResult = new BigDecimal(1);

        for(int i=0; i<iAcc; i++) {
            bdResult = bdResult.divide(BigDecimal.valueOf(iBaseOfCalculation), iAcc, RoundingMode.HALF_UP);
        }

        return bdResult;
    }

    public double GetAccuracyInDouble() {
        return ModifyAccuracyToDouble(iAccuracy);
    }

    public BigDecimal GetAccuracyInBigDecimal() {
        return ModifyAccuracyToBigDecimal(iAccuracy);
    }

    // Verifies the accuracy and sets it form a value in parameter.
    public boolean SetAccuracy(int iAcc) {
        boolean bResult = false;// Returns true if the radicand was changes and false if not

        if(VerifyAccuracy(iAcc)) {
            iAccuracy = iAcc;
            bResult = true;
        }

        return bResult;
    }

    // Verifies the accuracy.
    private boolean VerifyAccuracy(int iAcc) {
        boolean bResult = false;

        if (iAcc > 0 && iAcc <= iMaxAccuracy) { 
            bResult = true;
        }

        return bResult;
    }
}