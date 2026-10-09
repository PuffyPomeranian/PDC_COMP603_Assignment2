/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanagementsystem;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Playtech
 */
public class StudentsDB {
    
    private final DBManager dbManager;
    private final Connection conn;
    private Statement statement;
    
    public StudentsDB() {
        dbManager = new DBManager();
        conn = dbManager.getConnection();
    }
    
    public void createStudentsTable(ArrayList<Student> students, ArrayList<Student> stuAttendance)
    {
        try
        {
            statement = conn.createStatement();
            try
            {
                statement.executeUpdate("DROP TABLE STUDENT");
            }            
            catch (SQLException ex)
            {
                System.out.println("Invalid table"); 
                
            }            
            statement.executeUpdate("CREATE TABLE STUDENT(ID INT, FIRST_NAME VARCHAR(50), LAST_NAME VARCHAR(50), COURSE_UNDERTAKING VARCHAR(10), MARKS VARCHAR(20), ATTENDANCE VARCHAR(10))");
            for(int i = 0; i < students.size(); i++)
            {
                //INSERT INTO BOOK VALUES (1, 'Slum Dog Millionaire', 'Fiction', 19.90),
                statement.executeUpdate("INSERT INTO STUDENT VALUES ("+students.get(i).getId()+ ", '"+students.get(i).getFirstName()+"', '"
                + students.get(i).getLastName() + "', '"+ students.get(i).getAssessmentMarks().getCourse().getCode() 
                        + "', '" + students.get(i).getAssessmentMarks().getMarks() + "', '"+stuAttendance.get(i).getAttendance()+ "')");
            }
            
            
        }
        catch (SQLException e)
        {
            System.out.println("Invalid statements");
            e.printStackTrace();
        }
        
    }
    
}
