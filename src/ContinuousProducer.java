
import java.util.ArrayList;
import java.util.List;
/** Represent a continuous device, with a constant production power */
public class ContinuousProducer extends Producer {
    /**
     * @param name  name of the device
     * @param prod  value of the constant production
     */
    public ContinuousProducer(String name, float prod) {
        super(name, new Type1(new ArrayList<Float>(List.of(prod))));
    }
}
