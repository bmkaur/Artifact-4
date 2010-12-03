/**
 * @class     Degree
 * @version   0.01
 * @date      8 November 2010
 * @author    Sergey Khechumov, Jalal Noureddine, Baljinder Kaur (Team B)
 */

// We understand that classes Degree, Precision and Radicand have in fact the same functionality and code,
// so it could be one class, but in reason of maintainability we decided to separate them into 3 different classes.

package IPR;

public class Degree {

    private int iDegree;
    private static final int iMaxDegree = 200;// max is 200

    public int GetDegree() {
        return iDegree;
    }

    // Returns true if the radicand was changes and false if not
    public boolean SetDegree(int iDeg) {
        boolean bResult = false;

        if(VerifyDegree(iDeg)) {
            iDegree = iDeg;
            bResult = true;
        }

        return bResult;
    }

    private boolean VerifyDegree(int iDeg) {
        boolean bResult = false;

        if (iDeg > 0 && iDeg <= iMaxDegree) {
            bResult = true;
        }

        return bResult;
    }
}
