import java.util.ArrayList;
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

   
    /**
     * Default constructor with a city name
     * @param name  the city name
     */
    public City(String name) {
        this(new ArrayList<>(), new ArrayList<>());
        this.name = name;
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

    /**
     * Consumers getter
     * @return consumers list of the city
     */
    public ArrayList<House> getConsumers() {
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
     * Add a house to the city
     * @param house 
     */
    public void addHouse(House house) {
        consumers.add(house);
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
