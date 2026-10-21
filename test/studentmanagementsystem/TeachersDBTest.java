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
 * @author Playtech
 */
public class TeachersDBTest {
    
    private final DBManager dbManager;
    private final Connection conn;
    private Statement statement;
    private ResultSet rs;
    
    public TeachersDBTest() {
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
     * Test of createTeacherTable method, of class TeachersDB.
     */
    @Test
    public void testCreateTeacherTable() {
        System.out.println("createTeacherTable");
        TeachersDB instance = new TeachersDB();
        instance.createTeacherTable();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of addTeacher method, of class TeachersDB.
     */
    @Test
    public void testAddTeacher() {
        System.out.println("addTeacher");
        int id = 300;
        String firstName = "JUnit";
        String lastName = "Testing";
        String position = "Tester";
        String course = "COMP500";
        TeachersDB instance = new TeachersDB();
        instance.addTeacher(id, firstName, lastName, position, course);
        // TODO review the generated test code and remove the default call to fail.
        String expected = "JUnit Tester";
        String actual = "";
        try
        {
            statement = conn.createStatement();
            rs = statement.executeQuery("SELECT * FROM TEACHER");
            while(rs.next())
            {
                if(rs.getString("FIRST_NAME").equals("JUnit") && rs.getString("POSITION").equals("Tester"))
                {
                    actual = rs.getString("FIRST_NAME") + " " + rs.getString("POSITION");
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
     * Test of removeTeacher method, of class TeachersDB.
     */
    @Test
    public void testRemoveTeacher() {
        System.out.println("removeTeacher");
        int id = 300;
        TeachersDB instance = new TeachersDB();
        instance.removeTeacher(id);
        // TODO review the generated test code and remove the default call to fail.
        boolean found = false;
        try
        {
            statement = conn.createStatement();
            rs = statement.executeQuery("SELECT * FROM TEACHER");
            while(rs.next())
            {
                if(rs.getString("FIRST_NAME").equals("JUnit") && rs.getString("POSITION").equals("Tester"))
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
