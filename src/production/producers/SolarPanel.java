package production.producers;
import production.Producer;
import type.Type2;

/** Represents the solar panel producer, with a production that depends on the sun */
public class SolarPanel extends Producer {
    /**
     * Constructor of the Solar Panel
     * @param prod  production power when the weather is sunny
     */
    public SolarPanel(float prod) {
        super("Solar Panel", new Type2(s -> s.isSun() ? prod : 0));
    }
}