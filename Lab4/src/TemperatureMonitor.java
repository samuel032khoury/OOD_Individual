/**
 * This interface represents a monitor that collects multiple Thermostats' information.
 */
public interface TemperatureMonitor {

  /**
   * to add a Thermostat into monitors' list.
   * @param t the being added thermostat
   */
  public void add(Thermostat t);

  /**
   * to remove a Thermostat from monitors' list.
   * @param t the being removed thermostat
   */
  public void remove(Thermostat t);

  /**
   * to get the number of Thermostats in the Monitor.
   * @return the number of Thermostats in the Monitor
   */
  public int getNumberOfThermostats();

  /**
   * to determine if the thermostats are overheating.
   * @return true if there's too much heating
   */
  public boolean tooMuchHeating();
}
