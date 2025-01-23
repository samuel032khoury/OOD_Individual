package cs3500.marblesolitaire.model.hw02;

/**
 * To demonstrate English Solitaire Model.
 */
public class EnglishSolitaireModel implements MarbleSolitaireModel {
  private final int sideLength;
  private final SlotState[][] board;
  private int marbleLeft;

  /**
   * Construct a EnglishSolitaireModel with default arm thickness of 3 and a centered empty slot.
   */
  public EnglishSolitaireModel() {
    this(3);
  }

  /**
   * Construct a EnglishSolitaireModel with default arm thickness of 3 and the given empty slot.
   *
   * @param sRow the row of the empty slot.
   * @param sCol the column of the empty slot.
   * @throws IllegalArgumentException when empty slot is set at an invalid position.
   */
  public EnglishSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    this(3, sRow, sCol);
  }

  /**
   * Construct a EnglishSolitaireModel with the given arm thickness and the centered empty slot.
   *
   * @param armThickness the number of marbles in the top(/bottom) row (/ left or right column).
   * @throws IllegalArgumentException when armThickness is not a positive odd number.
   */
  public EnglishSolitaireModel(int armThickness) throws IllegalArgumentException {
    this(armThickness, (armThickness - 2 + (armThickness + 1) / 2),
            (armThickness - 2 + (armThickness + 1) / 2));
  }

  /**
   * Construct a EnglishSolitaireModel with the given arm thickness and the given empty slot.
   *
   * @param armThickness the number of marbles in the top(/bottom) row (/ left or right column).
   * @param sRow         the row of the empty slot.
   * @param sCol         the column of the empty slot.
   * @throws IllegalArgumentException when armThickness is not a positive odd number or empty slot
   *                                        is put at an invalid position.
   */
  public EnglishSolitaireModel(int armThickness, int sRow, int sCol)
          throws IllegalArgumentException {
    if (armThickness < 3 || armThickness % 2 == 0) {
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
    int arrLen = this.sideLength - 1;
    if (fromRow < 0 || fromCol < 0 || toRow < 0 || toCol < 0
            || fromRow > arrLen || fromCol > arrLen || toRow > arrLen || toCol > arrLen) {
      throw new IllegalArgumentException("at least one index is out of the dimension of the game "
              + "board!");
    }
    if (this.board[fromRow][fromCol] == SlotState.Marble
            && this.board[toRow][toCol] == SlotState.Empty
            && (Math.abs(fromRow - toRow) == 2 && fromCol - toCol == 0
            || Math.abs(fromCol - toCol) == 2 && fromRow - toRow == 0)
            && !(fromRow == toRow && fromCol == toCol)
            && this.board[(fromRow + toRow) / 2][(fromCol + toCol) / 2] == SlotState.Marble) {
      this.mutateState(fromRow, fromCol, toRow, toCol);
      marbleLeft--;
    } else {
      throw new IllegalArgumentException("This is an invalid move!");
    }
  }

  /**
   * Change the SlotState of the slot affected by a move action.
   *
   * @param fromRow the row of the from slot
   * @param fromCol the column of the from slot
   * @param toRow   the row of the to slot
   * @param toCol   the column of the from slot
   */
  private void mutateState(int fromRow, int fromCol, int toRow, int toCol) {
    this.board[fromRow][fromCol] = SlotState.Empty;
    this.board[toRow][toCol] = SlotState.Marble;
    this.board[(fromRow + toRow) / 2][(fromCol + toCol) / 2] = SlotState.Empty;
  }

  /**
   * Determine and return if the game is over or not. A game is over if no more moves can be made.
   *
   * @return true if the game is over, false otherwise
   */
  @Override
  public boolean isGameOver() {
    int currRow = 0;
    int currCol = 0;
    boolean noMoreToMove = true;

    while (noMoreToMove && currRow < this.sideLength) {
      while (noMoreToMove && currCol < this.sideLength) {
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
   * Determine if the current slot cannot be any end of a movement (the from end OR the to end).
   *
   * @param row    the row of the current visiting slot
   * @param col    the column of the current visiting slot
   * @param expect the expected State of the other end of the move: If the current visiting slot is
   *               a from slot, expect is the (expected) State of the to slot, and vice versa
   * @return true if the current slot can neither be the orientation(as a from slot) of a move nor a
   *               destination(as a to slot) of a move
   */
  private boolean currCannotMove(int row, int col, SlotState expect) {

    boolean horizMobility = expectInSlot(row, col + 1, SlotState.Marble) && expectInSlot(row,
            col + 2, expect);
    boolean vertiMobility = expectInSlot(row + 1, col, SlotState.Marble) && expectInSlot(row + 2,
            col, expect);
    boolean immovable = !(horizMobility) && !(vertiMobility);
    return immovable;
  }

  /**
   * Determine if the expected SlotState is met at the given 2-D position.
   *
   * @param row    the row of the 2-D position
   * @param col    the column of the 2-D position
   * @param expect the expected SlotState at the given 2-D position
   * @return true if the expectation is met
   */
  private boolean expectInSlot(int row, int col, SlotState expect) {
    return col < this.sideLength && row < this.sideLength && this.board[row][col] == expect;
  }

  /**
   * Return the size of this board. The size is roughly the longest dimension of a board.
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
   * @throws IllegalArgumentException if the row or the col are beyond the dimensions of the
   *                                        board
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
    return marbleLeft;
  }

}