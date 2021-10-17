package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

public abstract class AbstractMarbleSolitaireModel implements MarbleSolitaireModel {

  protected final int sideLength;
  protected final SlotState[][] board;
  protected int marbleLeft;

  /**
   * Construct a MarbleSolitaireModel with the given arm thickness and the given empty slot.
   *
   * @param armThickness the number of marbles in the top(/bottom) row (/ left or right column).
   * @param sRow         the row of the empty slot.
   * @param sCol         the column of the empty slot.
   * @throws IllegalArgumentException when armThickness is not a positive number or empty slot
   *                                        is put at an invalid position.
   */
  public AbstractMarbleSolitaireModel(int armThickness, int sRow, int sCol)
          throws IllegalArgumentException {
    if (armThickness <= 1) {
      throw new IllegalArgumentException();
    }
    int head = armThickness - 1;
    int tail = head + armThickness - 1;
    if ((sRow < head && sCol < head) || (sRow > tail && sCol < head)
            || (sRow < head && sCol > tail) || (sRow > tail && sCol > tail)) {
      throw new IllegalArgumentException("Invalid empty cell position (" + sRow + "," + sCol + ")");
    }
    this.sideLength = 3 * armThickness - 2;
    this.board = new SlotState[this.sideLength][this.sideLength];
    this.marbleLeft = 0;
    for (int i = 0; i < this.sideLength; i++) {
      for (int j = 0; j < this.sideLength; j++) {
        if ((i < head && j < head) || (i > tail && j < head)
                || (i < head && j > tail) || (i > tail && j > tail)) {
          board[i][j] = SlotState.Invalid;
        } else if (i == sRow && j == sCol) {
          board[i][j] = SlotState.Empty;
        } else {
          board[i][j] = SlotState.Marble;
          marbleLeft++;
        }
      }
    }
  }

  /**
   * Move a single marble from a given position to another given position. A move is valid only if
   * the from and to positions are valid. Specific implementations may place additional constraints
   * on the validity of a move.
   *
   * @param fromRow the row number of the position to be moved from (starts at 0)
   * @param fromCol the column number of the position to be moved from (starts at 0)
   * @param toRow   the row number of the position to be moved to (starts at 0)
   * @param toCol   the column number of the position to be moved to (starts at 0)
   * @throws IllegalArgumentException if the move is not possible
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {

  }

  /**
   * Determine and return if the game is over or not. A game is over if no more moves can be made.
   *
   * @return true if the game is over, false otherwise
   */
  @Override
  public boolean isGameOver() {
    return false;
  }

  /**
   * Return the size of this board. The size is roughly the longest dimension of a board
   *
   * @return the size as an integer
   */
  @Override
  public int getBoardSize() {
    return this.sideLength;
  }

  /**
   * Get the state of the slot at a given position on the board.
   *
   * @param row the row of the position sought, starting at 0
   * @param col the column of the position sought, starting at 0
   * @return the state of the slot at the given row and column
   * @throws IllegalArgumentException if the row or the column are beyond the dimensions of the
   *                                  board
   */
  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    if (row < 0 || col < 0 || row > this.sideLength - 1 || col > this.sideLength - 1) {
      throw new IllegalArgumentException();
    }
    return this.board[row][col];
  }

  /**
   * Return the number of marbles currently on the board.
   *
   * @return the number of marbles currently on the board
   */
  @Override
  public int getScore() {
    return this.marbleLeft;
  }
}
