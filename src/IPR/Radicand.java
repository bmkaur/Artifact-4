/**
 * @class     Radicand
 * @version   0.01
 * @date      8 November 2010
 * @author    Sergey Khechumov, Jalal Noureddine, Baljinder Kaur (Team B)
 */

// We understand that classes Degree, Precision and Radicand have in fact the same functionality and code,
// so it could be one class, but in reason of maintainability we decided to separate them into 3 different classes.

package IPR;

public class Radicand {

    private int iRadicand;
    private static final int iMaxRadicand = 2147454997;// radicand max value is 2147454997. error after this last prime number.
    												   // thanks to prime-numbers.org for providing the prime numbers list

    public int GetRadicand() {
        return iRadicand;
    }

    public boolean SetRadicand(int iRad) {
        boolean bResult = false;// Returns true if the radicand was changes and false if not

        if(VerifyRadicand(iRad)) {
            iRadicand = iRad;
            bResult = true;
        }

        return bResult;
    }

    private boolean VerifyRadicand(int iRad) {
        boolean bResult = false;

        if (iRad > 0 && iRad <= iMaxRadicand) {
            CheckForPrimality cpCheck = new CheckForPrimality();
            if(cpCheck.IsPrime(iRad)) {
                bResult = true;
            }
        }

        return bResult;
    }
}