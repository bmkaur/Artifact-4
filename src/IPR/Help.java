/**
 * @class    MainForm
 * @version   0.01
 * @date      8 November 2010
 * @author    Sergey Khechumov, Baljinder Kaur, Jalal Noureddine (Team B)
 */

package IPR;

import java.awt.Desktop;// To use Desktop class
import java.io.File;// To use File class
import java.io.IOException;// To use IOException class
import javax.swing.JOptionPane;// To use JOptionPane class (show the message box)

public class Help {
    static void OpenFile(String sPath) {
        // The code of this function was entirely taken from http://www.java2s.com/Code/Java/JDK-6/OpenaofficewordfilewithJava.htm
        // And just minor changes were made.
        try {
            Desktop desktop = null;
            if (Desktop.isDesktopSupported()) {
                desktop = Desktop.getDesktop();
            }

            desktop.open(new File(sPath));// Open file
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, "The program can not show this help page.\r\n" + e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
}
