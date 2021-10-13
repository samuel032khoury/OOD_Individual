/**
 * To test Multiple Choice Question.
 */
public class MultipleChoiceQuestionTest extends AbstractQuestionTest {
  /**
   * To construct a Multiple Choice Question Test.
   */
  public MultipleChoiceQuestionTest() {
    super();
    super.type = "MultipleChoice";
    super.answers = new String[] {"1", "2", "3", "4", "5"};
    super.invalidAnswers = new String[]  {"6", "7"};
  }

  @Override
  public Question createQuestion(String questionText, boolean includeQuestionMark) {
    return new MultipleChoiceQuestion(questionText += (includeQuestionMark) ? "?" : "");
  }
}