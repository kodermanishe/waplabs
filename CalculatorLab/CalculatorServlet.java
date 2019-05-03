/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 987066
 */
public class CalculatorServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   protected void doGet(HttpServletRequest request,
 HttpServletResponse response)throws ServletException, IOException
 {
 PrintWriter out = response.getWriter();
 out.print("<html><head><title>Simple calculator</title></head><body>");
 out.print("<form method='post'>");
 out.print("<input type='text' name='num1' width='4' placeholder='0'>");
 out.print(" + ");
 out.print("<input type='text' name='num2' width='4' placeholder='0'><br/><br/>");
 out.print("<input type='text' name='num3' width='4' placeholder='0'>");
 out.print(" * ");
 out.print("<input type='text' name='num4' width='4' placeholder='0'><br/><br/>");
 out.print("<input type='submit' value='Submit'/>");
 out.print("</form>");
 out.print("</body></html>");
 }

 protected void doPost(HttpServletRequest request,
 HttpServletResponse response) throws ServletException, IOException
 {
 int n1 = 0;
 int n2 = 0;
 int n3 = 0;
 int n4 = 0;
 
if (!request.getParameter("num1").equals(""))
     n1 = Integer.parseInt(request.getParameter("num1"));
if (!request.getParameter("num2").equals(""))
     n2 = Integer.parseInt(request.getParameter("num2"));
if (!request.getParameter("num3").equals(""))
     n3 = Integer.parseInt(request.getParameter("num3"));
if (!request.getParameter("num4").equals(""))
     n4 = Integer.parseInt(request.getParameter("num4"));

 PrintWriter out = response.getWriter();
 out.print("<html><head><title>Result</title></head><body>");
 if (n1 > 0 || n2 > 0){
     out.print("<p>"+n1+" + "+n2+" = "+(n1+n2)+"</p>");
 } 
 if (n3 > 0 || n4 > 0){
     out.print("<p>"+n3+" * "+n4+" = "+(n3*n4)+"</p>");
 }
 out.print("</body></html>");
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
