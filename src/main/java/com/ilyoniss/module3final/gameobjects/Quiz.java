package com.ilyoniss.module3final.gameobjects;

public class Quiz {
    // game constructor
    public Quiz() {
     Question question1 = new Question("What is the capital of France?", new
             Answer[]{
              new Answer("London", false, null),
              new Answer("Paris", true,null),
              new Answer("Berlin", false, null)
     });
     Question question2 = new Question("What is the largest planet in our solar system?", new Answer[]{
                new Answer("Mars", false, null),
                new Answer("Jupiter", true, null),
                new Answer("Earth", false, null)
     });
     question1.getAnswers()[1].setNextQuestion(question2);
    }

    public static Question PlayGame(Question startQuestion)
    {
        Question currentQuestion = startQuestion;
        while (currentQuestion != null)
        {
            System.out.println(currentQuestion.getQuestionText());

            Answer[] answers = currentQuestion.getAnswers();
            for (int i = 0; i < answers.length; i++)
            {
                System.out.println((i + 1) + " . " + answers[i].getAnswerText());
            }

            int userChoice = 2;
            Answer selectedAnswer = answers[userChoice - 1];
            if (selectedAnswer.isCorrect()){
                System.out.println("CORRECT answer! Game Over. ");
                currentQuestion = selectedAnswer.getNextQuestion();
            }
            else {
                System.out.println("incorrect answer! Game Over. ");
                currentQuestion = null;
            }

        }

        return currentQuestion;
    }
}
