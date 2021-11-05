import java.util.ArrayList;

import Devices.Central;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        City toulouse = new City();
        toulouse.addProducer(new Central(1000000));
        toulouse.addProducer(new Eolienne(1000));
        toulouse.addProducer(new Solar_Panel(0.2f));

        int nb_house = 1000;
        for (int i = 0; i < nb_house; i++) {
            House h1 = new House();
            h1.addDevice(new Heating(1));
            h1.addDevice(new Fridge(0.2f));
            toulouse.addHouse(h1);

        }
        ArrayList<ArrayList<Weather>> weather_year = Weather.generate_year_prediction();

        toulouse.annual_report("annual.csv", weather_year);
        toulouse.getProducers().get(1).daily_report("eolienne.csv", weather_year.get(100));
        toulouse.getConsumers().get(1).daily_report("house1.csv", weather_year.get(100));
    }
}
