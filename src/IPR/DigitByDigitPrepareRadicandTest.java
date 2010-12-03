package IPR;
import java.math.BigDecimal;// To use BigDecimal class.
import junit.framework.TestCase;

public class DigitByDigitPrepareRadicandTest extends TestCase{

    // To prepare the radicand to be used bydigit by digit method.
    public void testPrepareRadicand() {
        String sRadicand = "2";//bdRadicand.toString();
        BigDecimal bdAccuracy = new BigDecimal(2);
        int iPower = 3;

        // Add a point if the radicand is an integer value.
        if (!sRadicand.contains(".")) {
            sRadicand += ".";
        }

        // The number of digits before the decimal point should be divisible by a power (n).
        // If not, add zeros at the beginning.
        while ((sRadicand.indexOf('.')) % iPower != 0) {
            sRadicand = "0" + sRadicand;
        }

        // The number of digits after the decimal point should be  a power (n)
        // Multiplied by an accuracy.

        // iAccuracyDif = Accuracy * power - (length of the radicand - incremented index of the decimal point).
        // The index of the decimal point is incremented because indexes start by 0.
        // iAccuracyDif is to be used to compute zeros we need to add after a decimal point
        int iAccuracyDif = (bdAccuracy.intValue() * iPower) - (sRadicand.length() - (sRadicand.indexOf('.') + 1));

        if (iAccuracyDif > 0) {
            for (int i = 0; i < iAccuracyDif; i++) {
                sRadicand += "0";
            }
        }
        //sRadicand = "003.000000";
        assertFalse("Wrong number of digits before a digital point.", (sRadicand.substring(0, sRadicand.indexOf('.')+1).length() % iPower) == 0 );
        assertFalse("Wrong number of digits after a digital point.", (sRadicand.substring(sRadicand.indexOf('.')+2)).length() == (iPower * bdAccuracy.intValue()) );
    }
}
