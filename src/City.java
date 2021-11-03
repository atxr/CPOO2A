import java.util.ArrayList;

import javax.swing.text.WrappedPlainView;

/**
 * City class
 * Implements the Simulation interface
 * Model of a City, with electricity consumers and producers  
 */
public class City extends Simulation {
    
    /** List of all the houses in the city */
    private ArrayList<House> consumers;
    /** List of all the electricity producers of the city */
    private ArrayList<Producer> producers;

    
    public City() {
        this(new ArrayList<>(), new ArrayList<>());
    }
    
    /**
     * Basic constructor of a city, with consumers and producers as parameters
     * 
     * @param consumers
     * @param producers
     */
    public City(ArrayList<House> consumers, ArrayList<Producer> producers) {
        this.consumers = consumers;
        this.producers = producers;
    }

    public ArrayList<House> getConsumers() {
        return this.consumers;
    }

    public ArrayList<Producer> getProducers() {
        return this.producers;
    }

    public void addHouse(House h) {
        consumers.add(h);
    }

    public void addProducer(Producer p) {
        producers.add(p);
    }

    @Override
    public float get_consumption_min(int t, Weather w) {
        float sum = 0;
        for (House h: consumers) {
            sum += h.get_consumption_min(t, w);
        }
        return sum;
    }

    @Override
    public float get_production_min(int t, Weather w) {
        float sum = 0;
        for (Producer p: producers) {
            sum += p.get_production_min(t, w);
        }
        return sum;     
    }

    @Override
    public float get_consumption_day(int d, ArrayList<Weather> ws) {
        float sum = 0;
        for (House h: consumers) {
            sum += h.get_production_day(d, ws);
        }
        return sum;  
    }

    @Override
    public float get_production_day(int d, ArrayList<Weather> ws) {
        float sum = 0;
        for (Producer p: producers) {
            sum += p.get_production_day(d, ws);
        }
        return sum;  
    }
}
