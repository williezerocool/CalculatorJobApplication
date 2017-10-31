
package CalculatorDataStore;

import CalculatorApp.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class DataStore {
    
    Connection conn;
    
    public DataStore() throws SQLException {
       
        DatabaseConnection c = new DatabaseConnection();
        conn = c.getConnection();
    }
    
    public void addUserNameToDB(String userName) {
    
        try{
            
            String sql = "INSERT INTO User(userName) VALUEs(?)";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, userName);
            
            stmt.execute();
            
        } catch(SQLException ex) {
        
            ex.getSQLState();
        }
    }


    public void addCalculations(String userName, int Calculations, String equation) {
    
        String cal = Integer.toString(Calculations);
       
        try{
            
            String sql = "INSERT INTO calculations(usrName, calculationscol, equation) VALUES(?, ?, ?)";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, userName);
            stmt.setString(2, cal);
            stmt.setString(3, equation);
            
            stmt.execute();
            
        } catch(SQLException ex) {
        
            ex.getSQLState();
        }
    }
    
    public List<User> getCalculationRecords() {
        
        List<User> list = new ArrayList<>();
        
        try {
        
            String sql = "Select * FROM calculations";
            
            Statement stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()) {
            
                User usr = new User();
                usr.setName(rs.getString(1));
                usr.setCalculation(rs.getString(2));
                usr.setEquation(rs.getString(3));
                
                list.add(usr);
                
            }
          
            
        } catch(SQLException ex) {
        
            ex.getSQLState();
        }
        
        return list;
   }
}
