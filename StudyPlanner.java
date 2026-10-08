import java.util.ArrayList;
import java.util.Scanner;

public class StudyPlanner {

    private ArrayList<Subject> subjects;
    private Scanner scanner;

    public StudyPlanner() {

        subjects = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void start() {

        int choice = 0;

        System.out.println("================================");
        System.out.println("       SMART STUDY PLANNER");
        System.out.println("================================");

        while (choice != 7) {

            System.out.println("\n1. Add Subject");
            System.out.println("2. Add Topic");
            System.out.println("3. View Subjects");
            System.out.println("4. Start MCQ Practice");
            System.out.println("5. View Progress");
            System.out.println("6. Calculate Performance");
            System.out.println("7. Exit");

            System.out.print("\nEnter your choice: ");

            try {

                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {

                    case 1:
                        addSubject();
                        break;

                    case 2:
                        addTopic();
                        break;

                    case 3:
                        viewSubjects();
                        break;

                    case 4:
                        startMCQ();
                        break;

                    case 5:
                        viewProgress();
                        break;

                    case 6:
                        calculatePerformance();
                        break;

                    case 7:
                        System.out.println("Thank you!");
                        break;

                    default:
                        throw new InvalidInputException(
                                "Enter a number from 1 to 7."
                        );
                }

            } catch (NumberFormatException e) {

                System.out.println("Please enter a valid number.");

            } catch (InvalidInputException e) {

                System.out.println(e.getMessage());
            }
        }

        scanner.close();
    }

    private void addSubject() {

        System.out.print("\nEnter subject name: ");
        String name = scanner.nextLine();

        if (name.trim().isEmpty()) {

            System.out.println("Subject name cannot be empty.");
            return;
        }

        subjects.add(new Subject(name));

        System.out.println("Subject added successfully!");
    }

    private void addTopic() {

        if (subjects.isEmpty()) {

            System.out.println("Add a subject first.");
            return;
        }

        viewSubjects();

        try {

            System.out.print("\nSelect subject number: ");
            int subjectNumber = Integer.parseInt(scanner.nextLine());

            if (subjectNumber < 1 ||
                    subjectNumber > subjects.size()) {

                throw new InvalidInputException(
                        "Invalid subject number."
                );
            }

            Subject subject =
                    subjects.get(subjectNumber - 1);

            System.out.print("Enter topic name: ");
            String topicName = scanner.nextLine();

            if (topicName.trim().isEmpty()) {

                throw new InvalidInputException(
                        "Topic name cannot be empty."
                );
            }

            subject.addTopic(new Topic(topicName));

            System.out.println("Topic added successfully!");

        } catch (NumberFormatException e) {

            System.out.println("Enter a valid number.");

        } catch (InvalidInputException e) {

            System.out.println(e.getMessage());
        }
    }

    private void viewSubjects() {

        if (subjects.isEmpty()) {

            System.out.println("\nNo subjects available.");
            return;
        }

        System.out.println("\n========== SUBJECTS ==========");

        for (int i = 0; i < subjects.size(); i++) {

            Subject subject = subjects.get(i);

            System.out.println(
                    (i + 1) + ". " + subject.getName()
            );

            ArrayList<Topic> topics =
                    subject.getTopics();

            for (int j = 0; j < topics.size(); j++) {

                System.out.println(
                        "   " + (j + 1) + ". "
                                + topics.get(j).getName()
                );
            }
        }
    }

    private void startMCQ() {

        if (subjects.isEmpty()) {

            System.out.println("Add a subject first.");
            return;
        }

        viewSubjects();

        try {

            System.out.print("\nSelect subject number: ");
            int subjectNumber =
                    Integer.parseInt(scanner.nextLine());

            if (subjectNumber < 1 ||
                    subjectNumber > subjects.size()) {

                throw new InvalidInputException(
                        "Invalid subject number."
                );
            }

            Subject subject =
                    subjects.get(subjectNumber - 1);

            if (subject.getTopics().isEmpty()) {

                System.out.println(
                        "Add a topic to this subject first."
                );
                return;
            }

            ArrayList<Topic> topics =
                    subject.getTopics();

            System.out.println("\nTopics:");

            for (int i = 0; i < topics.size(); i++) {

                System.out.println(
                        (i + 1) + ". "
                                + topics.get(i).getName()
                );
            }

            System.out.print("\nSelect topic number: ");
            int topicNumber =
                    Integer.parseInt(scanner.nextLine());

            if (topicNumber < 1 ||
                    topicNumber > topics.size()) {

                throw new InvalidInputException(
                        "Invalid topic number."
                );
            }

            Topic topic =
                    topics.get(topicNumber - 1);

            runQuiz(topic);

        } catch (NumberFormatException e) {

            System.out.println("Enter a valid number.");

        } catch (InvalidInputException e) {

            System.out.println(e.getMessage());
        }
    }

    private void runQuiz(Topic topic) {

        ArrayList<Question> questions =
                createQuestions();

        int score = 0;

        System.out.println("\n================================");
        System.out.println("          MCQ PRACTICE");
        System.out.println("Topic: " + topic.getName());
        System.out.println("================================");

        for (int i = 0; i < questions.size(); i++) {

            Question question = questions.get(i);

            System.out.println(
                    "\nQuestion " + (i + 1)
            );

            question.displayQuestion();

            System.out.print("Your answer: ");

            try {

                int answer =
                        Integer.parseInt(scanner.nextLine());

                if (answer < 1 || answer > 4) {

                    throw new InvalidInputException(
                            "Answer must be between 1 and 4."
                    );
                }

                if (question.checkAnswer(answer)) {

                    System.out.println("Correct!");
                    score++;

                } else {

                    System.out.println("Wrong!");
                }

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid answer. Question skipped."
                );

            } catch (InvalidInputException e) {

                System.out.println(e.getMessage());
            }
        }

        topic.updateProgress(score, questions.size());

        System.out.println("\n================================");
        System.out.println("Quiz completed!");
        System.out.println(
                "Score: " + score + "/" + questions.size()
        );
        System.out.println(
                "Progress: " + topic.getProgress() + "%"
        );
        System.out.println("================================");
    }

