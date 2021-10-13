import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * To test method in SimpleFractio.
 */
public class SimpleFractionTest {

  Fraction f1;
  Fraction f2;
  Fraction f3;
  Fraction f3Neg;
  Fraction f4;
  Fraction f5;
  Fraction f6;

  @org.junit.Before()
  public void setUp() throws Exception {
    f1 = new SimpleFraction(1, 2);
    f2 = new SimpleFraction(2, 3);
    f3 = new SimpleFraction(7, 6);
    f3Neg = new SimpleFraction(-7, -6);
    f4 = new SimpleFraction(2, 4);
    f5 = new SimpleFraction(4, 4);
    f6 = new SimpleFraction(8, 8);
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testConstructor() {
    Fraction invalidF1 = new SimpleFraction(1, 0);
    Fraction invalidF2 = new SimpleFraction(-1, 2);
    Fraction invalidF3 = new SimpleFraction(1, -2);
    Fraction invalidF4 = new SimpleFraction(0, 0);
  }

  @org.junit.Test
  public void add() {
    assertEquals(f3.toString(), f1.add(f2).toString());
    assertEquals(f3Neg.toString(), f1.add(f2).toString());
    assertEquals(f6.toString(), f1.add(f4).toString());
    assertEquals(f5.toString(), f1.add(f1).toString());
    assertEquals(new SimpleFraction(40, 24).toString(), f3.add(f4).toString());
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testInvalidAdd() {
    f1.add(-1, 3);
    f1.add(1, -3);
    f1.add(1, 0);
    f1.add(0, 0);
    f1.add(-1, 0);
  }

  @org.junit.Test
  public void testAdd() {
    assertEquals(f3.toString(), f1.add(2, 3).toString());
    assertEquals(f3Neg.toString(), f1.add(2, 3).toString());
    assertEquals(f6.toString(), f1.add(2, 4).toString());
    assertEquals(f5.toString(), f1.add(1, 2).toString());
    assertEquals(new SimpleFraction(2, 4).toString(), f1.add(0, 2).toString());
  }

  @org.junit.Test
  public void getDecimalValue() {
    assertEquals(1, f1.getDecimalValue(0), 0.001);
    assertEquals(0.5, f1.getDecimalValue(1), 0.001);
    assertEquals(0.50, f1.getDecimalValue(2), 0.001);

    assertEquals(1, f2.getDecimalValue(0), 0.001);
    assertEquals(0.7, f2.getDecimalValue(1), 0.001);
    assertEquals(0.67, f2.getDecimalValue(2), 0.001);
    assertEquals(0.667, f2.getDecimalValue(3), 0.001);
    assertEquals(0.6666666667, f2.getDecimalValue(10), 0.001);

    assertEquals(1, f3.getDecimalValue(0), 0.001);
    assertEquals(1.2, f3.getDecimalValue(1), 0.001);
    assertEquals(1.17, f3.getDecimalValue(2), 0.001);
    assertEquals(1.167, f3.getDecimalValue(3), 0.001);
    assertEquals(1.1666666667, f3.getDecimalValue(10), 0.001);
    assertNotEquals(1.67, f3.getDecimalValue(10), 0.001);
  }

  @org.junit.Test
  public void testToString() {
    assertEquals("1/2", f1.toString());
    assertEquals("2/3", f2.toString());
    assertEquals("7/6", f3.toString());
    assertEquals("7/6", f3Neg.toString());
    assertEquals("2/4", f4.toString());
    assertEquals("4/4", f5.toString());
    assertEquals("8/8", f6.toString());
  }
}