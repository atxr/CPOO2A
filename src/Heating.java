public class Heating extends Device {
    Heating(String name, float consumption) {
        super(name, new Type2(f -> f.isCold() ? consumption : 0));
    }
}
