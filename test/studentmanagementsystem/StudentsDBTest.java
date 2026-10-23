/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package studentmanagementsystem;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import org.junit.Assert;
import static org.junit.Assert.*;

/**
 *
 * @author Samuel Pearson 25302305
 */
public class StudentsDBTest {
    
    private final DBManager dbManager;
    private final Connection conn;
    private Statement statement;
    private ResultSet rs;
    
    public StudentsDBTest() {
        dbManager = new DBManager();
        conn = dbManager.getConnection();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createStudentsTable method, of class StudentsDB.
     */
    @Before
    public void testCreateStudentsTable() {
        System.out.println("createStudentsTable");
        StudentsDB instance = new StudentsDB();
        instance.createStudentsTable();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of editStudentData method, of class StudentsDB.
     */
    @Test
    public void testEditStudentData() {
        System.out.println("editStudentData");
        int id = 1;
        String course = "COMP501";
        int mark1 = 0;
        int mark2 = 0;
        int mark3 = 0;
        int mark4 = 0;
        int attendance = 50;
        StudentsDB instance = new StudentsDB();
        instance.editStudentData(id, course, mark1, mark2, mark3, mark4, attendance);
        // TODO review the generated test code and remove the default call to fail.
        String expected = "50%";
        String actual = "";
        try
        {
            statement = conn.createStatement();
            rs = statement.executeQuery("SELECT * FROM STUDENT");
            while(rs.next())
            {
                if(rs.getString("ATTENDANCE").equals("50%") && rs.getInt("ID") == 1)
                {
                    actual = rs.getString("ATTENDANCE");
                }
            }
        }
        catch(SQLException e)
        {
            System.out.println("Error");
        }
        if(expected.equals(actual))
        {
            System.out.println("Test passed...");
            
        }
        else
        {
            fail();
        }
        
    }

    /**
     * Test of addStudent method, of class StudentsDB.
     */
    @Test
    public void testAddStudent() {
        System.out.println("addStudent");
        int id = 50;
        String firstName = "JUnit";
        String lastName = "Testing";
        String course = "COMP501";
        StudentsDB instance = new StudentsDB();
        instance.addStudent(id, firstName, lastName, course);
        // TODO review the generated test code and remove the default call to fail.
        String expected = firstName;
        String actual = "";
        try
        {
            statement = conn.createStatement();
            rs = statement.executeQuery("SELECT * FROM STUDENT");
            while(rs.next())
            {
                if(rs.getString("FIRST_NAME").equals("JUnit"))
                {
                    actual = rs.getString("FIRST_NAME");
                    System.out.println("test");
                }
            }
        }
        catch(SQLException e)
        {
            System.out.println("Error");
        }
        if(expected.equals(actual))
        {
            System.out.println("Test passed...");
            
        }
        else
        {
            fail();
        }
        
    }

    /**
     * Test of removeStudent method, of class StudentsDB.
     */
    @Test
    public void testRemoveStudent() {
        System.out.println("removeStudent");
        int id = 50;
        StudentsDB instance = new StudentsDB();
        instance.removeStudent(id);
        // TODO review the generated test code and remove the default call to fail.        
        boolean found = false;        
        try
        {
            statement = conn.createStatement();
            rs = statement.executeQuery("SELECT * FROM STUDENT");
            while(rs.next())
            {
                if(rs.getString("FIRST_NAME").equals("JUnit"))
                {
                   found = true;
                }
            }
        }
        catch(SQLException e)
        {
            System.out.println("Error");
        }
        if(!found)
        {
            System.out.println("Test passed...");
            
        }
        else
        {
            fail();
        }
        
    }
    
}
