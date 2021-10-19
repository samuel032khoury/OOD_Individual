package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * This class visualize the game state of a triangular MarbleSolitaire in a text form.
 */
public class TriangleSolitaireTextView extends AbstractMarbleSolitaireView {
  /**
   * Construct a visualized {@link MarbleSolitaireModelState}, with  the default {@code System.out}
   * as the out destination.
   *
   * @param ms a MarbleSolitaireModelState object
   * @throws IllegalArgumentException when the MarbleSolitaireModelState is null
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState ms) {
    super(ms);
  }

  /**
   * Construct a visualized MarbleSolitaireModelState, with the provided {@code destination} as the
   * out destination.
   *
   * @param ms          a MarbleSolitaireModelState object that is going to be displayed
   * @param destination an Appendable object that is going to be set as the out destination
   * @throws IllegalArgumentException when either the destination or the ms is null
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState ms, Appendable destination)
          throws IllegalArgumentException {
    super(ms, destination);
  }

  /**
   * Return a string that represents the current state of the board. The string should have one line
   * per row of the game board. Each slot on the game board is a single character (O, X or space for
   * a marble, empty and invalid position respectively). Slots in a row should be separated by a
   * space. Each row has no space before the first slot and after the last slot.
   *
   * @return the game state as a string
   */
  @Override
  public String toString() {
    String s = "";
    int height = super.ms.getBoardSize();

    for (int i = 0; i < height; i++) {
      for (int k = 0; k < height - 1 - i; k++) {
        s += " ";
      }
      for (int j = 0; j <= i; j++) {
        MarbleSolitaireModelState.SlotState state = super.ms.getSlotAt(i, j);
        switch (state) {
          case Empty:
            s += "_";
            break;
          case Marble:
            s += "O";
            break;
          default:
            break;
        }
        s += (j == i) ? "" : " ";
      }
      s += (i == height - 1) ? "" : "\n";
    }
    return s;
  }
}
