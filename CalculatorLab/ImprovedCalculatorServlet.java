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
    * @author HP Pavilion
    */
    public class ImprovedCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
    HttpServletResponse response)throws ServletException, IOException
    {
    PrintWriter out = response.getWriter();
    out.print("<html><head><title>Simple calculator</title></head><body>");
    out.print("<form method='post'>");
    out.print("<input type='text' name='num1' width='4' placeholder='0'>");
    out.print(" + ");
    out.print("<input type='text' name='num2' width='4' placeholder='0'>");
    out.print(" = ");
    out.print("<input type='text' name='res1' width='4' placeholder='0'><br/><br/>");
    out.print("<input type='text' name='num3' width='4' placeholder='0'>");
    out.print(" * ");
    out.print("<input type='text' name='num4' width='4' placeholder='0'>");
    out.print(" = ");
    out.print("<input type='text' name='res2' width='4' placeholder='0'><br/><br/>");
    out.print("<input type='submit' value='Submit'/>");
    out.print("</form>");
    out.print("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request,
    HttpServletResponse response) throws ServletException, IOException
    {
        
    int n1 = 0;
    int n2 = 0;
    int n3 = 0;
    int n4 = 0;
    
    String n1Str = request.getParameter("num1");
    String n2Str = request.getParameter("num2");
    String n3Str = request.getParameter("num3");
    String n4Str = request.getParameter("num4");

    if (!n1Str.equals(""))
     n1 = Integer.parseInt(n1Str);
    if (!n2Str.equals(""))
     n2 = Integer.parseInt(n2Str);
    if (!n3Str.equals(""))
     n3 = Integer.parseInt(n3Str);
    if (!n4Str.equals(""))
     n4 = Integer.parseInt(n4Str);

    
    PrintWriter out = response.getWriter();
    out.print("<html><head><title>Simple calculator</title></head><body>");
    out.print("<form method='post'>");
    out.print("<input type='text' name='num1' width='4' value='"+n1Str+"' placeholder='0'>");
    out.print(" + ");
    out.print("<input type='text' name='num2' width='4' value='"+n2Str+"' placeholder='0'>");
    out.print(" = ");
    
    if (n1>0 || n2 > 0)
        out.print("<input type='text' name='res1' width='4' value='"+(n1+n2)+"' placeholder='0'><br/><br/>");
    else
        out.print("<input type='text' name='res1' width='4' placeholder='0'><br/><br/>");
    
    out.print("<input type='text' name='num3' width='4' value='"+n3Str+"' placeholder='0'>");
    out.print(" * ");
    out.print("<input type='text' name='num4' width='4' value='"+n4Str+"' placeholder='0'>");
    out.print(" = ");
    if (n3>0 || n4 > 0)
        out.print("<input type='text' name='res2' width='4' value='"+(n3*n4)+"' placeholder='0'><br/><br/>");
    else
        out.print("<input type='text' name='res2' width='4' placeholder='0'><br/><br/>");
    out.print("<input type='submit' value='Submit'/>");
    out.print("</form>");
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
