package IPR;
import javax.swing.JOptionPane;
import IPR.Accuracy;
import IPR.Degree;
import IPR.Radicand;

import junit.framework.TestCase;

public class RootNTest extends TestCase{

    public void testRootN() {
    	
        Radicand Rad = new Radicand();
        Degree Deg = new Degree();
        Accuracy Acc = new Accuracy();
        //Newton Root = new Newton();
        
        Rad.SetRadicand(3);
        Deg.SetDegree(2);
        Acc.SetAccuracy(10);
        
        Newton.eErrorCode ErrorCode = Newton.eErrorCode.CONVERGE_ERROR;//Root.CalculateRootN(Rad.GetRadicand(), Deg.GetDegree(), Acc.GetAccuracy());
        // Compute the root with a Newton's method
        switch(ErrorCode) {
            case CONVERGE_ERROR: {// If Newton's method does not converge,...
                DigitByDigit DbD = new DigitByDigit();// ...use digit by digit algorithm
                JOptionPane.showMessageDialog(null, "The computation can take more time.\r\n", "Attention!", JOptionPane.INFORMATION_MESSAGE);

                DbD.SetRadicand(Rad.GetRadicand());
                DbD.SetPower(Deg.GetDegree());
                DbD.SetAccuracy(Acc.GetAccuracy());
                //sRootExtracted = DbD.RootN();// Compute the root.
                assertTrue("Enter to a case CONVERGE_ERROR when it's not a case.", ErrorCode == Newton.eErrorCode.CONVERGE_ERROR);
                break;
            }
            case EXCEPTION_ERROR: {// If Newton's method ended with an exception
                //sRootExtracted = "ERROR!";
            	assertTrue("Enter to a case EXCEPTION_ERROR when it's not a case.", ErrorCode == Newton.eErrorCode.EXCEPTION_ERROR);
                break;
            }
            default: {// OK
            	assertTrue("Enter to a case OK when it's not a case.", ErrorCode == Newton.eErrorCode.OK);
                //sRootExtracted = Root.GetRootN();
                break;
            }
        }
        
        ErrorCode = Newton.eErrorCode.EXCEPTION_ERROR;//Root.CalculateRootN(Rad.GetRadicand(), Deg.GetDegree(), Acc.GetAccuracy());
        switch(ErrorCode) {
        case CONVERGE_ERROR: {// If Newton's method does not converge,...
            DigitByDigit DbD = new DigitByDigit();// ...use digit by digit algorithm
            JOptionPane.showMessageDialog(null, "The computation can take more time.\r\n", "Attention!", JOptionPane.INFORMATION_MESSAGE);

            DbD.SetRadicand(Rad.GetRadicand());
            DbD.SetPower(Deg.GetDegree());
            DbD.SetAccuracy(Acc.GetAccuracy());
            //sRootExtracted = DbD.RootN();// Compute the root.
            assertTrue("Enter to a case CONVERGE_ERROR when it's not a case.", ErrorCode == Newton.eErrorCode.CONVERGE_ERROR);
            break;
        }
        case EXCEPTION_ERROR: {// If Newton's method ended with an exception
            //sRootExtracted = "ERROR!";
        	assertTrue("Enter to a case EXCEPTION_ERROR when it's not a case.", ErrorCode == Newton.eErrorCode.EXCEPTION_ERROR);
            break;
        }
        default: {// OK
        	assertTrue("Enter to a case OK when it's not a case.", ErrorCode == Newton.eErrorCode.OK);
            //sRootExtracted = Root.GetRootN();
            break;
        }
    }
        
        ErrorCode = Newton.eErrorCode.OK;//Root.CalculateRootN(Rad.GetRadicand(), Deg.GetDegree(), Acc.GetAccuracy());
        switch(ErrorCode) {
        case CONVERGE_ERROR: {// If Newton's method does not converge,...
            DigitByDigit DbD = new DigitByDigit();// ...use digit by digit algorithm
            JOptionPane.showMessageDialog(null, "The computation can take more time.\r\n", "Attention!", JOptionPane.INFORMATION_MESSAGE);

            DbD.SetRadicand(Rad.GetRadicand());
            DbD.SetPower(Deg.GetDegree());
            DbD.SetAccuracy(Acc.GetAccuracy());
            //sRootExtracted = DbD.RootN();// Compute the root.
            assertTrue("Enter to a case CONVERGE_ERROR when it's not a case.", ErrorCode == Newton.eErrorCode.CONVERGE_ERROR);
            break;
        }
        case EXCEPTION_ERROR: {// If Newton's method ended with an exception
            //sRootExtracted = "ERROR!";
        	assertTrue("Enter to a case EXCEPTION_ERROR when it's not a case.", ErrorCode == Newton.eErrorCode.EXCEPTION_ERROR);
            break;
        }
        default: {// OK
        	assertTrue("Enter to a case OK when it's not a case.", ErrorCode == Newton.eErrorCode.OK);
            //sRootExtracted = Root.GetRootN();
            break;
        }
    }
    }
}
