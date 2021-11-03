public class Solar_Panel extends Producer {
    Solar_Panel(float prod) {
        super(new Type2(s -> s.isSun() ? prod : 0));
    }
}