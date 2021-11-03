public class Heating extends Device {
    Heating(float conso) {
        super(new Type2(f -> f.isCold() ? conso : 0));
    }
}
