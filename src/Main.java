import java.util.ArrayList;

/**  */
public class Main {
    public static void main(String[] args) throws Exception {
        for (int i=0; i<10; i++) {
            System.out.println(Math.random());
        }

        City toulouse = new City("Toulouse");
        toulouse.addProducer(new ContinuousProducer("Central", 5000));
        toulouse.addProducer(new WindTurbine(50));
        int nb_panel = 50;
        for (int k = 0; k < nb_panel; k++) {
            toulouse.addProducer(new SolarPanel(0.2f));
            toulouse.addProducer(new SolarPanel(0.2f));
            toulouse.addProducer(new SolarPanel(0.2f));
        }

        int nb_house = 500;
        for (int i = 0; i < nb_house; i++) {
            House h = new House("House " + i);
            toulouse.addHouse(h);
        }
        ArrayList<ArrayList<Weather>> weather_year = Weather.generate_year_prediction();

        toulouse.annual_report("annual.csv", weather_year);
        toulouse.getProducers().get(1).daily_report("wind_turbine.csv", weather_year.get(100));
        toulouse.getConsumers().get(1).daily_report("house1.csv", weather_year.get(100));
    }
}
