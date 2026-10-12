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
 * @author Samuel Pearson 250302305
 */
public class MajorsDB {
    
    private final DBManager dbManager;
    private final Connection conn;
    private Statement statement;
    private ResultSet rs;
    
    public MajorsDB()
    {
        dbManager = new DBManager();
        conn = dbManager.getConnection();
    }
    
    public void createMajorTables()
    {
        try
        {
            statement = conn.createStatement();
            rs = statement.executeQuery("SELECT * FROM MAJOR");
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
            statement.executeUpdate("CREATE TABLE MAJOR(DEGREE VARCHAR(100), MAJOR_NAME VARCHAR(100), COURSES_ASSOC VARCHAR(75))");
            
            statement.executeUpdate("INSERT INTO MAJOR VALUES('Bachelor of Business', 'Accounting', 'BUSS512, BUSS514, ACCT703'),"
                    + "('Bachelor of Computer and Information Sciences', 'Software Development', 'COMP500, COMP501, COMP503'),"
                    + "('Bachelor of Design', 'Animation, Visual Effects, and Game Design', 'DESN511, DESN711, DIGD511')");
            

        }
        catch(SQLException e)
        {
            
        }
    }
}
