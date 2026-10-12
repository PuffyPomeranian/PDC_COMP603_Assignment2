/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studentmanagementsystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



/**
 *
 * @author Samuel
 */
public class StudentManagementSystem {

    /**
     * @param args the command line arguments
     */
    private static ArrayList<Faculty> faculty = new ArrayList<>();
    
      
    private static ArrayList<Teacher> teachers = new ArrayList<>();        
    
    public static void main(String[] args) {
        
        //This block of code is the setup of storing the items in the utilities class into respective ArrayLists
        
        faculty = Utilities.facultyInfo();
              
        Scanner scan = new Scanner(System.in);
        String input = "";        
          
               
        StudentsDB sDB = new StudentsDB();
        sDB.createStudentsTable();    
        CoursesDB cDB = new CoursesDB();
        cDB.createCoursesTable();
        MajorsDB mDB = new MajorsDB();
        mDB.createMajorTables();
        FacultiesDB fDB = new FacultiesDB();
        fDB.createFacultiesTable();
        managementSystemInterface mSI = new managementSystemInterface();
        mSI.show();
        
    }
    
}
