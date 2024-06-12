
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TimeSeriesTests {
    @Test
    public void computeSpan_SampleData_ShouldMatch(){
        //setup
        int[] p = {10, 11, 13, 7, 8, 9, 12, 5};
        

        //act
        int[] s = TimeSeries.computeSpan(p);

        //assert
        assertEquals(1, s[0]); //span s[0] = 1
        assertEquals(2, s[1]); //span s[1] = 2
        assertEquals(3, s[2]); //span s[2] = 3
        assertEquals(4, s[6]); //span S[6] = 4
    } 


}
