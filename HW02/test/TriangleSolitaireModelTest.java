import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;

import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Empty;
import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Invalid;
import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Marble;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * To test instances of {@link TriangleSolitaireModelTest}.
 */
public class TriangleSolitaireModelTest extends AbstractSolitaireModelTest {

  @Override
  public void setUp() {
    super.model1 = new TriangleSolitaireModel();
    super.model2 = new TriangleSolitaireModel(6);
    super.model3 = new TriangleSolitaireModel(3, 3);
    super.model4 = new TriangleSolitaireModel(6, 4, 3);

    super.model1RawExpanded =
      new MarbleSolitaireModelState.SlotState[][]
          {{Empty, Invalid, Invalid, Invalid, Invalid},
                  {Marble, Marble, Invalid, Invalid, Invalid},
                  {Marble, Marble, Marble, Invalid, Invalid},
                  {Marble, Marble, Marble, Marble, Invalid},
                  {Marble, Marble, Marble, Marble, Marble}};
    super.model2RawExpanded =
      new MarbleSolitaireModelState.SlotState[][]
          {{Empty, Invalid, Invalid, Invalid, Invalid,Invalid},
                  {Marble, Marble, Invalid, Invalid, Invalid,Invalid},
                  {Marble, Marble, Marble, Invalid, Invalid,Invalid},
                  {Marble, Marble, Marble, Marble, Invalid,Invalid},
                  {Marble, Marble, Marble, Marble, Marble,Invalid},
                  {Marble, Marble, Marble, Marble, Marble,Marble}};
    super.model3RawExpanded =
      new MarbleSolitaireModelState.SlotState[][]
          {{Marble, Invalid, Invalid, Invalid, Invalid},
                  {Marble, Marble, Invalid, Invalid, Invalid},
                  {Marble, Marble, Marble, Invalid, Invalid},
                  {Marble, Marble, Marble, Empty, Invalid},
                  {Marble, Marble, Marble, Marble, Marble}};
    super.model4RawExpanded =
      new MarbleSolitaireModelState.SlotState[][]
          {{Marble, Invalid, Invalid, Invalid, Invalid,Invalid},
                  {Marble, Marble, Invalid, Invalid, Invalid,Invalid},
                  {Marble, Marble, Marble, Invalid, Invalid,Invalid},
                  {Marble, Marble, Marble, Marble, Invalid,Invalid},
                  {Marble, Marble, Marble, Empty, Marble,Invalid},
                  {Marble, Marble, Marble, Marble, Marble,Marble}};
  }

  @Override
  public void constructExceptionOneArgsNegativeBoardSize() {
    new TriangleSolitaireModel(-3);
  }

  @Override
  public void constructExceptionOneArgsBoardTooSmall() {
    new TriangleSolitaireModel(1);
  }

  @Override
  public void constructExceptionTwoArgsImpossibleEmptySlot() {
    new TriangleSolitaireModel(3,5);
  }

  @Override
  public void constructExceptionThreeArgsImpossibleEmptySlot() {
    new TriangleSolitaireModel(10, 0, 100);
  }

  @Override
  public void constructExceptionThreeArgsNegativeBoardSize() {
    new TriangleSolitaireModel(-3, 0, 0);
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
    super.model1.move(2, 0, 0, 0);
    super.model1.move(2, 2, 2, 0);
    super.model1.move(4, 4, 2, 2);
    super.model1.move(4, 2, 4, 4);
    super.model1.move(4, 0, 4, 2);

    //to test an exception caused by the empty from slot
    assertTrue(super.moveExceptionAssertMessage(super.model1, 4, 1, 4, 3,
            super.invalidMoveExceptionMessage, super.invalidMoveFailMessage));
    // to test from slot and to slot are the same
    assertTrue(super.moveExceptionAssertMessage(super.model1, 3, 2, 3, 2,
            super.invalidMoveExceptionMessage, super.invalidMoveFailMessage));
    //to test an exception caused by too-short move distance (move to the adjacent instead of
    // jumping over the adjacent)
    assertTrue(super.moveExceptionAssertMessage(super.model1, 3, 2, 3, 3,
            super.invalidMoveExceptionMessage, super.invalidMoveFailMessage));
    //to test an exception caused by too-long horizontal move distance
    assertTrue(super.moveExceptionAssertMessage(super.model1, 3, 0, 3, 3,
            super.invalidMoveExceptionMessage, super.invalidMoveFailMessage));
    //to test an exception caused by too-long vertical move distance
    assertTrue(super.moveExceptionAssertMessage(super.model1, 0, 0, 4, 0,
            super.invalidMoveExceptionMessage, super.invalidMoveFailMessage));
    // to test an exception caused by the occupied to slot
    assertTrue(super.moveExceptionAssertMessage(super.model1, 3, 0, 3, 3,
            super.invalidMoveExceptionMessage, super.invalidMoveFailMessage));
    // to test an exception caused by the impossible path of a move (no marble between to jump over)
    assertTrue(super.moveExceptionAssertMessage(super.model1, 4, 2, 4, 0,
            super.invalidMoveExceptionMessage, super.invalidMoveFailMessage));
    // to test an exception caused by jumping to an invalid position
    assertTrue(super.moveExceptionAssertMessage(super.model1, 3, 2, 1, 2,
            super.invalidMoveExceptionMessage, super.invalidMoveFailMessage));
    // to test an exception caused by jumping from an invalid position
    assertTrue(super.moveExceptionAssertMessage(super.model1, 2, 3, 2, 1,
            super.invalidMoveExceptionMessage, super.invalidMoveFailMessage));
    // to test an exception caused by a diagonal move
    assertTrue(super.moveExceptionAssertMessage(super.model1, 3, 2, 2, 1,
            super.invalidMoveExceptionMessage, super.invalidMoveFailMessage));
    // to test an exception caused by a diagonal long jump
    assertTrue(super.moveExceptionAssertMessage(super.model1, 0, 0, 3, 3,
            super.invalidMoveExceptionMessage, super.invalidMoveFailMessage));
    // to test an exception caused by a (visually) flatter / rightTop-leftBottom diagonal jump
    assertTrue(super.moveExceptionAssertMessage(super.model1, 2, 2, 4, 0,
            super.invalidMoveExceptionMessage, super.invalidMoveFailMessage));
  }

