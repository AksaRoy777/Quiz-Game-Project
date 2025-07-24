import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class ApiClient {

    public static List<Question> fetchQuestions(int amount, String difficulty) {
        List<Question> questions = new ArrayList<>();
        try {
            String apiUrl = "https://opentdb.com/api.php?amount=" + amount +
                    "&type=multiple&difficulty=" + difficulty;

            HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();
            connection.setRequestMethod("GET");

            JSONParser parser = new JSONParser();
            JSONObject response = (JSONObject) parser.parse(new InputStreamReader(connection.getInputStream()));
            JSONArray results = (JSONArray) response.get("results");

            for (Object obj : results) {
                JSONObject jsonQ = (JSONObject) obj;

                String questionText = htmlDecode((String) jsonQ.get("question"));
                String correctAnswer = htmlDecode((String) jsonQ.get("correct_answer"));

                JSONArray incorrect = (JSONArray) jsonQ.get("incorrect_answers");
                List<String> options = new ArrayList<>();
                for (Object inc : incorrect) {
                    options.add(htmlDecode((String) inc));
                }
                options.add(correctAnswer);
                Collections.shuffle(options);

                questions.add(new Question(questionText, options, correctAnswer));
            }

        } catch (Exception e) {
            System.out.println("Error fetching questions: " + e.getMessage());
        }

        return questions;
    }

    private static String htmlDecode(String text) {
        return text.replace("&quot;", "\"")
                .replace("&#039;", "'")
                .replace("&amp;", "&")
                .replace("&lt;", "<")
                .replace("&gt;", ">");
    }
}