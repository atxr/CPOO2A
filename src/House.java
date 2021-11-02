import java.util.ArrayList;

public class House implements Simulation {

    private ArrayList<Device> devices;

    public House(ArrayList<Device> devices) {
        this.devices = devices;
    }

    public House() {
        devices = new ArrayList<>();
    }

    public void addDevice(Device d) {
        devices.add(d);
    }

    @Override
    public void annual_report(String filename) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void daily(String filename) {
        // TODO Auto-generated method stub
        
    }
}
