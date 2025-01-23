/**
 * this class represents a 5-scale likert question. the scales are strongly agree, agree, neither
 * agree nor disagree, disagree and strongly disagree.
 */
public class LikertQuestion extends AbstractQuestion {
  /**
   * Construct a Likert Question.
   *
   * @param text the description of the question
   * @throws IllegalArgumentException when the text is empty
   */
  public LikertQuestion(String text) throws IllegalArgumentException {
    super(text);
    options = new String[]{"strongly agree", "agree", "neither agree nor disagree", "disagree",
        "strongly disagree"};
  }

  /**
   * Get a string that represents the type of this question.
   *
   * @return the type of this question, which is "Likert"
   */
  @Override
  public String getType() {
    return "Likert";
  }
}
