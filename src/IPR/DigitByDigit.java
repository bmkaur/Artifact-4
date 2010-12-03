/**
 * @class     DigitByDigit
 * @version   0.02
 * @date      12 November 2010
 * @author    Sergey Khechumov (Team B)
 */

// This version (0.02) of the class uses BigDecimal class to calculate the root.

package IPR;

import java.math.BigDecimal;// To use BigDecimal class.

class DigitByDigit {
    private String sRadicand;
    BigDecimal bdRadicand = new BigDecimal(0);

    private BigDecimal bdRemainder = new BigDecimal(0);
    // Root extracted thus far.
    private BigDecimal bdRootExtracted = new BigDecimal(0);
    // Power of a root to be extracted.
    private int iPower;
    // Base of a using number system. Static final is like a constant.
    private static final BigDecimal bdBase = new BigDecimal(10);
    // Next n digits of the radicand.
    private BigDecimal bdPowerDigitsOfRadicand = new BigDecimal(0);
    // Next digit of the root.
    private BigDecimal bdNextDigitOfRoot = new BigDecimal(0);
    // Value of the root extracted for the next iteration.
    private BigDecimal bdNextRoot = new BigDecimal(0);
    // Value of the reaminder for the next iteration.
    private BigDecimal bdNextRemainder = new BigDecimal(0);
    private BigDecimal bdAccuracy = new BigDecimal(2);

    // To set a power of the root to compute. Necessary to use before calling RootN.
    public void SetPower(int iPow) {
        iPower = iPow;
    }

    // To set a radicand of the root to compute. Necessary to use before calling RootN.
    public void SetRadicand(int iRad) {
        bdRadicand = BigDecimal.valueOf(iRad);
    }

    // To set an accuracy of the root to compute. Necessary to use before calling RootN.
    public void SetAccuracy(int iAcc) {
        bdAccuracy = BigDecimal.valueOf(iAcc);
    }

    // To prepare the radicand to be used by digit by digit method.
    private void PrepareRadicand() {
        sRadicand = bdRadicand.toString();

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
    }

    // The function returns if there are another digit to calculate (true) or not.
    private boolean IsNextAlpha(int i) {
        boolean bResult = false;

        // 
        if (sRadicand.length() >= i * iPower + iPower) {
            bResult = true;
        }

        return bResult;
    }

    private boolean IsPoint(int i) {
        boolean bResult = false;
        int iStartIndex = i * iPower;// Start index of a next set of digits

        // If the next set of digits contains a decimal point return true
        if(sRadicand.substring(iStartIndex, iStartIndex + iPower).contains(".")) {
            bResult = true;
        }

        return bResult;
    }

    private int GetAlpha(int i) {
        int iResult;
        int iStartIndex = i * iPower;
        
        if(IsPoint(i)) {
            iStartIndex ++;//For not to have a "."
        }

        iResult = Integer.parseInt(sRadicand.substring(iStartIndex, iStartIndex + iPower));

        return iResult;
    }

    private BigDecimal GetBeta() {
        BigDecimal bdResult;
        BigDecimal bdLeft;
        BigDecimal bdRight;

        BigDecimal bdDifference;

        //Not the best method of search, but quickly to develop.
        for (bdResult = BigDecimal.valueOf(9); bdResult.compareTo(BigDecimal.valueOf(0)) >= 0; bdResult = bdResult.subtract(BigDecimal.valueOf(1))) {
            //iLeft = (B * y + iResult)^n - B^n * y^n;
            bdLeft = bdBase.multiply(bdRootExtracted).add(bdResult).pow(iPower).subtract(bdBase.pow(iPower).multiply(bdRootExtracted.pow(iPower)));
            //iRight = B^n * r + Alpha;
            bdRight = bdBase.pow(iPower).multiply(bdRemainder).add(bdPowerDigitsOfRadicand);

            //bdDifference = bdLeft - bdRight;
            bdDifference = bdLeft.subtract(bdRight);

            // If Left - Right less or equals to zero.
            if (bdDifference.compareTo(BigDecimal.valueOf(0)) <= 0) {
                break;//the best Beta is found
            }
        }

        return bdResult;
    }

    public String RootN() {
        String sResult;
        BigDecimal bdTemp = new BigDecimal(0);
        int iPointIndex = 0;

        PrepareRadicand();
        bdRootExtracted = BigDecimal.valueOf(0);
        bdRadicand = BigDecimal.valueOf(0);
        
        for (int i = 0; IsNextAlpha(i); i++) {
            if(IsPoint(i)) {
                iPointIndex = i;
            }
            
            bdPowerDigitsOfRadicand = BigDecimal.valueOf(GetAlpha(i));
            bdNextDigitOfRoot = GetBeta();
            bdNextRoot = bdBase.multiply(bdRootExtracted).add(bdNextDigitOfRoot);
            //r_ = (int)(Math.pow(B, n) + Alpha - (Math.pow((B * y + Beta), n) - Math.pow(B, n) * Math.pow(y, n)));
            bdTemp = bdBase.multiply(bdRootExtracted).add(bdNextDigitOfRoot).pow(iPower).subtract(bdBase.pow(iPower).multiply(bdRootExtracted.pow(iPower)));
            bdNextRemainder = bdBase.pow(iPower).multiply(bdRemainder).add(bdPowerDigitsOfRadicand).subtract(bdTemp);
            bdRootExtracted = bdNextRoot;
            bdRemainder = bdNextRemainder;
        }

        if(iPointIndex != 0) {
            sResult = bdRootExtracted.toString().substring(0, iPointIndex);
            sResult += ".";
            sResult += bdRootExtracted.toString().substring(iPointIndex);
        }
        else {
            sResult = bdRootExtracted.toString();
        }

        return sResult;
    }
}

