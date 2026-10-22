/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Samuel Pearson 25302305
 */
public final class DBManager {
    //Made sure this will run natively without having to do setup
    private static final String USER_NAME = "pdc";
    private static final String PASSWORD = "pdc"; 
    private static final String URL = "jdbc:derby:StudentManagementSystemDB;create=true";
    
    Connection conn;
    //Sets up the connection constructor
    public DBManager() {
        establishConnection();
    }   
    //gets the connection
    public Connection getConnection() {
        return this.conn;
    }

    //Establish connection
    public void establishConnection() {
        
        try {
            conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            System.out.println(URL+" connected...");
        }
        catch(SQLException e)
        {
            System.err.println("SQLException: " + e.getMessage());
        }
    }
    //closes the connections
    public void closeConnections() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public ResultSet queryDB(String sql) {

        Connection connection = this.conn;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return resultSet;
    }

    public void updateDB(String sql) {

        Connection connection = this.conn;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
