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

    public Type1(ArrayList<Integer> periods, ArrayList<Float> values) {
        this(generatePeriodicList(periods, values));
    }

    public static ArrayList<Float> generatePeriodicList(ArrayList<Integer> periods, ArrayList<Float> values) {
        ArrayList<Float> power = new ArrayList<>();
        for (int t=0; t<periods.size(); t++) {
            for (int k=0; k<periods.get(t); k++) {
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
