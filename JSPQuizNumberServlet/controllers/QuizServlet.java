/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mum.models.QuizModel;

/**
 *
 * @author HP Pavilion
 */
public class QuizServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ss = request.getSession();
        QuizModel model;
        if (ss.isNew())
            model = new QuizModel();
        else
            model = (QuizModel) ss.getAttribute("model");
        
        String question = model.next();          
        ss.putValue("model", model);
        request.setAttribute("score", model.getCorrectAnswers());
        request.setAttribute("question", question);
        request.setAttribute("age", model.getAge());
        RequestDispatcher view = request.getRequestDispatcher("views/QuestionPage.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ss = request.getSession();        
        QuizModel model = (QuizModel)ss.getAttribute("model"); 
        
        if (Objects.nonNull(request.getParameter("answer")) 
                    && !request.getParameter("answer").equals(""))
                model.putAnswer(Integer.parseInt(request.getParameter("answer")));
        if (model.isGameFinished()){
           String grade = "";
           int score  = model.getCorrectAnswers();
           if (score >= 45 && score <= 50)
               grade = "A";          
            else if (score >= 35 && score <= 44)
               grade = "B";
            else if (score >= 25 && score <= 34)
               grade = "C";
           else if (score < 25)
               grade = "NC";
           request.setAttribute("score", score);
           request.setAttribute("grade", grade);
           request.setAttribute("questions", model.getCountOfQuestions());
           request.setAttribute("age", model.getAge());
           RequestDispatcher view = request.getRequestDispatcher("views/ResultPage.jsp"); 
           view.forward(request, response);
        }else{            
            ss.putValue("model", model);
            request.setAttribute("score", model.getCorrectAnswers());  
            request.setAttribute("age", model.getAge());
            request.setAttribute("question", model.next());
            RequestDispatcher view = request.getRequestDispatcher("views/QuestionPage.jsp");
            view.forward(request, response);
        }          
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
