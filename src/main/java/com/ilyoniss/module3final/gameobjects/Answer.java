package com.ilyoniss.module3final.gameobjects;

public class Answer {
    private final String answerText;
    private final boolean isCorrect;
    private Question nextQuestion;
    private final Action action;

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

    public void setNextQuestion(Question nextQuestion) {
        this.nextQuestion = nextQuestion;
    }

    public Action getAction()
    {
        return action;
    }
}
