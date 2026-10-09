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
    private static ArrayList<Course> courses = new ArrayList<>();
    
    //Adds some faculties
    public static ArrayList<Faculty> facultyInfo()
    {
        faculties.add(new Faculty("Business, Economics, & Law", "WF Building"));
        faculties.add(new Faculty("Engineering, Computing, & Mathmatical Sciences", "WZ Building"));
        faculties.add(new Faculty("Faculty of Design & Creative Technologies", "WE Building"));
        return faculties;
    }
    //Adds some majors and refers to their respective faculties
    public static ArrayList<Major> majorInfo()
    {
        majors.add(new Major(faculties.get(0), "Bachelor of Business", "Accounting"));
        majors.add(new Major(faculties.get(1), "Bachelor of Computer and Information Sciences", "Software Development"));
        majors.add(new Major(faculties.get(2), "Bachelor of Design", "Animation, Visual Effects, and Game Design"));
        return majors;
    }
    //Adds a whole bunch of courses and refers to their respective majors
    public static ArrayList<Course> courseInfo()
    {
        courses.add(new Course(majors.get(0), "BUSS512", "Accounting and Information Systems", 15, 1250.25));
        courses.add(new Course(majors.get(0), "BUSS514", "Marketing and Global Business", 15, 1150.25));
        courses.add(new Course(majors.get(0), "ACCT703", "Management & Accounting", 15, 1800.00));
        courses.add(new Course(majors.get(1), "COMP500", "Introduction to Programming", 15, 1500.50));
        courses.add(new Course(majors.get(1), "COMP503", "Object Orientated Programming", 15, 1500.50));
        courses.add(new Course(majors.get(1), "COMP501", "Computing Technology in Society", 15, 1900.50));
        courses.add(new Course(majors.get(2), "DESN511", "Introduction to Design Practices", 30, 2500.00));
        courses.add(new Course(majors.get(2), "DIGD511", "Animation, Visual Effects & Game Design Practice 1", 30, 2500.00));
        courses.add(new Course(majors.get(2), "DESN711", "Integrated Design Practice", 60, 4250.75));
        return courses;
    }
    
    //This method reads from the learner file and adds it into an arraylist
    public static void studentReadFile(ArrayList<Student> students) throws IOException
    {
        try
        {                  
            FileReader fr = new FileReader("./resources/learners.txt");
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
                    String crsCode = studentDetails[3];
                    ArrayList<Integer> marks = new ArrayList();
                    for(int j = 4; j < studentDetails.length; j++)
                    {                                                                        
                        try
                        {
                            marks.add(Integer.parseInt(studentDetails[j]));
                        }
                        catch (NumberFormatException e)
                        {
                            marks.add(0);
                        }
                    }
                    int crsNum = 0;
                    for(int k = 0; k < courses.size(); k++)
                    {
                        if(crsCode.equals(courses.get(k).getCode()))
                        {
                            crsNum = k;
                            break;
                        }
                    }
                    AssessmentMarks assessmentMarks = new AssessmentMarks(courses.get(crsNum), marks);
                    Student student = new Student(id, firstName, lastName, assessmentMarks); 
                    students.add(student);
            
            }
            br.close();
        }
        catch (IOException e)
        {
            System.out.println("File read error");
        }                              
    }
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
                for(int i = 0; i < courses.size(); i++)
                {
                    if(crsCode.equals(courses.get(i).getCode()))
                    {
                        crsNum = i;
                        break;
                    }
                }
                Teacher teacher = new Teacher(id, firstName, lastName, position, courses.get(crsNum));
                teachers.add(teacher);
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
        ArrayList<Course> courses = new ArrayList();
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
