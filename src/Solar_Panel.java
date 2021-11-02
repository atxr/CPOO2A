public class Solar_Panel extends Type2 {
    Solar_Panel(double prod) {
        super(s -> {assert(s.length == 1); return s[0] ? prod : 0;});
    }
}