
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTests {
    @Test
    public void pow_RegularPositiveValues_ShouldRaise(){
        //setup
        double x = 7;
        double y = 6;
        double expected = Math.pow(x, y);

        //act
        double result = Calculator.pow(x, y);

        //assert
        assertEquals(expected, result, 0.001);
    } 


    @Test
    public void pow_NegativeBase_ShouldRaise(){
        //setup
        double x = -7;
        double y = 6;
        double expected = Math.pow(x, y);

        //act
        double result = Calculator.pow(x, y);

        //assert
        assertEquals(expected, result, 0.001);
    } 

    @Test
    public void pow_NegativeExpoent_ShouldRaise(){
        //setup
        double x = 7;
        double y = -6;
        double expected = Math.pow(x, y);

        //act
        double result = Calculator.pow(x, y);

        //assert
        assertEquals(expected, result, 0.001);
    } 

    @Test
    public void pow_NegativeBaseAndExpoent_ShouldRaise(){
        //setup
        double x = -7;
        double y = -6;
        double expected = Math.pow(x, y);

        //act
        double result = Calculator.pow(x, y);

        //assert
        assertEquals(expected, result, 0.001);
    } 

    @Test
    public void pow_ZeroedExpoent_ShouldReturn_1(){
        //setup
        double x = 7;
        double y = 0;
        double expected = Math.pow(x, y);

        //act
        double result = Calculator.pow(x, y);

        //assert
        assertEquals(expected, result, 0.001);
    } 

    @Test
    public void pow_ZeroedBase_ShouldReturn_0(){
        //setup
        double x = 0;
        double y = 6;
        double expected = Math.pow(x, y);

        //act
        double result = Calculator.pow(x, y);

        //assert
        assertEquals(expected, result, 0.001);
    } 
}
