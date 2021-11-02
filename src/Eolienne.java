import java.util.function.Function;

public class Eolienne extends Type2 {
    Eolienne(double prod) {
        super(v -> {assert(v.length == 1); return v[0] ? prod : 0;});
    }
}