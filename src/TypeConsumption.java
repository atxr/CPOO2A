/** Empty type interface that contains the periodic type and the external dependent type of consumption */
public interface TypeConsumption {
    /**
     * Get the power of a device/producer at a given minute, according to the weather
     * @param time      the number of the minute in the day 
     * @param weather   the weather at the given time
     * @return          the device power at the given time
     */
    public float getPower(int time, Weather weather);
}
