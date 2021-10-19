package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;

/**
 * To demonstrate a European Solitaire board model, whose dimension can be customized to form an
 * octagon shape and always has a (position customizable) empty slot allowing players to start
 * the game.
 */
public class EuropeanSolitaireModel extends EnglishSolitaireModel {

  /**
   * Construct a {@link EuropeanSolitaireModel} with default {@code armThickness} of 3 and a
   * centered empty slot.
   */
  public EuropeanSolitaireModel() {
    this(3);
  }

  /**
   * Construct a {@link EuropeanSolitaireModel} with default {@code armThickness} of 3 and the
   * given empty slot determined by {@code sRow} and {@code sCol}.
   *
   * @param sRow the row of the empty slot.
   * @param sCol the column of the empty slot.
   * @throws IllegalArgumentException when empty slot is set at an invalid position.
   */
  public EuropeanSolitaireModel(int sRow, int sCol) {
    this(3, sRow, sCol);
  }

  /**
   * Construct a {@link EuropeanSolitaireModel} with the given {@code armThickness} and the
   * centered empty slot.
   *
   * @param armThickness the number of marbles on the top/bottom most row (or equivalently
   *                           on the left/right most column).
   * @throws IllegalArgumentException when armThickness is not a positive odd number.
   */
  public EuropeanSolitaireModel(int armThickness) {
    this(armThickness, (armThickness - 2 + (armThickness + 1) / 2),
            (armThickness - 2 + (armThickness + 1) / 2));
  }

  /**
   * Construct a {@link EuropeanSolitaireModel} with the given {@code armThickness} and the given
   * empty slot determined by {@code sRow} and {@code sCol}.
   *
   * @param armThickness the number of marbles on the top/bottom most row (or equivalently
   *                           on the left/right most column).
   * @param sRow         the row of the empty slot.
   * @param sCol         the column of the empty slot.
   * @throws IllegalArgumentException when armThickness is not a positive odd number or empty slot
   *                                        is put at an invalid position.
   */
  public EuropeanSolitaireModel(int armThickness, int sRow, int sCol) {
    super(armThickness, sRow, sCol);
  }

  /**
   * Examine if the given slot determined by the {@code sRow} and {@code sCol} is invalid, with
   * the information of {@code armThickness} provided.
   * @param armThickness the number of marbles on the top/bottom most row (or equivalently on
   *                            the left/right most column).
   * @param row the row of the slot being examined
   * @param col the column of the slot being examined
   * @return {@code true} if the examining slot is of {@link SlotState} being {@code Invalid}
   */
  @Override
  protected boolean givenSlotIsInvalid(int armThickness, int row, int col) {
    int head = armThickness - 1;
    int tail = head + armThickness - 1;

    boolean leftUpConstrain = (row < head && col < head) && row + col < head;
    boolean rightUpConstrain =
            (row > tail && col < head) && ((this.span - 1 - row) + col < head);
    boolean leftDownConstrain =
            (row < head && col > tail) && ((this.span - 1 - col) + row < head);
    boolean rightDownConstrain =
            (row > tail && col > tail) && ((this.span - 1 - row) + (this.span - 1 - col) < head);
    return leftUpConstrain || rightUpConstrain || leftDownConstrain || rightDownConstrain;
  }
}