/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author aburom
 */
public class DBConnection {

    private static DBConnection aDBConnection;

    private static Connection aConnection;
    
    private static Statement aStatement;
    

    private DBConnection() throws SQLException {}

    public static DBConnection getInstance() throws SQLException {
        
        if (aDBConnection == null) {
            aDBConnection = new DBConnection();
        }
        return aDBConnection;
    }
    

    
    public Statement getStatement() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        aConnection = DriverManager.getConnection("jdbc:mysql://localhost/HRMS?user=root&password=root");
        aStatement = aConnection.createStatement();
        return aStatement;
    }
    
    
    public Connection getConnection() throws ClassNotFoundException, SQLException{
        return aConnection;
    }
    
    

}
