/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanagementsystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Samuel Pearson 25302305
 */
public class Utilities {
    //This class I called utilities creates the faculties, majors, and courses for each class, it also sets up the students and teachers
    private static ArrayList<Faculty> faculties = new ArrayList<>();
    private static ArrayList<Major> majors = new ArrayList<>();
    
    
    //Adds some faculties
    public static ArrayList<Faculty> facultyInfo()
    {
        faculties.add(new Faculty("Business, Economics, & Law", "WF Building"));
        faculties.add(new Faculty("Engineering, Computing, & Mathmatical Sciences", "WZ Building"));
        faculties.add(new Faculty("Faculty of Design & Creative Technologies", "WE Building"));
        return faculties;
    }
    //Adds some majors and refers to their respective faculties
    
    //Adds a whole bunch of courses and refers to their respective majors    
    
    
    //This reads from the teacher text file and adds it into an arraylist
    public static void teacherReadFile(ArrayList<Teacher> teachers) throws IOException, NumberFormatException
    {
        try
        {
            FileReader fr = new FileReader("./resources/teachers.txt");
            BufferedReader br = new BufferedReader(fr);
            String lines = "";
            int id = 0;
            while((lines = br.readLine()) != null)
            {
                String[] teacherDetails = lines.split(",");
                try
                {
                    id = Integer.parseInt(teacherDetails[0]);
                }
                catch(NumberFormatException e)
                {    
                    id = id + 10;
                }
                String firstName = teacherDetails[1];
                String lastName = teacherDetails[2];
                //This below code was made possible by the code in the teacher adding method in the AddStudentsOrLecturers class, which was help from Gemini
                Teacher.teacherPosition position = Teacher.teacherPosition.values()[Integer.parseInt(teacherDetails[3])];                
                String crsCode = teacherDetails[4];
                int crsNum = 0;                
                
            }
            br.close();
        }
        catch(IOException e)
        {
            System.out.println("File read error.");
        }
    }
    //This reads from the student attendance text file and adds it into an ArrayList
    public static void readStudentAttendanceFile(ArrayList<Student> studentAttendance) throws IOException, NumberFormatException
    {
        
        try
        {
            FileReader fr = new FileReader("./resources/attendance.txt");
            BufferedReader br = new BufferedReader(fr);
            String lines = "";            
            int id = 0;
            while((lines = br.readLine()) != null)
            {               
                
                    String[] studentDetails = lines.split(",");
                    try
                    {
                        id = Integer.parseInt(studentDetails[0]);
                    }
                    catch(NumberFormatException e)
                    {                        
                        id = id + 1;
                    }
                    String firstName = studentDetails[1];
                    String lastName = studentDetails[2];                     
                    int attendance = 0;
                    try
                    {
                        attendance = Integer.parseInt(studentDetails[3]);
                    }
                    catch (NumberFormatException e)
                    {
                        attendance = 0;
                    }                                        
                    Student student = new Student(id, firstName, lastName, attendance); 
                    studentAttendance.add(student);
            
            }
            br.close();
        }
        catch(IOException e)
        {
            System.out.println("File read error.");
        }
    }
}
