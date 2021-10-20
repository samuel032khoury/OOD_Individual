import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Invalid;
import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Empty;
import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Marble;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * To test instances of {@link EnglishSolitaireModel}.
 */
public class EnglishSolitaireModelTest extends AbstractSolitaireModelTest {

  @Override
  public void setUp() {
    super.model1 = new EnglishSolitaireModel();
    super.model2 = new EnglishSolitaireModel(7);
    super.model3 = new EnglishSolitaireModel(3, 4);
    super.model4 = new EnglishSolitaireModel(7, 7, 3);

    super.model1RawExpanded =
      new MarbleSolitaireModelState.SlotState[][]
          {{Invalid, Invalid, Marble, Marble, Marble, Invalid, Invalid},
                  {Invalid, Invalid, Marble, Marble, Marble, Invalid, Invalid},
                  {Marble, Marble, Marble, Marble, Marble, Marble, Marble},
                  {Marble, Marble, Marble, Empty, Marble, Marble, Marble},
                  {Marble, Marble, Marble, Marble, Marble, Marble, Marble},
                  {Invalid, Invalid, Marble, Marble, Marble, Invalid, Invalid},
                  {Invalid, Invalid, Marble, Marble, Marble, Invalid, Invalid}};
    super.model2RawExpanded =
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
    super.model3RawExpanded =
            new MarbleSolitaireModelState.SlotState[][]
            {{Invalid, Invalid, Marble, Marble, Marble, Invalid, Invalid},
              {Invalid, Invalid, Marble, Marble, Marble, Invalid, Invalid},
              {Marble, Marble, Marble, Marble, Marble, Marble, Marble},
              {Marble, Marble, Marble, Marble, Empty, Marble, Marble},
              {Marble, Marble, Marble, Marble, Marble, Marble, Marble},
              {Invalid, Invalid, Marble, Marble, Marble, Invalid, Invalid},
              {Invalid, Invalid, Marble, Marble, Marble, Invalid, Invalid}};

    super.model4RawExpanded =
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

  @Override
  public void constructExceptionOneArgsNegativeBoardSize() {
    new EnglishSolitaireModel(-10);
  }

  @Override
  public void constructExceptionOneArgsBoardTooSmall() {
    new EnglishSolitaireModel(1);
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void constructExceptionOneArgsRectangleBoardEvenSize() {
    new EnglishSolitaireModel(6);
  }

  @Override
  public void constructExceptionTwoArgsImpossibleEmptySlot() {
    new EnglishSolitaireModel(0, 0);
  }

  @Override
  public void constructExceptionThreeArgsImpossibleEmptySlot() {
    new EnglishSolitaireModel(7, 3, 3);
  }

  @Override
  public void constructExceptionThreeArgsNegativeBoardSize() {
    new EnglishSolitaireModel(-6, 3, 3);
  }

  @Override
  public void moveOutOfBoundException() {
    assertTrue(super.moveExceptionAssertMessage(super.model1, 9, 3, 7, 3,
            super.moveOutOfBoundExceptionMessage, super.moveOutOfBoundFailMessage));
    assertTrue(super.moveExceptionAssertMessage(super.model1, 7, 3, 9, 3,
            super.moveOutOfBoundExceptionMessage, super.moveOutOfBoundFailMessage));
    assertTrue(super.moveExceptionAssertMessage(super.model1, 3, 7, 3, 9,
            super.moveOutOfBoundExceptionMessage, super.moveOutOfBoundFailMessage));
    assertTrue(super.moveExceptionAssertMessage(super.model1, 3, 9, 3, 7,
            super.moveOutOfBoundExceptionMessage, super.moveOutOfBoundFailMessage));
    assertTrue(super.moveExceptionAssertMessage(super.model1, -1, 3, 1, 3,
            super.moveOutOfBoundExceptionMessage, super.moveOutOfBoundFailMessage));
    assertTrue(super.moveExceptionAssertMessage(super.model1, 1, 3, -1, 3,
            super.moveOutOfBoundExceptionMessage, super.moveOutOfBoundFailMessage));
    assertTrue(super.moveExceptionAssertMessage(super.model1, 1, -1, 1, 1,
            super.moveOutOfBoundExceptionMessage, super.moveOutOfBoundFailMessage));
    assertTrue(super.moveExceptionAssertMessage(super.model1, 1, 1, -1, -1,
            super.moveOutOfBoundExceptionMessage, super.moveOutOfBoundFailMessage));
  }

  @Override
  public void moveInvalidStepException() {

    // performing two move actions to have more spaces on the board and make the cause of the
    // following exception more specific
    super.model1.move(3, 1, 3, 3);
    super.model1.move(3, 4, 3, 2);

    //to test an exception caused by the empty from slot
    assertTrue(super.moveExceptionAssertMessage(super.model1, 3, 1, 3, 3,
            super.invalidMoveExceptionMessage, super.invalidMoveFailMessage));
    // to test from slot and to slot are the same
    assertTrue(super.moveExceptionAssertMessage(super.model1, 3, 2, 3, 2,
            super.invalidMoveExceptionMessage, super.invalidMoveFailMessage));
    //to test an exception caused by too-short move distance (move to the adjacent instead of
    // jumping over the adjacent)
    assertTrue(super.moveExceptionAssertMessage(super.model1, 3, 2, 3, 3,
            super.invalidMoveExceptionMessage, super.invalidMoveFailMessage));
    //to test an exception caused by too-long move distance
    assertTrue(super.moveExceptionAssertMessage(super.model1, 3, 0, 3, 3,
            super.invalidMoveExceptionMessage, super.invalidMoveFailMessage));
    // to test an exception caused by the occupied to slot
    assertTrue(super.moveExceptionAssertMessage(super.model1, 2, 0, 4, 0,
            super.invalidMoveExceptionMessage, super.invalidMoveFailMessage));
    // to test an exception caused by the impossible path of a move (no marble between to jump over)
    assertTrue(super.moveExceptionAssertMessage(super.model1, 3, 2, 3, 4,
            super.invalidMoveExceptionMessage, super.invalidMoveFailMessage));
    // to test an exception caused by jumping to an invalid position
    assertTrue(super.moveExceptionAssertMessage(super.model1, 3, 0, 1, 0,
            super.invalidMoveExceptionMessage, super.invalidMoveFailMessage));
    // to test an exception caused by jumping from an invalid position
    assertTrue(super.moveExceptionAssertMessage(super.model1, 1, 1, 3, 1,
            super.invalidMoveExceptionMessage, super.invalidMoveFailMessage));
    // to test an exception caused by a diagonal move
    assertTrue(super.moveExceptionAssertMessage(super.model1, 4, 2, 3, 3,
            super.invalidMoveExceptionMessage, super.invalidMoveFailMessage));
    // to test an exception caused by an L move
    assertTrue(super.moveExceptionAssertMessage(super.model1, 4, 2, 3, 4,
            super.invalidMoveExceptionMessage, super.invalidMoveFailMessage));
    // to test an exception caused by a diagonal jump
    assertTrue(super.moveExceptionAssertMessage(super.model1, 5, 2, 3, 4,
            super.invalidMoveExceptionMessage, super.invalidMoveFailMessage));
  }

  @Override
  public void moveANDisGameOver() {
    super.model1.move(1, 3, 3, 3);
    super.rawExpandedMutateState(super.model1RawExpanded, 1, 3, 3, 3);
    super.compareTwoDLists(super.model1, super.model1RawExpanded);
    assertFalse(super.model1.isGameOver());

    super.model1.move(4, 3, 2, 3);
    super.rawExpandedMutateState(super.model1RawExpanded, 4, 3, 2, 3);
    super.compareTwoDLists(super.model1, super.model1RawExpanded);
    assertFalse(super.model1.isGameOver());

    super.model1.move(6, 3, 4, 3);
    super.rawExpandedMutateState(super.model1RawExpanded, 6, 3, 4, 3);
    super.compareTwoDLists(super.model1, super.model1RawExpanded);
    assertFalse(super.model1.isGameOver());

    super.model1.move(3, 1, 3, 3);
    super.rawExpandedMutateState(super.model1RawExpanded, 3, 1, 3, 3);
    super.compareTwoDLists(super.model1, super.model1RawExpanded);
    assertFalse(super.model1.isGameOver());

    super.model1.move(3, 4, 3, 2);
    super.rawExpandedMutateState(super.model1RawExpanded, 3, 4, 3, 2);
    super.compareTwoDLists(super.model1, super.model1RawExpanded);
    assertFalse(super.model1.isGameOver());

    super.model1.move(3, 6, 3, 4);
    super.rawExpandedMutateState(super.model1RawExpanded, 3, 6, 3, 4);
    super.compareTwoDLists(super.model1, super.model1RawExpanded);
    assertTrue(model1.isGameOver());
  }

  @Override
  public void getBoardSize() {
    assertEquals(7, super.model1.getBoardSize());
    assertEquals(19, super.model2.getBoardSize());
    assertEquals(7, super.model3.getBoardSize());
    assertEquals(19, super.model4.getBoardSize());
  }

  @Override
  public void getSlotAt() {
    assertEquals(Invalid, super.model1.getSlotAt(0, 0));
    assertEquals(Invalid, super.model2.getSlotAt(0, 0));
    assertEquals(Empty, super.model1.getSlotAt(3, 3));
    assertEquals(Empty, super.model2.getSlotAt(9, 9));
    assertEquals(Marble, super.model1.getSlotAt(3, 1));
    assertEquals(Marble, super.model2.getSlotAt(9, 1));
  }


  @Override
  public void getScore() {
    assertEquals(32, super.model1.getScore());
    assertEquals(216, super.model2.getScore());
    assertEquals(32, super.model3.getScore());
    assertEquals(216, super.model4.getScore());

    super.model1.move(1, 3, 3, 3);
    assertEquals(31, super.model1.getScore());
    super.model1.move(4, 3, 2, 3);
    assertEquals(30, super.model1.getScore());
  }
}