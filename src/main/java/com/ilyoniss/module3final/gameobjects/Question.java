package com.ilyoniss.module3final.gameobjects;

public class Question {
    private String questionText;
    private Answer[] answers;

    public Question(String questionText, Answer[] answers) {
        this.questionText = questionText;
        this.answers = answers;
    }

    public String getQuestionText()
    {
        return questionText;
    }

    public Answer[] getAnswers()
    {
        return answers;
    }

    public void executeAction(int answerIndex)
    {
        Answer selectedAnswer = answers[answerIndex];
        Action action = selectedAnswer.getAction();
        if (action!=null)
        {
            action.performAction();
        }
    }

}
