package cs3500.marblesolitaire.view;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * This abstract class represents operations that should be offered by a view for the Marble
 * solitaire game.
 */
public abstract class AbstractMarbleSolitaireView implements MarbleSolitaireView {
  protected final MarbleSolitaireModelState ms;
  protected final Appendable destination;

  /**
   * Construct a visualized MarbleSolitaireModelState, with the default {@code System.out} as the
   * out destination.
   *
   * @param ms a MarbleSolitaireModelState object
   * @throws IllegalArgumentException when the MarbleSolitaireModelState is null
   */
  public AbstractMarbleSolitaireView(MarbleSolitaireModelState ms)
          throws IllegalArgumentException {
    if (ms == null) {
      throw new IllegalArgumentException();
    }
    this.ms = ms;
    this.destination = System.out;
  }

  /**
   * Construct a visualized MarbleSolitaireModelState, with the provided {@code destination} as the
   * out destination.
   *
   * @param ms          a MarbleSolitaireModelState object that is going to be displayed
   * @param destination an Appendable object that is going to be set as the out destination
   * @throws IllegalArgumentException when either the destination or the ms is null
   */
  public AbstractMarbleSolitaireView(MarbleSolitaireModelState ms, Appendable destination)
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
  public abstract String toString();

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
