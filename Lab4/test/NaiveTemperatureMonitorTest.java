import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

/**
 * To test NaiveTemperatureMonitor.
 */
public class NaiveTemperatureMonitorTest {

  private NaiveTemperatureMonitor naiveTemperatureMonitor;

  private SimpleThermostat thermostat1;
  private SimpleThermostat thermostat2;
  private SimpleThermostat thermostat3;
  private SimpleThermostat sameAsThermostat3;

  private ArrayList<Thermostat> thermostatList1;
  private ArrayList<Thermostat> thermostatList2;
  private ArrayList<Thermostat> thermostatList3;
  private ArrayList<Thermostat> thermostatList4;

  @Before
  public void setUp() throws Exception {
    this.naiveTemperatureMonitor = new NaiveTemperatureMonitor();

    this.thermostat1 = new SimpleThermostat("Thermostat1", 23.0);
    this.thermostat2 = new SimpleThermostat("Thermostat2", 22.9);
    this.thermostat3 = new SimpleThermostat("Thermostat3", 31.307);
    this.sameAsThermostat3 = new SimpleThermostat("Thermostat3", 31.307);

    this.thermostatList1 = new ArrayList<Thermostat>();
    this.thermostatList1.add(new SimpleThermostat("Thermostat1", 23.0));

    this.thermostatList2 = new ArrayList<Thermostat>();
    this.thermostatList2.add(new SimpleThermostat("Thermostat1", 23.0));
    this.thermostatList2.add(new SimpleThermostat("Thermostat3", 31.307));

    this.thermostatList3 = new ArrayList<Thermostat>();
    this.thermostatList3.add(new SimpleThermostat("Thermostat1", 23.0));
    this.thermostatList3.add(new SimpleThermostat("Thermostat3", 31.307));
    this.thermostatList3.add(new SimpleThermostat("Thermostat3", 31.307));

    this.thermostatList4 = new ArrayList<Thermostat>();
    this.thermostatList4.add(new SimpleThermostat("Thermostat1", 23.0));
    this.thermostatList4.add(new SimpleThermostat("Thermostat2", 22.9));
    this.thermostatList4.add(new SimpleThermostat("Thermostat3", 31.307));
  }

  @Test
  public void getList() {
    assertTrue(this.naiveTemperatureMonitor.getList().isEmpty());
    this.naiveTemperatureMonitor.add(thermostat1);
    assertEquals(this.thermostatList1, this.naiveTemperatureMonitor.getList());
    this.naiveTemperatureMonitor.add(thermostat3);
    assertEquals(this.thermostatList2, this.naiveTemperatureMonitor.getList());
    this.naiveTemperatureMonitor.add(sameAsThermostat3);
    assertEquals(this.thermostatList3, this.naiveTemperatureMonitor.getList());
  }

  /**
   * to determine if the list stored in a monitor is the same as expected.
   *
   * @param expectedList the expected list
   * @param monitor      a NaiveTemperatureMonitor whose list is in the comparison
   * @return true if the list stored in a monitor is the same as expected
   */
  private boolean expectListInMonitor(ArrayList<Thermostat> expectedList,
                                      NaiveTemperatureMonitor monitor) {
    boolean flag = true;
    int index = 0;
    List<Thermostat> monitorList = monitor.getList();
    if (monitorList.size() != expectedList.size()) {
      flag = false;
    } else {
      for (Thermostat t : monitorList) {
        if (!t.equals(expectedList.get(index))) {
          flag = false;
        }
        index++;
      }
    }
    return flag;
  }

  @Test
  public void add() {
    assertTrue(this.naiveTemperatureMonitor.getList().isEmpty());

    this.naiveTemperatureMonitor.add(thermostat1);
    assertTrue(expectListInMonitor(this.thermostatList1, this.naiveTemperatureMonitor));
    assertFalse(expectListInMonitor(this.thermostatList2, this.naiveTemperatureMonitor));
    assertFalse(expectListInMonitor(this.thermostatList3, this.naiveTemperatureMonitor));
    assertFalse(expectListInMonitor(this.thermostatList4, this.naiveTemperatureMonitor));

    this.naiveTemperatureMonitor.add(thermostat3);
    assertFalse(expectListInMonitor(this.thermostatList1, this.naiveTemperatureMonitor));
    assertTrue(expectListInMonitor(this.thermostatList2, this.naiveTemperatureMonitor));
    assertFalse(expectListInMonitor(this.thermostatList3, this.naiveTemperatureMonitor));
    assertFalse(expectListInMonitor(this.thermostatList4, this.naiveTemperatureMonitor));

    this.naiveTemperatureMonitor.add(thermostat1);
    assertFalse(expectListInMonitor(this.thermostatList1, this.naiveTemperatureMonitor));
    assertTrue(expectListInMonitor(this.thermostatList2, this.naiveTemperatureMonitor));
    assertFalse(expectListInMonitor(this.thermostatList3, this.naiveTemperatureMonitor));
    assertFalse(expectListInMonitor(this.thermostatList4, this.naiveTemperatureMonitor));

    this.naiveTemperatureMonitor.add(sameAsThermostat3);
    assertFalse(expectListInMonitor(this.thermostatList1, this.naiveTemperatureMonitor));
    assertFalse(expectListInMonitor(this.thermostatList2, this.naiveTemperatureMonitor));
    assertTrue(expectListInMonitor(this.thermostatList3, this.naiveTemperatureMonitor));
    assertFalse(expectListInMonitor(this.thermostatList4, this.naiveTemperatureMonitor));
  }

