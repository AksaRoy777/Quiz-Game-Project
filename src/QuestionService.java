import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuestionService {

    private boolean answered;
    private int score = 0;
    private final Scanner scanner = new Scanner(System.in);

    public void startQuiz(int count, String difficulty) {
        List<Question> questions = ApiClient.fetchQuestions(count, difficulty);

        if (questions.isEmpty()) {
            System.out.println("No questions found. Try again.");
            return;
        }

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("\nQuestion " + (i + 1) + ": " + q.getQuestionText());

            List<String> options = q.getOptions();
            char optionChar = 'A';
            for (String option : options) {
                System.out.println(optionChar + ". " + option);
                optionChar++;
            }

            answered = false;

            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    if (!answered) {
                        System.out.println("\n⏰ Time's up! You didn't answer.");
                        answered = true;
                    }
                }
            }, 10000); // 10 seconds

            String input = "";
            long startTime = System.currentTimeMillis();

            while (!answered && (System.currentTimeMillis() - startTime) < 10000) {
                if (scanner.hasNextLine()) {
                    input = scanner.nextLine().trim().toUpperCase();
                    answered = true;
                }
            }

            timer.cancel();

            if (!input.isEmpty()) {
                int index = input.charAt(0) - 'A';
                if (index >= 0 && index < options.size()) {
                    String selected = options.get(index);
                    if (selected.equals(q.getCorrectAnswer())) {
                        System.out.println("✅ Correct!");
                        score++;
                    } else {
                        System.out.println("❌ Wrong! Correct answer: " + q.getCorrectAnswer());
                    }
                } else {
                    System.out.println("Invalid choice.");
                }
            }
        }

        System.out.println("\n🎯 You scored " + score + " out of " + count + ".");
    }
}