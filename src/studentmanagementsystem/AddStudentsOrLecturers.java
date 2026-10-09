/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanagementsystem;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;



/**
 *
 * @author Samuel Pearson 25302305
 */
public class AddStudentsOrLecturers {
    
    //This is the class for adding new students and teachers
    
    public static ArrayList<Course> courses = new ArrayList(); 
    // Refer to the courses to add a new student into
    
    public static void AddStudents(ArrayList<Student> students, ArrayList<Student> studentsAttendance) throws IOException
    {
        Scanner scan = new Scanner(System.in);
        courses = Utilities.courseInfo();        
        System.out.println("Welcome to the add students system.\nPlease press Y to proceed, or N to go back.");        
        String proceed = scan.nextLine().toUpperCase();        
        while(!proceed.equals("Y") && !proceed.equals("N"))
        {
            System.out.println("Invalid Answer!\nPlease press Y to proceed, or N to go back.");
            proceed = scan.nextLine().toUpperCase();
        }
        if(proceed.equals("N"))
        {
            return;
        }
        //New id is a +1 from the previous id
        int id = students.getLast().getId() + 1;
        System.out.println("\nGenerating new student's ID...\nThe new id is "+id+"\n");       
        
        //This boolean is to check that each step of the way is completed properly and that the user is happy with their input
        boolean isHappy = false;
        String firstName = "";
        while(!isHappy) // Here is an example of that boolean in action
        {
            System.out.println("\nPlease enter the new student's first name.");
            firstName = scan.nextLine();
            //The .matches code was help from Gemini with some of my own additions to it, any other .matches like this in my program would be based off of this code here
            while(!firstName.matches("[a-zA-Z\\s-']+") || firstName.length() < 2)
            {
                System.out.println("Error! Invalid characters used!\nPlease only use the alphabet to enter the student's first name.");
                firstName = scan.nextLine();
            }
            System.out.println("\nFirst name is recorded as: "+firstName+"\nIs this correct? Y for yes, N for no.");
            proceed = scan.nextLine().toUpperCase();
            while(!proceed.equals("Y") && !proceed.equals("N"))
            {
                System.out.println("Invalid Answer!\nPlease press Y to proceed, or N to go back.");
                proceed = scan.nextLine().toUpperCase();
            }
            if(proceed.equals("Y"))
            {
                isHappy = true;
            }                       
        }
        isHappy = false; //Resets to false once first check is done so the next checks for say the last name can begin
        String lastName = "";
        while(!isHappy)
        {
            System.out.println("\nPlease enter the new student's last name.");
            lastName = scan.nextLine();
            while(!lastName.matches("[a-zA-Z\\s-']+") || lastName.length() < 2)
            {
                System.out.println("Error! Invalid characters used!\nPlease only use the alphabet to enter the student's last name.");
                lastName = scan.nextLine();
            }
            System.out.println("\nLast name is recorded as: "+lastName+"\nIs this correct? Y for yes, N for no.");
            proceed = scan.nextLine().toUpperCase();
            while(!proceed.equals("Y") && !proceed.equals("N"))
            {
                System.out.println("Invalid Answer!\nPlease press Y to proceed, or N to go back.");
                proceed = scan.nextLine().toUpperCase();
            }
            if(proceed.equals("Y"))
            {
                isHappy = true;
            }                       
        }
        isHappy = false;
        String crsCode = "";       
        while(!isHappy)
        {
            System.out.println("\nWhich Major is this student being enrolled into? Please enter a number from 1-3.\n1. Accounting\n2. Animation, Visual Effects, and Game Design\n3. Software Development");
            String answerNum = scan.nextLine();
            while(!answerNum.equals("1") && !answerNum.equals("2") && !answerNum.equals("3"))
            {
                System.out.println("That isn't a correct input! Please enter the number 1, 2, or 3.\n1. Accounting\n2. Animation, Visual Effects, and Game Design\n3. Software Development");
                System.out.print("Major Number: ");
                answerNum = scan.nextLine();
            }
            
            if(answerNum.equals("1"))
            {
                System.out.println("\nWhich course in the Accounting major is this student being enrolled into?");
                System.out.println("Please enter one of the following course codes:\nACCT703\nBUSS512\nBUSS514");
                System.out.print("\nCourse Code: ");
                crsCode = scan.nextLine();                
                while(!crsCode.equals("BUSS512") && !crsCode.equals("BUSS514") && !crsCode.equals("ACCT703"))
                {
                    System.out.println("\nInvalid input! Please enter in one of the following course codes:");
                    System.out.println("ACCT703\nBUSS512\nBUSS514");  
                    System.out.print("\nCourse Code: ");
                    crsCode = scan.nextLine();
                } 
                System.out.println("You have selected the Major: Accounting\nAnd the Course: "+crsCode+"\nIs this the correct selection? Enter Y to proceed or N to go back.");
                proceed = scan.nextLine().toUpperCase();
                while(!proceed.equals("Y") && !proceed.equals("N"))
                {
                    System.out.println("Invalid Answer!\nPlease press Y to proceed, or N to go back.");
                    proceed = scan.nextLine().toUpperCase();
                }               
                if(proceed.equals("Y"))
                {
                    isHappy = true;
                } 
            }
            if(answerNum.equals("2"))
            {
                System.out.println("\nWhich course in the Animation, Visual Effects, and Game Design major is this student being enrolled into?");
                System.out.println("Please enter one of the following course codes:\nDESN511\nDESN711\nDIGD511");
                System.out.print("\nCourse Code: ");
                crsCode = scan.nextLine();
                while(!crsCode.equals("DESN511") && !crsCode.equals("DESN711") && !crsCode.equals("DIGD511"))
                {
                    System.out.println("\nInvalid input! Please enter in one of the following course codes:");
                    System.out.println("DESN511\nDESN711\nDIGD511");
                    System.out.print("\nCourse Code: ");
                    crsCode = scan.nextLine();
                }
                System.out.println("You have selected the Major: Animation, Visual Effects, and Game Design\nAnd the Course: "+crsCode+"\nIs this the correct selection? Enter Y to proceed or N to go back.");
                proceed = scan.nextLine().toUpperCase();
                while(!proceed.equals("Y") && !proceed.equals("N"))
                {
                    System.out.println("Invalid Answer!\nPlease press Y to proceed, or N to go back.");
                    proceed = scan.nextLine().toUpperCase();
                }               
                if(proceed.equals("Y"))
                {
                    isHappy = true;
                } 
            }
            if(answerNum.equals("3"))
            {
                System.out.println("\nWhich course in the Software Development major is this student being enrolled into?");
                System.out.println("Please enter one of the following course codes:\nCOMP500\nCOMP501\nCOMP503");
                System.out.print("\nCourse Code: ");
                crsCode = scan.nextLine();
                while(!crsCode.equals("COMP500") && !crsCode.equals("COMP501") && !crsCode.equals("COMP503"))
                {
                    System.out.println("\nInvalid input! Please enter in one of the following course codes:");
                    System.out.println("COMP500\nCOMP501\nCOMP503");
                    System.out.print("\nCourse Code: ");
                    crsCode = scan.nextLine();
                }
                System.out.println("You have selected the Major: Software Development\nAnd the Course: "+crsCode+"\nIs this the correct selection? Enter Y to proceed or N to go back.");
                proceed = scan.nextLine().toUpperCase();
                while(!proceed.equals("Y") && !proceed.equals("N"))
                {
                    System.out.println("Invalid Answer!\nPlease press Y to proceed, or N to go back.");
                    proceed = scan.nextLine().toUpperCase();
                }               
                if(proceed.equals("Y"))
                {
                    isHappy = true;
                }                               
            }
        }
        System.out.println("\nStudent has been added to the system. Returning to the main menu...");
        ArrayList<Integer> marks = new ArrayList();
        //Automatically adds marks, can be edited later in the edit students screen
        if(crsCode.equals("COMP501") || crsCode.equals("ACCT703") || crsCode.equals("COMP500") || crsCode.equals("DESN711") || crsCode.equals("DIGD511") || crsCode.equals("BUSS514"))
        {
            for(int i = 0; i < 3; i++)
            {
                marks.add(0);
            }
        }
        else
        {
            for(int i = 0; i < 4; i++)
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
        //Adds the new student into the ArrayList
        Student student = new Student(id, firstName, lastName, assessmentMarks);
        int attendance = 0; // Default attendance can be edited later in the edit students screen        
        Student studentAttendance = new Student(id, firstName, lastName, attendance);
        studentsAttendance.add(studentAttendance);
        students.add(student);          
        
        //Writes the new student back into the leaner file
        FileWriter fw = new FileWriter("./resources/learners.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        
        for(int i = 0; i < students.size(); i++)
        {
            pw.print(students.get(i).getId() + ",");
            pw.print(students.get(i).getFirstName() + ",");
            pw.print(students.get(i).getLastName() + ",");
            pw.print(students.get(i).getAssessmentMarks().getCourse().getCode() + ",");
            for(int j = 0; j < students.get(i).getAssessmentMarks().getMarks().size(); j++)
            {
                if(j != students.get(i).getAssessmentMarks().getMarks().size() - 1)
                {
                    pw.print(students.get(i).getAssessmentMarks().getMarks().get(j) + ",");
                }
                else
                {
                    pw.print(students.get(i).getAssessmentMarks().getMarks().get(j) + "");
                }
                
            }
            pw.println();                      
        }        
        pw.flush();
        pw.close();
        
        //And this writes the student into the student attendance file
        FileWriter fw2 = new FileWriter("./resources/attendance.txt");
        BufferedWriter bw2 = new BufferedWriter(fw2);
        PrintWriter pw2 = new PrintWriter(bw2);
        for(int i = 0; i < studentsAttendance.size(); i++)
        {
            pw2.print(studentsAttendance.get(i).getId() + ",");
            pw2.print(studentsAttendance.get(i).getFirstName() + ",");
            pw2.print(studentsAttendance.get(i).getLastName() + ",");            
            pw2.print(studentsAttendance.get(i).getAttendance());
            pw2.println();
        }
        pw2.flush();
        pw2.close();
    }
    
    public static void AddTeacher(ArrayList<Teacher> teachers) throws IOException
    {
        //This method adds a teacher
        courses = Utilities.courseInfo();
        System.out.println("Welcome to the add teachers page.\nPlease press Y to proceed, or N to go back.");
        Scanner scan = new Scanner(System.in);
        String proceed = scan.nextLine().toUpperCase();        
        while(!proceed.equals("Y") && !proceed.equals("N"))
        {
            System.out.println("Invalid Answer!\nPlease press Y to proceed, or N to go back.");
            proceed = scan.nextLine().toUpperCase();
        }
        if(proceed.equals("N"))
        {
            return;
        }
        int id = 10 + teachers.getLast().getId();
        System.out.println("\nGenerating new teacher's ID...\nThe new id is "+id+"\n");       
        
        boolean isHappy = false; // Read the add student method above for explanation on this boolean
        String firstName = "";
        while(!isHappy)
        {
            System.out.println("\nPlease enter the new teacher's first name.");
            firstName = scan.nextLine();
            while(!firstName.matches("[a-zA-Z\\s-']+") || firstName.length() < 2)
            {
                System.out.println("Error! Invalid characters used!\nPlease only use the alphabet to enter the teacher's first name.");
                firstName = scan.nextLine();
            }
            System.out.println("\nFirst name is recorded as: "+firstName+"\nIs this correct? Y for yes, N for no.");
            proceed = scan.nextLine().toUpperCase();
            while(!proceed.equals("Y") && !proceed.equals("N"))
            {
                System.out.println("Invalid Answer!\nPlease press Y to proceed, or N to go back.");
                proceed = scan.nextLine().toUpperCase();
            }
            if(proceed.equals("Y"))
            {
                isHappy = true;
            }                       
        }
        isHappy = false;
        String lastName = "";
        while(!isHappy)
        {
            System.out.println("\nPlease enter the new teacher's last name.");
            lastName = scan.nextLine();
            while(!lastName.matches("[a-zA-Z\\s-']+") || lastName.length() < 2)
            {
                System.out.println("Error! Invalid characters used!\nPlease only use the alphabet to enter the teacher's last name.");
                lastName = scan.nextLine();
            }
            System.out.println("\nLast name is recorded as: "+lastName+"\nIs this correct? Y for yes, N for no.");
            proceed = scan.nextLine().toUpperCase();
            while(!proceed.equals("Y") && !proceed.equals("N"))
            {
                System.out.println("Invalid Answer!\nPlease press Y to proceed, or N to go back.");
                proceed = scan.nextLine().toUpperCase();
            }
            if(proceed.equals("Y"))
            {
                isHappy = true;
            }                       
        }
        isHappy = false;
        String crsCode = "";       
        while(!isHappy)
        {
            System.out.println("\nWhich Major is this teacher teaching? Please enter a number from 1-3.\n1. Accounting\n2. Animation, Visual Effects, and Game Design\n3. Software Development");
            String answerNum = scan.nextLine();
            
            //This series of code determine the class in which this teacher is teaching
            while(!answerNum.equals("1") && !answerNum.equals("2") && !answerNum.equals("3"))
            {
                System.out.println("That isn't a correct input! Please enter the number 1, 2, or 3.\n1. Accounting\n2. Animation, Visual Effects, and Game Design\n3. Software Development");
                System.out.print("Major Number: ");
                answerNum = scan.nextLine();
            }
            
            if(answerNum.equals("1"))
            {
                System.out.println("\nWhich course in the Accounting Major is this teacher teaching in?");
                System.out.println("Please enter one of the following course codes:\nACCT703\nBUSS512\nBUSS514");
                System.out.print("\nCourse Code: ");
                crsCode = scan.nextLine();                
                while(!crsCode.equals("BUSS512") && !crsCode.equals("BUSS514") && !crsCode.equals("ACCT703"))
                {
                    System.out.println("\nInvalid input! Please enter in one of the following course codes:");
                    System.out.println("ACCT703\nBUSS512\nBUSS514");  
                    System.out.print("\nCourse Code: ");
                    crsCode = scan.nextLine();
                } 
                System.out.println("You have selected the Major: Accounting\nAnd the Course: "+crsCode+"\nIs this the correct selection? Enter Y to proceed or N to go back.");
                proceed = scan.nextLine().toUpperCase();
                while(!proceed.equals("Y") && !proceed.equals("N"))
                {
                    System.out.println("Invalid Answer!\nPlease press Y to proceed, or N to go back.");
                    proceed = scan.nextLine().toUpperCase();
                }               
                if(proceed.equals("Y"))
                {
                    isHappy = true;
                } 
            }
            if(answerNum.equals("2"))
            {
                System.out.println("\nWhich course in the Animation, Visual Effects, and Game Design Major is this teacher teaching in?");
                System.out.println("Please enter one of the following course codes:\nDESN511\nDESN711\nDIGD511");
                System.out.print("\nCourse Code: ");
                crsCode = scan.nextLine();
                while(!crsCode.equals("DESN511") && !crsCode.equals("DESN711") && !crsCode.equals("DIGD511"))
                {
                    System.out.println("\nInvalid input! Please enter in one of the following course codes:");
                    System.out.println("DESN511\nDESN711\nDIGD511");
                    System.out.print("\nCourse Code: ");
                    crsCode = scan.nextLine();
                }
                System.out.println("You have selected the Major: Animation, Visual Effects, and Game Design\nAnd the Course: "+crsCode+"\nIs this the correct selection? Enter Y to proceed or N to go back.");
                proceed = scan.nextLine().toUpperCase();
                while(!proceed.equals("Y") && !proceed.equals("N"))
                {
                    System.out.println("Invalid Answer!\nPlease press Y to proceed, or N to go back.");
                    proceed = scan.nextLine().toUpperCase();
                }               
                if(proceed.equals("Y"))
                {
                    isHappy = true;
                } 
            }
            if(answerNum.equals("3"))
            {
                System.out.println("\nWhich course in the Software Development Major is this teacher teaching in");
                System.out.println("Please enter one of the following course codes:\nCOMP500\nCOMP501\nCOMP503");
                System.out.print("\nCourse Code: ");
                crsCode = scan.nextLine();
                while(!crsCode.equals("COMP500") && !crsCode.equals("COMP501") && !crsCode.equals("COMP503"))
                {
                    System.out.println("\nInvalid input! Please enter in one of the following course codes:");
                    System.out.println("COMP500\nCOMP501\nCOMP503");
                    System.out.print("\nCourse Code: ");
                    crsCode = scan.nextLine();
                }
                System.out.println("You have selected the Major: Software Development\nAnd the Course: "+crsCode+"\nIs this the correct selection? Enter Y to proceed or N to go back.");
                proceed = scan.nextLine().toUpperCase();
                while(!proceed.equals("Y") && !proceed.equals("N"))
                {
                    System.out.println("Invalid Answer!\nPlease press Y to proceed, or N to go back.");
                    proceed = scan.nextLine().toUpperCase();
                }               
                if(proceed.equals("Y"))
                {
                    isHappy = true;
                }                               
            }
        }
        isHappy = false;
        int role = 0;
        while(!isHappy)
        {
            //This series of code assigns a role to the teacher
            System.out.println("And which role does this teacher have?\nPlease select a number from 1-3.\n1. Teaching Assistant\n2. Lecturer\n3. Senior Lecturer\n");
            System.out.print("Role Number: ");
            String answerNum = scan.nextLine();
            while(!answerNum.equals("1") && !answerNum.equals("2") && !answerNum.equals("3"))
            {
                System.out.println("That isn't a correct input! Please enter the number 1, 2, or 3.\n1. Teaching Assistant\n2. Lecturer\n3. Senior Lecturer\n");
                System.out.print("Role Number: ");
                answerNum = scan.nextLine();
            }
            String chosenRole = "";
            if(answerNum.equals("1"))
            {
                role = 0;
                chosenRole = "Teacher Assistant";
            }
            else if(answerNum.equals("2"))
            {
                role = 1;
                chosenRole = "Lecturer";
            }
            else
            {
                role = 2;
                chosenRole = "Senior Lecturer";
            }
            System.out.println("The role chosen for this teacher is "+chosenRole+".\nIs this correct? Enter Y to proceed or N to go back");
            proceed = scan.nextLine().toUpperCase();
            while(!proceed.equals("Y") && !proceed.equals("N"))
            {
                System.out.println("Invalid Answer!\nPlease press Y to proceed, or N to go back.");
                proceed = scan.nextLine().toUpperCase();
            }               
            if(proceed.equals("Y"))
            {
                isHappy = true;
            }             
        }
        int crsNum = 0;
        for(int i = 0; i < courses.size(); i++)
        {
            if(crsCode.equals(courses.get(i).getCode()))
            {
                crsNum = i;
                break;
            }
        }
        //This adds the teacher to the teacher array list
        System.out.println("\nTeacher has been successfully added! Returning to the main menu...");
        //The Teacher.teacherPosition.values()[role] code was help from Gemini
        Teacher teacher = new Teacher(id, firstName, lastName, Teacher.teacherPosition.values()[role], courses.get(crsNum));
        teachers.add(teacher);        
        
        //And this prints the new teacher into the teacher text file
        FileWriter fw = new FileWriter("./resources/teachers.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        
        for(int i = 0; i < teachers.size(); i++)
        {
            pw.print(teachers.get(i).getId() + ",");
            pw.print(teachers.get(i).getFirstName() + ",");
            pw.print(teachers.get(i).getLastName() + ",");
            pw.print(teachers.get(i).getPosition().ordinal() + ",");
            pw.println(teachers.get(i).getCourse().getCode());            
        }
        pw.flush();
        pw.close();
    }
}
