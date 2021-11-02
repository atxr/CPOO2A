import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        City toulouse = new City();
        toulouse.addProducer(new Central(1000.));
        toulouse.addProducer(new Eolienne(300.));
        toulouse.addProducer(new Solar_Panel(200.));

        House h1 = new House();
        h1.addDevice(new Heating(30));
        toulouse.addHouse(h1);
    }
}
