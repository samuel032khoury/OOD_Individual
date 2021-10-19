package cs3500.marblesolitaire.model.hw02;

import cs3500.marblesolitaire.model.hw04.AbstractMarbleSolitaireModel;

/**
 * To demonstrate an English Solitaire board model, whose dimension can be customized to form a plus
 * shape and always has a (position customizable) empty slot allowing players to start the game.
 */
public class EnglishSolitaireModel extends AbstractMarbleSolitaireModel {

  /**
   * Construct a {@link EnglishSolitaireModel} with default {@code armThickness} of 3 and a
   * centered empty slot.
   */
  public EnglishSolitaireModel() {
    this(3);
  }

  /**
   * Construct a {@link EnglishSolitaireModel} with default {@code armThickness} of 3 and the
   * given empty slot determined by {@code sRow} and {@code sCol}.
   *
   * @param sRow the row of the empty slot.
   * @param sCol the column of the empty slot.
   * @throws IllegalArgumentException when empty slot is set at an invalid position.
   */
  public EnglishSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    this(3, sRow, sCol);
  }

  /**
   * Construct a {@link EnglishSolitaireModel} with the given {@code armThickness} and the
   * centered empty slot.
   *
   * @param armThickness the number of marbles on the top/bottom most row (or equivalently
   *                           on the left/right most column).
   * @throws IllegalArgumentException when armThickness is not a positive odd number.
   */
  public EnglishSolitaireModel(int armThickness) throws IllegalArgumentException {
    this(armThickness, (armThickness - 2 + (armThickness + 1) / 2),
            (armThickness - 2 + (armThickness + 1) / 2));
  }

  /**
   * Construct a {@link EnglishSolitaireModel} with the given {@code armThickness} and the given
   * empty slot determined by {@code sRow} and {@code sCol}.
   *
   * @param armThickness the number of marbles on the top/bottom most row (or equivalently
   *                           on the left/right most column).
   * @param sRow         the row of the empty slot.
   * @param sCol         the column of the empty slot.
   * @throws IllegalArgumentException when armThickness is not a positive odd number or empty slot
   *                                        is put at an invalid position.
   */
  public EnglishSolitaireModel(int armThickness, int sRow, int sCol)
          throws IllegalArgumentException {
    super(armThickness, sRow, sCol);
  }

  /**
   * Check the provided {@code armThickness} is valid to generate a playable board. Throw
   * exception if {@code armThickness} doesn't satisfy the constraint that it must not smaller
   * than 3 and must be an odd number, do nothing otherwise.
   *
   * @param armThickness  the number of marbles on the top/bottom most row (or equivalently on
   *                            the left/right most column).
   * @throws IllegalArgumentException if {@code armThickness} is smaller than 3 or is not an odd
   *                                        number that makes the game unplayable/lack a meaningful
   *                                        center
   */
  @Override
  protected void validSize(int armThickness) throws IllegalArgumentException {
    if (armThickness < 3 || armThickness % 2 == 0) {
      throw new IllegalArgumentException();
    }
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
    return ((row < head && col < head) || (row > tail && col < head)
            || (row < head && col > tail) || (row > tail && col > tail));
  }

  /**
   * Given the information of {@code armThickness}, calculate the longest dimension of the
   * rectangle board.
   * @param armThickness  the number of marbles on the top/bottom most row (or equivalently on
   *                            the left/right most column).
   * @return the longest dimension of the rectangle board
   */
  @Override
  protected int getSpan(int armThickness) {
    return 3 * armThickness - 2;
  }
}