/**
 * @class     RootN
 * @version   0.02
 * @date      12 November 2010
 * @author    Sergey Khechumov, Team B
*/

// This version (0.02) of the class uses BigDecimal class to calculate a root.
package IPR;

import javax.swing.JOptionPane;// To use JOptionPane message box.

public class RootN {
    private Radicand Rad = new Radicand();
    private Degree Deg = new Degree();
    private Accuracy Acc = new Accuracy();
    private String sRootExtracted;

    //private long lTimeOfOperation;

    public String GetRoot() {
        return sRootExtracted;
    }

    public int GetRadicand() {
        return Rad.GetRadicand();
    }

    public int GetDegree() {
        return Deg.GetDegree();
    }

    public int GetAccuracy() {
        return Acc.GetAccuracy();
    }
    
    public void Calculate(String sRadicand, String sDegree, String sAccuracy) {
        // TEST: Information for testers. Please comment before shipping to a client.
        // long lStartTime = System.currentTimeMillis();// Get a time of start of an operation.

        Newton Root = new Newton();

        // Verifies if fields for Radicand, Degree and Accuracy contain values.
        if(sRadicand.isEmpty() || sDegree.isEmpty() || sAccuracy.isEmpty()) {
            JOptionPane.showMessageDialog(null, "You should enter values into fields Radicand, Degree and Accuracy.", "Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Verifies if a radicand is an integer value.
        if(!Rad.SetRadicand(Integer.parseInt(sRadicand))) {
            JOptionPane.showMessageDialog(null, "The radicand must be a prime number!", "Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Verifies if a degree is an integer value.
        if(!Deg.SetDegree(Integer.parseInt(sDegree))) {
            JOptionPane.showMessageDialog(null, "The degree must be a natural number (1,2,...) less than 200!", "Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Verifies if an accuracy is an integer value.
        if(!Acc.SetAccuracy(Integer.parseInt(sAccuracy))) {
            JOptionPane.showMessageDialog(null, "The accuracy must be a natural number (1,2,...) less than 200!", "Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Compute the root with a Newton's method
        switch(Root.CalculateRootN(Rad.GetRadicand(), Deg.GetDegree(), Acc.GetAccuracy())) {
            case CONVERGE_ERROR: {// If Newton's method does not converge,...
                DigitByDigit DbD = new DigitByDigit();// ...use digit by digit algorithm
                JOptionPane.showMessageDialog(null, "The computation can take more time.\r\n", "Attention!", JOptionPane.INFORMATION_MESSAGE);

                DbD.SetRadicand(Rad.GetRadicand());
                DbD.SetPower(Deg.GetDegree());
                DbD.SetAccuracy(Acc.GetAccuracy());
                sRootExtracted = DbD.RootN();// Compute the root.
                break;
            }
            case EXCEPTION_ERROR: {// If Newton's method ended with an exception
                sRootExtracted = "ERROR!";
                break;
            }
            default: {// OK
                sRootExtracted = Root.GetRootN();
                break;
            }
        }

        // TEST: Information for testers. Please comment before shipping to a client.
        // lTimeOfOperation = System.currentTimeMillis() - lStartTime;
        // JOptionPane.showMessageDialog(null, "The computation has finished in " + lTimeOfOperation + " ms\r\n", "Attention!", JOptionPane.INFORMATION_MESSAGE);
    }
}
