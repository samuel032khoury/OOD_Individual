import java.util.Objects;

/**
 * This class represents the set temperature in celsius. It cannot have a blank ID, or be set at any
 * time to a temperature greater than 50 degrees celsius.
 */
public class SimpleThermostat implements Thermostat {
  private String id;
  private double temp;

  /**
   * Generate a SimpleThermostat.
   *
   * @param id   the unique id of a thermostat as a String
   * @param temp the initial set temperature in celsius
   * @throws IllegalArgumentException if it has a blank ID, or be set at any time to a temperature
   *                                  greater than 50 degrees celsius.
   */
  public SimpleThermostat(String id, double temp) throws IllegalArgumentException {
    if (id.equals("") || temp > 50) {
      throw new IllegalArgumentException();
    }
    this.id = id;
    this.temp = temp;
  }

  /**
   * Get the ID of a particular thermostat.
   *
   * @return the ID of a particular thermostat
   */
  @Override
  public String getID() {
    return this.id;
  }

  /**
   * Get the set temperature in degrees Kelvin of a particular thermostat.
   *
   * @return the set temperature of a particular thermostat
   */
  @Override
  public double getSetTemperature() {
    return this.temp + 273.15;
  }

  /**
   * Increases the set temperature for the thermostat.
   */
  @Override
  public void increaseSetTemperature() {
    this.temp += 0.1;
  }

  /**
   * Decrease the set temperature for the thermostat.
   */
  @Override
  public void decreaseSetTemperature() {
    this.temp -= 0.1;
  }

  //  /**
  //   * Compare if two objects are the same OR two Thermostat have the same ID AND their
  //   * temperature values are 0.01 degrees celsius apart
  //   *
  //   * @param o the other objects being compared
  //   * @return true if two objects are the same OR two Thermostat have the same ID AND their
  //   *               temperature values are 0.01 degrees celsius apart
  //   */
  //  @Override
  //  public boolean equals(Object o) {
  //    if (this == o) {
  //      return true;
  //    }
  //    if (o == null || this.getClass() != o.getClass()) {
  //      return false;
  //    }
  //    SimpleThermostat that = (SimpleThermostat) o;
  //    return that.getSetTemperature() - this.getSetTemperature() <= Math.abs(0.01)
  //            && this.getID().equals(that.getID());
  //  }
  //
  //  @Override
  //  public int hashCode() {
  //    return Objects.hash(this.id, this.temp);
  //  }

  /**
   * Compare if two objects are the same OR two Thermostat have the same ID AND same temperature
   * values when rounded to two decimal place.
   *
   * @param o the other objects being compared
   * @return true if two objects are the same OR two Thermostat have the same ID AND same
   *               temperature values when rounded to two decimal place.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    SimpleThermostat that = (SimpleThermostat) o;
    double thatTempInTwoPlace = Math.round(that.getSetTemperature() * 100) / 100.0;
    double thisTempInTwoPlace = Math.round(this.getSetTemperature() * 100) / 100.0;
    return thatTempInTwoPlace == thisTempInTwoPlace && this.getID().equals(that.getID());
  }

  /**
   * generate a unique hashcode for a instance by its id and set temperature.
   *
   * @return a hashcode
   */
  @Override
  public int hashCode() {
    return Objects.hash(id, Math.round(this.getSetTemperature() * 100) / 100.0);
  }
}