import java.util.ArrayList;
import java.util.List;

public class Central extends Producer {
    Central(float prod) {
        super(new Type1(new ArrayList<Float>(List.of(prod))));
    }
}
