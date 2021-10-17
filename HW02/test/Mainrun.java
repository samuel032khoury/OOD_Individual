import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;


import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;

public class Mainrun {
  public static void main(String[] args) {
    MarbleSolitaireModel mm = new EnglishSolitaireModel(5,6,6);
    MarbleSolitaireControllerImpl game = new MarbleSolitaireControllerImpl(mm,
            new MarbleSolitaireTextView(mm), new BufferedReader(new InputStreamReader(System.in)));
    game.playGame();
//    System.out.println(new MarbleSolitaireTextView(mm, new StringBuffer()));
  }
}
