import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a temperature monitor. It tracks several thermostats, and specifically
 * monitors how many of them have been set to too hot.
 */

public class NaiveTemperatureMonitor implements TemperatureMonitor {
  private final List<Thermostat> thermostatList;

  public NaiveTemperatureMonitor() {
    this.thermostatList = new ArrayList<Thermostat>();
  }

  /**
   * to add a Thermostat into monitors' list if it hasn't already show up in the list.
   *
   * @param t the being added thermostat
   */
  @Override
  public void add(Thermostat t) {
    boolean flag = true;
    for (Thermostat th : thermostatList) {
      if (th == t) {
        flag = false;
      }
    }
    if (flag) {
      thermostatList.add(t);
    }
  }

  /**
   * to remove a Thermostat from monitors' list.
   *
   * @param t the being removed thermostat
   */
  @Override
  public void remove(Thermostat t) {
    thermostatList.remove(t);
  }

  /**
   * to get the number of Thermostats in the Monitor.
   *
   * @return the number of Thermostats in the Monitor
   */
  @Override
  public int getNumberOfThermostats() {
    return thermostatList.size();
  }

  /**
   * to determine if the thermostats are overheating.
   *
   * @return true if there's too much heating
   */
  @Override
  public boolean tooMuchHeating() {
    int count = 0;
    for (Thermostat t : thermostatList) {
      if (t.getSetTemperature() > 23 + 273.15) {
        count += 1;
      }
    }
    return count > 1;
  }

  /**
   * Get the list in NaiveTemperatureMonitor.
   *
   * @return the list stored in this NaiveTemperatureMonitor
   */
  protected List<Thermostat> getList() {
    return this.thermostatList;
  }


}
