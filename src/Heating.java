public class Heating extends Device {
    Heating(double conso) {
        super(new Type2(f -> {assert f.length == 1; return f[0] ? -conso : 0; }));
    }
}
