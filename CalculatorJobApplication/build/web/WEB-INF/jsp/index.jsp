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
                <input type="text" name="usrName"><br><br><br>
                
                <label>Enter Numbers And Operation Here:</label><br>
                
                <input type="text" name="firstNumber"><br>
                <select>
                    <option value="+">Add</option>
                    <option value="-">Subtract</option>
                    <option value="*">Multiply</option>
                    <option value="/">Divide</option>
                </select><br>
                <input type="text" name="secondNumber"> <br>
                <button type="submit" name="submit">Get Answer</button>
            </form>
            
        </div>
    </body>
</html>
