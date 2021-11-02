import java.util.ArrayList;

/**
 * Type1 of TypeConsumption interface 
 * Represent a periodic type of consumption, with no dependencies on external parameters
 */
public class Type1 implements TypeConsumption {

    private ArrayList<Double> power;

    public Type1(ArrayList<Double> power) {
        this.power = power;
    }
    
    @Override
    public double getConsumption(double time) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
