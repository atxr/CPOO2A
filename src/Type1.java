import java.util.ArrayList;

/**
 * Type1 of TypeConsumption interface 
 * Represent a periodic type of consumption, with no dependencies on external parameters
 */
public class Type1 implements TypeConsumption {

    private ArrayList<Float> power;

    public Type1(ArrayList<Float> power) {
        this.power = power;
    }
    
    @Override
    public float getPower(int time, Weather w) {
        return power.get(time % power.size());
    }
    
}
