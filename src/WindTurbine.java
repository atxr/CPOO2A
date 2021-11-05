public class WindTurbine extends Producer {
    WindTurbine(float prod) {
        super("Wind Turbine", new Type2(v -> v.isWind() ? prod : 0));
    }
}