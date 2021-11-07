import java.util.ArrayList;

import consumption.InjectionPoint;
import production.producers.ContinuousProducer;
import production.producers.SolarPanel;
import production.producers.WindTurbine;
import simulation.City;
import simulation.Weather;

/**  */
public class Main {
    public static void main(String[] args) {
        City toulouse = new City("Toulouse");

        // add producers
        toulouse.addProducer(new ContinuousProducer("Central", 5000));
        toulouse.addProducer(new WindTurbine(50));
        int nb_panel = 50;
        for (int k = 0; k < nb_panel; k++) {
            toulouse.addProducer(new SolarPanel(0.2f));
        }

        // add injection points
        int nb_house = 500;
        for (int i = 0; i < nb_house; i++) {
            toulouse.addInjectionPoint(new InjectionPoint("House " + i));
        }

        // generate weather prediction
        ArrayList<ArrayList<Weather>> weather_year = Weather.generate_year_prediction();

        // generate 3 different reports
        toulouse.annual_report("annual.csv", weather_year);
        toulouse.getProducers().get(1).daily_report("wind_turbine.csv", weather_year.get(100));
        toulouse.getConsumers().get(1).daily_report("house1.csv", weather_year.get(100));
    }
}
