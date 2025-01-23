package spreadsheet;

/**
 * To represent a better {@link SpreadSheet} that supports bulk value assignment.
 */
public interface BetterSpreadSheet extends SpreadSheet {
  void massSet(int startRow, int startColumn, int endRow, int endColumn, double value)
          throws IllegalArgumentException;
}
