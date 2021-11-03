import java.util.ArrayList;

public class House extends Simulation {

    private ArrayList<Device> devices;

    public House() {
        devices = new ArrayList<>();
    }

    ArrayList<Device> getDevices() {
        return this.devices;
    }

    public void addDevice(Device d) {
        devices.add(d);
    }

    @Override
    public float get_consumption_min(int t, Weather w) {
        float sum = 0;
        for (Device d: devices) {
            sum += d.get_consumption_min(t, w);
        }
        return sum;
    }

    @Override
    public float get_production_min(int t, Weather w) {
        return 0;     
    }

    @Override
    public float get_consumption_day(int day, ArrayList<Weather> ws) {
        float sum = 0;
        for (Device d: devices) {
            sum += d.get_production_day(day, ws);
        }
        return sum;  
    }

    @Override
    public float get_production_day(int d, ArrayList<Weather> ws) {
        return 0;  
    }
}
