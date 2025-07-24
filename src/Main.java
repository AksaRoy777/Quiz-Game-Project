import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("🎯 Welcome to the Quiz Game!");

        boolean playAgain = true;

        while (playAgain) {
            int count = 0;
            while (count < 1 || count > 25) {
                System.out.print(" Enter number of questions (1 to 25): ");
                if (scanner.hasNextInt()) {
                    count = scanner.nextInt();
                } else {
                    scanner.next(); // discard invalid input
                }
                scanner.nextLine(); // clear newline
            }

            System.out.print(" Choose difficulty (easy / medium / hard): ");
            String difficulty = scanner.nextLine().trim().toLowerCase();

            if (!difficulty.equals("easy") && !difficulty.equals("medium") && !difficulty.equals("hard")) {
                System.out.println("⚠ Invalid choice. Defaulting to 'easy'.");
                difficulty = "easy";
            }

            QuestionService service = new QuestionService();
            service.startQuiz(count, difficulty);

            System.out.print("\n🔁 Do you want to play again? (yes / no): ");
            playAgain = scanner.nextLine().trim().equalsIgnoreCase("yes");
        }

        System.out.println("👋 Thanks for playing!");
        scanner.close();
    }
}