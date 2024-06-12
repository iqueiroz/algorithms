public class Calculator {
    /**
     * Raises a number to the power of another number.
     * @param x the base number
     * @param y the exponent
     * @return the value of x raised to the power of y
     */
    public static double pow(double x, double y) {
        if(y == 0)
            return 1;

        if(x == 0)
            return 0;

        double result = 1.0;
        

        for(double i = y > 0 ? y : y*-1; i>0; i--)
            result *= x;
        
        return y > 0 ? result : 1d/result;
    }
}
