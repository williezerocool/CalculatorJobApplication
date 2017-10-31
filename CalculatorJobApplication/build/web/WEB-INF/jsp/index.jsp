<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="CalculatorApp.User"%>
<%@page import="CalculatorDataStore.DataStore"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <div>
            <h1>You're Welcome To Use My Calculator</h1><br>
            
            
            
            <form method="post" action="CalculatorAddDataServlet">
                
                <label>Enter Username:</label>
                <input type="text" name="userName"><br><br><br>
                
                <label>Enter Your Equation:</label><br>
                <input type="text" name="equation">
                <button type="submit" name="submit">Get Answer</button>
            </form>
            
            <ul id="calculationList">
                <li>
                    <% 
                    DataStore d = new DataStore();
                    List<User> usr = new ArrayList<>();
                    List<User> usrList = new ArrayList<>();
                    usr = d.getCalculationRecords();
                    String name = "";
                    String equation = "" ;
                    String calculation = "";
                    
                     
                    if(usr.size() > 10) {
                        
                        usrList = usr.subList(usr.size()-10, usr.size());
                        Collections.reverse(usrList);
                    }else {
                    
                        usrList = usr;
                        Collections.reverse(usrList);
                    }
                    for(int i = 0; i < usrList.size(); i++){
                        name = usrList.get(i).getName();
                        equation = usrList.get(i).getEquation();
                        calculation = usrList.get(i).getCalculation();
                    out.println(name + "<br>" +  equation + " = " + calculation + "<br><br><br>" ); 
                    }
                %>
                </li>
                
            </ul>
            
            
        </div>
    </body>
</html>
