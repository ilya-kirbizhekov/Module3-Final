package com.ilyoniss.module3final.gameobjects;

public class Quiz {
    // game constructor

    public static void PlayGame(Question startQuestion)
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

            int userChoice = 1; // TO DO get from servlet

            Answer selectedAnswer = answers[userChoice - 1];
            if (selectedAnswer.isCorrect()){
                System.out.println("CORRECT answer! Game Over. ");
                currentQuestion = selectedAnswer.getNextQuestion();
            }
            else {
                //perform the assotiated action
                Action action = selectedAnswer.getAction();
                if (action != null)
                {
                    action.performAction();
                }

                System.out.println("incorrect answer! Game Over. ");
                currentQuestion = null;
            }

        }

    }
}
