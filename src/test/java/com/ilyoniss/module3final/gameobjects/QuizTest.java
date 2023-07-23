package com.ilyoniss.module3final.gameobjects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuizTest {

    @Test
    void testGame()
    {
      QuestionRepository questionRepository = new QuestionRepository();
      Question startQuestion = questionRepository.getQuestion("q1");
      Quiz.PlayGame(startQuestion);

    }

}