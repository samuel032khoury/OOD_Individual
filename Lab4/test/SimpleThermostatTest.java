import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * To test SimpleThermostat.
 */
public class SimpleThermostatTest {

  private SimpleThermostat thermostat1;
  private SimpleThermostat thermostat2;
  private SimpleThermostat thermostat3;

  private SimpleThermostat thermostat4;
  private SimpleThermostat sameAsThermostat4;

  @org.junit.Before
  public void setUp() throws Exception {
    this.thermostat1 = new SimpleThermostat("Thermostat1", 23.0);
    this.thermostat2 = new SimpleThermostat("Thermostat2", 19.0);
    this.thermostat3 = new SimpleThermostat("Thermostat3", 31.33);
    this.thermostat4 = new SimpleThermostat("Thermostat4", 31.307);
    this.sameAsThermostat4 = new SimpleThermostat("Thermostat4", 31.311);
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void constructException1() {
    new SimpleThermostat("", 10.0);
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void constructException2() {
    new SimpleThermostat("Invalid Thermostat", 80.0);
  }

  @org.junit.Test
  public void getID() {
    assertEquals("Thermostat1", this.thermostat1.getID());
    assertEquals("Thermostat2", this.thermostat2.getID());
    assertEquals("Thermostat3", this.thermostat3.getID());
    assertEquals("Thermostat4", this.thermostat4.getID());
    assertEquals("Thermostat4", this.sameAsThermostat4.getID());
  }

  @org.junit.Test
  public void getSetTemperature() {
    assertEquals(296.15, this.thermostat1.getSetTemperature(), 0.001);
    assertEquals(292.15, this.thermostat2.getSetTemperature(), 0.001);
    assertEquals(304.48, this.thermostat3.getSetTemperature(), 0.001);
    assertEquals(304.457, this.thermostat4.getSetTemperature(), 0.001);
    assertEquals(304.461, this.sameAsThermostat4.getSetTemperature(), 0.001);
  }

  @org.junit.Test
  public void increaseSetTemperature() {
    assertEquals(296.15, this.thermostat1.getSetTemperature(), 0.001);
    this.thermostat1.increaseSetTemperature();
    assertEquals(296.25, this.thermostat1.getSetTemperature(), 0.001);
    assertEquals(304.457, this.thermostat4.getSetTemperature(), 0.001);
    this.thermostat4.increaseSetTemperature();
    assertEquals(304.557, this.thermostat4.getSetTemperature(), 0.001);

  }

  @org.junit.Test
  public void decreaseSetTemperature() {
    assertEquals(296.15, this.thermostat1.getSetTemperature(), 0.001);
    this.thermostat1.decreaseSetTemperature();
    assertEquals(296.05, this.thermostat1.getSetTemperature(), 0.001);
    assertEquals(304.457, this.thermostat4.getSetTemperature(), 0.001);
    this.thermostat4.decreaseSetTemperature();
    assertEquals(304.357, this.thermostat4.getSetTemperature(), 0.001);
  }

  @org.junit.Test
  public void testEquals() {
    assertFalse(this.thermostat1.equals(this.thermostat2));
    assertFalse(this.thermostat3.equals(this.thermostat4));
    assertFalse(this.thermostat1.equals("S"));
    assertFalse(this.thermostat1.equals(new NaiveTemperatureMonitor()));
    assertTrue(this.thermostat1.equals(this.thermostat1));
    assertTrue(this.thermostat4.equals(this.thermostat4));
    assertTrue(this.thermostat4.equals(this.sameAsThermostat4));
  }

  @org.junit.Test
  public void testHashCode() {
    assertFalse(this.thermostat1.hashCode() == this.thermostat2.hashCode());
    assertTrue(this.thermostat1.hashCode() == this.thermostat1.hashCode());
    assertTrue(this.thermostat4.hashCode() == this.sameAsThermostat4.hashCode());

  }
}