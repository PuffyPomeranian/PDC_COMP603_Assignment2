/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studentmanagementsystem;

import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



/**
 *
 * @author Samuel Pearson 25302305
 */
public class StudentManagementSystem {

    /**
     * @param args the command line arguments
     */
          
    
    public static void main(String[] args) {                                    
        
        //Sets up all the databases for use in the program and shows the program
        StudentsDB sDB = new StudentsDB();
        sDB.createStudentsTable();    
        CoursesDB cDB = new CoursesDB();
        cDB.createCoursesTable();
        MajorsDB mDB = new MajorsDB();
        mDB.createMajorTables();
        FacultiesDB fDB = new FacultiesDB();
        fDB.createFacultiesTable();
        TeachersDB tDB = new TeachersDB();
        tDB.createTeacherTable();
        managementSystemInterface mSI = new managementSystemInterface();
        mSI.show();
        
        
    }
    
}
