package betterpizza;

import java.util.HashMap;

import pizza.Crust;
import pizza.Size;
import pizza.ToppingName;
import pizza.ToppingPortion;

/**
 * This class represents a piazza builder.
 */
public abstract class PizzaBuilder<T> {
  protected Crust crust;
  protected Size size;
  protected HashMap<ToppingName, ToppingPortion> toppings;

  /**
   * Start the process of building a pizza.
   */
  public PizzaBuilder() {
    this.toppings = new HashMap<ToppingName, ToppingPortion>();
  }

  /**
   * Set the crust of the pizza.
   *
   * @param crust the crust type chosen by customers
   * @return a specific type of PizzaBuilder that can be continually build on
   */
  public T crust(Crust crust) {
    if (crust == null) {
      throw new IllegalArgumentException();
    }
    this.crust = crust;
    return returnBuilder();
  }

  /**
   * Set the size of the pizza.
   *
   * @param size the size type chosen by customers
   * @return a specific type of PizzaBuilder that can be continually build on
   */
  public T size(Size size) {
    if (size == null) {
      throw new IllegalArgumentException();
    }
    this.size = size;
    return returnBuilder();
  }

  /**
   * add toppings on the pizza.
   *
   * @param toppingName    the name of the topping
   * @param toppingPortion the portion of the pizza that the topping is put
   * @return a specific type of PizzaBuilder that can be continually build on
   */
  public T addTopping(ToppingName toppingName, ToppingPortion toppingPortion) {
    this.toppings.put(toppingName, toppingPortion);
    return returnBuilder();
  }

  /**
   * build the final pizza.
   *
   * @return the final built pizza
   */
  public abstract ObservablePizza build();

  /**
   * get a specific type of PizzaBuilder that can be continually build on.
   *
   * @return a specific type of PizzaBuilder that can be continually build on
   */
  protected abstract T returnBuilder();

  /**
   * Remove the given toppings from the pizza.
   *
   * @param name the topping that is going to be removed
   * @return a specific type of PizzaBuilder that can be continually build on
   */
  protected T removeToppings(ToppingName name) {
    this.toppings.remove(name);
    return this.returnBuilder();
  }

  /**
   * Replace the given toppings' portion put on a pizza.
   *
   * @param name    the topping whose portion on a pizza is going to be changed
   * @param portion the portion that this topping put on a pizza
   * @return a specific type of PizzaBuilder that can be continually build on
   */
  protected T replaceToppingsPortion(ToppingName name, ToppingPortion portion) {
    this.toppings.replace(name, portion);
    return this.returnBuilder();
  }
}
