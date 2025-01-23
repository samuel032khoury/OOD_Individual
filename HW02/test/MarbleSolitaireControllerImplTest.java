import org.junit.Before;
import org.junit.Test;

import java.io.StringReader;
import java.util.ArrayList;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static org.junit.Assert.assertEquals;

/**
 * To test controllers.
 */
public class MarbleSolitaireControllerImplTest {
  private MarbleSolitaireModel model;
  private Appendable actualOutPut;
  private MarbleSolitaireView textView;

  private ArrayList<Interaction> listOfInteraction;
  private StringBuilder fakeUserInput;
  private StringBuilder expectedOutput;


  @Before
  public void setUp() {
    this.model = new EnglishSolitaireModel();
    this.actualOutPut = new StringBuilder();
    this.textView = new MarbleSolitaireTextView(model, actualOutPut);

    this.listOfInteraction = new ArrayList<>();
    this.listOfInteraction.add(prints("    O O O", "    O O O", "O O O O O O O", "O O O _ O O O",
            "O O O O O O O", "    O O O", "    O O O", "Score: 32"));
    this.fakeUserInput = new StringBuilder();
    this.expectedOutput = new StringBuilder();
  }

  /**
   * Generate an input {@link Interaction} that allows tests to parse (fake) user input.
   *
   * @param in the (fake) user input as a String
   * @return an object of an anonymous Interaction subclasses that has the only method of appending
   *               String to the first appendable argument
   */
  private static Interaction inputs(String in) {
    return (input, output) -> input.append(in).append("\n");
  }

  /**
   * Generate a print {@link Interaction} that allows tests to expect the output.
   *
   * @param lines the outputs as a stream of Strings
   * @return an object of an anonymous Interaction subclasses that has the only method of appending
   *               a stream of Strings to the second appendable argument
   */
  private static Interaction prints(String... lines) {
    return (input, output) -> {
      for (String line : lines) {
        output.append(line).append('\n');
      }
    };
  }

  /**
   * Generate a prompt {@link Interaction} that allows tests to simulate responding process.
   *
   * @param prompt   a String of prompt
   * @param response (fake) users input as a String
   * @return an object of an anonymous Interaction subclasses that has the only method of appending
   *               two String to the first and second appendable argument respectfully.
   */
  private static Interaction prompts(String prompt, String response) {
    return (input, output) -> {
      output.append(prompt).append("\n");
      input.append(response).append("\n");
    };
  }

  /**
   * Parse interactions in listOfInteraction to fakeUserInput and expectedOutput, respectfully by
   * the interaction type.
   */
  private void parseFakeInputAndExpectedOutput() {
    for (Interaction interaction : this.listOfInteraction) {
      interaction.apply(this.fakeUserInput, this.expectedOutput);
    }
  }

  /**
   * Generate a readable object that mocks user's input.
   *
   * @return a readable object that mocks user's input
   */
  private Readable genReadable() {
    return new StringReader(this.fakeUserInput.toString());
  }

