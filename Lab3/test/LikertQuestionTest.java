/**
 * To test Likert Question.
 */
public class LikertQuestionTest extends AbstractQuestionTest {
  /**
   * To construct a Likert Question Test.
   */
  public LikertQuestionTest() {
    super();
    super.type = "Likert";
    super.answers = new String[] {"strongly agree", "agree", "neither agree nor disagree",
        "disagree", "strongly disagree"};
    super.invalidAnswers = new String[] {"weakly disagree", ""};
  }

  @Override
  public Question createQuestion(String questionText, boolean includeQuestionMark) {
    return new LikertQuestion(questionText += (includeQuestionMark) ? "?" : "");
  }
}