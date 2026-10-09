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
    private static ArrayList<Major> major = new ArrayList<>();
    private static ArrayList<Course> course = new ArrayList<>();
    private static ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<Teacher> teachers = new ArrayList<>();
    private static ArrayList<Student> studentAttendance = new ArrayList<>();  
    
    
    public static void main(String[] args) {
        
        //This block of code is the setup of storing the items in the utilities class into respective ArrayLists
        
        faculty = Utilities.facultyInfo();
        major = Utilities.majorInfo(); 
        course = Utilities.courseInfo();
        Scanner scan = new Scanner(System.in);
        String input = "";
        //Setting up a try catch for the text files
        try
        {
            Utilities.teacherReadFile(teachers);
            Utilities.studentReadFile(students);
            Utilities.readStudentAttendanceFile(studentAttendance);
        }
        catch (IOException e)
        {
            System.out.println("Files not Found");
        }               
        StudentsDB sDB = new StudentsDB();
        sDB.createStudentsTable(students, studentAttendance);
        managementSystemInterface mSI = new managementSystemInterface();
        mSI.show();    
    }
    
}
