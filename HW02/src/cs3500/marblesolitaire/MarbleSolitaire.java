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

public final class MarbleSolitaire {
  public static void main(String[] args) {
    MarbleSolitaireModel model = null;
    MarbleSolitaireView view = null;

    if (args.length > 0) {
      switch (args[0]) {
        case "triangular":
          if (args.length == 1) {
            model = new TriangleSolitaireModel();
          }

          if (args.length == 3 && args[1].equals("-size")) {
            try {
              int size = Integer.parseInt(args[2]);
              model = new TriangleSolitaireModel(size);
            } catch (NumberFormatException e) {
              e.printStackTrace();
            }
          }

          if (args.length == 4 && args[1].equals("-hole")) {
            try {
              int row = Integer.parseInt(args[2]);
              int col = Integer.parseInt(args[3]);
              model = new TriangleSolitaireModel(row, col);
            } catch (NumberFormatException e) {
              e.printStackTrace();
            }
          }

          if (args.length == 6 && args[1].equals("-size") && args[3].equals("-hole")) {
            try {
              int size = Integer.parseInt(args[2]);
              int row = Integer.parseInt(args[4]);
              int col = Integer.parseInt(args[5]);
              model = new TriangleSolitaireModel(size, row, col);
            } catch (NumberFormatException e) {
              e.printStackTrace();
            }
          }
          view = new TriangleSolitaireTextView(model);
          break;
        case "english":
          if (args.length == 1) {
            model = new EnglishSolitaireModel();
          }

          if (args.length == 3 && args[1].equals("-size")) {
            try {
              int size = Integer.parseInt(args[2]);
              model = new EnglishSolitaireModel(size);
            } catch (NumberFormatException e) {
              e.printStackTrace();
            }
          }

          if (args.length == 4 && args[1].equals("-hole")) {
            try {
              int row = Integer.parseInt(args[2]);
              int col = Integer.parseInt(args[3]);
              model = new EnglishSolitaireModel(row, col);
            } catch (NumberFormatException e) {
              e.printStackTrace();
            }
          }

          if (args.length == 6 && args[1].equals("-size") && args[3].equals("-hole")) {
            try {
              int size = Integer.parseInt(args[2]);
              int row = Integer.parseInt(args[4]);
              int col = Integer.parseInt(args[5]);
              model = new EnglishSolitaireModel(size, row, col);
            } catch (NumberFormatException e) {
              e.printStackTrace();
            }
          }
          view = new MarbleSolitaireTextView(model);
          break;
        case "european":
          if (args.length == 1) {
            model = new EuropeanSolitaireModel();
          }

          if (args.length == 3 && args[1].equals("-size")) {
            try {
              int size = Integer.parseInt(args[2]);
              model = new EuropeanSolitaireModel(size);
            } catch (NumberFormatException e) {
              e.printStackTrace();
            }
          }

          if (args.length == 4 && args[1].equals("-hole")) {
            try {
              int row = Integer.parseInt(args[2]);
              int col = Integer.parseInt(args[3]);
              model = new EuropeanSolitaireModel(row, col);
            } catch (NumberFormatException e) {
              e.printStackTrace();
            }
          }

          if (args.length == 6 && args[1].equals("-size") && args[3].equals("-hole")) {
            try {
              int size = Integer.parseInt(args[2]);
              int row = Integer.parseInt(args[4]);
              int col = Integer.parseInt(args[5]);
              model = new EuropeanSolitaireModel(size, row, col);
            } catch (NumberFormatException e) {
              e.printStackTrace();
            }
          }
          view = new MarbleSolitaireTextView(model);
          break;
        default:
          break;
      }
      if(model != null) {
        MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view,
                new InputStreamReader(System.in));
        controller.playGame();
      }
    }
  }
}