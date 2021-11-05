import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Simulation interface Provide reports functions, for a day or a year
 */
public abstract class Simulation {
    public void annual_report(String filename, ArrayList<ArrayList<Weather>> weather_year) {
        ArrayList<Float> consumption = new ArrayList<>();
        ArrayList<Float> production = new ArrayList<>();

        for (int day = 0; day < 365; day++) {
            ArrayList<Weather> weather_day = weather_year.get(day);
            consumption.add(day, get_consumption_day(day, weather_day));
            production.add(day, get_production_day(day, weather_day));
        }

        Array2CSV(filename, consumption, production);
    }

    public void daily_report(String filename, ArrayList<Weather> weather_day) {
        ArrayList<Float> consumption = new ArrayList<>();
        ArrayList<Float> production = new ArrayList<>();

        for (int t = 0; t < 60 * 24; t++) {
            consumption.add(get_consumption_min(t, weather_day.get(t)));
            production.add(get_production_min(t, weather_day.get(t)));
        }

        Array2CSV(filename, consumption, production);
    }

    public void Array2CSV(String filename, ArrayList<Float> consumption, ArrayList<Float> production) {
        FileWriter fw = null;

        try {
            if (filename=="") {
                filename = "data/tmp.csv";
            } else {
                filename = "data/"+filename;
            }

            fw = new FileWriter(filename);

            float tot_consumption = 0;
            float tot_production = 0;
            for (int k = 0; k < consumption.size(); k++) {
                tot_consumption += consumption.get(k);
                tot_production += production.get(k);
                fw.write(k + " ; " + consumption.get(k) + " ; " + production.get(k) + " ; " + tot_consumption + " ; " + tot_production + "\n");
            }

            fw.close();

        } catch (IOException e) {
            System.out.println("Bad filename " + filename);
        }

    }

    abstract public float get_consumption_min(int time, Weather weather);

    abstract public float get_production_min(int time, Weather weather);

    abstract public float get_consumption_day(int day, ArrayList<Weather> weather_day);

    abstract public float get_production_day(int day, ArrayList<Weather> weather_day);
}
