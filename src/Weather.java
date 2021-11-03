import java.util.ArrayList;
import java.util.Random;

public class Weather {
    private boolean wind;
    private boolean sun;
    private boolean cold;

    int day;
    int t;


    Weather() {
        wind = false;
        sun = false;
        cold = false;
        day = 0;
        t = 0;
    }

    public Weather(boolean wind, boolean sun, boolean cold, int day, int t) {
        this.wind = wind;
        this.sun = sun;
        this.cold = cold;
        this.day = day;
        this.t = t;
    }

    public Weather(int day, int t) {
        this.day = day;
        this.t = t;

        Random rn = new Random();
        this.wind = rn.nextInt() % 2 == 0; // P(wind) = 1/2
        
        // if cold season (september to april)
        if ((day < 365/4) && (day > 365*3/4)) { 
            this.cold = rn.nextInt() % 10 < 9; // P(cold) = 9/10
            this.sun = (t > 8 * 60) && (t < 21 * 60) && (rn.nextInt() % 10 < 3); // sun between 8am and 9pm with P(sun) = 3/10
        } 
        // else hot season 
        else {
            this.cold = rn.nextInt() % 100 > 1; // P(cold) = 1%
            this.sun = (t > 8 * 60) && (t < 21 * 60) && (rn.nextInt() % 100 < 5); // sun between 8am and 9pm with P(sun) = 95%
        }

    }

    public boolean isWind() {
        return this.wind;
    }

    public boolean isSun() {
        return this.sun;
    }

    public boolean isCold() {
        return this.cold;
    }

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
