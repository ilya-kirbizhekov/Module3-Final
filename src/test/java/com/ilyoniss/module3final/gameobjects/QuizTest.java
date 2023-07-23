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
    @Test
    public void testPlayGameWithIncorrectAnswer()
    {

        // Run the game with an incorrect answer (selecting option 1, "London")
       // Question finalQuestion = Quiz.playGame(q1);

        // Check if the final question is null, indicating the game is over due to the incorrect answer
        //assertNull(finalQuestion);
    }
    @Test
    public void testPlayGameWithCorrectAnswer()
    {

    }

}