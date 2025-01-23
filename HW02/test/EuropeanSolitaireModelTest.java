import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;

import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Empty;
import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Invalid;
import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Marble;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * To test instances of {@link EuropeanSolitaireModel}.
 */
public class EuropeanSolitaireModelTest extends AbstractSolitaireModelTest {
  @Override
  public void setUp() {
    super.model1 = new EuropeanSolitaireModel();
    super.model2 = new EuropeanSolitaireModel(7);
    super.model3 = new EuropeanSolitaireModel(3, 4);
    super.model4 = new EuropeanSolitaireModel(7, 7, 3);

    super.model1RawExpanded =
      new MarbleSolitaireModelState.SlotState[][]
          {{Invalid, Invalid, Marble, Marble, Marble, Invalid, Invalid},
                  {Invalid, Marble, Marble, Marble, Marble, Marble, Invalid},
                  {Marble, Marble, Marble, Marble, Marble, Marble, Marble},
                  {Marble, Marble, Marble, Empty, Marble, Marble, Marble},
                  {Marble, Marble, Marble, Marble, Marble, Marble, Marble},
                  {Invalid, Marble, Marble, Marble, Marble, Marble, Invalid},
                  {Invalid, Invalid, Marble, Marble, Marble, Invalid, Invalid}};
    super.model2RawExpanded =
            new MarbleSolitaireModelState.SlotState[][]
            {{Invalid, Invalid, Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble,
                    Marble, Marble, Marble, Marble, Invalid, Invalid, Invalid, Invalid, Invalid,
                    Invalid},
                    {Invalid, Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble, Marble,
                        Marble, Marble, Marble, Marble, Marble, Invalid, Invalid, Invalid,
                        Invalid, Invalid},
                    {Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble, Marble, Marble,
                        Marble, Marble, Marble, Marble, Marble, Marble, Invalid, Invalid,
                        Invalid, Invalid},
                    {Invalid, Invalid, Invalid, Marble, Marble, Marble, Marble, Marble, Marble,
                        Marble, Marble, Marble, Marble, Marble, Marble, Marble, Invalid,
                        Invalid, Invalid},
                    {Invalid, Invalid, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                        Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                        Invalid, Invalid},
                    {Invalid, Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                        Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                        Marble, Invalid},
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
                    {Invalid, Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                        Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                        Marble, Invalid},
                    {Invalid, Invalid, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                        Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                        Invalid, Invalid},
                    {Invalid, Invalid, Invalid, Marble, Marble, Marble, Marble, Marble, Marble,
                        Marble, Marble, Marble, Marble, Marble, Marble, Marble, Invalid,
                        Invalid, Invalid},
                    {Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble, Marble, Marble,
                        Marble, Marble, Marble, Marble, Marble, Marble, Invalid, Invalid,
                        Invalid, Invalid},
                    {Invalid, Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble, Marble,
                        Marble, Marble, Marble, Marble, Marble, Invalid, Invalid, Invalid,
                        Invalid, Invalid},
                    {Invalid, Invalid, Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble,
                        Marble, Marble, Marble, Marble, Invalid, Invalid, Invalid, Invalid,
                        Invalid, Invalid}};
    super.model3RawExpanded =
      new MarbleSolitaireModelState.SlotState[][]
          {{Invalid, Invalid, Marble, Marble, Marble, Invalid, Invalid},
                  {Invalid, Marble, Marble, Marble, Marble, Marble, Invalid},
                  {Marble, Marble, Marble, Marble, Marble, Marble, Marble},
                  {Marble, Marble, Marble, Marble, Empty,Marble, Marble},
                  {Marble, Marble, Marble, Marble, Marble, Marble, Marble},
                  {Invalid, Marble, Marble, Marble, Marble, Marble, Invalid},
                  {Invalid, Invalid, Marble, Marble, Marble, Invalid, Invalid}};
    super.model4RawExpanded =
            new MarbleSolitaireModelState.SlotState[][]
            {{Invalid, Invalid, Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble,
                    Marble, Marble, Marble, Marble, Invalid, Invalid, Invalid, Invalid, Invalid,
                    Invalid},
                    {Invalid, Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble, Marble,
                        Marble, Marble, Marble, Marble, Marble, Invalid, Invalid, Invalid,
                        Invalid, Invalid},
                    {Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble, Marble, Marble,
                        Marble, Marble, Marble, Marble, Marble, Marble, Invalid, Invalid,
                        Invalid, Invalid},
                    {Invalid, Invalid, Invalid, Marble, Marble, Marble, Marble, Marble, Marble,
                        Marble, Marble, Marble, Marble, Marble, Marble, Marble, Invalid,
                        Invalid, Invalid},
                    {Invalid, Invalid, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                        Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                        Invalid, Invalid},
                    {Invalid, Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                        Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                        Marble, Invalid},
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
                    {Invalid, Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                        Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                        Marble, Invalid},
                    {Invalid, Invalid, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                        Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                        Invalid, Invalid},
                    {Invalid, Invalid, Invalid, Marble, Marble, Marble, Marble, Marble, Marble,
                        Marble, Marble, Marble, Marble, Marble, Marble, Marble, Invalid,
                        Invalid, Invalid},
                    {Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble, Marble, Marble,
                        Marble, Marble, Marble, Marble, Marble, Marble, Invalid, Invalid,
                        Invalid, Invalid},
                    {Invalid, Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble, Marble,
                        Marble, Marble, Marble, Marble, Marble, Invalid, Invalid, Invalid,
                        Invalid, Invalid},
                    {Invalid, Invalid, Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble,
                        Marble, Marble, Marble, Marble, Invalid, Invalid, Invalid, Invalid,
                        Invalid, Invalid}};
  }

