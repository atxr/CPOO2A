import java.util.ArrayList;

/**
 * City class
 * Implements the Simulation interface
 * Model of a City, with electricity consumers and producers  
 */
public class City implements Simulation {
    
    /** List of all the houses in the city */
    private ArrayList<Home> consumers;
    /** List of all the electricity producers of the city */
    private ArrayList<Producer> producers;

    /**
     * Basic constructor of a city, with consumers and producers as parameters
     * 
     * @param consumers
     * @param producers
     */
    public City(ArrayList<Home> consumers, ArrayList<Producer> producers) {
        this.consumers = consumers;
        this.producers = producers;
    }

    /**
     * Compute the annual report of consumption of the city in the given filename, in CSV format
     * 
     * @param filename output filename
     */
    public void annual_report(String filename) {
        // TODO Auto-generated method stub
        
    }

    /**
     * Compute the daily report of consumption of the city in the given filename, in CSV format
     * 
     * @param filename output filename
     */
    public void daily(String filename) {
        // TODO Auto-generated method stub
        
    }
}
