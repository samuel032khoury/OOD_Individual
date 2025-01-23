package spreadsheet;

import java.io.IOException;
import java.util.Scanner;

/**
 * This class represents the controller of an interactive spreadsheet application.
 * This controller offers a simple text interface in which the user can
 * type instructions to manipulate a spreadsheet.
 *
 * <p>This controller works with any Readable to read its inputs and
 * any Appendable to transmit output. This controller directly uses
 * the Appendable object (i.e. there is no official "view")
 *
 * <p>A cell in the spreadsheet is referred to using a row-letter and a column number.
 * The row letter starts from A-Z and then AA-ZZ, then AAA-ZZZ and so on.
 * The column numbers begin with 1.
 *
 * <p>For example, the cell in the first row and column is A 1.
 * The cell in the 30th row and 26th column is AD 26.
 *
 * <p>In this way it tries to simulate how Microsoft Excel works (except that
 * it uses letters for rows, not columns).
 */
public class SpreadSheetController {
  private Readable readable;
  private Appendable appendable;
  private BetterSpreadSheet sheet;

  /**
   * To construct a {@SpreadSheetController}.
   *
   * @param sheet the {@link SparseSpreadSheet} model
   * @param readable input parsed to the model
   * @param appendable destination of output
   */
  public SpreadSheetController(BetterSpreadSheet sheet,Readable readable,Appendable appendable) {
    if ((sheet == null) || (readable == null) || (appendable == null)) {
      throw new IllegalArgumentException("Sheet, readable or appendable is null");
    }
    this.sheet = sheet;
    this.appendable = appendable;
    this.readable = readable;
  }

  /**
   * To execute the program.
   * @throws IllegalStateException when a I/O exception is thrown
   */
  public void exe() throws IllegalStateException {
    Scanner sc = new Scanner(readable);
    boolean quit = false;
    int row;
    int col;
    double value;

    //print the welcome message
    this.welcomeMessage();

    while (!quit) { //continue until the user quits
      writeMessage("Type instruction: "); //prompt for the instruction name
      String userInstruction = sc.next(); //take an instruction name
      switch (userInstruction) {
        case "assign-value": //assign a value to a cell
          try {
            row = getRowNum(sc.next()); //get in the row string
            col = sc.nextInt(); //get in the column number, starting with 1
            sheet.set(row,col - 1,sc.nextDouble()); //use the spreadsheet
          }
          catch (IllegalArgumentException e) {
            writeMessage("Error: " + e.getMessage() + System.lineSeparator());
          }
          break;
        case "print-value": //print a value from the cell
          try {
            row = getRowNum(sc.next()); //get the row string
            col = sc.nextInt(); //get the column number, starting with 1
            writeMessage("Value: " + sheet.get(row,col - 1) + System.lineSeparator());
          }
          catch (IllegalArgumentException e) {
            writeMessage("Error: " + e.getMessage() + System.lineSeparator());
          }
          break;
        case "bulk-assign":
          try {
            int fromRow;
            int toRow;
            int fromCol;
            int toCol;
            fromRow = getRowNum(sc.next()); //get in the {@code from row} string
            toRow = sc.nextInt(); //get in the {@code from column} number, starting with 1
            fromCol = getRowNum(sc.next()); //get in the {@code to row} string
            toCol = sc.nextInt(); //get in the {@code to column} number, starting with 1
            value = sc.nextDouble();
            sheet.massSet(fromRow,fromCol - 1,toRow,toCol - 1, value);
          }
          catch (IllegalArgumentException e) {
            writeMessage("Error: " + e.getMessage() + System.lineSeparator());
          }
          break;
        case "menu": //print the menu of supported instructions
          welcomeMessage();
          break;

        case "q": //quit
        case "quit": //quit
          quit = true;
          break;
        default: //error due to unrecognized instruction
          writeMessage("Undefined instruction: " + userInstruction + System.lineSeparator());
      }
    }

    //after the user has quit, print farewell message
    this.farewellMessage();

  }

  //converts a row string into a row number starting with 0
  private int getRowNum(String rowLetters) throws IllegalArgumentException {
    int rowNumber = 0;

    for (int i = rowLetters.length() - 1;i >= 0;i = i - 1) {
      char c = rowLetters.charAt(i);
      if (!Character.isAlphabetic(c)) {
        throw new IllegalArgumentException("Invalid row");
      }
      rowNumber = 26 * rowNumber + ((int)Character.toLowerCase(c) - 'a');
    }
    return rowNumber;
  }


  private void writeMessage(String message) throws IllegalStateException {
    try {
      appendable.append(message);

    }
    catch (IOException e) {
      throw new IllegalStateException(e.getMessage());
    }
  }

  private void printMenu() throws IllegalStateException {
    writeMessage("Supported user instructions are: " + System.lineSeparator());
    writeMessage("assign-value row-num col-num value (set a cell to a value)"
            + System.lineSeparator());
    writeMessage("print-value row-num col-num (print the value at a given cell)"
            + System.lineSeparator());
    writeMessage("bulk-assign fromRow-num fromCol-num toRow-num toCol-num value (set the value for"
            + " the provided region)" + System.lineSeparator());
    writeMessage("menu (Print supported instruction list)" + System.lineSeparator());
    writeMessage("q or quit (quit the program) " + System.lineSeparator());
  }

  private void welcomeMessage() throws IllegalStateException {
    writeMessage("Welcome to the spreadsheet program!"  + System.lineSeparator());
    printMenu();
  }

  private void farewellMessage() throws IllegalStateException {
    writeMessage("Thank you for using this program!");
  }




}
