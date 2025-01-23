import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


import betterpizza.CheesePizza;
import betterpizza.VeggiePizza;
import pizza.Crust;
import pizza.Size;
import pizza.ToppingName;
import pizza.ToppingPortion;
import betterpizza.ObservablePizza;
import betterpizza.AlaCartePizza;

/**
 * to tests methods in better pizza.
 */
public class BetterPizzaTest {
  private ObservablePizza cheese;
  private ObservablePizza veggie;
  private ObservablePizza pepperoni;

  @Before
  public void setUp() {
    this.cheese =
            new CheesePizza.CheesePizzaBuilder()
                    .size(Size.Medium)
                    .crust(Crust.Classic)
                    .build();
    this.veggie =
            new VeggiePizza.VeggiePizzaBuilder()
                    .size(Size.Large)
                    .crust(Crust.Thin)
                    .noBlackOlive()
                    .leftHalfTomato()
                    .rightHalfOnion()
                    .build();
    this.pepperoni =
            new AlaCartePizza.AlaCartePizzaBuilder().size(Size.Small).crust(Crust.Stuffed)
                    .addTopping(ToppingName.Pepperoni, ToppingPortion.Full)
                    .addTopping(ToppingName.Ham, ToppingPortion.Full)
                    .addTopping(ToppingName.Alfredo, ToppingPortion.RightHalf)
                    .addTopping(ToppingName.Cheese, ToppingPortion.LeftHalf)
                    .build();
  }

  @Test (expected = IllegalStateException.class)
  public void testExceptionConstruct1() {
    new AlaCartePizza.AlaCartePizzaBuilder().build();
  }

  @Test (expected = IllegalStateException.class)
  public void testExceptionConstruct2() {
    new CheesePizza.CheesePizzaBuilder().size(Size.Large).build();
  }

  @Test (expected = IllegalStateException.class)
  public void testExceptionConstruct3() {
    new VeggiePizza.VeggiePizzaBuilder().crust(Crust.Stuffed).build();
  }

  @Test (expected = IllegalArgumentException.class)
  public void testExceptionConstruct4() {
    new VeggiePizza.VeggiePizzaBuilder().size(Size.Large).crust(null).build();
  }

  @Test (expected = IllegalArgumentException.class)
  public void testExceptionConstruct5() {
    new VeggiePizza.VeggiePizzaBuilder().size(null).crust(Crust.Stuffed).build();
  }

  @Test
  public void testCost() {
    assertEquals(7.0, cheese.cost(), 0.0001);
    assertEquals(10.5, veggie.cost(), 0.0001);
    assertEquals(5.875, pepperoni.cost(), 0.0001);
  }

  @Test
  public void testHasTopping() {
    assertEquals(ToppingPortion.Full, cheese.hasTopping(ToppingName.Cheese));
    assertEquals(ToppingPortion.Full, cheese.hasTopping(ToppingName.Sauce));
    assertEquals(null, cheese.hasTopping(ToppingName.Alfredo));
    assertEquals(null, cheese.hasTopping(ToppingName.GreenPepper));
    assertEquals(null, cheese.hasTopping(ToppingName.Tomato));
    assertEquals(null, cheese.hasTopping(ToppingName.Onion));
    assertEquals(null, cheese.hasTopping(ToppingName.Jalapeno));
    assertEquals(null, cheese.hasTopping(ToppingName.BlackOlive));
    assertEquals(null, cheese.hasTopping(ToppingName.Ham));
    assertEquals(null, cheese.hasTopping(ToppingName.Pepperoni));
    assertEquals(null, cheese.hasTopping(ToppingName.Steak));
    assertEquals(null, cheese.hasTopping(ToppingName.Chicken));

    assertEquals(ToppingPortion.Full, veggie.hasTopping(ToppingName.Cheese));
    assertEquals(ToppingPortion.Full, veggie.hasTopping(ToppingName.Sauce));
    assertEquals(ToppingPortion.Full, veggie.hasTopping(ToppingName.GreenPepper));
    assertEquals(ToppingPortion.Full, veggie.hasTopping(ToppingName.Jalapeno));
    assertEquals(ToppingPortion.LeftHalf, veggie.hasTopping(ToppingName.Tomato));
    assertEquals(ToppingPortion.RightHalf, veggie.hasTopping(ToppingName.Onion));
    assertEquals(null, veggie.hasTopping(ToppingName.BlackOlive));
    assertEquals(null, veggie.hasTopping(ToppingName.Alfredo));
    assertEquals(null, veggie.hasTopping(ToppingName.Ham));
    assertEquals(null, veggie.hasTopping(ToppingName.Pepperoni));
    assertEquals(null, veggie.hasTopping(ToppingName.Steak));
    assertEquals(null, veggie.hasTopping(ToppingName.Chicken));

    assertEquals(ToppingPortion.Full, pepperoni.hasTopping(ToppingName.Ham));
    assertEquals(ToppingPortion.Full, pepperoni.hasTopping(ToppingName.Pepperoni));
    assertEquals(ToppingPortion.LeftHalf, pepperoni.hasTopping(ToppingName.Cheese));
    assertEquals(ToppingPortion.RightHalf, pepperoni.hasTopping(ToppingName.Alfredo));
    assertEquals(null, pepperoni.hasTopping(ToppingName.Sauce));
    assertEquals(null, pepperoni.hasTopping(ToppingName.GreenPepper));
    assertEquals(null, pepperoni.hasTopping(ToppingName.Jalapeno));
    assertEquals(null, pepperoni.hasTopping(ToppingName.Tomato));
    assertEquals(null, pepperoni.hasTopping(ToppingName.Onion));
    assertEquals(null, pepperoni.hasTopping(ToppingName.BlackOlive));
    assertEquals(null, pepperoni.hasTopping(ToppingName.Steak));
    assertEquals(null, pepperoni.hasTopping(ToppingName.Chicken));
  }

}
