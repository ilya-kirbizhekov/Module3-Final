package com.ilyoniss.module3final.servlets;

import com.ilyoniss.module3final.gameobjects.Question;
import com.ilyoniss.module3final.gameobjects.QuestionRepository;

import java.io.*;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "/InitServlet", value = "/startGame")
public class InitServlet extends HttpServlet {
    private String message;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession currentSession = request.getSession(true);
        // create question->answer repo and set first question
        QuestionRepository questionRepository = new QuestionRepository();
        Question currentQuestion = questionRepository.getQuestion("q1");

        request.setAttribute("question", currentQuestion);
        request.setAttribute("message", "");
        request.getRequestDispatcher("/index.jsp").forward(request, response);

    }

}