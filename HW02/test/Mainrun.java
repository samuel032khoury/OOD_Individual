import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;


import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

public class Mainrun {
  public static void main(String[] args) {
    MarbleSolitaireModel mm = new EuropeanSolitaireModel(3);
//    MarbleSolitaireModel tm = new TriangleSolitaireModel(3);
    MarbleSolitaireControllerImpl game = new MarbleSolitaireControllerImpl(mm,
            new MarbleSolitaireTextView(mm), new BufferedReader(new InputStreamReader(System.in)));
//    MarbleSolitaireControllerImpl trigGame = new MarbleSolitaireControllerImpl(tm,
//            new TriangleSolitaireTextView(tm), new BufferedReader(new InputStreamReader(System.in)));
    game.playGame();
//    trigGame.playGame();
//    System.out.println(new MarbleSolitaireTextView(mm, new StringBuffer()));
  }
}
