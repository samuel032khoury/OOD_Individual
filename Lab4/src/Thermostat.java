/**
 * This interface represents set of thermostats, with the monitor that can observe their status.
 */
public interface Thermostat {
  /**
   * Get the ID of a particular thermostat.
   * @return the ID of a particular thermostat
   */
  String getID();

  /**
   * Get the set temperature of a particular thermostat.
   * @return the set temperature in degrees Kelvin of a particular thermostat
   */
  double getSetTemperature();

  /**
   * Increases the set temperature for the thermostat.
   */
  void increaseSetTemperature();

  /**
   * Decrease the set temperature for the thermostat.
   */
  void decreaseSetTemperature();
}
