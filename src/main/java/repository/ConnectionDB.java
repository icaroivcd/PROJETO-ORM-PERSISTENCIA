/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ícaro Viníciua &lt;Ícaro Vinícius at ifnmg.edu.br&gt;
 */
public class ConnectionDB {

    
    private static Connection connection;

  
    public static final String URL;

    // Database user
    private static final String USER;

    
    private static final String PASSWORD;

    
    static {
        
        URL = "jdbc:mysql://localhost:3306/" + Dao.DB
                + "?useUnicode=true"
                + "&useJDBCCompliantTimezoneShift=true"
                + "&serverTimezone=UTC"
                + "&autoReconnect=true";
        USER = "root";
        PASSWORD = "";
    }

    //<editor-fold defaultstate="collapsed" desc="Construtor privado">
    
    private ConnectionDB() {
    }
    //</editor-fold>

    public static Connection getConnection() {

        
        if (connection == null) {
            
            try {
                System.out.println(">> New database connection");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex); 
            }
        }
        return connection;
    }
}
