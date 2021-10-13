import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;

import static org.junit.Assert.assertEquals;

/**
 * To test instances of MarbleSolitaireTextView.
 */
public class MarbleSolitaireTextViewTest {
  private EnglishSolitaireModel model1;
  private MarbleSolitaireTextView view1;
  private MarbleSolitaireTextView view2;
  private MarbleSolitaireTextView customizedEmptyModel;

  Appendable outputForViewWSB;
  private MarbleSolitaireTextView viewWithStringBuilder;

  @Before
  public void setUp() {
    this.model1 = new EnglishSolitaireModel();
    this.view1 = new MarbleSolitaireTextView(this.model1);
    this.view2 = new MarbleSolitaireTextView(new EnglishSolitaireModel(7));
    this.customizedEmptyModel = new MarbleSolitaireTextView(new EnglishSolitaireModel(3, 4, 2));

    this.outputForViewWSB = new StringBuilder();
    this.viewWithStringBuilder = new MarbleSolitaireTextView(this.model1, outputForViewWSB);
  }
  //TODO: testRenderMessage
  //TODO: testRenderBoard

  @Test(expected = IllegalArgumentException.class)
  public void testConstructException1() {
    new MarbleSolitaireTextView(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructException2() {
    new MarbleSolitaireTextView(model1, null);
  }

  @Test
  public void testToString() {
    String model1ToString =
            "    O O O\n"
                    + "    O O O\n"
                    + "O O O O O O O\n"
                    + "O O O _ O O O\n"
                    + "O O O O O O O\n"
                    + "    O O O\n"
                    + "    O O O";
    assertEquals(model1ToString, view1.toString());

    model1.move(3, 1, 3, 3);
    String model1ToStringAfterMove =
            "    O O O\n"
                    + "    O O O\n"
                    + "O O O O O O O\n"
                    + "O _ _ O O O O\n"
                    + "O O O O O O O\n"
                    + "    O O O\n"
                    + "    O O O";
    assertEquals(model1ToStringAfterMove, view1.toString());


    String model2ToString =
            "            O O O O O O O\n"
                    + "            O O O O O O O\n"
                    + "            O O O O O O O\n"
                    + "            O O O O O O O\n"
                    + "            O O O O O O O\n"
                    + "            O O O O O O O\n"
                    + "O O O O O O O O O O O O O O O O O O O\n"
                    + "O O O O O O O O O O O O O O O O O O O\n"
                    + "O O O O O O O O O O O O O O O O O O O\n"
                    + "O O O O O O O O O _ O O O O O O O O O\n"
                    + "O O O O O O O O O O O O O O O O O O O\n"
                    + "O O O O O O O O O O O O O O O O O O O\n"
                    + "O O O O O O O O O O O O O O O O O O O\n"
                    + "            O O O O O O O\n"
                    + "            O O O O O O O\n"
                    + "            O O O O O O O\n"
                    + "            O O O O O O O\n"
                    + "            O O O O O O O\n"
                    + "            O O O O O O O";
    assertEquals(model2ToString, view2.toString());


    String customizedEmptyModelToString =
            "    O O O\n"
                    + "    O O O\n"
                    + "O O O O O O O\n"
                    + "O O O O O O O\n"
                    + "O O _ O O O O\n"
                    + "    O O O\n"
                    + "    O O O";
    assertEquals(customizedEmptyModelToString, customizedEmptyModel.toString());
  }


  @Test
  public void testRenderMessage() {
    try {
      this.viewWithStringBuilder.renderMessage("Invalid Move, try again\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    StringBuilder expectedSb1 = new StringBuilder();
    expectedSb1.append("Invalid Move, try again\n");
    assertEquals(expectedSb1.toString(), this.outputForViewWSB.toString());
    try {
      this.viewWithStringBuilder.renderMessage("Game quit!\n");
      this.viewWithStringBuilder.renderMessage("State of game when quit:\n");
      this.viewWithStringBuilder.renderMessage("Score: 30");
    } catch (IOException e) {
      e.printStackTrace();
    }
    expectedSb1.append("Game quit!\n");
    expectedSb1.append("State of game when quit:\n");
    expectedSb1.append("Score: 30");
  }

  @Test
  public void testRenderBoard() {
    try {
      this.viewWithStringBuilder.renderBoard();
    } catch (IOException e) {
      e.printStackTrace();
    }

    StringBuilder expectedSb2 = new StringBuilder();
    expectedSb2.append("    O O O\n    O O O\nO O O O O O O\nO O O _ O O O\nO O O O O O O\n    O"
            + " O O\n    O O O");
    assertEquals(expectedSb2.toString(), this.outputForViewWSB.toString());
  }


  @Test
  public void testRenderMsgAndBoard() {
    try {
      this.viewWithStringBuilder.renderBoard();
      this.viewWithStringBuilder.renderMessage("\n");
      this.viewWithStringBuilder.renderMessage("Input index to play");
    } catch (IOException e) {
      e.printStackTrace();
    }

    StringBuilder expectedSb3 = new StringBuilder();
    expectedSb3.append("    O O O\n    O O O\nO O O O O O O\nO O O _ O O O\nO O O O O O O\n    O"
            + " O O\n    O O O");
    expectedSb3.append("\n");
    expectedSb3.append("Input index to play");
    assertEquals(expectedSb3.toString(), this.outputForViewWSB.toString());

    this.model1.move(3, 1, 3, 3);
    try {
      this.viewWithStringBuilder.renderBoard();
      this.viewWithStringBuilder.renderMessage("\n");
      this.viewWithStringBuilder.renderMessage("You moved one step!");
    } catch (IOException e) {
      e.printStackTrace();
    }
    expectedSb3.append("    O O O\n    O O O\nO O O O O O O\nO _ _ O O O O\nO O O O O O O\n    O"
            + " O O\n    O O O");
    expectedSb3.append("\n");
    expectedSb3.append("You moved one step!");
    assertEquals(expectedSb3.toString(), this.outputForViewWSB.toString());

  }
}