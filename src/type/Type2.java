package type;
import java.util.function.Function;

import simulation.Weather;
/**
 * Type2 of TypeConsumption interface 
 * Represent a type of consumption, which depends on external parameters
 */
public class Type2 implements TypeConsumption {
    /** Function f that describe the behavior of the consumption according to the external parameters */
    private Function<Weather, Float>  f;

    /**
     * Basic constructor
     * @param f     function that return the device/producer power according to the weather 
     */
    public Type2(Function<Weather, Float> f) {
        this.f = f;
    }

    @Override
    public float getPower(int time, Weather w) {
        return f.apply(w);
    }
    
}
