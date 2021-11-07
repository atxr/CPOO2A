package consumption;
import java.util.ArrayList;

import simulation.Simulation;
import simulation.Weather;
import type.TypeConsumption;

/** Device class that represent a consumption device */
public class Device extends Simulation {
    /** Type of consumption of the device */
    private TypeConsumption consumption;

    /**
     * Basic constructor of the device class
     * @param name          name of the device
     * @param consumption   type of consumption
     */
    public Device(String name, TypeConsumption consumption) {
        this.name = name;
        this.consumption = consumption;
    }

    @Override
    public float get_production_min(int t, Weather w) {
        return 0;
    }

    @Override
    public float get_consumption_min(int t, Weather w) {
        return consumption.getPower(t, w) / 60;
    }

    @Override
    public float get_production_day(int d, ArrayList<Weather> ws) {
        return 0;
    }

    @Override
    public float get_consumption_day(int d, ArrayList<Weather> ws) {
        float sum = 0;
        for (int t=0; t<24*60; t++) {
            sum += consumption.getPower(t, ws.get(t));
        }
        return sum/60;
    }
}
