/**
 * Type1 of TypeConsumption interface 
 * Represent a periodic type of consumption, with no dependencies on external parameters
 */
public class Type1 implements TypeConsumption {

    private double power[];
    private int period;
    
    @Override
    public double getConsumption(double time) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
