package IPR;
import junit.framework.TestCase;

public class CheckForPrimalityTest_Prime extends TestCase {

		
    public void testIsPrime()
    {
    	int iNum = 4733;// Set a number to test
    	
        boolean bResult = true;// Result of the function (if a number (iNum) is prime (true) or not (false))
        boolean bIncIndex = false;// A boolean that indicates whether m will be incremented by 4 (true) or by 2 (false)

        if (iNum <= 1)// 0, 1 and any negative number are not prime
        {
            bResult = false;
        }
        else if (iNum == 2 || iNum == 3) // 2 and 3 are prime
        {
            bResult = true;// Don't have to assign, but to eliminate a chance of error in case of changes of default value of bResult or something else
        }
        else if (iNum % 2 == 0 || iNum % 3 == 0) // If 2 or 3 are factors of iNum, iNum is not prime
        {
            bResult = false;
        }
        else
        {
            double dNumSqrt;// For sqrt of iNum. We will calculate it just once before the loop for not to recalculate it each iteration.

            //RootN LocalRootN = new RootN();//new instance of RootN class
            //LocalRootN.CalculateRootN(iNum, 2, 2);//calculate square root of iNum


            dNumSqrt = Math.sqrt(iNum); // Assign calculated sqrt to the dNumSqrt
			
			 // MAIN CYCLE
            // m is a number of form 6*k-1 and 6*k+1 where k is a positive integer number

            for (int m = 5; m <= dNumSqrt; m += 2)
            {
                if (iNum % m == 00) // If m is a factor of iNum, iNum is not prime
                {
                    bResult = false; // Not prime
                    break;
                }

                if (bIncIndex)// If bIncIndex is true, we have to add 4 to m and not just 2.
                {
                    m += 2;
                }
				
                bIncIndex = !bIncIndex;// Invert bIncIndex to have 2 and 4 and 2, ... one after another

            }
        }
        
        assertTrue(bResult);
    }
		
	}
		