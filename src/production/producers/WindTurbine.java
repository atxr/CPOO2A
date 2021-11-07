package production.producers;
import production.Producer;
import type.Type2;

/** Wind Turbine class that represent a producer with a wind dependency */
public class WindTurbine extends Producer {
    /**
     * Constructor with the power value when their is wind
     * @param power
     */
    public WindTurbine(float power) {
        super("Wind Turbine", new Type2(v -> v.isWind() ? power : 0));
    }
}