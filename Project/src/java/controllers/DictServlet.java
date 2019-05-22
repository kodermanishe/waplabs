package controllers;

import beans.Entry;
import com.fasterxml.jackson.databind.ObjectMapper;
import db.DbConnection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DictServlet extends HttpServlet {
    DbConnection connection = new DbConnection();
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String word = req.getParameter("word");
        List<Entry> entries = new ArrayList<>();
        try {
            if (connection.connect()){
                entries = connection.selectDataByWord(word);   
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DictServlet.class.getName()).log(Level.SEVERE, null, ex);        
        }        
        resp.setContentType("application/json");
        String jsonStr = new ObjectMapper().writeValueAsString(entries);
        resp.getWriter().write(jsonStr);
        
    }
    
   @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pr = resp.getWriter();
        pr.write("Test");
    } 
}
