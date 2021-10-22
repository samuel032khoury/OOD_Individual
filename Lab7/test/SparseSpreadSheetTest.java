import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.StringReader;
import java.util.ArrayList;

import spreadsheet.BetterSparseSpreadSheet;
import spreadsheet.BetterSpreadSheet;
import spreadsheet.SparseSpreadSheet;
import spreadsheet.SpreadSheet;
import spreadsheet.SpreadSheetController;

/**
 * To test operations on instance of {@link SparseSpreadSheet}.
 */
public class SparseSpreadSheetTest {

  BetterSpreadSheet sheet;
  ArrayList<Interaction> listOfInteraction;
  StringBuilder fakeUserInput;
  StringBuilder expectedOutput;

  StringBuilder actualOutput;

  @Before
  public void setUp() {
    this.sheet = new BetterSparseSpreadSheet();
    this.listOfInteraction = new ArrayList<>();
    this.fakeUserInput = new StringBuilder();
    this.expectedOutput = new StringBuilder();
    this.actualOutput = new StringBuilder();
    this.listOfInteraction.add(prints(true,
            "Welcome to the spreadsheet program!",
            "Supported user instructions are: ",
            "assign-value row-num col-num value (set a cell to a value)",
            "print-value row-num col-num (print the value at a given cell)",
            "bulk-assign fromRow-num fromCol-num toRow-num toCol-num value (set the value for"
            + " the provided region)",
            "menu (Print supported instruction list)",
            "q or quit (quit the program) "));
  }

  @Test
  public void testWelcome() {
    this.listOfInteraction.add(inputs("q"));
    this.parseFakeInputAndExpectedOutput();
    SpreadSheetController controller = this.genController();
    controller.exe();

    String[] expectedOutList = this.expectedOutput.toString().split("\n");
    String[] actualOutList = this.actualOutput.toString().split(System.lineSeparator());
    for (int i = 0; i < expectedOutList.length; i++) {
      assertEquals(expectedOutList[i], actualOutList[i]);
    }
  }

  @Test
  public void testFarewell() {
    this.listOfInteraction.add(inputs("q"));
    this.parseFakeInputAndExpectedOutput();
    this.expectedOutput.append("Type instruction: Thank you for using this program!");
    SpreadSheetController controller = this.genController();
    controller.exe();

    String[] expectedOutList = this.expectedOutput.toString().split(": ");
    String[] actualOutList = this.actualOutput.toString().split(": ");
    assertEquals(expectedOutList[expectedOutList.length - 1],
            actualOutList[actualOutList.length - 1]);
  }

  @Test
  public void testInputForGet() {
    StringBuilder log = new StringBuilder();
    SpreadSheet confirmInputSheet = new ConfirmControllerInput(log);
    confirmInputSheet.get(3, 4);
    assertEquals("row: 3, col: 4", log.toString());
  }

  @Test
  public void testInputForSet() {
    StringBuilder log = new StringBuilder();
    SpreadSheet confirmInputSheet = new ConfirmControllerInput(log);
    confirmInputSheet.set(2, 7, 3.6);
    assertEquals("row: 2, col: 7, value: 3.6", log.toString());
  }

  @Test
  public void testInputForIsEmpty() {
    StringBuilder log = new StringBuilder();
    SpreadSheet confirmInputSheet = new ConfirmControllerInput(log);
    confirmInputSheet.isEmpty(8, 2);
    assertEquals("row: 8, col: 2", log.toString());
  }

  @Test
  public void testBulkInput() {
    this.listOfInteraction.add(inputs("bulk-assign A  1  B  4 100"));
    this.listOfInteraction.add(prints(false, "Type instruction: "));
    char[] rowIndex = new char[] {'A','B'};
    for (char c : rowIndex) {
      for (int j = 1; j < 5; j++) {
        String command = String.format("print-value %c %d", c, j);
        this.listOfInteraction.add(inputs(command));
        this.listOfInteraction.add(prints(true, "Type instruction: Value: 100.0"));
      }
    }
    this.listOfInteraction.add(inputs("q"));
    this.listOfInteraction.add(prints(false, "Type instruction: Thank you for using this "
            + "program!"));

    this.parseFakeInputAndExpectedOutput();
    SpreadSheetController controller = this.genController();
    controller.exe();


    assertEquals(this.expectedOutput.toString(), this.actualOutput.toString());
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
  private static Interaction prints(boolean newline, String... lines) {
    return (input, output) -> {
      for (String line : lines) {
        output.append(line);
        if (newline) {
          output.append(System.lineSeparator());
        }
      }
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
   * Generate a Controller for a {@link SpreadSheetController}, with inputs and destination of out
   * parsed.
   *
   * @return a controller for a {@link SpreadSheetController}, with inputs and destination of out
   *               parsed.
   */
  private SpreadSheetController genController() {
    return new SpreadSheetController(this.sheet, this.genReadable(), this.actualOutput);
  }
}
