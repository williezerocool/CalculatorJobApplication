
package CalculatorDataStore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
    
    private Connection conn;

    public DBConnection() throws SQLException {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/calculatorJobApp?useSSL=false", "root", "williemysql");
    }

    public Connection getConnection() {
        return conn;
    }
    
}
