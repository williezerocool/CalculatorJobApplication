<%-- 
    Document   : equations
    Created on : Oct 30, 2017, 4:40:45 PM
    Author     : kendrabooker
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="CalculatorAddDataServlet">
                
              <label>Enter Your Equation:</label><br>
                <input type="text" name="equation">
                <button type="submit" name="submit">Get Answer</button>
        </form>
    </body>
</html>