    private ArrayList<Question> createQuestions() {

        ArrayList<Question> questions =
                new ArrayList<>();

        questions.add(
                new MCQQuestion(
                        "Which keyword is used to create a class?",
                        "class",
                        "object",
                        "new",
                        "create",
                        1
                )
        );

        questions.add(
                new MCQQuestion(
                        "Which concept hides data?",
                        "Inheritance",
                        "Encapsulation",
                        "Polymorphism",
                        "Abstraction",
                        2
                )
        );

        questions.add(
                new MCQQuestion(
                        "Which keyword is used for inheritance?",
                        "this",
                        "super",
                        "extends",
                        "static",
                        3
                )
        );

        questions.add(
                new MCQQuestion(
                        "Which method starts a Java program?",
                        "start()",
                        "run()",
                        "main()",
                        "execute()",
                        3
                )
        );

        return questions;
    }

    private void viewProgress() {

        if (subjects.isEmpty()) {

            System.out.println("No progress available.");
            return;
        }

        System.out.println("\n========== PROGRESS ==========");

        for (Subject subject : subjects) {

            System.out.println(
                    "\nSubject: " + subject.getName()
            );

            for (Topic topic : subject.getTopics()) {

                System.out.println(
                        topic.getName()
                                + " : "
                                + topic.getProgress()
                                + "%"
                );
            }
        }
    }

    private void calculatePerformance() {

        int totalTopics = 0;
        int totalProgress = 0;

        for (Subject subject : subjects) {

            for (Topic topic : subject.getTopics()) {

                totalTopics++;
                totalProgress += topic.getProgress();
            }
        }

        if (totalTopics == 0) {

            System.out.println(
                    "No topics available."
            );
            return;
        }

        double performance =
                (double) totalProgress / totalTopics;

        System.out.printf(
                "\nOverall Performance: %.2f%%%n",
                performance
        );
    }
}