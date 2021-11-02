import java.util.function.Function;

public class Eolienne extends Producer {
    Eolienne(double prod) {
        super(new Type2(v -> {assert(v.length == 1); return v[0] ? prod : 0;}));
    }
}