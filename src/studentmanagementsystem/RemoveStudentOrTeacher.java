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
public class RemoveStudentOrTeacher {
    
    public static void removeStudent(ArrayList<Student> students, ArrayList<Student> studentAttendance) throws NumberFormatException, IOException
    {
        System.out.println("Welcome to the student removal system.\nPress Y to proceed or N to go back to the main menu");        
        Scanner scan = new Scanner(System.in);
        String proceed = scan.nextLine().toUpperCase();
        
        while(!proceed.equals("Y") && !proceed.equals("N"))
        {
            System.out.println("\nIncorrect Input! Please enter Y to proceed or N to go back to the main menu");
            proceed = scan.nextLine().toUpperCase();
        }
        if(proceed.equals("N"))
        {
            return;
        }
        boolean deletionProcess = false; //This will remain false as long as the user keeps wanting to delete students
        String valid = "";
        String person = "";
        String query = "";
        while(!deletionProcess)
        {
            System.out.println("\nPlease enter the"+valid+" ID of the student you would like to remove.\nFor help,"+query+" enter \'q\' to see the full list of students and their ID's");
            System.out.print("\nStudent ID Number: ");
            String studentID = scan.nextLine(); 
            if(studentID.equalsIgnoreCase("q"))
            {
                for(int i = 0; i < students.size(); i++)
                {
                    System.out.println("\n"+students.get(i));
                }
                valid = "";
                System.out.println("\nPlease enter the"+valid+" ID of the student you would like to remove from the above list.");
                studentID = scan.nextLine(); 
            }
            boolean isValid = false;
            while(!studentID.matches("[0-9]+"))
            {                
                System.out.println("\nInvalid input! Please enter a valid student ID using only digits!");
                studentID = scan.nextLine();                                      
            }
            for(int i = 0; i < students.size(); i++)
            {
                if(students.get(i).getId() == Integer.parseInt(studentID))
                {
                    person = students.get(i) + "\n";
                    isValid = true;                        
                }
            }
            if(!isValid)
            {
                valid = "\rInvalid ID! Please enter a valid";
                query = "\rRemember, for help you can";
                continue;
            }
            valid = "";
            query = "";
            System.out.println("\nHere are the details of the student to remove: \n");
            System.out.println(person);
            System.out.println("Would you like to proceed with deletion? Press Y to delete or N to return to the ID input");
            proceed = scan.nextLine().toUpperCase();
            while(!proceed.equals("Y") && !proceed.equals("N"))
            {
                System.out.println("\nIncorrect Input! Please enter Y to delete or N to go back to the ID input.");
                proceed = scan.nextLine().toUpperCase();
            }
            //This will remove them from the students and studentAttendance ArrayLists
            if(proceed.equals("Y"))
            {
                System.out.println("\nProceeding with deletion...\n");
                for(int i = 0; i < students.size(); i++)
                {
                    if(students.get(i).getId() == Integer.parseInt(studentID))
                    {
                        students.remove(i);
                        studentAttendance.remove(i);
                    }                    
                }
            }
            else
            {
                continue; //If the user regrets their entry or thinks "no this is the wrong person" then this will continue the loop anew
            }
            
            //This will write the updated learner and learner attendance ArrayLists to the text files
            FileWriter fw = new FileWriter("./resources/learners.txt");
            FileWriter fw2 = new FileWriter("./resources/attendance.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            BufferedWriter bw2 = new BufferedWriter(fw2);
            PrintWriter pw = new PrintWriter(bw);
            PrintWriter pw2 = new PrintWriter(bw2);
        
            for(int i = 0; i < students.size(); i++)
            {                               
                pw.print(students.get(i).getId() + ",");
                pw.print(students.get(i).getFirstName() + ",");
                pw.print(students.get(i).getLastName() + ",");
                
                
                pw2.print(studentAttendance.get(i).getId() + ",");
                pw2.print(studentAttendance.get(i).getFirstName() + ",");
                pw2.print(studentAttendance.get(i).getLastName() + ",");               
                pw2.print(studentAttendance.get(i).getAttendance());
                
                                              
                pw.println();
                pw2.println();
            }
            
            pw.flush();
            pw.close();
            pw2.flush();
            pw2.close();
            
            System.out.println("Student successfully deleted!\nWould you like to remove another student? Enter Y to return to the ID input or press N to return to the main menu");
            proceed = scan.nextLine().toUpperCase();
            while(!proceed.equals("Y") && !proceed.equals("N"))
            {
                System.out.println("\nIncorrect Input! Please enter Y to return to the ID input or N to go back to the main menu.");
                proceed = scan.nextLine().toUpperCase();
            }
            if(proceed.equals("N"))
            {                
                deletionProcess = true;                 
            }                                        
        }               
    }
    //This method removes a Teacher, it acts in the same way as the removeStudent method, refer to the comments
    //above to see how it operates (as I said it operates in the exact same way as the student removal method
    public static void removeTeacher(ArrayList<Teacher> teachers) throws IOException
    {
        System.out.println("Welcome to the teacher removal system.\nPress Y to proceed or N to go back to the main menu");        
        Scanner scan = new Scanner(System.in);
        String proceed = scan.nextLine().toUpperCase();
        
        while(!proceed.equals("Y") && !proceed.equals("N"))
        {
            System.out.println("\nIncorrect Input! Please enter Y to proceed or N to go back to the main menu");
            proceed = scan.nextLine().toUpperCase();
        }
        if(proceed.equals("N"))
        {
            return;
        }
        boolean deletionProcess = false;
        String valid = "";
        String person = "";
        String query = "";
        while(!deletionProcess)
        {
            System.out.println("\nPlease enter the"+valid+" ID of the teacher you would like to remove.\nFor help,"+query+" enter \'q\' to see the full list of teachers and their ID's");
            System.out.print("\nTeacher ID Number: ");
            String teacherID = scan.nextLine(); 
            if(teacherID.equalsIgnoreCase("q"))
            {
                for(int i = 0; i < teachers.size(); i++)
                {
                    System.out.println("\n"+teachers.get(i));
                }
                valid = "";
                System.out.println("\nPlease enter the"+valid+" ID of the student you would like to remove from the above list.");
                teacherID = scan.nextLine(); 
            }
            boolean isValid = false;
            while(!teacherID.matches("[0-9]+"))
            {                
                System.out.println("\nInvalid input! Please enter a valid student ID using only digits!");
                teacherID = scan.nextLine();                                      
            }
            for(int i = 0; i < teachers.size(); i++)
            {
                if(teachers.get(i).getId() == Integer.parseInt(teacherID))
                {
                    person = teachers.get(i) + "\n";
                    isValid = true;                        
                }
            }
            if(!isValid)
            {
                valid = "\rInvalid ID! Please enter a valid";
                query = "\rRemember, for help you can";
                continue;
            }
            valid = "";
            query = "";
            System.out.println("\nHere are the details of the teacher to remove: \n");
            System.out.println(person);
            System.out.println("Would you like to proceed with deletion? Press Y to delete or N to return to the ID input");
            proceed = scan.nextLine().toUpperCase();
            while(!proceed.equals("Y") && !proceed.equals("N"))
            {
                System.out.println("\nIncorrect Input! Please enter Y to delete or N to go back to the ID input.");
                proceed = scan.nextLine().toUpperCase();
            }
            if(proceed.equals("Y"))
            {
                System.out.println("\nProceeding with deletion...\n");
                for(int i = 0; i < teachers.size(); i++)
                {
                    if(teachers.get(i).getId() == Integer.parseInt(teacherID))
                    {
                        teachers.remove(i);                        
                    }                    
                }
            }
            else
            {
                continue;
            }
            FileWriter fw = new FileWriter("./resources/teachers.txt");            
            BufferedWriter bw = new BufferedWriter(fw);            
            PrintWriter pw = new PrintWriter(bw);            
        
            for(int i = 0; i < teachers.size(); i++)
            {                               
                pw.print(teachers.get(i).getId() + ",");
                pw.print(teachers.get(i).getFirstName() + ",");
                pw.print(teachers.get(i).getLastName() + ",");
                pw.print(teachers.get(i).getPosition().ordinal() + ",");                               
               
            }
            
            pw.flush();
            pw.close();                        
            System.out.println("Teacher successfully deleted!\nWould you like to remove another teacher? Enter Y to return to the ID input or press N to return to the main menu");
            proceed = scan.nextLine().toUpperCase();
            while(!proceed.equals("Y") && !proceed.equals("N"))
            {
                System.out.println("\nIncorrect Input! Please enter Y to return to the ID input or N to go back to the main menu.");
                proceed = scan.nextLine().toUpperCase();
            }
            if(proceed.equals("N"))
            {                
                deletionProcess = true;                 
            }                                        
        
        }
    }
}
