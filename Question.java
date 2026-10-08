public abstract class Question {

    private String questionText;

    public Question(String questionText) {
        this.questionText = questionText;
    }

    public String getQuestionText() {
        return questionText;
    }

    public abstract void displayQuestion();

    public abstract boolean checkAnswer(int answer);
}