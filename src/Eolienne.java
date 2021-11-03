import java.util.function.Function;

public class Eolienne extends Producer {
    Eolienne(float prod) {
        super(new Type2(v -> v.isWind() ? prod : 0));
    }
}