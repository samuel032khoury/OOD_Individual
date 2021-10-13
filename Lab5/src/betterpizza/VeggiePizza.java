package betterpizza;

import java.util.HashMap;

import pizza.Crust;
import pizza.Size;
import pizza.ToppingName;
import pizza.ToppingPortion;

/**
 * This class represents veggie pizza, with cheese, sauce, black olive, green pepper, onion,
 * jalapeno, and tomato on it.
 */
public class VeggiePizza extends AlaCartePizza {

  /**
   * Create a pizza given its crust type, size and toppings.
   *
   * @param size  the size of the pizza
   * @param crust the crust of the pizza
   */
  public VeggiePizza(Size size, Crust crust) {
    super(size, crust);
  }

  protected VeggiePizza(Size size, Crust crust, HashMap<ToppingName, ToppingPortion> toppings) {
    super(size, crust, toppings);
  }

  /**
   * This represents a veggie pizza builder.
   */
  public static class VeggiePizzaBuilder extends PizzaBuilder<VeggiePizzaBuilder> {

    /**
     * Start the process of building a veggie pizza by adding all the default toppings in the list.
     */
    public VeggiePizzaBuilder() {
      super();
      this.toppings.put(ToppingName.Cheese, ToppingPortion.Full);
      this.toppings.put(ToppingName.Sauce, ToppingPortion.Full);
      this.toppings.put(ToppingName.BlackOlive, ToppingPortion.Full);
      this.toppings.put(ToppingName.GreenPepper, ToppingPortion.Full);
      this.toppings.put(ToppingName.Onion, ToppingPortion.Full);
      this.toppings.put(ToppingName.Jalapeno, ToppingPortion.Full);
      this.toppings.put(ToppingName.Tomato, ToppingPortion.Full);
    }

    /**
     * remove the jalapeno on the pizza.
     *
     * @return a CheesePizzaBuilder that can be continually build on
     */
    public VeggiePizzaBuilder noJalapeno() {
      return super.removeToppings(ToppingName.Jalapeno);
    }

    /**
     * change the topping portion of the pizza so that jalapeno is only put on the left half.
     *
     * @return a CheesePizzaBuilder that can be continually build on
     */
    public VeggiePizzaBuilder leftHalfJalapeno() {
      return super.replaceToppingsPortion(ToppingName.Jalapeno, ToppingPortion.LeftHalf);
    }

    /**
     * change the topping portion of the pizza so that jalapeno is only put on the right half.
     *
     * @return a CheesePizzaBuilder that can be continually build on
     */
    public VeggiePizzaBuilder rightHalfJalapeno() {
      return super.replaceToppingsPortion(ToppingName.Jalapeno, ToppingPortion.RightHalf);
    }

    /**
     * remove the tomato on the pizza.
     *
     * @return a CheesePizzaBuilder that can be continually build on
     */
    public VeggiePizzaBuilder noTomato() {
      return super.removeToppings(ToppingName.Tomato);
    }

    /**
     * change the topping portion of the pizza so that tomato is only put on the left half.
     *
     * @return a CheesePizzaBuilder that can be continually build on
     */
    public VeggiePizzaBuilder leftHalfTomato() {
      return super.replaceToppingsPortion(ToppingName.Tomato, ToppingPortion.LeftHalf);
    }

    /**
     * change the topping portion of the pizza so that tomato is only put on the right half.
     *
     * @return a CheesePizzaBuilder that can be continually build on
     */
    public VeggiePizzaBuilder rightHalfTomato() {
      return super.replaceToppingsPortion(ToppingName.Tomato, ToppingPortion.RightHalf);
    }

    /**
     * remove the cheese on the pizza.
     *
     * @return a CheesePizzaBuilder that can be continually build on
     */
    public VeggiePizzaBuilder noCheese() {
      return super.removeToppings(ToppingName.Cheese);
    }

    /**
     * change the topping portion of the pizza so that cheese is only put on the left half.
     *
     * @return a CheesePizzaBuilder that can be continually build on
     */
    public VeggiePizzaBuilder leftHalfCheese() {
      return super.replaceToppingsPortion(ToppingName.Cheese, ToppingPortion.LeftHalf);
    }

