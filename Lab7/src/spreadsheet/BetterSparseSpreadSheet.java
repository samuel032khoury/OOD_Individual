package spreadsheet;

/**
 * To represent a BetterSparseSpreadSheet that supports bulk value assignment.
 */
public class BetterSparseSpreadSheet implements BetterSpreadSheet {
  private SpreadSheet delegate;

  /**
   * To construct a {@link BetterSpreadSheet}.
   */
  public BetterSparseSpreadSheet() {
    this.delegate = new SparseSpreadSheet();
  }

  @Override
  public void massSet(int startRow, int startColumn, int endRow, int endColumn, double value)
          throws IllegalArgumentException {
    for (int i = startRow; i <= endRow; i++) {
      for (int j = startColumn; j <= endColumn; j++) {
        this.set(i, j, value);
      }
    }
  }

  @Override
  public double get(int row, int col) throws IllegalArgumentException {
    return this.delegate.get(row, col);
  }

  @Override
  public void set(int row, int col, double value) throws IllegalArgumentException {
    this.delegate.set(row, col, value);
  }

  @Override
  public boolean isEmpty(int row, int col) throws IllegalArgumentException {
    return this.delegate.isEmpty(row, col);
  }

  @Override
  public int getWidth() {
    return this.delegate.getWidth();
  }

  @Override
  public int getHeight() {
    return this.delegate.getHeight();
  }
}
