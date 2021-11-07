package type;
import java.util.ArrayList;
import java.util.List;

import simulation.Weather;
/**
 * Type1 of TypeConsumption interface 
 * Represent a periodic type of consumption/production, with no dependencies on external parameters
 */
public class Type1 implements TypeConsumption {
    /** List of power values
     * The index represents the time in minutes
     * The length of the array represents the period of the production/consumption model 
     */
    private List<Float> power;

    /**
     * Basic constructor with only the power list
     * @param power power list whose size is the period of the model
     */
    public Type1(List<Float> power) {
        this.power = power;
    }

    /**
     * Constructor with a different format of input to construct the power list
     * @param times     array of times  
     * @param values    array of power value during the corresponding time in the periods array
     */
    public Type1(List<Integer> times, List<Float> values) {
        this(generatePeriodicList(times, values));
    }

    /**
     * Static function that generate a periodic list from a time and a value list
     * @param times     array of times
     * @param values    array of power value during the corresponding time in the periods array
     * @return          A power list built from the times and values array
     */
    public static List<Float> generatePeriodicList(List<Integer> times, List<Float> values) {
        List<Float> power = new ArrayList<>();
        for (int t=0; t<times.size(); t++) {
            for (int k=0; k<times.get(t); k++) {
                power.add(values.get(t));
            }
        }
        return power;
    } 
    
    @Override
    public float getPower(int time, Weather w) {
        return power.get(time % power.size());
    }
    
}
