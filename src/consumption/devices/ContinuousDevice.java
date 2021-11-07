package consumption.devices;
import java.util.List;

import consumption.Device;
import type.Type1;
/** Represent a continuous device, with a constant consumption power */
public class ContinuousDevice extends Device {
    /**
     * @param name  name of the device
     * @param prod  value of the constant consumption
     */
    public ContinuousDevice(String name, float prod) {
        super(name, new Type1(List.of(prod)));
    }
    
}
