package betterpizza;

import java.util.HashMap;

import pizza.Crust;
import pizza.Size;
import pizza.ToppingName;
import pizza.ToppingPortion;

/**
 * This class represents cheese pizza, with cheese and sauce on it.
 */
public class CheesePizza extends AlaCartePizza {

  /**
   * Create a Cheese pizza given its crust type, size and toppings.
   *
   * @param size  the size of the pizza
   * @param crust the crust of the pizza
   */
  public CheesePizza(Size size, Crust crust) {
    super(size, crust);
  }

  protected CheesePizza(Size size, Crust crust, HashMap<ToppingName, ToppingPortion> toppings) {
    super(size, crust, toppings);
  }

  /**
   * This represents a cheese pizza builder.
   */
  public static class CheesePizzaBuilder extends PizzaBuilder<CheesePizzaBuilder> {

    /**
     * Start the process of building a cheese pizza by adding all the default toppings in the list.
     */
    public CheesePizzaBuilder() {
      super();
      this.toppings.put(ToppingName.Cheese, ToppingPortion.Full);
      this.toppings.put(ToppingName.Sauce, ToppingPortion.Full);
    }

    /**
     * remove the cheese on the pizza.
     * @return a CheesePizzaBuilder that can be continually build on
     */
    public CheesePizzaBuilder noCheese() {
      return super.removeToppings(ToppingName.Cheese);
    }

    /**
     * change the topping portion of the pizza so that cheese is only put on the left half.
     * @return a CheesePizzaBuilder that can be continually build on
     */
    public CheesePizzaBuilder leftHalfCheese() {
      return super.replaceToppingsPortion(ToppingName.Cheese, ToppingPortion.LeftHalf);
    }

    /**
     * change the topping portion of the pizza so that cheese is only put on the right half.
     * @return a CheesePizzaBuilder that can be continually build on
     */
    public CheesePizzaBuilder rightHalfCheese() {
      return super.replaceToppingsPortion(ToppingName.Cheese, ToppingPortion.RightHalf);
    }

    /**
     * remove the sauce on the pizza.
     * @return a CheesePizzaBuilder that can be continually build on
     */
    public CheesePizzaBuilder noSauce() {
      return super.removeToppings(ToppingName.Sauce);
    }

    /**
     * change the topping portion of the pizza so that sauce is only put on the left half.
     * @return a CheesePizzaBuilder that can be continually build on
     */
    public CheesePizzaBuilder leftHalfSauce() {
      return super.replaceToppingsPortion(ToppingName.Sauce, ToppingPortion.LeftHalf);
    }

    /**
     * change the topping portion of the pizza so that sauce is only put on the right half.
     * @return a CheesePizzaBuilder that can be continually build on
     */
    public CheesePizzaBuilder rightHalfSauce() {
      return super.replaceToppingsPortion(ToppingName.Sauce, ToppingPortion.RightHalf);
    }

    /**
     * build the final pizza.
     *
     * @return the final built pizza
     */
    @Override
    public ObservablePizza build() {
      if (this.size == null || this.crust == null) {
        throw new IllegalStateException();
      }
      return new CheesePizza(this.size, this.crust, this.toppings);
    }

    /**
     * get a specific type of PizzaBuilder that can be continually build on.
     *
     * @return a specific type of PizzaBuilder that can be continually build on
     */
    @Override
    protected CheesePizzaBuilder returnBuilder() {
      return this;
    }

  }
}
