import java.util.ArrayList;
import java.util.List;

public class ContinuousDevice extends Device {

    public ContinuousDevice(String name, float prod) {
        super(name, new Type1(new ArrayList<Float>(List.of(prod))));
    }
    
}
