
import java.util.ArrayList;
import java.util.List;

public class ContinuousProducer extends Producer {
    public ContinuousProducer(String name, float prod) {
        super(name, new Type1(new ArrayList<Float>(List.of(prod))));
    }
}
