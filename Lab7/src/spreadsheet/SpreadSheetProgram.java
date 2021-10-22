package spreadsheet;

import java.io.InputStreamReader;

/**
 * To represent the main program of the {@code SpreadSheet}.
 */
public class SpreadSheetProgram {
  /**
   * To start the program in the command line.
   * @param args arguments parsed to the {@code SpreadSheet}.
   */
  public static void main(String []args) {
    BetterSpreadSheet model = new BetterSparseSpreadSheet();
    Readable rd = new InputStreamReader(System.in);
    Appendable ap = System.out;
    SpreadSheetController controller = new SpreadSheetController(model,rd,ap);
    controller.exe();
  }
}
