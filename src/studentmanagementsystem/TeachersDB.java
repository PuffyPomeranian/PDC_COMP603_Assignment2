/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanagementsystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Playtech
 */
public class TeachersDB {
    
    private final DBManager dbManager;
    private final Connection conn;
    private Statement statement;
    private ResultSet rs;
    //Sets up the connection
    public TeachersDB()
    {
        dbManager = new DBManager();
        conn = dbManager.getConnection();
    }
    //Creates the Teacher table and inserts data, if the table is already made then it returns
    public void createTeacherTable()
    {
        try
        {
            statement = conn.createStatement();
            rs = statement.executeQuery("SELECT * FROM TEACHER");
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
            
            statement.executeUpdate("CREATE TABLE TEACHER(ID INT, FIRST_NAME VARCHAR(50), LAST_NAME VARCHAR(50), POSITION VARCHAR(50), COURSE_ID VARCHAR(10))");
            
            statement.executeUpdate("INSERT INTO TEACHER VALUES(10, 'Michael', 'Brown', 'Teaching Assistant', 'BUSS512'),"
                    + "(20, 'Sophia', 'Brown', 'Lecturer', 'BUSS514'),"
                    + "(30, 'Ethan', 'White', 'Senior Lecturer', 'ACCT703'),"
                    + "(40, 'Emma', 'Clark', 'Lecturer', 'COMP500'),"
                    + "(50, 'Liam', 'Harris', 'Teaching Assistant', 'COMP503'),"
                    + "(60, 'Emilia', 'Black', 'Teaching Assistant', 'DESN511'),"
                    + "(70, 'Clark', 'Gables', 'Teaching Assistant', 'COMP501'),"
                    + "(80, 'Samantha', 'Brackson', 'Lecturer', 'COMP503'),"
                    + "(90, 'Peter', 'Cleric', 'Senior Lecturer', 'DESN711'),"
                    + "(100, 'Levi', 'Lemon', 'Lecturer', 'DIGD511'),"
                    + "(110, 'Jack', 'Johnson', 'Lecturer', 'DIGD511'),"
                    + "(120, 'Samantha', 'Hayes', 'Teaching Assistant', 'COMP501'),"
                    + "(130, 'Jenny', 'Keyes', 'Lecturer', 'COMP503')");            
        }
        catch (SQLException e)
        {
            
        }
    }
    //Method for adding a teacher referred from the add teacher JFrame, inherits the variables to insert
    //Into the database
    public void addTeacher(int id, String firstName, String lastName, String position, String course)
    {
        
        //This method inserts the new teacher from the add teacher window into the database for Teachers
        try
        {
            statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO TEACHER VALUES("+id+", '"+firstName+"', '"+lastName+"', '"+position+"', '"+course+"')");
        }
        catch(SQLException e)
        {
            System.out.println("Error adding teacher");
        }
    }
    //Remove teacher based on the ID entered and inherited from that JFrame
    public void removeTeacher(int id)
    {
        try
        {
           statement = conn.createStatement();
           statement.executeUpdate("DELETE FROM TEACHER WHERE ID = "+id);
           JOptionPane.showConfirmDialog(null, "Teacher has been removed.","Information",JOptionPane.DEFAULT_OPTION);
        }
        catch(SQLException e)
        {
            System.out.println("Error removing teacher");
        }
    }
    
}
