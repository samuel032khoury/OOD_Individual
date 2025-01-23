package cs3500.marblesolitaire;

import java.io.InputStreamReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

/**
 * This class intends to allow user run the game by calling {@link #main(String[])} in a command
 * line context and then play the game.
 */
public final class MarbleSolitaire {
  /**
   * This method allows user to initialize the game board by parsing inputs and start the game.
   * Specifically, the first argument is required and should always be the type of {@link
   * MarbleSolitaireModel}. The optional (ordered) arguments include:
   * <ol>
   *   <li>{@code -size} and should have a following integer to represent the determinant of the
   *   dimension of the game board.
   *   <li>{@code -hole} and should have two following integers to represent the row and column
   *   of the empty slot.
   * </ol>
   *
   * @param args commands that help the method to form a proper {@link MarbleSolitaireModel} as the
   *                   player expected
   * @throws IllegalArgumentException when the argument fails to be an integer wherever it should
   *                                        be
   */
  public static void main(String[] args) throws IllegalArgumentException {
    MarbleSolitaireModel model = null;
    MarbleSolitaireView view = null;
    try {
      if (args.length > 0) {
        switch (args[0]) {
          case "triangular":
            if (args.length == 1) {
              model = new TriangleSolitaireModel();
            } else if (args.length == 3 && args[1].equals("-size")) {
              int size = Integer.parseInt(args[2]);
              model = new TriangleSolitaireModel(size);
            } else if (args.length == 4 && args[1].equals("-hole")) {
              int row = Integer.parseInt(args[2]) - 1;
              int col = Integer.parseInt(args[3]) - 1;
              model = new TriangleSolitaireModel(row, col);
            } else if (args.length == 6 && args[1].equals("-size") && args[3].equals("-hole")) {
              int size = Integer.parseInt(args[2]);
              int row = Integer.parseInt(args[4]) - 1;
              int col = Integer.parseInt(args[5]) - 1;
              model = new TriangleSolitaireModel(size, row, col);
            } else if (args.length == 6 && args[1].equals("-hole") && args[3].equals("-size")) {
              int row = Integer.parseInt(args[2]) - 1;
              int col = Integer.parseInt(args[3]) - 1;
              int size = Integer.parseInt(args[5]);
              model = new EnglishSolitaireModel(size, row, col);
            }
            view = new TriangleSolitaireTextView(model);
            break;
          case "english":
            if (args.length == 1) {
              model = new EnglishSolitaireModel();
            } else if (args.length == 3 && args[1].equals("-size")) {
              int size = Integer.parseInt(args[2]);
              model = new EnglishSolitaireModel(size);
            } else if (args.length == 4 && args[1].equals("-hole")) {
              int row = Integer.parseInt(args[2]) - 1;
              int col = Integer.parseInt(args[3]) - 1;
              model = new EnglishSolitaireModel(row, col);
            } else if (args.length == 6 && args[1].equals("-size") && args[3].equals("-hole")) {
              int size = Integer.parseInt(args[2]);
              int row = Integer.parseInt(args[4]) - 1;
              int col = Integer.parseInt(args[5]) - 1;
              model = new EnglishSolitaireModel(size, row, col);
            } else if (args.length == 6 && args[1].equals("-hole") && args[3].equals("-size")) {
              int row = Integer.parseInt(args[2]) - 1;
              int col = Integer.parseInt(args[3]) - 1;
              int size = Integer.parseInt(args[5]);
              model = new EnglishSolitaireModel(size, row, col);
            }
            view = new MarbleSolitaireTextView(model);
            break;
          case "european":
            if (args.length == 1) {
              model = new EuropeanSolitaireModel();
            } else if (args.length == 3 && args[1].equals("-size")) {
              int size = Integer.parseInt(args[2]);
              model = new EuropeanSolitaireModel(size);
            } else if (args.length == 4 && args[1].equals("-hole")) {
              int row = Integer.parseInt(args[2]) - 1;
              int col = Integer.parseInt(args[3]) - 1;
              model = new EuropeanSolitaireModel(row, col);
            } else if (args.length == 6 && args[1].equals("-size") && args[3].equals("-hole")) {
              int size = Integer.parseInt(args[2]);
              int row = Integer.parseInt(args[4]) - 1;
              int col = Integer.parseInt(args[5]) - 1;
              model = new EuropeanSolitaireModel(size, row, col);
            }  else if (args.length == 6 && args[1].equals("-hole") && args[3].equals("-size")) {
              int row = Integer.parseInt(args[2]) - 1;
              int col = Integer.parseInt(args[3]) - 1;
              int size = Integer.parseInt(args[5]);
              model = new EnglishSolitaireModel(size, row, col);
            }
            view = new MarbleSolitaireTextView(model);
            break;
          default:
            break;
        }
        if (model != null) {
          MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view,
                  new InputStreamReader(System.in));
          controller.playGame();
        }
      }
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException();
    }
  }
}