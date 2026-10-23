/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanagementsystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Samuel Pearson 25302305
 */
public class FacultiesDB {
    
    private final DBManager dbManager;
    private final Connection conn;
    private Statement statement;
    private ResultSet rs;
    //Sets up the connection
    public FacultiesDB()
    {
        dbManager = new DBManager();
        conn = dbManager.getConnection();
    }
    //Creates the Faculty tables and inserts data, checks if the table already exists first
    public void createFacultiesTable()
    {
        try
        {
            statement = conn.createStatement();            
            rs = statement.executeQuery("SELECT * FROM FACULTY");
            if(rs.next()) {
                System.out.println("Tables exist, checks passed...");            
                return;
            }
        }
        catch (SQLException e)
        {
            System.out.println("Tables don't exist. Creating tables...");
        }
        
        try
        {
            statement = conn.createStatement();
            statement.executeUpdate("CREATE TABLE FACULTY(NAME VARCHAR(100), LOCATION VARCHAR(30), COURSES_ASSOC VARCHAR(75))");
            
            statement.executeUpdate("INSERT INTO FACULTY VALUES('Business, Economics, & Law', 'WF Building', 'BUSS512, BUSS514, ACCT703'),"
                    + "('Engineering, Computing, & Mathematical Sciences', 'WZ Building', 'COMP500, COMP501, COMP503'),"
                    + "('Faculty of Design & Creative Technologies', 'WE Building', 'DESN511, DESN711, DIGD511')");
        }
        catch(SQLException e)
        {
            System.out.println("Error creating or inserting tables");
            e.printStackTrace();
        }
    }
    
}
