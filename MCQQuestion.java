public class MCQQuestion extends Question {

    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private int correctAnswer;

    public MCQQuestion(
            String questionText,
            String optionA,
            String optionB,
            String optionC,
            String optionD,
            int correctAnswer) {

        super(questionText);

        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctAnswer = correctAnswer;
    }

    @Override
    public void displayQuestion() {

        System.out.println(getQuestionText());
        System.out.println("1. " + optionA);
        System.out.println("2. " + optionB);
        System.out.println("3. " + optionC);
        System.out.println("4. " + optionD);
    }

    @Override
    public boolean checkAnswer(int answer) {

        return answer == correctAnswer;
    }
}