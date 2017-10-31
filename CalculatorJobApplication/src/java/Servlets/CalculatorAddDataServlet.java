/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import CalculatorApp.User;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import CalculatorDataStore.DataStore;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author kendrabooker
 */
@WebServlet(name = "CalculatorAddDataServlet", urlPatterns = {"/CalculatorAddDataServlet"})
public class CalculatorAddDataServlet extends HttpServlet {

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       User usr = new User();
       
       int calculation;
       String userName, equation;
       usr.setName(request.getParameter("userName"));
       usr.setEquation(request.getParameter("equation"));
       
      
        
       try {
           
           String eq = usr.getEquation();
            calculation =  doMath(usr.getEquation());
            usr.setCalculation(Integer.toString(calculation));
            request.setAttribute("user", usr);
            
            DataStore ds = new DataStore();
            ds.addCalculations(usr.getName(), calculation, eq);
            ds.addUserNameToDB(usr.getName());
            
            
        } catch (ScriptException ex) {
            Logger.getLogger(CalculatorAddDataServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CalculatorAddDataServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
       
   request.setAttribute("userName", usr.getName());
       RequestDispatcher rd = request.getRequestDispatcher("redirect.jsp");
       rd.forward(request, response);
        
    }

    public int doMath(String equation) throws ScriptException {
    
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        
        String calculation = engine.eval(equation).toString();
        int cal = Integer.parseInt(calculation);
        
        return cal;
    }
   
}
