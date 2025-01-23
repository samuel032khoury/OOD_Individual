/**
 * An interface that represent fractions.
 */
public interface Fraction {
  /**
   * Calculate the sum of this Fraction and the other Fraction.
   *
   * @param other the other Fraction object that involved in the calculation.
   * @return the result of the sum of two Fraction's.
   */
  public Fraction add(Fraction other);

  /**
   * Given other Fraction's numerator and denominator, calculate the sum of this Fraction and the
   * other Fraction.
   *
   * @param numerator   the numerator of the other Fraction object that involved in the calculation.
   * @param denominator the denominator of the other Fraction object that involved in the
   *                    calculation.
   * @return the result of the sum of two Fraction's, given other fractions' numerator and
   *     denominator.
   */
  public Fraction add(int numerator, int denominator);

  /**
   * Calculate the decimal value of the fraction, ginven the places it should be rounded.
   *
   * @param places digits kept for a decimal representation of a Fraction.
   * @return a double that represents the decimal form of a Fraction, with the given nummber of
   *     digits decimal points precision.
   */
  public double getDecimalValue(int places);
}
