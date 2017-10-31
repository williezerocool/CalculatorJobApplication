
package CalculatorApp;

import java.sql.Date;
import java.time.LocalDate;


public class User {
    
    String name, calculation, equation;
    LocalDate date;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCalculation() {
        return calculation;
    }

    public void setCalculation(String calculation) {
        this.calculation = calculation;
    }

    public String getEquation() {
        return equation;
    }

    public void setEquation(String equation) {
        this.equation = equation;
    }

    

    
}
