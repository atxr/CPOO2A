import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        City toulouse = new City("Toulouse");
        toulouse.addProducer(new ContinuousProducer("Central", 1000000));
        toulouse.addProducer(new WindTurbine(1000));
        toulouse.addProducer(new SolarPanel(0.2f));
        toulouse.addProducer(new SolarPanel(0.2f));
        toulouse.addProducer(new SolarPanel(0.2f));

        int nb_house = 1000;
        for (int i = 0; i < nb_house; i++) {
            House h1 = new House("House "+i);
            h1.addDevice(new Heating("Heating", 1));
            h1.addDevice(new ContinuousDevice("Fridge", 0.2f));
            toulouse.addHouse(h1);

        }
        ArrayList<ArrayList<Weather>> weather_year = Weather.generate_year_prediction();

        toulouse.annual_report("annual.csv", weather_year);
        toulouse.getProducers().get(1).daily_report("wind_turbine.csv", weather_year.get(100));
        toulouse.getConsumers().get(1).daily_report("house1.csv", weather_year.get(100));
    }
}
