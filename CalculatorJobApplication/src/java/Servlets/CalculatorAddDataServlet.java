/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;


import CalculatorDataStore.DataStore;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kendrabooker
 */
@WebServlet(name = "CalculatorAddDataServlet", urlPatterns = {"/CalculatorAddDataServlet"})
public class CalculatorAddDataServlet extends HttpServlet {

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String userName = request.getParameter("userName");
        String firstNumber = request.getParameter("fisrtName");
        String secondNumber = request.getParameter("secondNumber");
        String operation = request.getParameter("operation");
        int calculation = makeCalulation(Integer.parseInt(firstNumber), Integer.parseInt(secondNumber), operation);
        
        try{
        
            DataStore ds = new DataStore();
            ds.addUserNameToDB(userName);
            ds.addCalculations(userName, calculation);
            
        } catch(SQLException ex) {
        
            
        }
        
    }

    public int makeCalulation(int firstNum, int secondNum, String operation) {
    
        int cal = 0;
        
        
        if(operation == "+") {
        
            cal = firstNum + secondNum;
        
        } else if (operation == "-") {
        
            cal = firstNum - secondNum;
            
        } else if(operation == "*") {
        
            cal = firstNum * secondNum;
            
        } else {
        
            cal = firstNum / secondNum;
        }
        
        return cal;
     }
   
}
