package cs3500.marblesolitaire.view;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * This class visualize the game state in a text form.
 */
public class MarbleSolitaireTextView implements MarbleSolitaireView {
  private final MarbleSolitaireModelState ms;
  private final Appendable destination;

  /**
   * Construct a visualized MarbleSolitaireModelState, with  the default System.out as the out
   * destination.
   *
   * @param ms a MarbleSolitaireModelState object
   * @throws IllegalArgumentException when the MarbleSolitaireModelState is null
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState ms) throws IllegalArgumentException {
    if (ms == null) {
      throw new IllegalArgumentException();
    }
    this.ms = ms;
    this.destination = System.out;
  }

  /**
   * Construct a visualized MarbleSolitaireModelState, with the provided {@Code destination} as the
   * out destination.
   *
   * @param ms          a MarbleSolitaireModelState object that is going to be displayed
   * @param destination an Appendable object that is going to be set as the out destination
   * @throws IllegalArgumentException when either the destination or the ms is null
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState ms, Appendable destination)
          throws IllegalArgumentException {
    if (ms == null || destination == null) {
      throw new IllegalArgumentException();
    }
    this.ms = ms;
    this.destination = destination;
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

  /**
   * Render the board to the provided data destination. The board should be rendered exactly in the
   * format produced by the toString method above
   *
   * @throws IOException if transmission of the board to the provided data destination fails
   */
  @Override
  public void renderBoard() throws IOException {
    this.destination.append(this.toString());
  }

  /**
   * Render a specific message to the provided data destination.
   *
   * @param message the message to be transmitted
   * @throws IOException if transmission of the board to the provided data destination fails
   */
  @Override
  public void renderMessage(String message) throws IOException {
    this.destination.append(message);
  }
}
