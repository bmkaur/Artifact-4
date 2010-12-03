/**
* @class     SaveResult
* @version   0.01
* @date      8 November 2010
* @author    Sergey Khechumov, Jalal Noureddine, Baljinder Kaur (Team B)
*/

package IPR;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class SaveResult {
    private String sRootToSave;
    private String sRadicandToSave;
    private String sAccuracyToSave;
    private String sDegreeToSave;

    public void SetRootToSave(String sRoot) {
        sRootToSave = sRoot;
    }

    public void SetRadicandToSave(String sRadicand) {
        sRadicandToSave = sRadicand;
    }

    public void SetAccuracyToSave(String sAccuracy) {
        sAccuracyToSave = sAccuracy;
    }

    public void SetDegreeToSave(String sDegree) {
        sDegreeToSave = sDegree;
    }

    private String PathForSaving() {
        String sResult = "";
        JFileChooser frmSaveAs = new JFileChooser();
        int iReturnVal;

        iReturnVal = frmSaveAs.showSaveDialog(frmSaveAs);

        switch(iReturnVal) {
	        case JFileChooser.APPROVE_OPTION: {
	        	sResult = frmSaveAs.getSelectedFile().getPath();
	        	break;
	        }
	        default: {// An error while saving
	        	JOptionPane.showMessageDialog(null, "The program was unable to save your file.", "Error!", JOptionPane.ERROR_MESSAGE);
	        	break;
	        }
        }

        return sResult;
    }

    public boolean SaveTXT() {
        boolean bResult = true;
        String sFilePath;

        String sTemplate = "Incredible Prime Root (IPR)\r\n\n"
                + "This file represents the TXT output of the IPR program.\r\n\n"
                + "IPR is about carrying out a number of activities and, as a result, producing a number of artifacts related to a program that computes the root of integral degree d, d > 1, of a prime number n.\r\n\n"
                + "Date saved: " + DateTime.now() + "\r\n\n"
                + "Author: Team B\r\n\n"
                + "Radicand: "  + sRadicandToSave + "\r\n\n"
                + "Degree: " + sDegreeToSave + "\r\n\n"
                + "Accuracy: " + sAccuracyToSave + "\r\n\n"
                + "Result: " + sRootToSave;

        sFilePath = PathForSaving() + ".txt";
        File ioFile= new File(sFilePath);
        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter(ioFile));
            writer.write(sTemplate);
            writer.close();
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, "The program was unable to save your file.\r\n" + e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
            bResult = false;
        }

        return bResult;
    }

    public boolean SaveXML() {
        String sFilePath;
        String sXMLheader = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n\n";
        String sDTD ="<!DOCTYPE IPR [\r\n\n"
                + "<!ELEMENT IPR (DESCRIPTION, RADICAND, DEGREE, ACCURACY, RESULT)>\r\n\n"
                + "<!ATTLIST IPR\r\n"
                + "date CDATA #REQUIRED\r\n"
                + "author CDATA #REQUIRED\r\n"
                + ">\r\n\n"
                + "<!ELEMENT DESCRIPTION (#PCDATA)>\r\n"
                + "<!ELEMENT RADICAND (#PCDATA)>\r\n"
                + "<!ELEMENT DEGREE (#PCDATA)>\r\n"
                + "<!ELEMENT ACCURACY (#PCDATA)>\r\n"
                + "<!ELEMENT RESULT (#PCDATA)>\r\n\n"
                + "]>\r\n\n";
        String sXML ="<IPR author=\"Team B\" date=\"" + DateTime.now() + "\">\r\n\n"
                + "<DESCRIPTION>This file represents the XML output of the IPR program.\r\n"
                + "IPR is about carrying out a number of activities and, as a result, producing a number of artifacts related to a program that computes the root of integral degree d, d > 1, of a prime number n.</DESCRIPTION>\r\n\n"
                + "<RADICAND>"+ sRadicandToSave +"</RADICAND>\r\n\n"
                + "<DEGREE>"+ sDegreeToSave +"</DEGREE>\r\n\n"
                + "<ACCURACY>"+ sAccuracyToSave +"</ACCURACY>\r\n\n"
                + "<RESULT>"+ sRootToSave +"</RESULT>\r\n\n"
                + "</IPR>";
        sFilePath = PathForSaving() + ".xml";
        File ioXmlFile= new File(sFilePath);
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(ioXmlFile));
        }
        catch (IOException e) {
            e.getMessage();
        }
        try {
            writer.write(sXMLheader);
            writer.append(sDTD);
            writer.append(sXML);
        }
        catch(IOException e) {
            e.getMessage();
        }
        try {
            writer.close();
        }
        catch(IOException e) {
            e.getMessage();
        }
        return true;
    }
}
