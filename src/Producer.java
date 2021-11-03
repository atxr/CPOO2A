import java.util.ArrayList;

public class Producer extends Simulation {
    private TypeConsumption consumption;

    public Producer(TypeConsumption consumption) {
        this.consumption = consumption;
    }

    @Override
    public float get_consumption_min(int t, Weather w) {
        return 0;
    }

    @Override
    public float get_production_min(int t, Weather w) {
        return consumption.getPower(t, w) / 60;
    }

    @Override
    public float get_consumption_day(int d, ArrayList<Weather> ws) {
        return 0;
    }

    @Override
    public float get_production_day(int d, ArrayList<Weather> ws) {
        float sum = 0;
        for (int t=0; t<24*60; t++) {
            sum += consumption.getPower(t, ws.get(t));
        }
        return sum/60;
    }
}