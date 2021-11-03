import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        City toulouse = new City();
        toulouse.addProducer(new Central(1000));
        toulouse.addProducer(new Eolienne(300));
        toulouse.addProducer(new Solar_Panel(200));

        House h1 = new House();
        h1.addDevice(new Heating(30));
        toulouse.addHouse(h1);

        ArrayList<ArrayList<Weather>> weather_year = Weather.generate_year_prediction();

        toulouse.annual_report("annual.csv", weather_year);
        h1.annual_report("h1.csv", weather_year);
        toulouse.getProducers().get(1).daily_report("eolienne.csv", weather_year.get(100));
    }
}
