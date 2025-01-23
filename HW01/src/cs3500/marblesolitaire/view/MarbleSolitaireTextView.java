package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * This class visualize the game state in a text form.
 */
public class MarbleSolitaireTextView implements MarbleSolitaireView {
  private MarbleSolitaireModelState ms;

  /**
   * Construct an instance of Marble Solitaire going to be visualized.
   *
   * @param ms a marble solitaire model object
   * @throws IllegalArgumentException when the argument is null
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState ms) throws IllegalArgumentException {
    if (ms == null) {
      throw new IllegalArgumentException();
    }
    this.ms = ms;
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
    int sideLength = this.ms.getBoardSize();
    int head = (sideLength + 2) / 3 - 1;
    int tail = 2 * head;
    for (int i = 0; i < sideLength; i++) {
      for (int j = 0; j < sideLength; j++) {
        MarbleSolitaireModelState.SlotState state = ms.getSlotAt(i, j);
        switch (state) {
          case Empty:
            s += "_";
            break;
          case Marble:
            s += "O";
            break;
          default:
            s += (j > tail) ? "" : " ";
            break;
        }
        s += (i < head && j >= tail || i > tail && j >= tail || j == sideLength - 1) ? "" : " ";
      }
      s += (i == sideLength - 1) ? "" : "\n";
    }
    return s;
  }

}