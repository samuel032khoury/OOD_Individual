import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;

/**
 * Do not modify this file. This file should compile correctly with your code!
 */
public class MainRun {

  /**
   * A sample main method.
   *
   * @param args the program arguments
   */
  public static void main(String[] args) {
    EnglishSolitaireModel es = new EnglishSolitaireModel();
    es.move(1, 3, 3, 3);
    es.move(4, 3, 2, 3);
    es.move(4, 1, 4, 3);
    es.move(2, 1, 4, 1);
    es.move(2, 3, 2, 1);
    es.move(2, 0, 2, 2);
    es.move(4, 0, 2, 0);
    es.move(6, 2, 4, 2);

    es.move(6, 4, 6, 2);
    es.move(4, 2, 4, 0);
    es.move(4, 4, 4, 2);
    es.move(2, 5, 2, 3);
    es.move(2, 3, 2, 1);
    es.move(4, 2, 2, 2);
    es.move(4, 6, 4, 4);
    es.move(4, 4, 6, 4);
    es.move(2, 6, 4, 6);
    es.move(3, 5, 3, 3);
    System.out.println(new MarbleSolitaireTextView(es));
    System.out.println(es.isGameOver());
    es.move(2, 1, 2, 3);
    es.move(0, 2, 2, 2);
    es.move(0, 4, 0, 2);
    es.move(2, 3, 4, 3);
    es.move(4, 3, 6, 3);
    System.out.println(new MarbleSolitaireTextView(es));
    System.out.println(es.isGameOver());
  }

  private static void helper(cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel model) {
    model.move(1, 3, 3, 3);
  }


}
