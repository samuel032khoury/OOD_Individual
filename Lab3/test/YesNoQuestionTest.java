import org.junit.Test;

/**
 * To test YesNo Question.
 */
public class YesNoQuestionTest extends AbstractQuestionTest {
  /**
   * To construct a YesNo Question Test.
   */
  public YesNoQuestionTest() {
    super();
    super.type = "YesNo";
    super.answers = new String[] {"yes", "Yes", "YEs", "YeS", "YES", "yEs", "yES", "yeS",
        "no", "No", "nO", "NO"};
    super.invalidAnswers = new String[] {"yess", ""};
  }

  @Override
  public Question createQuestion(String questionText, boolean includeQuestionMark) {
    return new YesNoQuestion(questionText += (includeQuestionMark) ? "?" : "");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCreateYesNoQuestionNoQuestionMark() {
    new YesNoQuestion("Is this fun");
  }
}