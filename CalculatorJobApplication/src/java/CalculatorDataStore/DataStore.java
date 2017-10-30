
package CalculatorDataStore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DataStore {
    
    Connection conn;
    
    public DataStore() throws SQLException {
       
        DBConnection c = new DBConnection();
        conn = c.getConnection();
    }
    
    public void addUserNameToDB(String userName) {
    
        try{
            
            String sql = "INSERT INTO User(userName) VALUES(?)";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, userName);
            
            stmt.executeQuery();
            
        } catch(SQLException ex) {
        
            ex.getSQLState();
        }
    }


    public void addCalculations(String userName, int Calculations) {
    
        String cal = Integer.toString(Calculations);
       
        try{
            
            String sql = "INSERT INTO calculations(userName, calculationscol) VALUES(?, ?)";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, userName);
            stmt.setString(2, cal);

            
            stmt.executeQuery();
            
        } catch(SQLException ex) {
        
            ex.getSQLState();
        }
    }
}
