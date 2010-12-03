/**
 * @class     CheckPrime
 * @version   0.01
 * @date      9 November 2010
 * @author    Jalal Noureddine, Team B
*/

package IPR;

import java.util.Calendar;
import java.text.SimpleDateFormat;

public class DateTime {
    private static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";// Date and time format

    public static String now() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
        return sdf.format(cal.getTime());
    }
}
