package consumption.devices;
import consumption.Device;
import type.Type2;

/** Represent a device which depends on the coldness of the weather */
public class Heating extends Device {
    /**
     * @param name          name of the device
     * @param consumption   consumption of the device when the weather is cold
     */
    public Heating(String name, float consumption) {
        super(name, new Type2(f -> f.isCold() ? consumption : 0));
    }
}
