# QUIZ GAME PROJECT

This is a Java-based quiz game created as part of my 15-day internship project at Learn and Build. The purpose of this project was to apply basic Java programming concepts and understand how to work with external APIs and JSON data.

# Project Layout

QuizGame/
├── src/
│   ├── Main.java
│   ├── ApiClient.java
│   ├── Question.java
│   └── QuestionService.java
├── lib/
│   └── json-simple-1.1.1.jar
├── README.md
└── quiz_results.txt

# Project Description

The project is a *console-based quiz application* built using Java. It uses the [Open Trivia Database API](https://opentdb.com/) to fetch quiz questions in real time. The game allows the user to:

- Choose the number of questions (from 1 to 25)
- Select difficulty level: Easy, Medium, or Hard
- Answer multiple-choice questions (Options A, B, C, D)


# Timer Feature

Each question has a *countdown timer of 10 seconds* 
The user must enter their answer within this time.

- After 10 seconds, input is locked and the quiz waits for the user to *press Enter* to continue.
- Answers entered after time runs out are not accepted.

# Final Score
At the end of the quiz:

- The total score is shown.
- The user is asked if they want to **restart** the quiz.

# How to Run the Project

1. Open the project in *IntelliJ IDEA*
2. Add the `json-simple-1.1.1.jar` to your project:
   - Go to *File → Project Structure → Libraries → + → Add the jar file*
3. Run the `Main.java` file.
4. Follow the instructions shown in the console to play the quiz.

# Technologies Used

- Java (Console-based)
- Open Trivia Database API
- JSON parsing using `json-simple` library

# Learning Outcome
Through this project, I learned:

- How to make GET requests and fetch data from a public API
- How to parse JSON data in Java using `json-simple`
- How to handle user input, logic flow, and countdown timers
- How to structure and run a Java project using IntelliJ IDEA

This project was done as part of my internship and is intended to demonstrate the concepts I have learned so far.


 Submitted by
 
Aksa Roy  
First Year Student  
Global Institute of Technology, Jaipur
