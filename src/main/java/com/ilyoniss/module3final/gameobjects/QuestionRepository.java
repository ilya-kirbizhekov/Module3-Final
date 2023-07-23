package com.ilyoniss.module3final.gameobjects;

import java.util.HashMap;
import java.util.Map;

public class QuestionRepository {
    private Map<String, Question> questionMap;

    public QuestionRepository() {
        questionMap = new HashMap<>();
        initializeQuestions();
    }

    // Method to add a question to the repository
    public void addQuestion(String questionId, Question question) {
        questionMap.put(questionId, question);
    }

    // Method to get a question from the repository by its ID
    public Question getQuestion(String questionId) {
        return questionMap.get(questionId);
    }

    // Method to initialize the questions and answers
    private void initializeQuestions() {
        // Create the questions and answers
        Question q1 = new Question("What is the capital of France?", new Answer[]{
                new Answer("London", false, null),
                new Answer("Paris", true, null),
                new Answer("Berlin", false, null)
        });

        Question q2 = new Question("What is the largest planet in our solar system?", new Answer[]{
                new Answer("Mars", false, null),
                new Answer("Jupiter", true, null),
                new Answer("Earth", false, null)
        });

        // Link the questions together based on correct answers
        q1.getAnswers()[1].setNextQuestion(q2);

        // Add the questions to the repository
        addQuestion("q1", q1);
        addQuestion("q2", q2);
        // Add more questions here as needed
    }

}
