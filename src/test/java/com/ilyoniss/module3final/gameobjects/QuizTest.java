package com.ilyoniss.module3final.gameobjects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuizTest {
    @Test
    void testPlayGameWithCorrectAnswer() {
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

        q1.getAnswers()[1].setNextQuestion(q2);
        Question finalQuiestion = Quiz.PlayGame(q1);

    }
    @Test
    void testGame()
    {
      QuestionRepository questionRepository = new QuestionRepository();
      Question startQuestion = questionRepository.getQuestion("q1");
      Quiz.PlayGame(startQuestion);

    }

}