import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Invalid;
import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Empty;
import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Marble;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * To test instances of EnglishSolitaireModel.
 */
public class EnglishSolitaireModelTest {
  private EnglishSolitaireModel model1;
  private EnglishSolitaireModel model2;
  private EnglishSolitaireModel model3;
  private EnglishSolitaireModel model4;

  private MarbleSolitaireModelState.SlotState[][] model1RawExpanded;
  private MarbleSolitaireModelState.SlotState[][] model2RawExpanded;

  private MarbleSolitaireModelState.SlotState[][] model3RawExpanded;

  private MarbleSolitaireModelState.SlotState[][] model4RawExpanded;

  @org.junit.Before
  public void setUp() {
    this.model1 = new EnglishSolitaireModel();
    this.model2 = new EnglishSolitaireModel(7);
    this.model3 = new EnglishSolitaireModel(3, 4);
    this.model4 = new EnglishSolitaireModel(7, 7, 3);

    this.model1RawExpanded =
      new MarbleSolitaireModelState.SlotState[][]
          {{Invalid, Invalid, Marble, Marble, Marble, Invalid, Invalid},
                  {Invalid, Invalid, Marble, Marble, Marble, Invalid, Invalid},
                  {Marble, Marble, Marble, Marble, Marble, Marble, Marble},
                  {Marble, Marble, Marble, Empty, Marble, Marble, Marble},
                  {Marble, Marble, Marble, Marble, Marble, Marble, Marble},
                  {Invalid, Invalid, Marble, Marble, Marble, Invalid, Invalid},
                  {Invalid, Invalid, Marble, Marble, Marble, Invalid, Invalid}};
    this.model2RawExpanded =
            new MarbleSolitaireModelState.SlotState[][]
            {{Invalid, Invalid, Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble,
                    Marble, Marble, Marble, Marble, Invalid, Invalid, Invalid, Invalid, Invalid,
                    Invalid},
                    {Invalid, Invalid, Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble,
                        Marble, Marble, Marble, Marble, Invalid, Invalid, Invalid, Invalid,
                        Invalid, Invalid},
                    {Invalid, Invalid, Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble,
                        Marble, Marble, Marble, Marble, Invalid, Invalid, Invalid, Invalid,
                        Invalid, Invalid},
                    {Invalid, Invalid, Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble,
                        Marble, Marble, Marble, Marble, Invalid, Invalid, Invalid, Invalid,
                        Invalid, Invalid},
                    {Invalid, Invalid, Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble,
                        Marble, Marble, Marble, Marble, Invalid, Invalid, Invalid, Invalid,
                        Invalid, Invalid},
                    {Invalid, Invalid, Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble,
                        Marble, Marble, Marble, Marble, Invalid, Invalid, Invalid, Invalid,
                        Invalid, Invalid},
                    {Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                        Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                        Marble, Marble},
                    {Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                        Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                        Marble, Marble},
                    {Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                        Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                        Marble, Marble},
                    {Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                        Empty, Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                        Marble},
                    {Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                        Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                        Marble, Marble},
                    {Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                        Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                        Marble, Marble},
                    {Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                        Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                        Marble, Marble},
                    {Invalid, Invalid, Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble,
                        Marble, Marble, Marble, Marble, Invalid, Invalid, Invalid, Invalid,
                        Invalid, Invalid},
                    {Invalid, Invalid, Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble,
                        Marble, Marble, Marble, Marble, Invalid, Invalid, Invalid, Invalid,
                        Invalid, Invalid},
                    {Invalid, Invalid, Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble,
                        Marble, Marble, Marble, Marble, Invalid, Invalid, Invalid, Invalid,
                        Invalid, Invalid},
                    {Invalid, Invalid, Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble,
                        Marble, Marble, Marble, Marble, Invalid, Invalid, Invalid, Invalid,
                        Invalid, Invalid},
                    {Invalid, Invalid, Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble,
                        Marble, Marble, Marble, Marble, Invalid, Invalid, Invalid, Invalid,
                        Invalid, Invalid},
                    {Invalid, Invalid, Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble,
                        Marble, Marble, Marble, Marble, Invalid, Invalid, Invalid, Invalid,
                        Invalid, Invalid}};
    this.model3RawExpanded =
            new MarbleSolitaireModelState.SlotState[][]
            {{Invalid, Invalid, Marble, Marble, Marble, Invalid, Invalid},
              {Invalid, Invalid, Marble, Marble, Marble, Invalid, Invalid},
              {Marble, Marble, Marble, Marble, Marble, Marble, Marble},
              {Marble, Marble, Marble, Marble, Empty, Marble, Marble},
              {Marble, Marble, Marble, Marble, Marble, Marble, Marble},
              {Invalid, Invalid, Marble, Marble, Marble, Invalid, Invalid},
              {Invalid, Invalid, Marble, Marble, Marble, Invalid, Invalid}};

    this.model4RawExpanded =
      new MarbleSolitaireModelState.SlotState[][]
          {{Invalid, Invalid, Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble,
                  Marble, Marble, Marble, Marble, Invalid, Invalid, Invalid, Invalid, Invalid,
                  Invalid},
                  {Invalid, Invalid, Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble,
                      Marble, Marble, Marble, Marble, Invalid, Invalid, Invalid, Invalid,
                      Invalid, Invalid},
                  {Invalid, Invalid, Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble,
                      Marble, Marble, Marble, Marble, Invalid, Invalid, Invalid, Invalid,
                      Invalid, Invalid},
                  {Invalid, Invalid, Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble,
                      Marble, Marble, Marble, Marble, Invalid, Invalid, Invalid, Invalid,
                      Invalid, Invalid},
                  {Invalid, Invalid, Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble,
                      Marble, Marble, Marble, Marble, Invalid, Invalid, Invalid, Invalid,
                      Invalid, Invalid},
                  {Invalid, Invalid, Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble,
                      Marble, Marble, Marble, Marble, Invalid, Invalid, Invalid, Invalid,
                      Invalid, Invalid},
                  {Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                      Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                      Marble, Marble},
                  {Marble, Marble, Marble, Empty, Marble, Marble, Marble, Marble, Marble,
                      Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                      Marble, Marble},
                  {Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                      Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                      Marble, Marble},
                  {Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                      Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                      Marble},
                  {Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                      Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                      Marble, Marble},
                  {Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                      Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                      Marble, Marble},
                  {Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                      Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                      Marble, Marble},
                  {Invalid, Invalid, Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble,
                      Marble, Marble, Marble, Marble, Invalid, Invalid, Invalid, Invalid,
                      Invalid, Invalid},
                  {Invalid, Invalid, Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble,
                      Marble, Marble, Marble, Marble, Invalid, Invalid, Invalid, Invalid,
                      Invalid, Invalid},
                  {Invalid, Invalid, Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble,
                      Marble, Marble, Marble, Marble, Invalid, Invalid, Invalid, Invalid,
                      Invalid, Invalid},
                  {Invalid, Invalid, Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble,
                      Marble, Marble, Marble, Marble, Invalid, Invalid, Invalid, Invalid,
                      Invalid, Invalid},
                  {Invalid, Invalid, Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble,
                      Marble, Marble, Marble, Marble, Invalid, Invalid, Invalid, Invalid,
                      Invalid, Invalid},
                  {Invalid, Invalid, Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble,
                      Marble, Marble, Marble, Marble, Invalid, Invalid, Invalid, Invalid,
                      Invalid, Invalid}};
  }

