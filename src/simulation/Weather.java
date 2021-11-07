package simulation;
import java.util.ArrayList;
import java.util.Random;

/** Class Weather that implements the external parameters  at a given date and time for the simulation */
public class Weather {
    /** boolean to set the wind force at a given time */
    private boolean wind;
    /** boolean to set the sunlight at a given time */
    private boolean sun;
    /** boolean to set the coldness at a given time */
    private boolean cold;

    /** Day number in the year */
    int day;
    /** Minute number in the day */
    int t;

    /**
     * Constructor which sets each external parameters
     * 
     * @param wind  presence of wind or not
     * @param sun   presence of sun or not
     * @param cold  coldness
     * @param day   number of the day in the year
     * @param t     number of the minute in the day
     */
    public Weather(boolean wind, boolean sun, boolean cold, int day, int t) {
        this.wind = wind;
        this.sun = sun;
        this.cold = cold;
        this.day = day;
        this.t = t;
    }

    /**
     * Constructor which generate random external parameters according to the day in the year and the hour of the day
     * 
     * @param day   number of the day in the year
     * @param t     number of the minute in the day
     */
    public Weather(int day, int t) {
        Random rn = new Random();

        // Define probabilities for random generation
        double p_cold_winter = 0.9;
        double p_cold_summer = 0.001;
        double p_sun_winter = 0.3;
        double p_sun_summer = 0.8;

        this.day = day;
        this.t = t;

        this.wind = rn.nextDouble() < 0.5;
        
        // if cold season (september to april)
        if ((day < 365/4) || (day > 365*3/4)) { 
            this.cold = rn.nextDouble() < p_cold_winter; 
            this.sun = (t > 8 * 60) && (t < 21 * 60) && (rn.nextDouble() < p_sun_winter); 
        } 
        // else hot season 
        else {
            this.cold = rn.nextDouble() < p_cold_summer;
            this.sun = (t > 8 * 60) && (t < 21 * 60) && (rn.nextDouble() < p_sun_summer); // sun between 8am and 9pm with P(sun) = 95%
        }

    }

    /**
     * Getter wind
     * @return  wind
     */
    public boolean isWind() {
        return this.wind;
    }

    /**
     * Getter sun
     * @return  sun
     */
    public boolean isSun() {
        return this.sun;
    }

    /**
     * Getter coldness
     * @return cold
     */
    public boolean isCold() {
        return this.cold;
    }

    /**
     * Generate a random prediction of the weather for a whole year
     * The format of the prediction in an array of each day of the year, and a weather for a day is an array of Weather object at a given minute
     * @return The weather year prediction
     */
    static public ArrayList<ArrayList<Weather>> generate_year_prediction() {
        ArrayList<ArrayList<Weather>> weather_year = new ArrayList<>();

        for (int day=0; day<365; day++) {
            ArrayList<Weather> weather_day = new ArrayList<>();
            for (int t=0; t<60*24; t++) {
                weather_day.add(new Weather(day, t));
            }
            weather_year.add(weather_day);
        }

        return weather_year;
    }

}
