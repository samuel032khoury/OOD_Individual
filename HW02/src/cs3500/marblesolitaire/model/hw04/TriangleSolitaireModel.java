package cs3500.marblesolitaire.model.hw04;

/**
 * To demonstrate a Triangle Solitaire board model, whose dimension can be customized to form a
 * triangle shape and always has a (position customizable) empty slot allowing players to start
 * the game.
 */
public class TriangleSolitaireModel extends AbstractMarbleSolitaireModel {
  /**
   * Construct a {@link TriangleSolitaireModel} with default {@code dimensions} of 5 and an
   * empty slot at (0,0).
   */
  public TriangleSolitaireModel() {
    this(5);
  }

  /**
   * Construct a {@link TriangleSolitaireModel} with the default {@code dimensions} of 5 and the
   * given empty slot determined by {@code row} and {@code col}.
   *
   * @param row        the row of the empty slot.
   * @param col        the column of the empty slot.
   * @throws IllegalArgumentException when empty slot is put at an invalid position.
   */
  public TriangleSolitaireModel(int row, int col) throws IllegalArgumentException {
    this(5, row, col);
  }

  /**
   * Construct a {@link TriangleSolitaireModel} with the given {@code dimensions} and the default
   * empty slot at (0,0).
   *
   * @param dimensions the number of marbles on the bottom most row, as well as the height of the
   *                         triangle.
   * @throws IllegalArgumentException when {@code dimensions} is not a positive number.
   */
  public TriangleSolitaireModel(int dimensions) throws IllegalArgumentException {
    this(dimensions, 0, 0);
  }

  /**
   * Construct a {@link TriangleSolitaireModel} with the given {@code dimensions} and the given
   * empty slot determined by {@code row} and {@code col}.
   *
   * @param dimensions the number of marbles on the bottom most row, as well as the height of the
   *                         triangle.
   * @param row        the row of the empty slot.
   * @param col        the column of the empty slot.
   * @throws IllegalArgumentException when {@code dimensions} is not a positive number or empty
   *                                        slot is put at an invalid position.
   */
  public TriangleSolitaireModel(int dimensions, int row, int col)
          throws IllegalArgumentException {
    super(dimensions, row, col);
  }

  /**
   * Examine if the given slot determined by the {@code sRow} and {@code sCol} is invalid, with
   * the information of {@code dimensions} provided.
   * @param dimensions the number of marbles on the bottom most row, as well as the height of
   *                         the triangle.
   * @param row the row of the slot being examined
   * @param col the column of the slot being examined
   * @return {@code true} if the examining slot is of {@link SlotState} being {@code Invalid}
   */
  @Override
  protected boolean givenSlotIsInvalid(int dimensions, int row, int col) {
    return col > row;
  }

  /**
   * Given the information of {@code dimensions}, calculate the longest dimension of the
   * triangular board.
   * @param dimensions  the number of marbles on the top/bottom most row (or equivalently on
   *                            the left/right most column).
   * @return the longest dimension of the triangular board
   */
  @Override
  protected int getSpan(int dimensions) {
    return dimensions;
  }

  /**
   * Determine if the move can be performed in terms of the direction and distance of its
   * movement. For triangular models, a marble can move both horizontally and diagonally (in a
   * visual sense) 2 slots away.
   *
   * @param fromRow the row of the "from slot"
   * @param fromCol the column of the "from slot"
   * @param toRow   the row of the to slot
   * @param toCol   the column of the "from slot"
   * @return {@code true} if the move can be performed in terms of the direction and distance of
   *                            its movement.
   */
  @Override
  protected boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol) {
    return super.isValidMove(fromRow, fromCol, toRow, toCol)
            || (fromRow - toRow == fromCol - toCol && Math.abs(fromRow - toRow) == 2);
  }

  /**
   * Determine the current slot cannot be any end of a movement (neither the {@code from} end nor
   * the {@code to} end).
   *
   * @param row    the row of the current visiting slot
   * @param col    the column of the current visiting slot
   * @param expect the expected {@link SlotState} of the other end of a move action: If the current
   *               visiting slot is a {@code from} slot, then {@code expect} should be the
   *               (expected) {@link SlotState} of the {@code to} slot, and vice versa
   * @return {@code true} if the current slot can neither be the start point (as a from slot) of a
   *               move nor a destination(as a "to slot") of a move
   */
  @Override
  protected boolean currCannotMove(int row, int col, SlotState expect) {
    boolean rightDownMobility =
            expectInSlot(row + 1, col + 1, SlotState.Marble) && expectInSlot(row + 2, col + 2,
                    expect);
    return super.currCannotMove(row, col, expect) && !rightDownMobility;
  }
}
