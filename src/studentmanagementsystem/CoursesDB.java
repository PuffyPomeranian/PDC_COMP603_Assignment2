/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanagementsystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

/**
 *
 * @author Playtech
 */
public class CoursesDB {
    
    private final DBManager dbManager;
    private final Connection conn;
    private Statement statement;
    private ResultSet rs;
    //Sets up the connection to the DBManager
    public CoursesDB() {
        dbManager = new DBManager();
        conn = dbManager.getConnection();
    }
    //Creates the courses and checks if it's already created too
    public void createCoursesTable()
    {
        try
        {
            statement = conn.createStatement();
            rs = statement.executeQuery("SELECT * FROM COURSES");
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
            statement.execute("CREATE TABLE COURSES(COURSE_ID VARCHAR(20), NAME VARCHAR(75), CREDITS INT, PRICE FLOAT)");
            
            statement.execute("INSERT INTO COURSES VALUES('BUSS512', 'Accounting & Info Systems', 15, 1250.25),"
                    + "('BUSS514', 'Marketing & Global Business', 15, 1150.25),"
                    + "('ACCT703', 'Management & Accounting', 15, 1800.00),"
                    + "('COMP500', 'Introduction to Programming', 15, 1500.50),"
                    + "('COMP503', 'Object Orientated Programming', 15, 1500.50),"
                    + "('COMP501', 'Computing Technology in Society', 15, 1900.50),"
                    + "('DESN511', 'Introduction to Design Practices', 30, 2500.00),"
                    + "('DIGD511', 'Animation, Visual Effects & Game Design Practices 1', 30, 2500.00),"
                    + "('DESN711', 'Integrated Design Practice', 60, 4250.75)");
            
        }
        catch(SQLException e)
        {
            System.out.println("Error inserting into or creating tables.");
        }
    }
    
}
