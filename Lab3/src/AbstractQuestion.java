/**
 * To represent abstracted Questions.
 */
public abstract class AbstractQuestion implements Question {
  protected String questionText;
  protected String enteredAnswer;
  protected String[] options;

  /**
   * Construct a abstract question.
   *
   * @param text the description of the question
   * @throws IllegalArgumentException when the text is empty
   */
  AbstractQuestion(String text) throws IllegalArgumentException {
    if ((text.length() == 0)) {
      throw new IllegalArgumentException("Invalid question text");
    }
    this.questionText = text;
    enteredAnswer = "";
  }

  /**
   * Get the text of this question.
   *
   * @return the text of this question as a string
   */
  @Override
  public String getQuestionText() {
    return questionText;
  }

  /**
   * Enter an answer to this question. Specific implementations may enforce constraints on what a
   * valid answer can be.
   *
   * @param enteredAnswer the answer entered for this question by a student
   * @throws IllegalArgumentException when the answer is not any option provided
   */
  @Override
  public void answer(String enteredAnswer) throws IllegalArgumentException {
    for (String option : options) {
      if (enteredAnswer.equalsIgnoreCase(option)) {
        this.enteredAnswer = enteredAnswer.toLowerCase();
        return;
      }
    }
    throw new IllegalArgumentException("Invalid answer: " + enteredAnswer);
  }

  /**
   * Returns whether this question has been answered by the student.
   *
   * @return true if the question has been answered, false otherwise
   */
  @Override
  public boolean hasBeenAnswered() {
    return !(this.enteredAnswer.equals(""));
  }

  /**
   * Return the answer entered by the student, if it has been entered.
   *
   * @return the answer entered by the student
   * @throws IllegalStateException if the question has not been answered yet
   */
  @Override
  public String getEnteredAnswer() throws IllegalStateException {
    if (!hasBeenAnswered()) {
      throw new IllegalStateException("solution.Question not attempted yet!");
    } else {
      return enteredAnswer;
    }
  }
}
