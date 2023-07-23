package com.ilyoniss.module3final.servlets;

import com.ilyoniss.module3final.gameobjects.Answer;
import com.ilyoniss.module3final.gameobjects.Question;
import com.ilyoniss.module3final.gameobjects.QuestionRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/TextGameServlet")
public class TextGameServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private Question currentQuestion;
    private QuestionRepository questionRepository;

    @Override
    public void init() throws ServletException {
        super.init();
        // Initialize the question repository and get the starting question by its ID
        questionRepository = new QuestionRepository();
        currentQuestion = questionRepository.getQuestion("q1");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userChoice = request.getParameter("userChoice");
        if (userChoice != null) {
            int choiceIndex = Integer.parseInt(userChoice);
            Answer selectedAnswer = currentQuestion.getAnswers()[choiceIndex];
            if (selectedAnswer.isCorrect()) {
                currentQuestion = selectedAnswer.getNextQuestion();
                if (currentQuestion == null) {
                    // Game over
                    request.setAttribute("question", currentQuestion);
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                    return;

                }
            } else {
                // Game over
                request.setAttribute("answer", selectedAnswer);
                request.setAttribute("result", selectedAnswer.getAction().getActionText());
                request.setAttribute("message", "Incorrect answer! Game over.");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                return;
            }
        }


    }

}