  @Override
  public void constructExceptionOneArgsNegativeBoardSize() {
    new EuropeanSolitaireModel(-6);
  }

  @Override
  public void constructExceptionOneArgsBoardTooSmall() {
    new EuropeanSolitaireModel(1);
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void constructExceptionOneArgsOctagonBoardEvenSize() {
    new EuropeanSolitaireModel(6);
  }

  @Override
  public void constructExceptionTwoArgsImpossibleEmptySlot() {
    new EuropeanSolitaireModel(0,0);
  }

  @Override
  public void constructExceptionThreeArgsImpossibleEmptySlot() {
    new EuropeanSolitaireModel(21,21);
  }

  @Override
  public void constructExceptionThreeArgsNegativeBoardSize() {
    new EuropeanSolitaireModel(-3, 3, 3);
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
    assertTrue(super.moveExceptionAssertMessage(super.model1, 3, 4, 3, 6,
            super.invalidMoveExceptionMessage, super.invalidMoveFailMessage));
    // to test an exception caused by jumping to an invalid position
    assertTrue(super.moveExceptionAssertMessage(super.model1, 3, 0, 1, 0,
            super.invalidMoveExceptionMessage, super.invalidMoveFailMessage));
    // to test an exception caused by jumping from an invalid position
    assertTrue(super.moveExceptionAssertMessage(super.model1, 1, 6, 3, 6,
            super.invalidMoveExceptionMessage, super.invalidMoveFailMessage));
    // to test an exception caused by a diagonal move
    assertTrue(super.moveExceptionAssertMessage(super.model1, 4, 2, 3, 3,
            super.invalidMoveExceptionMessage, super.invalidMoveFailMessage));
    // to test an exception caused by an L move
    assertTrue(super.moveExceptionAssertMessage(super.model1, 2, 4, 3, 6,
            super.invalidMoveExceptionMessage, super.invalidMoveFailMessage));
    // to test an exception caused by a diagonal jump
    assertTrue(super.moveExceptionAssertMessage(super.model1, 1, 1, 3, 3,
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
    assertFalse(model1.isGameOver());

    super.model1.move(1, 1, 3, 1);
    super.rawExpandedMutateState(super.model1RawExpanded, 1, 1, 3, 1);
    super.compareTwoDLists(super.model1, super.model1RawExpanded);
    assertFalse(model1.isGameOver());

    super.model1.move(4, 1, 2, 1);
    super.rawExpandedMutateState(super.model1RawExpanded, 4, 1, 2, 1);
    super.compareTwoDLists(super.model1, super.model1RawExpanded);
    assertFalse(model1.isGameOver());

    super.model1.move(1, 5, 3, 5);
    super.rawExpandedMutateState(super.model1RawExpanded, 1, 5, 3, 5);
    super.compareTwoDLists(super.model1, super.model1RawExpanded);
    assertFalse(model1.isGameOver());

    super.model1.move(4, 5, 2, 5);
    super.rawExpandedMutateState(super.model1RawExpanded, 4, 5, 2, 5);
    super.compareTwoDLists(super.model1, super.model1RawExpanded);
    assertFalse(model1.isGameOver());

    super.model1.move(4, 3, 4, 5);
    super.rawExpandedMutateState(super.model1RawExpanded, 4, 3, 4, 5);
    super.compareTwoDLists(super.model1, super.model1RawExpanded);
    assertFalse(model1.isGameOver());

    super.model1.move(4, 6, 4, 4);
    super.rawExpandedMutateState(super.model1RawExpanded, 4, 6, 4, 4);
    super.compareTwoDLists(super.model1, super.model1RawExpanded);
    assertFalse(model1.isGameOver());

    super.model1.move(5, 5, 5, 3);
    super.rawExpandedMutateState(super.model1RawExpanded, 5, 5, 5, 3);
    super.compareTwoDLists(super.model1, super.model1RawExpanded);
    assertFalse(model1.isGameOver());

    super.model1.move(5, 2, 5, 4);
    super.rawExpandedMutateState(super.model1RawExpanded, 5, 2, 5, 4);
    super.compareTwoDLists(super.model1, super.model1RawExpanded);
    assertFalse(model1.isGameOver());

    super.model1.move(3, 2, 5, 2);
    super.rawExpandedMutateState(super.model1RawExpanded, 3, 2, 5, 2);
    super.compareTwoDLists(super.model1, super.model1RawExpanded);
    assertFalse(model1.isGameOver());

    super.model1.move(6, 2, 4, 2);
    super.rawExpandedMutateState(super.model1RawExpanded, 6, 2, 4, 2);
    super.compareTwoDLists(super.model1, super.model1RawExpanded);
    assertFalse(model1.isGameOver());

    super.model1.move(1, 2, 3, 2);
    super.rawExpandedMutateState(super.model1RawExpanded, 1, 2, 3, 2);
    super.compareTwoDLists(super.model1, super.model1RawExpanded);
    assertFalse(model1.isGameOver());

    super.model1.move(4, 2, 2, 2);
    super.rawExpandedMutateState(super.model1RawExpanded, 4, 2, 2, 2);
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
    assertEquals(Marble, super.model1.getSlotAt(1, 1));
    assertEquals(Marble, super.model2.getSlotAt(4, 2));

    assertEquals(Marble, super.model1.getSlotAt(1,1));
    assertEquals(Marble, super.model1.getSlotAt(1,5));
    assertEquals(Marble, super.model1.getSlotAt(5,1));
    assertEquals(Marble, super.model1.getSlotAt(5,5));
  }

  @Override
  public void getScore() {
    assertEquals(36, super.model1.getScore());
    assertEquals(276, super.model2.getScore());
    assertEquals(36, super.model3.getScore());
    assertEquals(276, super.model4.getScore());
  }
}
