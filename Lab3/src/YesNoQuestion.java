/**
 * this class represents a yes/no question.
 */
public class YesNoQuestion extends AbstractQuestion {
  /**
   * Construct a YesNo Question.
   *
   * @param text the description of the question
   * @throws IllegalArgumentException when the text is empty, or it does not end with a question
   *                                  mark
   */
  public YesNoQuestion(String text) throws IllegalArgumentException {
    super(text);
    if ((text.charAt(text.length() - 1) != '?')) {
      throw new IllegalArgumentException("Invalid question text");
    }
    options = new String[]{"yes", "no"};
  }

  /**
   * Get a string that represents the type of this question.
   *
   * @return the type of this question, which is "YesNo"
   */
  @Override
  public String getType() {
    return "YesNo";
  }
}
