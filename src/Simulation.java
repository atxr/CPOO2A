/**
 * Simulation interface 
 * Provide reports functions, for a day or a year
 */
public interface Simulation {
    public void annual_report(String filename);
    public void daily(String filename);
}
