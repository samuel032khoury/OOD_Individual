/**
 * An implementation of Fraction which only accept the representation of a non-negtive fraction.
 */
public class SimpleFraction implements Fraction {

  private final int num;
  private final int denom;

  /**
   * Generate a Fraction Object.
   *
   * @param num   an integer represents the numerator of the Fraction.
   * @param denom an integer represents the denominator of the Fraction.
   * @throws IllegalArgumentException if denominator is 0 or the Fraction is negativs.
   */
  public SimpleFraction(int num, int denom) {
    if (!((num > 0 && denom > 0) || (num < 0 && denom < 0))) {
      throw new IllegalArgumentException("Simple Fraction cannot be negative");
    } else if (denom == 0) {
      throw new IllegalArgumentException("This fraction is undefined");
    }
    this.num = num;
    this.denom = denom;
  }

  /**
   * Calculate the sum of this non-negative Fraction and the other  non-negative Fraction.
   *
   * @param other the other non-negative Fraction object that involved in the calculation.
   * @return the result of the sum of two non-negative Fraction's.
   */
  @Override
  public Fraction add(Fraction other) {
    return other.add(this.num, this.denom);
  }

  /**
   * Given other non-negtive Fraction's numerator and denominator, calculate the sum of this
   * (non-negative) Fraction and the other Fraction.
   *
   * @param numerator   the numerator of the other Fraction object that involved in the
   *                    calculation.
   * @param denominator the denominator of the other Fraction object that involved in the
   *                    calculation.
   * @return the result of the sum of two Fraction's, given other fractions' numerator and
   *     denominator.
   */
  @Override
  public Fraction add(int numerator, int denominator) {
    if (numerator * denominator < 0) {
      throw new IllegalArgumentException("Simple Fraction cannot be negative");
    } else if (denominator == 0) {
      throw new IllegalArgumentException("This fraction is undefined");
    }
    return new SimpleFraction(this.num * denominator + this.denom * numerator,
            this.denom * denominator);
  }


  /**
   * returns the decimal value of the fraction, ginven the places it should be rounded.
   *
   * @param places digits kept for a decimal representation of a Fraction.
   * @return a double that represents the decimal form of a Fraction, with the given nummber of
   *     digits decimal points precision.
   */
  @Override
  public double getDecimalValue(int places) {
    double floatExpression = this.num * 1.0 / this.denom * 1.0;
    return Math.round(floatExpression * (Math.pow(10, places))) * 1.0 / Math.pow(10, places);
  }

  /**
   * Convert Fraction Object into a line of String.
   *
   * @return a String that represents the Fraction.
   */
  @Override
  public String toString() {
    return Integer.toString(Math.abs(this.num)) + "/" + Integer.toString(Math.abs(this.denom));
  }
}
