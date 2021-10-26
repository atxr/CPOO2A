import java.util.function.Function;

/**
 * Type2 of TypeConsumption interface 
 * Represent a type of consumption, which depends on external parameters
 */
public class Type2 implements TypeConsumption {
    /** Function f that describe the behavior of the consumption according to the external parameters */
    private Function<Double, Double []>  f;

    @Override
    public double getConsumption(double time) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
