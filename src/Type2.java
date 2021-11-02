import java.util.function.Function;

import javax.swing.text.StyledEditorKit.BoldAction;

/**
 * Type2 of TypeConsumption interface 
 * Represent a type of consumption, which depends on external parameters
 */
public class Type2 implements TypeConsumption {
    /** Function f that describe the behavior of the consumption according to the external parameters */
    private Function<Boolean[], Double>  f;

    public Type2(Function<Boolean[], Double> f) {
        this.f = f;
    }

    @Override
    public double getConsumption(double time) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
