/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mum.models.QuizModel;

/**
 *
 * @author 987066
 */
public class HintServlet extends HttpServlet {

    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {       
            RequestDispatcher view = request.getRequestDispatcher("views/AgePage.jsp");
            view.forward(request, response);
        }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean err = false;
        String age = request.getParameter("age");
        int nAge = 0;
        try{
            nAge = Integer.parseInt(age);
        }catch(NumberFormatException e){
           request.setAttribute("msg", "Wrong format");
           RequestDispatcher view = request.getRequestDispatcher("views/AgePage.jsp");
           view.forward(request, response);
           err = true;
        }
        if (!err){
            if (nAge > 100 || nAge < 4){
                request.setAttribute("msg", "Entered number is out of bound");
                RequestDispatcher view = request.getRequestDispatcher("views/AgePage.jsp");
                view.forward(request, response);
                err = true;
            }
        }
        if (!err){
            QuizModel model = new QuizModel();
            HttpSession ss = request.getSession();
            model.setAge(nAge);
            ss.putValue("model", model);
            response.sendRedirect("index.html");
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
