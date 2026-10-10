/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanagementsystem;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


/**
 *
 * @author Samuel Pearson 25302305
 */
public class StudentsDB {
    
    private final DBManager dbManager;
    private final Connection conn;
    private Statement statement;
    
    public StudentsDB() {
        dbManager = new DBManager();
        conn = dbManager.getConnection();
    }
    
    public void createStudentsTable()
    {
        try
        {
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM STUDENT");
            if(rs.next()) {
                System.out.println("Tables exits, checks passed...");            
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
            //Creating the Student table 
                            
            statement.executeUpdate("CREATE TABLE STUDENT(ID INT, FIRST_NAME VARCHAR(50), LAST_NAME VARCHAR(50), COURSE_UNDERTAKING VARCHAR(10), MARKS VARCHAR(50), ATTENDANCE VARCHAR(10))");
            
            statement.executeUpdate("INSERT INTO STUDENT VALUES (1, 'Alex', 'Walker', 'COMP501', '30, 30, 30', '100%')");
            statement.executeUpdate("INSERT INTO STUDENT VALUES (2, 'Lucy', 'Taylor', 'ACCT703', '22, 30, 29', '80%')");
            statement.executeUpdate("INSERT INTO STUDENT VALUES (3, 'Ethan', 'Moore', 'BUSS512', '10, 20, 60, 5', '92%')");
            statement.executeUpdate("INSERT INTO STUDENT VALUES (4, 'Chloe', 'Adams', 'COMP501', '30, 20, 40', '100%')");
            statement.executeUpdate("INSERT INTO STUDENT VALUES (5, 'Noah', 'Baker', 'BUSS512', '0, 0, 0, 0', '4%')");
            statement.executeUpdate("INSERT INTO STUDENT VALUES (6, 'Samuel', 'Jackson', 'COMP500', '22, 25, 37', '86%')");
            statement.executeUpdate("INSERT INTO STUDENT VALUES (7, 'Jennifer', 'Tailors', 'DESN711', '12, 17, 2', '33%')");
            statement.executeUpdate("INSERT INTO STUDENT VALUES (8, 'John', 'Shoore', 'DIGD511', '22, 12, 12', '46%')");
            statement.executeUpdate("INSERT INTO STUDENT VALUES (9, 'Jack', 'Breacher', 'COMP503', '10, 10, 40, 20', '75%')");
            statement.executeUpdate("INSERT INTO STUDENT VALUES (10, 'Sarah', 'Peterson', 'BUSS514', '25, 25, 50', '98%')");
            statement.executeUpdate("INSERT INTO STUDENT VALUES (11, 'James', 'Alexander', 'COMP501', '12, 20, 20', '72%')");
            statement.executeUpdate("INSERT INTO STUDENT VALUES (12, 'Mary', 'Beth', 'ACCT703', '30, 30, 29', '62%')");
            statement.executeUpdate("INSERT INTO STUDENT VALUES (13, 'Wiremu', 'Taua', 'BUSS512', '10, 20, 60, 10', '100%')");
            statement.executeUpdate("INSERT INTO STUDENT VALUES (14, 'Jaquelyn', 'Toa', 'COMP501', '10, 10, 40', '68%')");
            statement.executeUpdate("INSERT INTO STUDENT VALUES (15, 'Frank', 'Stevens', 'BUSS512', '10, 20, 0, 10', '33%')");
            statement.executeUpdate("INSERT INTO STUDENT VALUES (16, 'Xavier', 'Huia', 'COMP500', '30, 30, 40', '100%')");
            statement.executeUpdate("INSERT INTO STUDENT VALUES (17, 'Sandra', 'Bulls', 'DESN711', '15, 17, 20', '30%')");
            statement.executeUpdate("INSERT INTO STUDENT VALUES (18, 'Lochlan', 'Anthony', 'DESN511', '20, 20, 30', '62%')");
            statement.executeUpdate("INSERT INTO STUDENT VALUES (19, 'Zachary', 'Rancher', 'COMP503', '3, 7, 37, 20', '24%')");
            statement.executeUpdate("INSERT INTO STUDENT VALUES (20, 'Sapphire', 'Kenny', 'BUSS514', '18, 25, 50', '56%')");           
                                  
        }
        catch (SQLException e)
        {
            System.out.println("Invalid statements");            
        }  
        
        
    }
    
    public static void editStudentData(String course, int mark1, int mark2, int mark3, int mark4, int attendance)            
    {
        System.out.println("It is making it to here");
        System.out.println(course +"\n" + mark1+"\n" + mark2+"\n" + mark3 +"\n"+ mark4+"\n"+ attendance);
    }
    
}
