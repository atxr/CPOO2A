import java.util.ArrayList;
import java.util.List;

public class Central extends Producer {
    Central(double prod) {
        super(new Type1(new ArrayList<Double>(List.of(prod))));
    }
}
