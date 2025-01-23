/**
 * To represent an Interaction between (fake) user input and the system output.
 */
public interface Interaction {
  void apply(StringBuilder in, StringBuilder out);
}
