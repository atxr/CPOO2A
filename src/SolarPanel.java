

public class SolarPanel extends Producer {
    SolarPanel(float prod) {
        super("Solar Panel", new Type2(s -> s.isSun() ? prod : 0));
    }
}