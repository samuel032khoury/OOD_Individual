import org.junit.Before;
import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;

import static org.junit.Assert.assertEquals;

/**
 * To test instances of MarbleSolitaireTextView.
 */
public class MarbleSolitaireTextViewTest {
  EnglishSolitaireModel model1;
  EnglishSolitaireModel model2;
  MarbleSolitaireTextView view1;
  MarbleSolitaireTextView view2;

  @Before
  public void setUp() throws Exception {
    this.model1 = new EnglishSolitaireModel();
    this.model2 = new EnglishSolitaireModel(7);
    this.view1 = new MarbleSolitaireTextView(this.model1);
    this.view2 = new MarbleSolitaireTextView(this.model2);
  }

  @Test
  public void testToString() {
    String model1ToString = "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O";
    assertEquals(model1ToString, view1.toString());

    String model2ToString = "            O O O O O O O\n"
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
  }
}