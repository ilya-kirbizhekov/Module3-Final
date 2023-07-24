package com.ilyoniss.module3final.gameobjects;

import java.util.HashMap;
import java.util.Map;

public class QuestionRepository {
    private final Map<String, Question> questionMap;

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

        Question q1 = new Question("Ты потерял память. Принять вызов НЛО?", new Answer[]{
                new Answer("Принять вызов", true, null,
                        new Action("")),
                new Answer("Отклонить вызов", false, null,
                        new Action("Ты отклонил вызов. Поражение."))
        });
        Question q2 = new Question("Ты принял вызов.Поднимаешься на мостик к капитану?", new Answer[]{
                new Answer("Подняться на мостик", true, null,
                        new Action("")),
                new Answer("Отказаться подниматься на мостик", false, null,
                        new Action("Ты не пошел на переговоры. Поражение"))
        });
        Question q3 = new Question("Ты поднялся на мостик. Ты кто?", new Answer[]{
                new Answer("Рассказать правду о себе.", true, null,
                        new Action("Тебя вернули домой. Победа.")),
                new Answer("Солгать о себе.", false, null,
                        new Action("Твою ложь разоблачили. Поражение"))
        });

        // Link the questions together based on correct answers
        // Rules
        q1.getAnswers()[0].setNextQuestion(q2);
        q2.getAnswers()[0].setNextQuestion(q3);

        // Add the questions to the repository
        addQuestion("q1", q1);
        addQuestion("q2", q2);
        addQuestion("q3", q3);
        // Add more questions here as needed
    }

}
