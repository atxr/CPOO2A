public class Solar_Panel extends Producer {
    Solar_Panel(double prod) {
        super(new Type2(s -> {assert(s.length == 1); return s[0] ? prod : 0;}));
    }
}