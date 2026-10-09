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
public class EditStudent {
    
    //This class edits students, and the below method edits their assessment marks
    public static void editStudentMarks(ArrayList<Student> students) throws IOException
    {
        System.out.println("Welcome to the edit student marks system. Enter Y to proceed or N to go back to the main menu.\n");
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
        boolean editProcess = false; //This boolean is for the entire edit process of a student's marks
        String valid = "";
        String person = "";
        String query = "";
        while(!editProcess)
        {
            System.out.println("\nPlease enter the"+valid+" ID of the student whose marks you wish to edit.\nFor help,"+query+" enter \'q\' to see the full list of students and their ID's");
            System.out.print("\nStudent ID Number: ");
            String studentID = scan.nextLine(); 
            if(studentID.equalsIgnoreCase("q"))
            {
                for(int i = 0; i < students.size(); i++)
                {
                    System.out.println("\n"+students.get(i));
                }
                valid = "";
                System.out.println("\nPlease enter the"+valid+" ID of the student whose marks you wish to edit from the list above.");
                studentID = scan.nextLine(); 
            }
            boolean isValid = false;
            while(!studentID.matches("[0-9]+"))
            {                
                System.out.println("\nInvalid input! Please enter a valid student ID using only digits!");
                System.out.print("\nStudent ID Number: ");
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
            System.out.println("\nHere are the details of the student to edit: \n");
            System.out.println(person);
            System.out.println("Would you like to proceed with editing this student's marks? Press Y to proceed or N to return to the ID input");
            proceed = scan.nextLine().toUpperCase();
            while(!proceed.equals("Y") && !proceed.equals("N"))
            {
                System.out.println("\nIncorrect Input! Please enter Y to proceed with editing this student's marks or N to go back to the ID input.");
                proceed = scan.nextLine().toUpperCase();
            }            
            if(proceed.equals("N"))
            {
                continue;
            }                        
            System.out.println("Here is the student's current marks: \n");
            int count = 1;            
            String mark1 = "";
            String mark2 = "";
            String mark3 = "";
            String mark4 = "";
            ArrayList<Integer> newMarks = new ArrayList();
            //This is a large for loop determining the student's current marks then adding in the new ones, it goes by the course they're enrolled in
            for(int i = 0; i < students.size(); i++)
            {
                if(students.get(i).getId() == Integer.parseInt(studentID))
                {
                    if(students.get(i).getAssessmentMarks().getCourse().getCode().equals("COMP500") || students.get(i).getAssessmentMarks().getCourse().getCode().equals("COMP501") || students.get(i).getAssessmentMarks().getCourse().getCode().equals("ACCT703") || students.get(i).getAssessmentMarks().getCourse().getCode().equals("DESN711") || students.get(i).getAssessmentMarks().getCourse().getCode().equals("DIGD511"))
                    {
                        for(int j = 0; j < students.get(i).getAssessmentMarks().getMarks().size(); j++)
                        {
                            if(j != students.get(i).getAssessmentMarks().getMarks().size() - 1)
                                System.out.println("Mark "+count+": "+students.get(i).getAssessmentMarks().getMarks().get(j) + "/30");
                            else
                                System.out.println("Mark "+count+": "+students.get(i).getAssessmentMarks().getMarks().get(j) + "/40");
                            
                            count++;
                        }
                        System.out.print("\nPlease enter the new marks below.\n\nNew Mark 1 (? out of 30): ");
                        mark1 = scan.nextLine();                        
                        while(!mark1.matches("[0-9]+") || Integer.parseInt(mark1) > 30)
                        {                
                            System.out.println("\nInvalid input! Input must be an integer and must be 30 or below!");
                            System.out.print("Please enter the new marks below.\n\nNew Mark 1 (? out of 30): ");
                            mark1 = scan.nextLine();                                      
                        }
                        System.out.print("\nNew Mark 2 (? out of 30): ");
                        mark2 = scan.nextLine();                        
                        while(!mark2.matches("[0-9]+") || Integer.parseInt(mark2) > 30)
                        {                
                            System.out.println("\nInvalid input! Input must be an integer and must be 30 or below!");
                            System.out.print("Please enter the new marks below.\n\nNew Mark 2 (? out of 30): ");
                            mark2 = scan.nextLine();                                      
                        }
                        System.out.print("\nNew Mark 3 (? out of 40): ");
                        mark3 = scan.nextLine();                        
                        while(!mark3.matches("[0-9]+") || Integer.parseInt(mark3) > 40)
                        {                
                            System.out.println("\nInvalid input! Input must be an integer and must be 40 or below!");
                            System.out.print("Please enter the new marks below.\n\nNew Mark 3 (? out of 40): ");
                            mark3 = scan.nextLine();                                      
                        }
                        newMarks.add(Integer.parseInt(mark1));
                        newMarks.add(Integer.parseInt(mark2));
                        newMarks.add(Integer.parseInt(mark3));
                        students.get(i).getAssessmentMarks().setMarks(newMarks);
                        String newMarkSet = students.get(i) + "";
                        System.out.println("Here's the student's new marks: \n"+newMarkSet);
                    }
                    else if(students.get(i).getAssessmentMarks().getCourse().getCode().equals("COMP503"))
                    {
                        for(int j = 0; j < students.get(i).getAssessmentMarks().getMarks().size(); j++)
                        {
                            if(j == 0 || j == 1)
                                System.out.println("Mark "+count+": "+students.get(i).getAssessmentMarks().getMarks().get(j) + "/10");
                            else
                                System.out.println("Mark "+count+": "+students.get(i).getAssessmentMarks().getMarks().get(j) + "/40");                           
                                
                            count++;
                        }
                        System.out.print("\nPlease enter the new marks below.\n\nNew Mark 1 (? out of 10): ");
                        mark1 = scan.nextLine();                        
                        while(!mark1.matches("[0-9]+") || Integer.parseInt(mark1) > 10)
                        {                
                            System.out.println("\nInvalid input! Input must be an integer and must be 10 or below!");
                            System.out.print("Please enter the new marks below.\n\nNew Mark 1 (? out of 10): ");
                            mark1 = scan.nextLine();                                      
                        }
                        System.out.print("\nNew Mark 2 (? out of 10): ");
                        mark2 = scan.nextLine();                        
                        while(!mark2.matches("[0-9]+") || Integer.parseInt(mark2) > 10)
                        {                
                            System.out.println("\nInvalid input! Input must be an integer and must be 10 or below!");
                            System.out.print("Please enter the new marks below.\n\nNew Mark 2 (? out of 10): ");
                            mark2 = scan.nextLine();                                      
                        }
                        System.out.print("\nNew Mark 3 (? out of 40): ");
                        mark3 = scan.nextLine();                        
                        while(!mark3.matches("[0-9]+") || Integer.parseInt(mark3) > 40)
                        {                
                            System.out.println("\nInvalid input! Input must be an integer and must be 40 or below!");
                            System.out.print("Please enter the new marks below.\n\nNew Mark 3 (? out of 40): ");
                            mark3 = scan.nextLine();                                      
                        }
                        System.out.print("\nNew Mark 4 (? out of 40): ");
                        mark4 = scan.nextLine();                        
                        while(!mark4.matches("[0-9]+") || Integer.parseInt(mark4) > 40)
                        {                
                            System.out.println("\nInvalid input! Input must be an integer and must be 40 or below!");
                            System.out.print("Please enter the new marks below.\n\nNew Mark 3 (? out of 40): ");
                            mark4 = scan.nextLine();                                      
                        }
                        newMarks.add(Integer.parseInt(mark1));
                        newMarks.add(Integer.parseInt(mark2));
                        newMarks.add(Integer.parseInt(mark3));
                        newMarks.add(Integer.parseInt(mark4));
                        students.get(i).getAssessmentMarks().setMarks(newMarks);
                        String newMarkSet = students.get(i) + "";
                        System.out.println("Here's the student's new marks: \n"+newMarkSet);
                    }
                    else if(students.get(i).getAssessmentMarks().getCourse().getCode().equals("BUSS512"))
                    {
                        for(int j = 0; j < students.get(i).getAssessmentMarks().getMarks().size(); j++)
                        {
                            if(j == 0 || j == students.get(i).getAssessmentMarks().getMarks().size() - 1)
                                System.out.println("Mark "+count+": "+students.get(i).getAssessmentMarks().getMarks().get(j) + "/10");
                            else if(j == 1)
                                System.out.println("Mark "+count+": "+students.get(i).getAssessmentMarks().getMarks().get(j) + "/20");
                            else
                                System.out.println("Mark "+count+": "+students.get(i).getAssessmentMarks().getMarks().get(j) + "/60");
                                
                            count++;
                        }
                        System.out.print("\nPlease enter the new marks below.\n\nNew Mark 1 (? out of 10): ");
                        mark1 = scan.nextLine();                        
                        while(!mark1.matches("[0-9]+") || Integer.parseInt(mark1) > 10)
                        {                
                            System.out.println("\nInvalid input! Input must be an integer and must be 10 or below!");
                            System.out.print("Please enter the new marks below.\n\nNew Mark 1 (? out of 10): ");
                            mark1 = scan.nextLine();                                      
                        }
                        System.out.print("\nNew Mark 2 (? out of 20): ");
                        mark2 = scan.nextLine();                        
                        while(!mark2.matches("[0-9]+") || Integer.parseInt(mark2) > 20)
                        {                
                            System.out.println("\nInvalid input! Input must be an integer and must be 20 or below!");
                            System.out.print("Please enter the new marks below.\n\nNew Mark 2 (? out of 20): ");
                            mark2 = scan.nextLine();                                      
                        }
                        System.out.print("\nNew Mark 3 (? out of 60): ");
                        mark3 = scan.nextLine();                        
                        while(!mark3.matches("[0-9]+") || Integer.parseInt(mark3) > 60)
                        {                
                            System.out.println("\nInvalid input! Input must be an integer and must be 60 or below!");
                            System.out.print("Please enter the new marks below.\n\nNew Mark 3 (? out of 60): ");
                            mark3 = scan.nextLine();                                      
                        }
                        System.out.print("\nNew Mark 4 (? out of 10): ");
                        mark4 = scan.nextLine();                        
                        while(!mark4.matches("[0-9]+") || Integer.parseInt(mark4) > 10)
                        {                
                            System.out.println("\nInvalid input! Input must be an integer and must be 10 or below!");
                            System.out.print("Please enter the new marks below.\n\nNew Mark 3 (? out of 10): ");
                            mark4 = scan.nextLine();                                      
                        }
                        newMarks.add(Integer.parseInt(mark1));
                        newMarks.add(Integer.parseInt(mark2));
                        newMarks.add(Integer.parseInt(mark3));
                        newMarks.add(Integer.parseInt(mark4));
                        students.get(i).getAssessmentMarks().setMarks(newMarks);
                        String newMarkSet = students.get(i) + "";
                        System.out.println("Here's the student's new marks: \n"+newMarkSet);                        
                    }
                    else if(students.get(i).getAssessmentMarks().getCourse().getCode().equals("BUSS514") || students.get(i).getAssessmentMarks().getCourse().getCode().equals("DESN511"))
                    {
                        for(int j = 0; j < students.get(i).getAssessmentMarks().getMarks().size(); j++)
                        {
                            if(j == students.get(i).getAssessmentMarks().getMarks().size() - 1)
                                System.out.println("Mark "+count+": "+students.get(i).getAssessmentMarks().getMarks().get(j) + "/50");                                                           
                            else
                                System.out.println("Mark "+count+": "+students.get(i).getAssessmentMarks().getMarks().get(j) + "/25");
                                
                            count++;
                        }
                        System.out.print("\nPlease enter the new marks below.\n\nNew Mark 1 (? out of 25): ");
                        mark1 = scan.nextLine();                        
                        while(!mark1.matches("[0-9]+") || Integer.parseInt(mark1) > 25)
                        {                
                            System.out.println("\nInvalid input! Input must be an integer and must be 25 or below!");
                            System.out.print("Please enter the new marks below.\n\nNew Mark 1 (? out of 25): ");
                            mark1 = scan.nextLine();                                      
                        }
                        System.out.print("\nNew Mark 2 (? out of 25): ");
                        mark2 = scan.nextLine();                        
                        while(!mark2.matches("[0-9]+") || Integer.parseInt(mark2) > 25)
                        {                
                            System.out.println("\nInvalid input! Input must be an integer and must be 25 or below!");
                            System.out.print("Please enter the new marks below.\n\nNew Mark 2 (? out of 25): ");
                            mark2 = scan.nextLine();                                      
                        }
                        System.out.print("\nNew Mark 3 (? out of 50): ");
                        mark3 = scan.nextLine();                        
                        while(!mark3.matches("[0-9]+") || Integer.parseInt(mark3) > 50)
                        {                
                            System.out.println("\nInvalid input! Input must be an integer and must be 50 or below!");
                            System.out.print("Please enter the new marks below.\n\nNew Mark 3 (? out of 50): ");
                            mark3 = scan.nextLine();                                      
                        }
                        newMarks.add(Integer.parseInt(mark1));
                        newMarks.add(Integer.parseInt(mark2));
                        newMarks.add(Integer.parseInt(mark3));students.get(i).getAssessmentMarks().setMarks(newMarks);
                        String newMarkSet = students.get(i) + "";
                        System.out.println("\nHere's the student and their new marks: \n"+newMarkSet);
                        
                    }
                    
                }
            }
            //Once it has the new marks it prints the new marks back into the learner file
            FileWriter fw = new FileWriter("./resources/learners.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            try (PrintWriter pw = new PrintWriter(bw)) {
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
            }
            System.out.println("Would you like to edit the marks of another student? Enter Y to edit another student's marks or N to go back to the main menu");
            proceed = scan.nextLine().toUpperCase();
            while(!proceed.equals("Y") && !proceed.equals("N"))
            {
                System.out.println("\nIncorrect Input! Please enter Y to proceed with editing another student's marks or N to go back to the main menu.");
                proceed = scan.nextLine().toUpperCase();
            }
            if(proceed.equals("N"))
                editProcess = true;
            
        }        
    }
    
    //This method edits the attendance percentage of a student
    public static void editStudentAttendance(ArrayList<Student> studentAttendance) throws IOException
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the student attendance editor system. Enter Y to proceed or N to go back to the main menu.");
        String proceed = scan.nextLine().toUpperCase();
        while(!proceed.equals("Y") && !proceed.equals("N"))
        {
            System.out.println("\nIncorrect Input! Please enter Y to proceed with editing another student's marks or N to go back to the main menu.");
            proceed = scan.nextLine().toUpperCase();
        }
        if(proceed.equals("N"))
        {
            return;
        }
        boolean editProcess = false; // This boolean is for the entire edit process of the student's attendance
        String valid = "";
        String person = "";
        String query = "";
        while(!editProcess)
        {
            System.out.println("\nPlease enter the"+valid+" ID of the student whose attendance you wish to edit.\nFor help,"+query+" enter \'q\' to see the full list of students and their ID's");
            System.out.print("\nStudent ID Number: ");
            String studentID = scan.nextLine(); 
            if(studentID.equalsIgnoreCase("q"))
            {
                for(int i = 0; i < studentAttendance.size(); i++)
                {
                    System.out.println("\n"+studentAttendance.get(i));
                }
                valid = "";
                System.out.println("\nPlease enter the"+valid+" ID of the student whose attendance you wish to edit from the list above.");
                studentID = scan.nextLine(); 
            }
            boolean isValid = false;            
            while(!studentID.matches("[0-9]+"))
            {                
                System.out.println("\nInvalid input! Please enter a valid student ID using only digits!");
                System.out.print("\nStudent ID Number: ");
                studentID = scan.nextLine();                                      
            }
            for(int i = 0; i < studentAttendance.size(); i++)
            {
                if(studentAttendance.get(i).getId() == Integer.parseInt(studentID))
                {
                    person = studentAttendance.get(i) + "\n";
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
            System.out.println("\nHere are the details of the student to edit: \n");
            System.out.println(person);
            System.out.println("Would you like to proceed with editing this student's attendance? Press Y to proceed or N to return to the ID input");
            proceed = scan.nextLine().toUpperCase();
            while(!proceed.equals("Y") && !proceed.equals("N"))
            {
                System.out.println("\nIncorrect Input! Please enter Y to proceed with editing this student's attendance or N to go back to the ID input.");
                proceed = scan.nextLine().toUpperCase();
            }            
            if(proceed.equals("N"))
            {
                continue;
            }  
            //This determines the total classes/lectures that have come and gone
            System.out.print("How many classes and lectures has their been? (Max is 24): ");
            String total = scan.nextLine();
            while(!total.matches("[0-9]+") || Integer.parseInt(total) > 24)
            {                
                System.out.println("\nInvalid input! Input must be an integer and must be 24 or below!");
                System.out.print("Please enter the total classes and lectures below.\n\nHow many lectures has their been? (Max is 24): ");
                total = scan.nextLine();                                      
            }
            //This determines how many classes/lectures the student has attended
            System.out.print("\nAnd how many lectures/classes has this student attended? (Max is 24):  ");
            String attended = scan.nextLine();
            while(!attended.matches("[0-9]+") || Integer.parseInt(attended) > 24 || Integer.parseInt(attended) > Integer.parseInt(total))
            {                
                System.out.println("\nInvalid input! Input must be an integer and must be 24 or below, and must also be below the total number of lectures/classes that have happened!");
                System.out.print("Please enter the total classes and lectures this student has attended below.\n\nHow many lectures/classes has this student attended? (Max is 24): ");
                attended = scan.nextLine();                                      
            }
            //We then calculate their attendance percentage
            int percentage = (Integer.parseInt(attended) * 100 / Integer.parseInt(total));
            for(int i = 0; i < studentAttendance.size(); i++)
            {
                if(studentAttendance.get(i).getId() == Integer.parseInt(studentID))
                {
                    studentAttendance.get(i).setAttendance(percentage);                    
                }
                    
            }
            System.out.println("\nThe student's attendance has been successfully recorded in the system as a total of "+percentage+"% attendance.");
            
            //And here we write that attendance back into the attendance learner file
            FileWriter fw = new FileWriter("./resources/attendance.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            for(int i = 0; i < studentAttendance.size(); i++)
            {
                pw.print(studentAttendance.get(i).getId() + ",");
                pw.print(studentAttendance.get(i).getFirstName() + ",");
                pw.print(studentAttendance.get(i).getLastName() + ",");                
                pw.println(studentAttendance.get(i).getAttendance());
            }
            pw.flush();
            pw.close();
            
            System.out.println("Would you like to edit another student's attendance?\nEnter Y to edit another student's attendance or N to go back to the main menu");
            proceed = scan.nextLine().toUpperCase();
            while(!proceed.equals("Y") && !proceed.equals("N"))
            {
                System.out.println("\nIncorrect Input! Please enter Y to proceed with editing another student's attendance or N to go back to the main menu.");
                proceed = scan.nextLine().toUpperCase();
            }
            if(proceed.equals("N"))
                editProcess = true; //So if someone enters in N/n then they will be returned to the main menu
        }                          
    }
    
}
