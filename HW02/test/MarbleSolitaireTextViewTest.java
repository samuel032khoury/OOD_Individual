import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

import static org.junit.Assert.assertEquals;

/**
 * To test instances of MarbleSolitaireTextView.
 */
public class MarbleSolitaireTextViewTest {
  private MarbleSolitaireModel englishModel;
  private MarbleSolitaireModel europeanModel;
  private MarbleSolitaireModel triangleModel;

  private MarbleSolitaireView englishView;
  private MarbleSolitaireView europeanView;
  private MarbleSolitaireView triangleView;

  private MarbleSolitaireView biggerEnglishView;
  private MarbleSolitaireView biggerEuropeanView;
  private MarbleSolitaireView biggerTriangleView;

  private MarbleSolitaireView customizedEmptyEnglishView;
  private MarbleSolitaireView customizedEmptyTriangleView;

  Appendable outputStringBuilder;
  private MarbleSolitaireView viewWithStringBuilder;

  @Before
  public void setUp() {
    this.englishModel = new EnglishSolitaireModel();
    this.europeanModel = new EuropeanSolitaireModel();
    this.triangleModel = new TriangleSolitaireModel();

    this.englishView = new MarbleSolitaireTextView(this.englishModel);
    this.europeanView = new MarbleSolitaireTextView(this.europeanModel);
    this.triangleView = new TriangleSolitaireTextView(this.triangleModel);

    MarbleSolitaireModel biggerEnglishModel = new EnglishSolitaireModel(7);
    MarbleSolitaireModel biggerEuropeanModel = new EuropeanSolitaireModel(7);
    MarbleSolitaireModel biggerTriangleModel = new TriangleSolitaireModel(7);

    this.biggerEnglishView = new MarbleSolitaireTextView(biggerEnglishModel);
    this.biggerEuropeanView = new MarbleSolitaireTextView(biggerEuropeanModel);
    this.biggerTriangleView = new TriangleSolitaireTextView(biggerTriangleModel);

    MarbleSolitaireModel customizedEmptyEnglishModel = new EnglishSolitaireModel(4, 2);
    MarbleSolitaireModel customizedEmptyTriangleModel = new TriangleSolitaireModel(3, 3);

    this.customizedEmptyEnglishView = new MarbleSolitaireTextView(customizedEmptyEnglishModel);
    this.customizedEmptyTriangleView =
            new TriangleSolitaireTextView(customizedEmptyTriangleModel);

    this.outputStringBuilder = new StringBuilder();
    this.viewWithStringBuilder = new MarbleSolitaireTextView(this.englishModel,
            outputStringBuilder);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructException1() {
    new MarbleSolitaireTextView(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructException2() {
    new MarbleSolitaireTextView(englishModel, null);
  }

  @Test
  public void testToString() {
    String englishModelToString =
            "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O _ O O O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O";
    assertEquals(englishModelToString, englishView.toString());

    englishModel.move(3, 1, 3, 3);
    String englishModelToStringAfterMove =
            "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O _ _ O O O O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O";
    assertEquals(englishModelToStringAfterMove, englishView.toString());

    String europeanModelToString =
            "    O O O\n"
          + "  O O O O O\n"
          + "O O O O O O O\n"
          + "O O O _ O O O\n"
          + "O O O O O O O\n"
          + "  O O O O O\n"
          + "    O O O";
    assertEquals(europeanModelToString, europeanView.toString());

    europeanModel.move(3, 1, 3, 3);
    String europeanModelToStringAfterMove =
            "    O O O\n"
          + "  O O O O O\n"
          + "O O O O O O O\n"
          + "O _ _ O O O O\n"
          + "O O O O O O O\n"
          + "  O O O O O\n"
          + "    O O O";
    assertEquals(europeanModelToStringAfterMove, europeanView.toString());

    String triangleModelToString =
            "    _\n"
          + "   O O\n"
          + "  O O O\n"
          + " O O O O\n"
          + "O O O O O";
    assertEquals(triangleModelToString, triangleView.toString());

    triangleModel.move(2, 0, 0, 0);
    String triangleModelToStringAfterMove =
            "    O\n"
          + "   _ O\n"
          + "  _ O O\n"
          + " O O O O\n"
          + "O O O O O";
    assertEquals(triangleModelToStringAfterMove, triangleView.toString());

    String biggerEnglishViewToString =
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
    assertEquals(biggerEnglishViewToString, biggerEnglishView.toString());

    String biggerEuropeanModelToString =
            "            O O O O O O O\n"
          + "          O O O O O O O O O\n"
          + "        O O O O O O O O O O O\n"
          + "      O O O O O O O O O O O O O\n"
          + "    O O O O O O O O O O O O O O O\n"
          + "  O O O O O O O O O O O O O O O O O\n"
          + "O O O O O O O O O O O O O O O O O O O\n"
          + "O O O O O O O O O O O O O O O O O O O\n"
          + "O O O O O O O O O O O O O O O O O O O\n"
          + "O O O O O O O O O _ O O O O O O O O O\n"
          + "O O O O O O O O O O O O O O O O O O O\n"
          + "O O O O O O O O O O O O O O O O O O O\n"
          + "O O O O O O O O O O O O O O O O O O O\n"
          + "  O O O O O O O O O O O O O O O O O\n"
          + "    O O O O O O O O O O O O O O O\n"
          + "      O O O O O O O O O O O O O\n"
          + "        O O O O O O O O O O O\n"
          + "          O O O O O O O O O\n"
          + "            O O O O O O O";
    assertEquals(biggerEuropeanModelToString, biggerEuropeanView.toString());

    String biggerTriangleModelToString =
            "      _\n"
          + "     O O\n"
          + "    O O O\n"
          + "   O O O O\n"
          + "  O O O O O\n"
          + " O O O O O O\n"
          + "O O O O O O O";
    assertEquals(biggerTriangleModelToString, biggerTriangleView.toString());


    String customizedEmptyEnglishModelToString =
            "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O O O O O\n"
          + "O O _ O O O O\n"
          + "    O O O\n"
          + "    O O O";
    assertEquals(customizedEmptyEnglishModelToString, customizedEmptyEnglishView.toString());

    String customizedEmptyTriangleModelToString =
            "    O\n"
          + "   O O\n"
          + "  O O O\n"
          + " O O O _\n"
          + "O O O O O";
    assertEquals(customizedEmptyTriangleModelToString, customizedEmptyTriangleView.toString());
  }


  @Test
  public void testRenderMessage() {
    try {
      this.viewWithStringBuilder.renderMessage("Invalid Move, try again\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    StringBuilder expectedStringBuilder = new StringBuilder();
    expectedStringBuilder.append("Invalid Move, try again\n");
    assertEquals(expectedStringBuilder.toString(), this.outputStringBuilder.toString());
    try {
      this.viewWithStringBuilder.renderMessage("Game quit!\n");
      this.viewWithStringBuilder.renderMessage("State of game when quit:\n");
      this.viewWithStringBuilder.renderMessage("Score: 30");
    } catch (IOException e) {
      e.printStackTrace();
    }
    expectedStringBuilder.append("Game quit!\n");
    expectedStringBuilder.append("State of game when quit:\n");
    expectedStringBuilder.append("Score: 30");
    assertEquals(expectedStringBuilder.toString(), this.outputStringBuilder.toString());
  }

  @Test
  public void testRenderBoardToStringBuilder() {
    try {
      this.viewWithStringBuilder.renderBoard();
    } catch (IOException e) {
      e.printStackTrace();
    }

    StringBuilder expectedStringBuilder = new StringBuilder();
    expectedStringBuilder.append("    O O O\n"
                               + "    O O O\n"
                               + "O O O O O O O\n"
                               + "O O O _ O O O\n"
                               + "O O O O O O O\n"
                               + "    O O O\n"
                               + "    O O O");
    assertEquals(expectedStringBuilder.toString(), this.outputStringBuilder.toString());
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

    StringBuilder expectedStringBuilder = new StringBuilder();
    expectedStringBuilder.append("    O O O\n"
                               + "    O O O\n"
                               + "O O O O O O O\n"
                               + "O O O _ O O O\n"
                               + "O O O O O O O\n"
                               + "    O O O\n"
                               + "    O O O");
    expectedStringBuilder.append("\n");
    expectedStringBuilder.append("Input index to play");
    assertEquals(expectedStringBuilder.toString(), this.outputStringBuilder.toString());

    this.englishModel.move(3, 1, 3, 3);
    try {
      this.viewWithStringBuilder.renderBoard();
      this.viewWithStringBuilder.renderMessage("\n");
      this.viewWithStringBuilder.renderMessage("You moved one step!");
    } catch (IOException e) {
      e.printStackTrace();
    }
    expectedStringBuilder.append("    O O O\n"
                               + "    O O O\n"
                               + "O O O O O O O\n"
                               + "O _ _ O O O O\n"
                               + "O O O O O O O\n"
                               + "    O O O\n"
                               + "    O O O");
    expectedStringBuilder.append("\n");
    expectedStringBuilder.append("You moved one step!");
    assertEquals(expectedStringBuilder.toString(), this.outputStringBuilder.toString());
  }
}