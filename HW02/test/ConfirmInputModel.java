import java.util.Objects;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * A class that has its move method log the input from the controller.
 */
public class ConfirmInputModel implements MarbleSolitaireModel {
  final StringBuilder log;

  /**
   * Generate a confirm Input model for testing the correctness of input.
   * @param log a StringBuilder to store the input log
   */
  public ConfirmInputModel(StringBuilder log) {
    this.log = Objects.requireNonNull(log);
  }

  /**
   * append the input to log for testing purpose, notice the input is 1 based.
   *
   * @param fromRow the row number of the position to be moved from (starts at 0)
   * @param fromCol the column number of the position to be moved from (starts at 0)
   * @param toRow   the row number of the position to be moved to (starts at 0)
   * @param toCol   the column number of the position to be moved to (starts at 0)
   * @throws IllegalArgumentException if the move is not possible
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    log.append(String.format("fromRow = %d, fromCol = %d, toRow = %d, toCol = %d\n",fromRow ,
            fromCol ,toRow ,toCol));
  }

  /**
   * Determine and return if the game is over or not. A game is over if no more moves can be made.
   *
   * @return false as the output of this method is irrelevant for testing
   */
  @Override
  public boolean isGameOver() {
    return false;
  }

  /**
   * Return the size of this board. The size is roughly the longest dimension of a board
   *
   * @return 0 as the output of this method is irrelevant for testing
   */
  @Override
  public int getBoardSize() {
    return 0;
  }

  /**
   * Get the state of the slot at a given position on the board.
   *
   * @param row the row of the position sought, starting at 0
   * @param col the column of the position sought, starting at 0
   * @return null as the output of this method is irrelevant for testing
   * @throws IllegalArgumentException if the row or the column are beyond the dimensions of the
   *                                  board
   */
  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    return null;
  }

  /**
   * Return the number of marbles currently on the board.
   *
   * @return 0 as the output of this method is irrelevant for testing
   */
  @Override
  public int getScore() {
    return 0;
  }
}
