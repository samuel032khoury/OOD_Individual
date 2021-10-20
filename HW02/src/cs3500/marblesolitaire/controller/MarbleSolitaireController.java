package cs3500.marblesolitaire.controller;

/**
 * To represent the controller of the MarbleSolitaire game, aiming to connect the model and the
 * view. Users can play a game by parse inputs after calling {@link #playGame}. The game playing
 * depends on specific implementations.
 */
public interface MarbleSolitaireController {
  /**
   * To (start) play a new game of Marble Solitaire.
   *
   * @throws IllegalStateException when the controller is unable to successfully read input or
   *                                     transmit output
   */
  void playGame() throws IllegalStateException;
}