  /**
   * Generate a Controller for a EnglishSolitaire model and its textview, with inputs parsed.
   *
   * @return a controller for a EnglishSolitaire model and its textview, with inputs parsed.
   */
  private MarbleSolitaireController genController() {
    return new MarbleSolitaireControllerImpl(this.model, this.textView, this.genReadable());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullModelConstructException() {
    new MarbleSolitaireControllerImpl(null, textView, genReadable());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullViewConstructException() {
    new MarbleSolitaireControllerImpl(model, null, genReadable());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullInputConstructException() {
    new MarbleSolitaireControllerImpl(model, textView, null);
  }

  @Test
  public void testOneMoveAndQuitInOneLineThruController() {
    this.listOfInteraction.add(inputs("4 2 4 4 q"));
    this.listOfInteraction.add(prints("    O O O", "    O O O", "O O O O O O O", "O _ _ O O O O",
            "O O O O O O O", "    O O O", "    O O O", "Score: 31"));
    this.listOfInteraction.add(prints("Game quit!", "State of game when quit:", "    O O O",
            "    O O O", "O O O O O O O", "O _ _ O O O O", "O O O O O O O", "    O O O",
            "    O O O", "Score: 31"));

    this.parseFakeInputAndExpectedOutput();
    this.genController().playGame();

    assertEquals(this.expectedOutput.toString(), this.actualOutPut.toString());
  }

  @Test
  public void testMultipleMoveAndQuitThruController() {
    this.listOfInteraction.add(inputs("4 2 4 4 4 5 4 3"));
    this.listOfInteraction.add(prints("    O O O", "    O O O", "O O O O O O O", "O _ _ O O O O",
            "O O O O O O O", "    O O O", "    O O O", "Score: 31"));
    this.listOfInteraction.add(prints("    O O O", "    O O O", "O O O O O O O", "O _ O _ _ O O",
            "O O O O O O O", "    O O O", "    O O O", "Score: 30"));
    this.listOfInteraction.add(inputs("4 7 4 5"));
    this.listOfInteraction.add(prints("    O O O", "    O O O", "O O O O O O O", "O _ O _ O _ _",
            "O O O O O O O", "    O O O", "    O O O", "Score: 29"));
    this.listOfInteraction.add(inputs("q"));
    this.listOfInteraction.add(prints("Game quit!", "State of game when quit:",
            "    O O O", "    O O O", "O O O O O O O", "O _ O _ O _ _", "O O O O O O O",
            "    O O O", "    O O O", "Score: 29"));

    this.parseFakeInputAndExpectedOutput();
    this.genController().playGame();
    assertEquals(this.expectedOutput.toString(), this.actualOutPut.toString());
  }

  @Test
  public void testInvalidMoveErrorMsgAndQuitWithCapQ() {
    this.listOfInteraction.add(inputs("3 3 3 3"));
    this.listOfInteraction.add(prompts("Invalid Move, try again", "4 2 4 4"));
    this.listOfInteraction.add(prints("    O O O", "    O O O", "O O O O O O O", "O _ _ O O O O",
            "O O O O O O O", "    O O O", "    O O O", "Score: 31"));
    this.listOfInteraction.add(inputs("3 3 3 3"));
    this.listOfInteraction.add(prints("Invalid Move, try again"));
    this.listOfInteraction.add(inputs("Q"));
    this.listOfInteraction.add(prints("Game quit!", "State of game when quit:", "    O O O",
            "    O O O", "O O O O O O O", "O _ _ O O O O", "O O O O O O O", "    O O O",
            "    O O O", "Score: 31"));

    this.parseFakeInputAndExpectedOutput();
    this.genController().playGame();
    assertEquals(this.expectedOutput.toString(), this.actualOutPut.toString());
  }

  @Test
  public void testAbruptQuitAtFromRow() {
    this.listOfInteraction.add(inputs("4 2 4 4"));
    this.listOfInteraction.add(prints("    O O O", "    O O O", "O O O O O O O", "O _ _ O O O O",
            "O O O O O O O", "    O O O", "    O O O", "Score: 31"));
    this.listOfInteraction.add(inputs("q 4 5 4 3"));
    this.listOfInteraction.add(prints("Game quit!", "State of game when quit:", "    O O O",
            "    O O O", "O O O O O O O", "O _ _ O O O O", "O O O O O O O", "    O O O",
            "    O O O", "Score: 31"));

    this.parseFakeInputAndExpectedOutput();
    this.genController().playGame();
    assertEquals(this.expectedOutput.toString(), this.actualOutPut.toString());
  }

  @Test
  public void testAbruptQuitAtFromCol() {
    this.listOfInteraction.add(inputs("4 2 4 4"));
    this.listOfInteraction.add(prints("    O O O", "    O O O", "O O O O O O O", "O _ _ O O O O",
            "O O O O O O O", "    O O O", "    O O O", "Score: 31"));
    this.listOfInteraction.add(inputs("4 q 5 4 3"));
    this.listOfInteraction.add(prints("Game quit!", "State of game when quit:", "    O O O",
            "    O O O", "O O O O O O O", "O _ _ O O O O", "O O O O O O O", "    O O O",
            "    O O O", "Score: 31"));

    this.parseFakeInputAndExpectedOutput();
    this.genController().playGame();
    assertEquals(this.expectedOutput.toString(), this.actualOutPut.toString());
  }

  @Test
  public void testAbruptQuitAtToRow() {
    this.listOfInteraction.add(inputs("4 2 4 4"));
    this.listOfInteraction.add(prints("    O O O", "    O O O", "O O O O O O O", "O _ _ O O O O",
            "O O O O O O O", "    O O O", "    O O O", "Score: 31"));
    this.listOfInteraction.add(inputs("4 5 q 4 3"));
    this.listOfInteraction.add(prints("Game quit!", "State of game when quit:", "    O O O",
            "    O O O", "O O O O O O O", "O _ _ O O O O", "O O O O O O O", "    O O O",
            "    O O O", "Score: 31"));

    this.parseFakeInputAndExpectedOutput();
    this.genController().playGame();
    assertEquals(this.expectedOutput.toString(), this.actualOutPut.toString());
  }

  @Test
  public void testAbruptQuitAtToCol() {
    this.listOfInteraction.add(inputs("4 2 4 4"));
    this.listOfInteraction.add(prints("    O O O", "    O O O", "O O O O O O O", "O _ _ O O O O",
            "O O O O O O O", "    O O O", "    O O O", "Score: 31"));
    this.listOfInteraction.add(inputs("4 5 4 q 3"));
    this.listOfInteraction.add(prints("Game quit!", "State of game when quit:", "    O O O",
            "    O O O", "O O O O O O O", "O _ _ O O O O", "O O O O O O O", "    O O O",
            "    O O O", "Score: 31"));

    this.parseFakeInputAndExpectedOutput();
    this.genController().playGame();
    assertEquals(this.expectedOutput.toString(), this.actualOutPut.toString());
  }

  @Test(expected = IllegalStateException.class)
  public void testReadableRunningOutThrowIllegalStateException() {
    this.listOfInteraction.add(inputs("4 2 4 4"));
    this.listOfInteraction.add(prints("    O O O", "    O O O", "O O O O O O O", "O _ _ O O O O",
            "O O O O O O O", "    O O O", "    O O O", "Score: 31"));

    this.parseFakeInputAndExpectedOutput();
    this.genController().playGame();
  }

  @Test
  public void testInvalidInputsBeforeMove() {
    this.listOfInteraction.add(inputs("all these inputs should not be parsed into the controller"));
    this.listOfInteraction.add(inputs("4 2 4 4"));
    this.listOfInteraction.add(prints("    O O O", "    O O O", "O O O O O O O", "O _ _ O O O O",
            "O O O O O O O", "    O O O", "    O O O", "Score: 31"));
    this.listOfInteraction.add(inputs("q"));
    this.listOfInteraction.add(prints("Game quit!", "State of game when quit:", "    O O O",
            "    O O O", "O O O O O O O", "O _ _ O O O O", "O O O O O O O", "    O O O",
            "    O O O", "Score: 31"));

    this.parseFakeInputAndExpectedOutput();
    this.genController().playGame();
    assertEquals(this.expectedOutput.toString(), this.actualOutPut.toString());
  }

  @Test
  public void testIgnoreGibberishAndContinueTheGame() {
    this.listOfInteraction.add(inputs("4 2 w 0 -1  4 thisShouldNotGetIn ! @# $ % ^ & * ( )  4"));
    this.listOfInteraction.add(inputs("q"));
    this.listOfInteraction.add(prints("    O O O", "    O O O", "O O O O O O O", "O _ _ O O O O",
            "O O O O O O O", "    O O O", "    O O O", "Score: 31"));
    this.listOfInteraction.add(prints("Game quit!", "State of game when quit:", "    O O O",
            "    O O O", "O O O O O O O", "O _ _ O O O O", "O O O O O O O", "    O O O",
            "    O O O", "Score: 31"));

    this.parseFakeInputAndExpectedOutput();
    this.genController().playGame();
    assertEquals(this.expectedOutput.toString(), this.actualOutPut.toString());
  }

  @Test
  public void testGameOverWRandomInput() {
    this.listOfInteraction.add(inputs("4 2 4 4"));
    this.listOfInteraction.add(prints("    O O O", "    O O O", "O O O O O O O", "O _ _ O O O O",
            "O O O O O O O", "    O O O", "    O O O", "Score: 31"));
    this.listOfInteraction.add(inputs("4 5 4 3"));
    this.listOfInteraction.add(prints("    O O O", "    O O O", "O O O O O O O", "O _ O _ _ O O",
            "O O O O O O O", "    O O O", "    O O O", "Score: 30"));
    this.listOfInteraction.add(inputs("This line should not do anything"));
    this.listOfInteraction.add(inputs(" 1 2 3 4 5"));
    this.listOfInteraction.add(prompts("Invalid Move, try again", "60 70 80"));
    this.listOfInteraction.add(prompts("Invalid Move, try again", "4 7"));
    this.listOfInteraction.add(inputs("4 5"));
    this.listOfInteraction.add(prints("    O O O", "    O O O", "O O O O O O O", "O _ O _ O _ _",
            "O O O O O O O", "    O O O", "    O O O", "Score: 29"));
    this.listOfInteraction.add(inputs("2 4 4 4 5 4 3 4 7 4 5 4"));
    this.listOfInteraction.add(prints("    O O O", "    O _ O", "O O O _ O O O", "O _ O O O _ _",
            "O O O O O O O", "    O O O", "    O O O", "Score: 28"));
    this.listOfInteraction.add(prints("    O O O", "    O _ O", "O O O O O O O", "O _ O _ O _ _",
            "O O O _ O O O", "    O O O", "    O O O", "Score: 27"));
    this.listOfInteraction.add(prints("Game over!", "    O O O", "    O _ O", "O O O O O O O",
            "O _ O _ O _ _", "O O O O O O O", "    O _ O", "    O _ O", "Score: 26"));


    this.parseFakeInputAndExpectedOutput();
    this.genController().playGame();
    assertEquals(this.expectedOutput.toString(), this.actualOutPut.toString());

  }

  @Test(expected = IllegalStateException.class)
  public void testIllegalStateWhenIOException() {
    this.actualOutPut = new FakeAppendable();
    this.textView = new MarbleSolitaireTextView(model, actualOutPut);

    this.listOfInteraction.add(inputs("4 2 4 4"));
    this.listOfInteraction.add(prints("    O O O", "    O O O", "O O O O O O O", "O _ _ O O O O",
            "O O O O O O O", "    O O O", "    O O O", "Score: 31"));
    this.listOfInteraction.add(inputs("4 5 4 q 3"));
    this.listOfInteraction.add(prints("Game quit!", "State of game when quit:", "    O O O",
            "    O O O", "O O O O O O O", "O _ _ O O O O", "O O O O O O O", "    O O O",
            "    O O O", "Score: 31"));

    this.parseFakeInputAndExpectedOutput();
    this.genController().playGame();
  }

  @Test
  public void testInputs1() {
    this.listOfInteraction.add(inputs("4 2 -1 4 4"));
    this.listOfInteraction.add(inputs("q"));

    this.parseFakeInputAndExpectedOutput();

    StringBuilder log = new StringBuilder();
    this.model = new ConfirmInputModel(log);

    this.genController().playGame();
    assertEquals("fromRow = 3, fromCol = 1, toRow = 3, toCol = 3\n", log.toString());
  }

  @Test
  public void testInputs2() {
    this.listOfInteraction.add(inputs("4 2 q 4 4"));

    this.parseFakeInputAndExpectedOutput();

    StringBuilder log = new StringBuilder();
    this.model = new ConfirmInputModel(log);

    this.genController().playGame();
    assertEquals("", log.toString());
  }

  @Test
  public void testInputs3() {
    this.listOfInteraction.add(inputs("4 2 4 4 should not log this seq -13239487 31 41 51 61"));
    this.listOfInteraction.add(inputs("q"));

    this.parseFakeInputAndExpectedOutput();

    StringBuilder log = new StringBuilder();
    this.model = new ConfirmInputModel(log);

    this.genController().playGame();
    assertEquals("fromRow = 3, fromCol = 1, toRow = 3, toCol = 3\n"
            + "fromRow = 30, fromCol = 40, toRow = 50, toCol = 60\n", log.toString());
  }
}