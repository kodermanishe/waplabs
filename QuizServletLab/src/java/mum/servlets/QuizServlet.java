/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
            model = (QuizModel) ss.getAttribute("quiz");
            
        PrintWriter out = response.getWriter();
        String question = model.next();
        ss.putValue("quiz", model);
        
        out.print("<html><head><title>Quiz</title></head><body>");
        out.print("<form method='post'>");
        out.print("<h2>The number quiz</h2>");
        out.print("<p>Your current score is "+model.getCorrectAnswers()+"</p>");
        out.print("<p>Quess the next number in the sequence.</p>");
        out.print("<p>"+question+"</p>");
        out.print("<label>Your answer:</label><input type='text' name='answer' width='3'>");
        out.print("<input type='submit' value='Submit'>");
        out.print("</form>");
        out.print("</body></html>");        
              
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ss = request.getSession();
        PrintWriter out = response.getWriter();
        
        QuizModel model = (QuizModel)ss.getAttribute("quiz");
        
        if (model.isGameFinished()){
            out.print("<html><head><title>Result of quiz</title></head><body>");
            out.print("<h2>Your current score is "+model.getCorrectAnswers()+"</h2>");
            out.print("<p>You have completed the number quiz, with a score of "
                    +model.getCorrectAnswers()+" out of "+model.getCountOfQuestions()+".</p>");
            out.print("</form>");
            out.print("</body></html>"); 
        }else{
            int ans = Integer.parseInt(request.getParameter("answer"));
            model.putAnswer(ans);
            String question = model.next();          
            ss.putValue("quiz", model);
            out.print("<html><head><title>Quiz</title></head><body>");
            out.print("<form method='post'>");
            out.print("<h2>The number quiz</h2>");
            out.print("<p>Your current score is "+model.getCorrectAnswers()+"</p>");
            out.print("<p>Quess the nex number in the sequence.</p>");
            out.print("<p>"+question+"</p>");
            out.print("<label>Your answer:</label><input type='text' name='answer' width='3'>");
            out.print("<input type='submit' value='Submit'>");
            out.print("</form>");
            out.print("</body></html>");
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
