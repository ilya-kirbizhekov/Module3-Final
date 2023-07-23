package com.ilyoniss.module3final.gameobjects;

public class Answer {
    private String answerText;
    private boolean isCorrect;
    private Question nextQuestion;

    private Action action;

    public Answer(String answerText, boolean isCorrect, Question nextQuestion, Action action) {
        this.answerText = answerText;
        this.isCorrect = isCorrect;
        this.nextQuestion = nextQuestion;
        this.action = action;

    }

    public String getAnswerText()
    {
        return answerText;
    }

    public boolean isCorrect()
    {
        return isCorrect;
    }

    public Question getNextQuestion() {
        return nextQuestion;
    }

    public Question setNextQuestion(Question nextQuestion) {
        return nextQuestion;
    }

    public Action getAction()
    {
        return action;
    }
}