  @Override
  public void moveANDisGameOver() {

    super.model1.move(2, 0, 0, 0);
    super.rawExpandedMutateState(super.model1RawExpanded, 2, 0, 0, 0);
    super.compareTwoDLists(super.model1, super.model1RawExpanded);
    assertFalse(super.model1.isGameOver());

    super.model1.move(2, 2, 2, 0);
    super.rawExpandedMutateState(super.model1RawExpanded, 2, 2, 2, 0);
    super.compareTwoDLists(super.model1, super.model1RawExpanded);
    assertFalse(super.model1.isGameOver());

    super.model1.move(4, 4, 2, 2);
    super.rawExpandedMutateState(super.model1RawExpanded, 4, 4, 2, 2);
    super.compareTwoDLists(super.model1, super.model1RawExpanded);
    assertFalse(super.model1.isGameOver());

    super.model1.move(4, 2, 4, 4);
    super.rawExpandedMutateState(super.model1RawExpanded, 4, 2, 4, 4);
    super.compareTwoDLists(super.model1, super.model1RawExpanded);
    assertFalse(super.model1.isGameOver());

    super.model1.move(4, 0, 4, 2);
    super.rawExpandedMutateState(super.model1RawExpanded, 4, 0, 4, 2);
    super.compareTwoDLists(super.model1, super.model1RawExpanded);
    assertFalse(super.model1.isGameOver());

    super.model1.move(1, 1, 3, 3);
    super.rawExpandedMutateState(super.model1RawExpanded, 1, 1, 3, 3);
    super.compareTwoDLists(super.model1, super.model1RawExpanded);
    assertFalse(super.model1.isGameOver());

    super.model1.move(4, 2, 2, 2);
    super.rawExpandedMutateState(super.model1RawExpanded, 4, 2, 2, 2);
    super.compareTwoDLists(super.model1, super.model1RawExpanded);
    assertFalse(super.model1.isGameOver());

    super.model1.move(3, 0, 3, 2);
    super.rawExpandedMutateState(super.model1RawExpanded, 3, 0, 3, 2);
    super.compareTwoDLists(super.model1, super.model1RawExpanded);
    assertFalse(super.model1.isGameOver());

    super.model1.move(3, 3, 1, 1);
    super.rawExpandedMutateState(super.model1RawExpanded, 3, 3, 1, 1);
    super.compareTwoDLists(super.model1, super.model1RawExpanded);
    assertFalse(super.model1.isGameOver());

    super.model1.move(0, 0, 2, 2);
    super.rawExpandedMutateState(super.model1RawExpanded, 0, 0, 2, 2);
    super.compareTwoDLists(super.model1, super.model1RawExpanded);
    assertFalse(super.model1.isGameOver());

    super.model1.move(2, 2, 4, 2);
    super.rawExpandedMutateState(super.model1RawExpanded, 2, 2, 4, 2);
    super.compareTwoDLists(super.model1, super.model1RawExpanded);
    assertTrue(super.model1.isGameOver());
  }

  @Override
  public void getBoardSize() {
    assertEquals(5, super.model1.getBoardSize());
    assertEquals(6, super.model2.getBoardSize());
    assertEquals(5, super.model3.getBoardSize());
    assertEquals(6, super.model4.getBoardSize());
  }

  @Override
  public void getSlotAt() {
    assertEquals(Invalid, super.model1.getSlotAt(0, 4));
    assertEquals(Invalid, super.model2.getSlotAt(1, 5));
    assertEquals(Empty, super.model1.getSlotAt(0, 0));
    assertEquals(Empty, super.model2.getSlotAt(0, 0));
    assertEquals(Marble, super.model1.getSlotAt(1, 1));
    assertEquals(Marble, super.model2.getSlotAt(4, 2));
  }

  @Override
  public void getScore() {
    assertEquals(14, super.model1.getScore());
    assertEquals(20, super.model2.getScore());
    assertEquals(14, super.model3.getScore());
    assertEquals(20, super.model4.getScore());
  }
}
