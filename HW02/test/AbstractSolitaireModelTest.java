import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Empty;
import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Marble;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * To represent an abstract testing class for instances of MarbleSolitaireModel implementations.
 */
public abstract class AbstractSolitaireModelTest {
  protected MarbleSolitaireModel model1;
  protected MarbleSolitaireModel model2;
  protected MarbleSolitaireModel model3;
  protected MarbleSolitaireModel model4;

  protected MarbleSolitaireModelState.SlotState[][] model1RawExpanded;
  protected MarbleSolitaireModelState.SlotState[][] model2RawExpanded;
  protected MarbleSolitaireModelState.SlotState[][] model3RawExpanded;
  protected MarbleSolitaireModelState.SlotState[][] model4RawExpanded;

  protected final String invalidMoveExceptionMessage = "This is an invalid move!";
  protected final String invalidMoveFailMessage = "Invalid move exception did not throw!";
  protected final String moveOutOfBoundExceptionMessage =  "at least one index is out of the "
          + "dimension of the game board!";
  protected final String moveOutOfBoundFailMessage = "Out of bound exception did not throw!";

  @org.junit.Before
  public abstract void setUp();

  @org.junit.Test
  public void constructTest() {
    assertTrue(this.compareTwoDLists(this.model1, this.model1RawExpanded));
    assertTrue(this.compareTwoDLists(this.model2, this.model2RawExpanded));
    assertTrue(this.compareTwoDLists(this.model3, this.model3RawExpanded));
    assertTrue(this.compareTwoDLists(this.model4, this.model4RawExpanded));
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public abstract void constructExceptionOneArgsNegativeBoardSize();

  @org.junit.Test(expected = IllegalArgumentException.class)
  public abstract void constructExceptionOneArgsBoardTooSmall();

  @org.junit.Test(expected = IllegalArgumentException.class)
  public abstract void constructExceptionTwoArgsImpossibleEmptySlot();

  @org.junit.Test(expected = IllegalArgumentException.class)
  public abstract void constructExceptionThreeArgsImpossibleEmptySlot();

  @org.junit.Test(expected = IllegalArgumentException.class)
  public abstract void constructExceptionThreeArgsNegativeBoardSize();

  @org.junit.Test
  public abstract void moveOutOfBoundException();

  @org.junit.Test
  public abstract void moveInvalidStepException();

  @org.junit.Test
  public abstract void moveANDisGameOver();

  @org.junit.Test
  public abstract void getBoardSize();

  @org.junit.Test
  public abstract void getSlotAt();

  @org.junit.Test
  public void getSlotAtException() {
    assertTrue(this.failGetSlotAt(this.model1, -3,1));
    assertTrue(this.failGetSlotAt(this.model1, 1,-3));
    assertTrue(this.failGetSlotAt(this.model1, this.model1.getBoardSize() + 3,1));
    assertTrue(this.failGetSlotAt(this.model1, 1,this.model1.getBoardSize() + 3));
  }

  @org.junit.Test
  public abstract void getScore();


  /**
   * Determine if elements in the board (2-D list) from a {@link MarbleSolitaireModel} are the same
   * as an expecting board (2-D list).
   * @param model a {@link MarbleSolitaireModel}
   * @param modelRawExpanded the expecting 2-D list
   * @return true if two lists contain the same elements
   */
  protected boolean compareTwoDLists(MarbleSolitaireModel model,
                                MarbleSolitaireModelState.SlotState[][] modelRawExpanded) {
    boolean result = true;
    for (int row = 0; row < model.getBoardSize(); row++) {
      for (int col = 0; col < model.getBoardSize(); col++) {
        result = result && (modelRawExpanded[row][col] == model.getSlotAt(row, col));
      }
    }
    return result;
  }

  /**
   * To determine if an {@link IllegalArgumentException} thrown during a move action matches the
   * expected cause.
   *
   * @param model            the testing EnglishSolitaireModel
   * @param fromRow          the row number of the position to be moved from (starts at 0)
   * @param fromCol          the column number of the position to be moved from (starts at 0)
   * @param toRow            the row number of the position to be moved to (starts at 0)
   * @param toCol            the column number of the position to be moved to (starts at 0)
   * @param exceptionMessage the expected exception message
   * @param failMessage      the exception message thrown if the test is not up to expectation
   * @return                 true when the expected exception message is thrown
   */
  protected boolean moveExceptionAssertMessage(MarbleSolitaireModel model, int fromRow,
                                             int fromCol, int toRow, int toCol,
                                             String exceptionMessage, String failMessage) {
    boolean result = false;
    try {
      model.move(fromRow, fromCol, toRow, toCol);
      fail(failMessage);
    } catch (IllegalArgumentException e) {
      result = exceptionMessage.equals(e.getMessage());
    }
    return  result;
  }

  /**
   * Update the {@link MarbleSolitaireModelState.SlotState} of slots involved in a move action.
   *
   * @param modelRawExpanded the expanded 2-D list that representing the game board
   * @param fromRow          the row of the {@code from} slot in the given {@code SlotState} 2-D
   *                               list
   * @param fromCol          the column of the {@code from} slot in the given {@code SlotState} 2-D
   *                               list
   * @param toRow            the row of the {@code to} slot in the given {@code SlotState} 2-D list
   * @param toCol            the column of the {@code to} slot in the given {@code SlotState} 2-D
   *                               list
   */
  protected void rawExpandedMutateState(
          MarbleSolitaireModelState.SlotState[] [] modelRawExpanded,
          int fromRow, int fromCol, int toRow, int toCol) {
    modelRawExpanded[fromRow][fromCol] = Empty;
    modelRawExpanded[toRow][toCol] = Marble;
    modelRawExpanded[(fromRow + toRow) / 2][(fromCol + toCol) / 2] = Empty;
  }

  /**
   * To determine if an {@link IllegalArgumentException} thrown during a SlotState getting
   * action, presumably caused by indices are out of bound.
   * @param model the model used to perform a SlotState getting action
   * @param row the row of the slot trying access in a SlotState getting action
   * @param col the column of the slot trying access in a SlotState getting action
   * @return {@code true} if the getting-slot action failed, i.e. throw an
   *               {@link IllegalArgumentException}
   */
  protected boolean failGetSlotAt(MarbleSolitaireModel model, int row, int col) {
    boolean result = false;
    try {
      model.getSlotAt(row, col);
    } catch (IllegalArgumentException e) {
      result = true;
    }
    return result;
  }
}
