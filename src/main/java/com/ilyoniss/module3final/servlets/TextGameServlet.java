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
    private Question currentQuestion;

    @Override
    public void init() throws ServletException {
        super.init();
        // Initialize the question repository and get the starting question by its ID
        QuestionRepository questionRepository = new QuestionRepository();
        currentQuestion = questionRepository.getQuestion("q1");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userChoice = request.getParameter("userChoice");
        if (userChoice != null) {
            // from radio button, selected radiobutton id
            int choiceIndex = Integer.parseInt(userChoice);
            //get answer from repository
            Answer selectedAnswer = currentQuestion.getAnswers()[choiceIndex];
            // if answer is correct, meaning linked to next answer (allow to ask next question)
            if (selectedAnswer.isCorrect()) {
                // get next question
                currentQuestion = selectedAnswer.getNextQuestion();
                // end of game
                if (currentQuestion == null) {
                    // end of map
                    request.setAttribute("answer", selectedAnswer);
                    request.setAttribute("result", selectedAnswer.getAction().getActionText());
                    request.getRequestDispatcher("/index.jsp").forward(request, response);

                }
                else {
                    request.setAttribute("question", currentQuestion);
                    request.setAttribute("message", "");
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                }

            }
            else {
                // Game over
                request.setAttribute("answer", selectedAnswer);
                request.setAttribute("result", selectedAnswer.getAction().getActionText());
                request.setAttribute("message", "Incorrect answer! Game over.");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
        }

    }

}
