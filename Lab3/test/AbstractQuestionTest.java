import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * To represent abstracted tests of Question.
 */
public abstract class AbstractQuestionTest {
  protected String longRandom;
  protected String type;
  protected String[] answers;
  protected String[] invalidAnswers;

  /**
   * To construct a AbstractQuestionTest.
   */
  public AbstractQuestionTest() {
    longRandom = "aosdifjaso oifhas;ldihv;al skdfha;osidghv;osiadhvbasdjkhvn";
  }

  @Test
  public void testCreateQuestion() {
    Random r = new Random(200);
    for (int i = 0; i < 1000; i++) {
      int start = r.nextInt(longRandom.length() - 1);
      int end = start + r.nextInt(longRandom.length() - start - 1) + 1;
      String questionText = longRandom.substring(start, end);
      Question q = createQuestion(questionText, true);
      assertEquals(questionText + "?", q.getQuestionText());
      assertEquals(type, q.getType());
    }
  }
  
  public abstract Question createQuestion(String questionText, boolean includeQuestionMark);

  @Test(expected = IllegalArgumentException.class)
  public void testCreateQuestionNoText() {
    createQuestion("", false);
  }

  @Test
  public void testAnswerCorrectly() {
    for (String answer : this.answers) {
      Question q = createQuestion("Is this a trick question?", false);
      assertFalse(q.hasBeenAnswered());

      q.answer(answer);
      assertEquals(answer.toLowerCase(), q.getEnteredAnswer());
      assertTrue(q.hasBeenAnswered());
    }
  }

  @Test
  public void testAnswerInCorrectly() {
    for (String answer : this.invalidAnswers) {
      Question q = createQuestion("Is this a trick question?", false);
      assertFalse(q.hasBeenAnswered());

      try {
        q.answer(answer);
        fail(q.getType() + " question accepted an invalid answer");
      } catch (IllegalArgumentException e) {
        assertFalse(q.hasBeenAnswered());
      }
    }
  }
}
