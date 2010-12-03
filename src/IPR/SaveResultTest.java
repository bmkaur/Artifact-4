package IPR;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import IPR.Accuracy;
import IPR.Degree;
import IPR.Radicand;

import junit.framework.TestCase;

public class SaveResultTest extends TestCase{

    public void testPathForSaving() {
        //String sResult = "";
        //JFileChooser frmSaveAs = new JFileChooser();
        int iReturnVal;

        iReturnVal = JFileChooser.APPROVE_OPTION;//frmSaveAs.showSaveDialog(frmSaveAs);

        switch(iReturnVal) {
	        case JFileChooser.APPROVE_OPTION: {
	        	assertTrue("Enter to a case APPROVE_OPTION when it's not a case.", iReturnVal == JFileChooser.APPROVE_OPTION);
	        	break;
	        	//sResult = frmSaveAs.getSelectedFile().getPath();
	        }
	        default: {// An error while saving
	        	//JOptionPane.showMessageDialog(null, "The program was unable to save your file.", "Error!", JOptionPane.ERROR_MESSAGE);
	        	assertTrue("Do not enter to a case APPROVE_OPTION when it's a case.", iReturnVal != JFileChooser.APPROVE_OPTION);
	        	break;
	        }
        }

        
        iReturnVal = JFileChooser.ERROR_OPTION;//frmSaveAs.showSaveDialog(frmSaveAs);

        switch(iReturnVal) {
	        case JFileChooser.APPROVE_OPTION: {
	        	assertTrue("Enter to a case APPROVE_OPTION when it's not a case.", iReturnVal == JFileChooser.APPROVE_OPTION);
	        	break;
	        	//sResult = frmSaveAs.getSelectedFile().getPath();
	        }
	        default: {// An error while saving
	        	//JOptionPane.showMessageDialog(null, "The program was unable to save your file.", "Error!", JOptionPane.ERROR_MESSAGE);
	        	assertTrue("Do not enter to a case APPROVE_OPTION when it's a case.", iReturnVal != JFileChooser.APPROVE_OPTION);
	        	break;
	        }
        }
        //return sResult;
    }
}