  @Test
  public void remove() {
    this.naiveTemperatureMonitor.add(thermostat1);
    this.naiveTemperatureMonitor.add(thermostat3);
    this.naiveTemperatureMonitor.add(sameAsThermostat3);

    assertFalse(expectListInMonitor(this.thermostatList1, this.naiveTemperatureMonitor));
    assertFalse(expectListInMonitor(this.thermostatList2, this.naiveTemperatureMonitor));
    assertTrue(expectListInMonitor(this.thermostatList3, this.naiveTemperatureMonitor));
    assertFalse(expectListInMonitor(this.thermostatList4, this.naiveTemperatureMonitor));

    this.naiveTemperatureMonitor.remove(sameAsThermostat3);
    assertFalse(expectListInMonitor(this.thermostatList1, this.naiveTemperatureMonitor));
    assertTrue(expectListInMonitor(this.thermostatList2, this.naiveTemperatureMonitor));
    assertFalse(expectListInMonitor(this.thermostatList3, this.naiveTemperatureMonitor));
    assertFalse(expectListInMonitor(this.thermostatList4, this.naiveTemperatureMonitor));

    this.naiveTemperatureMonitor.remove(thermostat3);
    assertTrue(expectListInMonitor(this.thermostatList1, this.naiveTemperatureMonitor));
    assertFalse(expectListInMonitor(this.thermostatList2, this.naiveTemperatureMonitor));
    assertFalse(expectListInMonitor(this.thermostatList3, this.naiveTemperatureMonitor));
    assertFalse(expectListInMonitor(this.thermostatList4, this.naiveTemperatureMonitor));

    this.naiveTemperatureMonitor.remove(thermostat2);
    assertTrue(expectListInMonitor(this.thermostatList1, this.naiveTemperatureMonitor));
    assertFalse(expectListInMonitor(this.thermostatList2, this.naiveTemperatureMonitor));
    assertFalse(expectListInMonitor(this.thermostatList3, this.naiveTemperatureMonitor));
    assertFalse(expectListInMonitor(this.thermostatList4, this.naiveTemperatureMonitor));

    this.naiveTemperatureMonitor.remove(thermostat1);
    assertTrue(this.naiveTemperatureMonitor.getList().isEmpty());
  }

  @Test
  public void getNumberOfThermostats() {
    assertEquals(0, this.naiveTemperatureMonitor.getNumberOfThermostats());

    this.naiveTemperatureMonitor.add(thermostat1);
    assertEquals(1, this.naiveTemperatureMonitor.getNumberOfThermostats());

    this.naiveTemperatureMonitor.add(thermostat3);
    assertEquals(2, this.naiveTemperatureMonitor.getNumberOfThermostats());

    this.naiveTemperatureMonitor.add(thermostat1);
    assertEquals(2, this.naiveTemperatureMonitor.getNumberOfThermostats());

    this.naiveTemperatureMonitor.add(sameAsThermostat3);
    assertEquals(3, this.naiveTemperatureMonitor.getNumberOfThermostats());
  }

  @Test
  public void tooMuchHeating() {
    this.naiveTemperatureMonitor.add(thermostat1);
    this.naiveTemperatureMonitor.add(thermostat1);
    this.naiveTemperatureMonitor.add(thermostat1);
    this.naiveTemperatureMonitor.add(thermostat2);
    assertFalse(naiveTemperatureMonitor.tooMuchHeating());

    thermostat1.increaseSetTemperature();
    assertFalse(naiveTemperatureMonitor.tooMuchHeating());

    thermostat2.increaseSetTemperature();
    thermostat2.increaseSetTemperature();
    assertTrue(naiveTemperatureMonitor.tooMuchHeating());
  }
}