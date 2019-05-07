/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.wap;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author 987066
 */
public class Head extends SimpleTagSupport {
    String thecolor;
    String words;
   
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        
        if (thecolor != null) {
            out.write(String.format(
                "<h1 style='color:%s'>%s</h1>", thecolor, words));
        } else {
            out.write(String.format("<h1>%s</h1>", words));
        }
    }
   
    public void setthecolor(String thecolor) {
        this.thecolor = thecolor;
    }
    
    public void setwords(String words) {
        this.words = words;
    }
}

