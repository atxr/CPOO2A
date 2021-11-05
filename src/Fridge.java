import java.util.ArrayList;
import java.util.List;

public class Fridge extends Device {

    public Fridge(float prod) {
        super(new Type1(new ArrayList<Float>(List.of(prod))));
    }
    
}
