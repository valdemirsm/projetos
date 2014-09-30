/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Valdemir
 */
public class ConnectionFactory {
    public static Connection getConnection() throws SQLException { 
    try { 
            Class.forName("org.postgresql.Driver"); 
            System.out.println("Conectando ao banco"); 
            return DriverManager.getConnection("jdbc:postgresql://localhost/bdteste", "postgres", "123"); 
        } catch (ClassNotFoundException e) { 
            throw new SQLException(e.getMessage()); 
        } 
    }
}