    /**
     * change the topping portion of the pizza so that cheese is only put on the right half.
     *
     * @return a CheesePizzaBuilder that can be continually build on
     */
    public VeggiePizzaBuilder rightHalfCheese() {
      return super.replaceToppingsPortion(ToppingName.Cheese, ToppingPortion.RightHalf);
    }

    /**
     * remove the sauce on the pizza.
     *
     * @return a CheesePizzaBuilder that can be continually build on
     */
    public VeggiePizzaBuilder noSauce() {
      return super.removeToppings(ToppingName.Sauce);
    }

    /**
     * change the topping portion of the pizza so that sauce is only put on the left half.
     *
     * @return a CheesePizzaBuilder that can be continually build on
     */
    public VeggiePizzaBuilder leftHalfSauce() {
      return super.replaceToppingsPortion(ToppingName.Sauce, ToppingPortion.LeftHalf);
    }

    /**
     * change the topping portion of the pizza so that sauce is only put on the right half.
     *
     * @return a CheesePizzaBuilder that can be continually build on
     */
    public VeggiePizzaBuilder rightHalfSauce() {
      return super.replaceToppingsPortion(ToppingName.Sauce, ToppingPortion.RightHalf);
    }

    /**
     * remove the black olive on the pizza.
     *
     * @return a CheesePizzaBuilder that can be continually build on
     */
    public VeggiePizzaBuilder noBlackOlive() {
      return super.removeToppings(ToppingName.BlackOlive);
    }

    /**
     * change the topping portion of the pizza so that black olive is only put on the left half.
     *
     * @return a CheesePizzaBuilder that can be continually build on
     */
    public VeggiePizzaBuilder leftHalfBlackOlive() {
      return super.replaceToppingsPortion(ToppingName.BlackOlive, ToppingPortion.LeftHalf);
    }

    /**
     * change the topping portion of the pizza so that black olive is only put on the right half.
     *
     * @return a CheesePizzaBuilder that can be continually build on
     */
    public VeggiePizzaBuilder rightHalfBlackOlive() {
      return super.replaceToppingsPortion(ToppingName.BlackOlive, ToppingPortion.RightHalf);
    }

    /**
     * remove the green pepper on the pizza.
     *
     * @return a CheesePizzaBuilder that can be continually build on
     */
    public VeggiePizzaBuilder noGreenPepper() {
      return super.removeToppings(ToppingName.GreenPepper);
    }

    /**
     * change the topping portion of the pizza so that green pepper is only put on the left half.
     *
     * @return a CheesePizzaBuilder that can be continually build on
     */
    public VeggiePizzaBuilder leftHalfGreenPepper() {
      return super.replaceToppingsPortion(ToppingName.GreenPepper, ToppingPortion.LeftHalf);
    }

    /**
     * change the topping portion of the pizza so that green pepper is only put on the right half.
     *
     * @return a CheesePizzaBuilder that can be continually build on
     */
    public VeggiePizzaBuilder rightHalfGreenPepper() {
      return super.replaceToppingsPortion(ToppingName.GreenPepper, ToppingPortion.RightHalf);
    }

    /**
     * remove the onion on the pizza.
     *
     * @return a CheesePizzaBuilder that can be continually build on
     */
    public VeggiePizzaBuilder noOnion() {
      return super.removeToppings(ToppingName.Onion);
    }

    /**
     * change the topping portion of the pizza so that onion is only put on the left half.
     *
     * @return a CheesePizzaBuilder that can be continually build on
     */
    public VeggiePizzaBuilder leftHalfOnion() {
      return super.replaceToppingsPortion(ToppingName.Onion, ToppingPortion.LeftHalf);
    }

    /**
     * change the topping portion of the pizza so that onion is only put on the right half.
     *
     * @return a CheesePizzaBuilder that can be continually build on
     */
    public VeggiePizzaBuilder rightHalfOnion() {
      return super.replaceToppingsPortion(ToppingName.Onion, ToppingPortion.RightHalf);
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
      return new VeggiePizza(this.size, this.crust, this.toppings);
    }

    /**
     * get a specific type of PizzaBuilder that can be continually build on.
     *
     * @return a specific type of PizzaBuilder that can be continually build on
     */
    @Override
    protected VeggiePizzaBuilder returnBuilder() {
      return this;
    }
  }
}
