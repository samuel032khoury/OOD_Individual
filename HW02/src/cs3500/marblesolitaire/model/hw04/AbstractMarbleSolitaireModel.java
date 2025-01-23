package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * To demonstrate a Marble Solitaire board model, whose dimension can be customized and always has a
 * (position customizable) empty slot allowing players to start the game. The shape of the board
 * depends on specific implementation.
 */
public abstract class AbstractMarbleSolitaireModel implements MarbleSolitaireModel {

  protected final int span;
  protected final SlotState[][] board;
  protected int marbleLeft;

  /**
   * Construct a {@link MarbleSolitaireModel} with the given {@code inputLength} and the given
   * empty slot determined by {@code sRow} and {@code sCol}.
   *
   * @param inputLength  user's input that can determine the dimension of a board. The final
   *                     dimension depends on specific implementation
   * @param sRow         the row of the empty slot.
   * @param sCol         the column of the empty slot.
   * @throws IllegalArgumentException when {@code inputLength}  is not a positive number or
   *                                        empty slot is put at an invalid position.
   */
  public AbstractMarbleSolitaireModel(int inputLength, int sRow, int sCol)
          throws IllegalArgumentException {

    this.validSize(inputLength);
    this.span = this.getSpan(inputLength);
    if (this.givenSlotIsInvalid(inputLength, sRow, sCol)) {
      throw new IllegalArgumentException();
    }


    this.board = new SlotState[this.span][this.span];
    this.marbleLeft = 0;

    for (int i = 0; i < this.span; i++) {
      for (int j = 0; j < this.span; j++) {
        if (givenSlotIsInvalid(inputLength, i, j)) {
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
   * Check the provided {@code inputLength} is valid to generate a playable board. Throw
   * exception if {@code inputLength} doesn't satisfy the constraint that it must not smaller
   * than 2, do nothing otherwise.
   *
   * @param inputLength user's input that can determine the dimension of a board.
   * @throws IllegalArgumentException if {@code inputLength} is smaller than 2 that makes the
   *                                        game unplayable
   */
  protected void validSize(int inputLength) throws IllegalArgumentException {
    if (inputLength < 2) {
      throw new IllegalArgumentException();
    }
  }

  /**
   * Examine if the given slot determined by the {@code sRow} and {@code sCol} is invalid, with
   * the information of {@code inputLength} provided.
   * @param inputLength user's input that can determine the dimension of a board.
   * @param sRow the row of the slot being examined
   * @param sCol the column of the slot being examined
   * @return {@code true} if the examining slot is of {@link SlotState} being {@code Invalid}
   */
  protected abstract boolean givenSlotIsInvalid(int inputLength, int sRow, int sCol);

  /**
   * Given the information of {@code inputLength}, calculate the longest dimension of the board
   * based on the shape of the specific implemented model.
   * @param inputLength user's input that can determine the dimension of a board.
   * @return the longest dimension of the board
   */
  protected abstract int getSpan(int inputLength);

  /**
   * Move a single marble from a given position to another provided position and update  {@code
   * marbleLeft}. A move is valid only if the from and to positions are valid, meaning it can
   * pass the {@link #isLegalMove} test.
   *
   * @param fromRow the row number of the position to be moved from (starts at 0)
   * @param fromCol the column number of the position to be moved from (starts at 0)
   * @param toRow   the row number of the position to be moved to (starts at 0)
   * @param toCol   the column number of the position to be moved to (starts at 0)
   * @throws IllegalArgumentException if any of the parameters is out of the dimension or the move
   *                                        is not possible
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    int arrLen = this.span - 1;
    if (fromRow < 0 || fromCol < 0 || toRow < 0 || toCol < 0
            || fromRow > arrLen || fromCol > arrLen || toRow > arrLen || toCol > arrLen) {
      throw new IllegalArgumentException("at least one index is out of the dimension of the game "
              + "board!");
    }
    if (this.isLegalMove(fromRow, fromCol, toRow, toCol)) {
      this.mutateState(fromRow, fromCol, toRow, toCol);
      marbleLeft--;
    }  else {
      throw new IllegalArgumentException("This is an invalid move!");
    }
  }

  /**
   * Update the {@link SlotState} of slots involved in a move action.
   *
   * @param fromRow the row of the "from slot"
   * @param fromCol the column of the "from slot"
   * @param toRow   the row of the to slot
   * @param toCol   the column of the "from slot"
   */
  private void mutateState(int fromRow, int fromCol, int toRow, int toCol) {
    this.board[fromRow][fromCol] = SlotState.Empty;
    this.board[toRow][toCol] = SlotState.Marble;
    this.board[(fromRow + toRow) / 2][(fromCol + toCol) / 2] = SlotState.Empty;
  }

  /**
   * Determine if a movement operation follows the fundamental rule of marble moving, regardless of
   * further specific implementation, that the {@code from} end has to be of a {@code Marble}
   * {@link SlotState}, the {@code to} end has to be of a {@code Empty} {@link SlotState}, the
   * slot in between has to be of a {@code Marble} {@link SlotState}, and the {@code from} row
   * is not the same as the {@code to} row, additional restrictions can be attached in
   * {@link #isValidMove} depends on specific implementations.
   *
   * @param fromRow the row of the "from slot"
   * @param fromCol the column of the "from slot"
   * @param toRow   the row of the to slot
   * @param toCol   the column of the "from slot"
   * @return {@code true} if the move follows the fundamental rule of a movement regardless of
   *               further specific implementation.
   */
  private boolean isLegalMove(int fromRow, int fromCol, int toRow, int toCol) {
    return  this.board[fromRow][fromCol] == SlotState.Marble
            && this.board[toRow][toCol] == SlotState.Empty
            && this.board[(fromRow + toRow) / 2][(fromCol + toCol) / 2] == SlotState.Marble
            && this.isValidMove(fromRow, fromCol, toRow, toCol)
            && !(fromRow == toRow && fromCol == toCol);
  }

  /**
   * Determine if the move can be performed in terms of the direction and distance of its
   * movement, by default a marble can move both horizontally and vertically 2 slots away.
   *
   * @param fromRow the row of the "from slot"
   * @param fromCol the column of the "from slot"
   * @param toRow   the row of the to slot
   * @param toCol   the column of the "from slot"
   * @return {@code true} if the move can be performed in terms of the direction and distance of
   *                            its movement.
   */
  protected boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol) {
    return (Math.abs(fromRow - toRow) == 2 && fromCol - toCol == 0
            || Math.abs(fromCol - toCol) == 2 && fromRow - toRow == 0);
  }

  /**
   * Determine and return if the game is over. A game is over if no more moves can be made.
   *
   * @return {@code true} if the game is over, {@code false} otherwise
   */
  @Override
  public boolean isGameOver() {
    int currRow = 0;
    int currCol = 0;
    boolean noMoreToMove = true;

    while (noMoreToMove && currRow < this.span) {
      while (noMoreToMove && currCol < this.span) {
        SlotState current = this.board[currRow][currCol];
        switch (current) {
          case Empty:
            noMoreToMove = currCannotMove(currRow, currCol, SlotState.Marble);
            break;
          case Marble:
            noMoreToMove = currCannotMove(currRow, currCol, SlotState.Empty);
            break;
          default:
            break;
        }
        currCol++;
      }
      currCol = 0;
      currRow++;
    }

    return noMoreToMove;
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
  protected boolean currCannotMove(int row, int col, SlotState expect) {

    boolean horizMobility = expectInSlot(row, col + 1, SlotState.Marble) && expectInSlot(row,
            col + 2, expect);
    boolean vertiMobility = expectInSlot(row + 1, col, SlotState.Marble) && expectInSlot(row + 2,
            col, expect);
    return !(horizMobility) && !(vertiMobility);
  }

  /**
   * Determine if the expected {@link SlotState} is met at the given 2-D position determined by
   * {@code row} and {@code col}.
   *
   * @param row    the row of the 2-D position
   * @param col    the column of the 2-D position
   * @param expect the expected {@link SlotState} at the given 2-D position
   * @return {@code true} if the expectation is met
   */
  protected boolean expectInSlot(int row, int col, SlotState expect) {
    return col > 0 && row > 0
        && col < this.span && row < this.span
        && this.board[row][col] == expect;
  }

  /**
   * Return the size of this board. The size is the longest dimension of the board
   *
   * @return the size as an integer
   */
  @Override
  public int getBoardSize() {
    return this.span;
  }

  /**
   * Get the {@link SlotState} of the slot at a given position on the board.
   *
   * @param row the row of the position sought, starting at 0
   * @param col the column of the position sought, starting at 0
   * @return the {@link SlotState} of the slot at the given row and column
   * @throws IllegalArgumentException if the row or the column are beyond the dimensions of the
   *                                        board
   */
  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    if (row < 0 || col < 0 || row > this.span - 1 || col > this.span - 1) {
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
