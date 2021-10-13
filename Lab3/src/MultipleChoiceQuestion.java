/**
 * this class represents a multiple choice question.
 */
public class MultipleChoiceQuestion extends AbstractQuestion {

  /**
   * Construct a multiple choice question with five options.
   *
   * @param text the description of the question
   * @throws IllegalArgumentException when the text is empty
   */
  MultipleChoiceQuestion(String text) throws IllegalArgumentException {
    super(text);
    options = new String[]{"1", "2", "3", "4", "5"};
  }

  /**
   * Get a string that represents the type of this question.
   *
   * @return the type of this question, which is "MultipleChoice"
   */
  @Override
  public String getType() {
    return "MultipleChoice";
  }
}
