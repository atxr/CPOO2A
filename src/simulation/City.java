package simulation;
import java.util.ArrayList;

import consumption.InjectionPoint;
import production.Producer;
/**
 * City class
 * Implements the Simulation interface
 * Model of a City, with electricity consumers and producers  
 */
public class City extends Simulation {
    
    /** List of all the injection_points in the city */
    private ArrayList<InjectionPoint> consumers;
    /** List of all the electricity producers of the city */
    private ArrayList<Producer> producers;

   
    /**
     * Default constructor with a city name
     * @param name  the city name
     */
    public City(String name) {
        consumers = new ArrayList<>();
        producers = new ArrayList<>();
        this.name = name;
    }
    
    /**
     * Consumers getter
     * @return consumers list of the city
     */
    public ArrayList<InjectionPoint> getConsumers() {
        return this.consumers;
    }

     /**
     * Producers getter
     * @return producers list of the city
     */
    public ArrayList<Producer> getProducers() {
        return this.producers;
    }

    /**
     * Add a injection_point to the city
     * @param injection_point 
     */
    public void addInjectionPoint(InjectionPoint injection_point) {
        consumers.add(injection_point);
    }

    /**
     * Add a producer to the city
     * @param producer
     */
    public void addProducer(Producer producer) {
        producers.add(producer);
    }

    @Override
    public float get_consumption_min(int t, Weather w) {
        float sum = 0;
        for (InjectionPoint h: consumers) {
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
        for (InjectionPoint h: consumers) {
            sum += h.get_consumption_day(d, ws);
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