  @org.junit.Test
  public void constructTest() {
    assertTrue(this.compareTwoDLists(this.model1, this.model1RawExpanded));
    assertTrue(this.compareTwoDLists(this.model1, this.model1RawExpanded));
    assertTrue(this.compareTwoDLists(this.model2, this.model2RawExpanded));
    assertTrue(this.compareTwoDLists(this.model3, this.model3RawExpanded));
    assertTrue(this.compareTwoDLists(this.model4, this.model4RawExpanded));
  }


  /**
   * Compare two 2-D lists by checking if they have identical elements, and determine if two lists
   * are the same.
   * @param model the English Solitaire model
   * @param modelRawExpanded the expected 2-D list
   * @return true if two lists are the same
   */
  private boolean compareTwoDLists(EnglishSolitaireModel model,
                                MarbleSolitaireModelState.SlotState[][] modelRawExpanded) {
    boolean result = true;
    for (int row = 0; row < model.getBoardSize(); row++) {
      for (int col = 0; col < model.getBoardSize(); col++) {
        result = result && (modelRawExpanded[row][col] == model.getSlotAt(row, col));
      }
    }
    return result;
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void constructException1() {
    new EnglishSolitaireModel(0, 0);
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void constructException2() {
    new EnglishSolitaireModel(-10);
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void constructException3() {
    new EnglishSolitaireModel(6);
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void constructException4() {
    new EnglishSolitaireModel(7, 20, 20);
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void constructException5() {
    new EnglishSolitaireModel(-6, 20, 20);
  }

  @org.junit.Test
  public void moveOutOfBoundException() {
    String exceptionMessage = "at least one index is out of the dimension of the game board!";
    String failMessage = "Out of bound exception did not throw!";

    assertTrue(this.moveExceptionAssertMessage(this.model1, 9, 3, 7, 3, exceptionMessage,
            failMessage));
    assertTrue(this.moveExceptionAssertMessage(this.model1, 7, 3, 9, 3, exceptionMessage,
            failMessage));
    assertTrue(this.moveExceptionAssertMessage(this.model1, 3, 7, 3, 9, exceptionMessage,
            failMessage));
    assertTrue(this.moveExceptionAssertMessage(this.model1, 3, 9, 3, 7, exceptionMessage,
            failMessage));
    assertTrue(this.moveExceptionAssertMessage(this.model1, -1, 3, 1, 3, exceptionMessage,
            failMessage));
    assertTrue(this.moveExceptionAssertMessage(this.model1, 1, 3, -1, 3, exceptionMessage,
            failMessage));
    assertTrue(this.moveExceptionAssertMessage(this.model1, 1, -1, 1, 1, exceptionMessage,
            failMessage));
    assertTrue(this.moveExceptionAssertMessage(this.model1, 1, 1, -1, -1, exceptionMessage,
            failMessage));
  }

  @org.junit.Test
  public void moveInvalidStepException() {
    String exceptionMessage = "This is an invalid move!";
    String failMessage = "Invalid move exception did not throw!";

    // performing two move actions to have more spaces on the board and make the cause of the
    // following exception more specific
    this.model1.move(3, 1, 3, 3);
    this.model1.move(3, 4, 3, 2);

    //to test an exception caused by the empty from slot
    assertTrue(this.moveExceptionAssertMessage(this.model1, 3, 1, 3, 3, exceptionMessage,
            failMessage));
    // to test from slot and to slot are the same
    assertTrue(this.moveExceptionAssertMessage(this.model1, 3, 2, 3, 2, exceptionMessage,
            failMessage));
    //to test an exception caused by too-short move distance (move to the adjacent instead of
    // jumping over the adjacent)
    assertTrue(this.moveExceptionAssertMessage(this.model1, 3, 2, 3, 3, exceptionMessage,
            failMessage));
    //to test an exception caused by too-long move distance
    assertTrue(this.moveExceptionAssertMessage(this.model1, 3, 0, 3, 3, exceptionMessage,
            failMessage));
    // to test an exception caused by the occupied to slot
    assertTrue(this.moveExceptionAssertMessage(this.model1, 2, 0, 4, 0, exceptionMessage,
            failMessage));
    // to test an exception caused by the impossible path of a move (no marble between to jump over)
    assertTrue(this.moveExceptionAssertMessage(this.model1, 3, 2, 3, 4, exceptionMessage,
            failMessage));
    // to test an exception caused by jumping to an invalid position
    assertTrue(this.moveExceptionAssertMessage(this.model1, 3, 0, 1, 0, exceptionMessage,
            failMessage));
    // to test an exception caused by jumping from an invalid position
    assertTrue(this.moveExceptionAssertMessage(this.model1, 1, 1, 3, 1, exceptionMessage,
            failMessage));
    // to test an exception caused by a diagonal move
    assertTrue(this.moveExceptionAssertMessage(this.model1, 4, 2, 3, 3, exceptionMessage,
            failMessage));
    // to test an exception caused by an L move
    assertTrue(this.moveExceptionAssertMessage(this.model1, 4, 2, 3, 4, exceptionMessage,
            failMessage));
    // to test an exception caused by a diagonal jump
    assertTrue(this.moveExceptionAssertMessage(this.model1, 5, 2, 3, 4, exceptionMessage,
            failMessage));
  }

  /**
   * To determine if the illegal argument exception thrown during a move action matches the expected
   * cause (i.e. message of the exception can be expected).
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
  private boolean moveExceptionAssertMessage(EnglishSolitaireModel model, int fromRow,
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

  @org.junit.Test
  public void moveANDisGameOver() {
    this.model1.move(1, 3, 3, 3);
    this.rawExpandedMutateState(this.model1RawExpanded,1, 3, 3, 3);
    this.compareTwoDLists(this.model1, this.model1RawExpanded);
    assertFalse(this.model1.isGameOver());

    this.model1.move(4, 3, 2, 3);
    this.rawExpandedMutateState(this.model1RawExpanded,4, 3, 2, 3);
    this.compareTwoDLists(this.model1, this.model1RawExpanded);
    assertFalse(this.model1.isGameOver());

    this.model1.move(6, 3, 4, 3);
    this.rawExpandedMutateState(this.model1RawExpanded,6, 3, 4, 3);
    this.compareTwoDLists(this.model1, this.model1RawExpanded);
    assertFalse(this.model1.isGameOver());

    this.model1.move(3, 1, 3, 3);
    this.rawExpandedMutateState(this.model1RawExpanded,3, 1, 3, 3);
    this.compareTwoDLists(this.model1, this.model1RawExpanded);
    assertFalse(this.model1.isGameOver());

    this.model1.move(3, 4, 3, 2);
    this.rawExpandedMutateState(this.model1RawExpanded,3, 4, 3, 2);
    this.compareTwoDLists(this.model1, this.model1RawExpanded);
    assertFalse(this.model1.isGameOver());

    this.model1.move(3, 6, 3, 4);
    this.rawExpandedMutateState(this.model1RawExpanded,3, 6, 3, 4);
    this.compareTwoDLists(this.model1, this.model1RawExpanded);
    assertTrue(model1.isGameOver());
  }

  /**
   * Change the SlotState of the slot affected by a move action.
   *
   * @param modelRawExpanded the expanded 2-D list that representing the game board
   * @param fromRow          the row of the from slot in the given SlotState 2-D list
   * @param fromCol          the column of the from slot in the given SlotState 2-D list
   * @param toRow            the row of the to slot in the given SlotState 2-D list
   * @param toCol            the column of the from slot in the given SlotState 2-D list
   */
  private void rawExpandedMutateState(
          MarbleSolitaireModelState.SlotState[] [] modelRawExpanded,
          int fromRow, int fromCol, int toRow, int toCol) {
    modelRawExpanded[fromRow][fromCol] = Empty;
    modelRawExpanded[toRow][toCol] = Marble;
    modelRawExpanded[(fromRow + toRow) / 2][(fromCol + toCol) / 2] = Empty;
  }


  @org.junit.Test
  public void getBoardSize() {
    assertEquals(7, this.model1.getBoardSize());
    assertEquals(19, this.model2.getBoardSize());
    assertEquals(7, this.model3.getBoardSize());
    assertEquals(19, this.model4.getBoardSize());
  }

  @org.junit.Test
  public void getSlotAt() {
    assertEquals(Invalid, this.model1.getSlotAt(0, 0));
    assertEquals(Invalid, this.model2.getSlotAt(0, 0));
    assertEquals(Empty, this.model1.getSlotAt(3, 3));
    assertEquals(Empty, this.model2.getSlotAt(9, 9));
    assertEquals(Marble, this.model1.getSlotAt(3, 1));
    assertEquals(Marble, this.model2.getSlotAt(9, 1));
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void getSlotAtException1() {
    this.model1.getSlotAt(-1, 0);
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void getSlotAtException2() {
    this.model1.getSlotAt(3, 3);
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void getSlotAtException3() {
    this.model1.getSlotAt(9, 1);
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void getSlotAtException4() {
    this.model1.getSlotAt(3, 10);
  }

  @org.junit.Test
  public void getScore() {
    assertEquals(32, this.model1.getScore());
    assertEquals(216, this.model2.getScore());
    assertEquals(32, this.model3.getScore());
    assertEquals(216, this.model4.getScore());

    this.model1.move(1, 3, 3, 3);
    assertEquals(31, this.model1.getScore());
    this.model1.move(4, 3, 2, 3);
    assertEquals(30, this.model1.getScore());
  }
}