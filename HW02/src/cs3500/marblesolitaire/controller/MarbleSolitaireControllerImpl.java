package cs3500.marblesolitaire.controller;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Scanner;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

/**
 * To represent a controller of marble solitaire. User can parse input to the model and receive the
 * view generated by visualizer (view package).
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {
  private final MarbleSolitaireModel model;
  private final MarbleSolitaireView view;
  private final Readable input;
  private boolean invMove;

  /**
   * To construct a new MarbleSolitaire Controller.
   *
   * @param model the model that this controller uses
   * @param view  the destination of the output created each state of the game
   * @param input the input players parse in
   * @throws IllegalArgumentException when any of the arguments is null
   */
  public MarbleSolitaireControllerImpl(MarbleSolitaireModel model, MarbleSolitaireView view,
                                       Readable input) throws IllegalArgumentException {
    if (model == null || view == null || input == null) {
      throw new IllegalArgumentException();
    }
    this.model = model;
    this.view = view;
    this.input = input;
    this.invMove = false;
  }

  /**
   * To (start) play a new game of Marble Solitaire.
   * In this game, every four inputs will be grouped as the indices (1-based) of the "fromRow",
   * "fromCol", "toRow" and "toCol" and the game will move marbles according to these inputs.
   * Inputs must either be positive integers to move marbles or "q"(or "Q") to quit the game.
   * Otherwise, the game will ignore the inputs. The visualized board of each round will be
   * displayed after the entry of inputs, along with some informative information.
   * The game will end if there's no more marble can be moved, or no more inputs can proceed the
   * game, which will also complains through a IllegalStateException.
   *
   * @throws IllegalStateException Either when there's no more inputs can proceed the game or when
   *                                     the controller is unable to successfully read input or
   *                                     transmit output
   */
  @Override
  public void playGame() throws IllegalStateException {
    Scanner s = new Scanner(input);
    ArrayDeque<Integer> moveSteps = new ArrayDeque<>();

    while (!this.model.isGameOver()) {
      if (!this.invMove) {
        this.formatOut();
      }
      while (moveSteps.size() < 4) {

        if (!s.hasNext()) {
          throw new IllegalStateException();
        }
        String next = s.next();
        try {
          if (Integer.parseInt(next) > 0) {
            moveSteps.offer(Integer.parseInt(next));
          }
        } catch (NumberFormatException e) {
          if (next.equals("q") || next.equals("Q")) {
            this.invMove = false;
            this.formatOut("Game quit!", "State of game when quit:");
            return;
          }
        }
      }
      this.tryMove(moveSteps);
    }
    this.formatOut("Game over!");
  }

  /**
   * Try executing a move operation for model, by the queue of the coordinates of from slot and to
   * slot, if move fails flip the invMove to true indicating the failure.
   * @param moveSteps a queue of guaranteed size of 4 consisting indices of "fromrow", "fromfol",
   *                        "torow", "tocol" in order
   */
  private void tryMove(ArrayDeque<Integer> moveSteps) {
    try {
      this.model.move(moveSteps.remove() - 1, moveSteps.remove() - 1, moveSteps.remove() - 1,
              moveSteps.remove() - 1);
      this.invMove = false;
    } catch (IllegalArgumentException iaE) {
      this.invMove = true;
      this.formatOut();
    }
  }

  /**
   * If the controller receives bad inputs, let view render a prompt ask users to re-input.
   * Otherwise, let view render an output consists of head message (can be empty/"Game quit!"/
   * "Game-over!", based on the state of the game), a visualized board, and the score for the
   * current state, from top to bottom.
   *
   * @param message strings of messages put at the head of the output
   * @throws IllegalStateException when there's an IOException thrown
   */
  private void formatOut(String... message) throws IllegalStateException {
    try {
      if (this.invMove) {
        view.renderMessage("Invalid Move, try again\n");
        return;
      }

      for (String s : message) {
        view.renderMessage(s + "\n");
      }

      view.renderBoard();
      view.renderMessage("\n");
      view.renderMessage("Score: " + this.model.getScore());
      view.renderMessage("\n");
    } catch (IOException ioE) {
      throw new IllegalStateException();
    }
  }
}