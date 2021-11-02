import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Simulation interface Provide reports functions, for a day or a year
 */
public abstract class Simulation {
    /** name of the simulated object */
    protected String name;

    /**
     * Provide an annual report for the simulated object
     * The report is then written in a file in the data/ directory, in CSV format
     * @param filename      the filename stored in data/ (do not include data/ in the filename)
     * @param weather_year  a weather prediction for the whole year
     */
    public void annual_report(String filename, ArrayList<ArrayList<Weather>> weather_year) {
        System.out.println("Generate annual report for " +name+ " in " +filename);
        
        ArrayList<Float> consumption = new ArrayList<>();
        ArrayList<Float> production = new ArrayList<>();

        for (int day = 0; day < 365; day++) {
            ArrayList<Weather> weather_day = weather_year.get(day);
            consumption.add(day, get_consumption_day(day, weather_day));
            production.add(day, get_production_day(day, weather_day));
        }

        Array2CSV(filename, consumption, production);
    }

    /**
     * Provide an daily report for the simulated object
     * The report is then written in a file in the data/ directory, in CSV format
     * @param filename      the filename stored in data/ (do not include data/ in the filename)
     * @param weather_day   a weather prediction for the whole year
     */
    public void daily_report(String filename, ArrayList<Weather> weather_day) {
        System.out.println("Generate daily report for " +name+ " in " +filename);

        ArrayList<Float> consumption = new ArrayList<>();
        ArrayList<Float> production = new ArrayList<>();

        for (int t = 0; t < 60 * 24; t++) {
            consumption.add(get_consumption_min(t, weather_day.get(t)));
            production.add(get_production_min(t, weather_day.get(t)));
        }

        Array2CSV(filename, consumption, production);
    }

    /**
     * Write a CSV formatted file from two data arrays 
     * @param filename      the filename stored in data/ (do not include data/ in the filename)
     * @param consumption   the array with the consumption data
     * @param production    the array with the production data
     */
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

    /**
     * Function that return the consumption power of the simulated device for a given minute
     * @param time      the time to get the consumption power
     * @param weather   the weather at the given time 
     * @return          the power during the given minute
     */
    abstract public float get_consumption_min(int time, Weather weather);
    
    /**
     * Function that return the production power of the simulated device for a given minute
     * @param time      the time to get the production power
     * @param weather   the weather at the given time 
     * @return          the power during the given minute
     */   
    abstract public float get_production_min(int time, Weather weather);

     /**
     * Function that return the consumption power of the simulated device for a given day
     * @param day           the day to get the consumption power
     * @param weather_day   the weather during the whole day 
     * @return              the power during the given day
     */   
    abstract public float get_consumption_day(int day, ArrayList<Weather> weather_day);

    /**
     * Function that return the consumption power of the simulated device for a given day
     * @param time      the day to get the consumption power
     * @param weather   the weather the whole day 
     * @return          the power during the given day
     */   
   abstract public float get_production_day(int day, ArrayList<Weather> weather_day);
}
