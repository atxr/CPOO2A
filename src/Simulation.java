import java.util.ArrayList;

/**
 * Simulation interface 
 * Provide reports functions, for a day or a year
 */
public abstract class Simulation {
    public void annual_report(String filename, ArrayList<ArrayList<Weather>> weather_year) {
        ArrayList<Float> consumption = new ArrayList<>();
        ArrayList<Float> production = new ArrayList<>();

        for (int day=0; day<365; day++) {
            ArrayList<Weather> weather_day =  weather_year.get(day);
            consumption.add(get_consumption_day(day, weather_day));
            production.add(get_production_day(day, weather_day));
        }

        // TODO print CSV
    }

    public void daily_report(String filename, ArrayList<Weather> weather_day) {
        ArrayList<Float> consumption = new ArrayList<>();
        ArrayList<Float> production = new ArrayList<>();

        for (int t=0; t<60*24; t++) {
            consumption.add(get_consumption_min(t, weather_day.get(t)));
            production.add(get_production_min(t, weather_day.get(t)));
        }

        // TODO print CSV
    }
    
    abstract public float get_consumption_min(int time, Weather weather);
    abstract public float get_production_min(int time, Weather weather);
    abstract public float get_consumption_day(int day, ArrayList<Weather> weather_day);
    abstract public float get_production_day(int day, ArrayList<Weather> weather_day);
}
