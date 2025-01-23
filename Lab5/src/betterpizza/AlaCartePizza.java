package betterpizza;

import java.util.HashMap;
import java.util.Map;

import pizza.Crust;
import pizza.Size;
import pizza.ToppingName;
import pizza.ToppingPortion;

/**
 * This class represents an ala carte pizza (i.e. a pizza that can have an arbitrary number of
 * ingredients.
 */
public class AlaCartePizza implements ObservablePizza {
  protected Crust crust;
  protected Size size;
  protected Map<ToppingName, ToppingPortion> toppings;

  /**
   * Create a Ala Carte pizza given its crust type, size and toppings.
   *
   * @param size  the size of the pizza
   * @param crust the crust of the pizza
   */
  public AlaCartePizza(Size size, Crust crust) {
    this.crust = crust;
    this.size = size;
    this.toppings = new HashMap<ToppingName, ToppingPortion>();
  }

  protected AlaCartePizza(Size size, Crust crust, HashMap<ToppingName, ToppingPortion> toppings) {
    if (size == null || crust == null || toppings == null) {
      throw new IllegalArgumentException();
    }
    this.size = size;
    this.crust = crust;
    this.toppings = toppings;
  }

  /**
   * This class represents an ala carte pizza builder (i.e. a pizza that has no default toppings
   * that can have an arbitrary number of ingredients.
   */
  public static class AlaCartePizzaBuilder extends PizzaBuilder<AlaCartePizzaBuilder> {

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
      return new AlaCartePizza(this.size, this.crust, this.toppings);
    }

    /**
     * get a specific type of PizzaBuilder that can be continually build on.
     *
     * @return a specific type of PizzaBuilder that can be continually build on
     */
    @Override
    protected AlaCartePizzaBuilder returnBuilder() {
      return this;
    }
  }


  /**
   * Determines if the specified topping is on this pizza and if so, return its portion.
   *
   * @param name the name of the topping
   * @return the portion of this topping on this pizza, or null if the given topping is not on this
   *               pizza
   */
  @Override
  public ToppingPortion hasTopping(ToppingName name) {
    return this.toppings.getOrDefault(name, null);
  }

  /**
   * Get the cost of this pizza.
   *
   * @return the cost of this pizza in MM.CC format
   */
  @Override
  public double cost() {
    double cost = 0.0;
    for (Map.Entry<ToppingName, ToppingPortion> item : this.toppings.entrySet()) {
      cost += item.getKey().getCost() * item.getValue().getCostMultiplier();
    }
    return cost + this.size.getBaseCost();
  }

}
