import java.util.Arrays;

public class TimeSeries {
    /**
     * Raises a number to the power of another number.
     * @param p prices stock for days
     * @return the span on any day i where the maximum number of consecutive days (including current day i)
     *         when the price has been less than or equal to its price on day i
     */
    public static int[] computeSpan(int[] p) {

        int[] s = new int[p.length];

        //current day is inclusive, so we've at least 1 for each position
        Arrays.fill(s, 1); 

        //start loops on 2nd element, since the 1st one is already calculated
        for(int i=1; i<p.length; i++) {
            if(p[i] >= p[i-1]) 
                s[i] = s[i-1]+1;
        }

        return s;

    }
}
