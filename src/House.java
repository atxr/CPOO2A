import java.util.ArrayList;
import java.util.List;

public class House extends Simulation {

    private ArrayList<Device> devices;

    public House(String name) {
        devices = new ArrayList<>();
        this.name = name;
        addDevice(new Heating("Heating", 1));
        addDevice(new ContinuousDevice("Fridge", 0.2f));
        addDevice(new Device("TV", new Type1(new ArrayList<>(List.of(19*60, 4*60, 2*60)), new ArrayList<>(List.of(0f, 0.1f, 0f)))));
        addDevice(new Device("Computer", new Type1(new ArrayList<>(List.of(8*60, 12*60, 4*60)), new ArrayList<>(List.of(0f, 0.1f, 0f)))));
        addDevice(new Device("Kitchen", new Type1(new ArrayList<>(List.of(12*60, 60, 7*60, 60, 3*60)), new ArrayList<>(List.of(0f, 10f, 0f, 10f, 0f)))));
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
        for (Device d : devices) {
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
        for (Device d : devices) {
            sum += d.get_consumption_day(day, ws);
        }
        return sum;
    }

    @Override
    public float get_production_day(int d, ArrayList<Weather> ws) {
        return 0;
    }
}
