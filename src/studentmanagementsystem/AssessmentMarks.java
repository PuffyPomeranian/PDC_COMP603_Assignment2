/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanagementsystem;

import java.util.ArrayList;

/**
 *
 * @author Samuel Pearson 25302305
 */
public class AssessmentMarks {
    
    //Class to determine a students marks and assign them grades, also used as a passthrough for their course
    
    private Course course;
    private ArrayList<Integer> marks = new ArrayList();
    
    public AssessmentMarks(Course course, ArrayList<Integer> marks)
    {
        this.course = course;
        this.marks = marks;
    }
    
    public Course getCourse() { return course; }
    
    public ArrayList getMarks() { return marks; }
    
    public void setCourse(Course newCourse) { this.course = newCourse; }
    
    public void setMarks(ArrayList<Integer> newMarks) { this.marks = newMarks; }
    
    public String overallGrade()
    {               
        int grades = 0;
        String overallGrade = "FAIL";
        for(int i: marks)
        {
            grades = grades + i;
        }
        if(grades > 89)
        {
            overallGrade = "A+";
        }
        else if(grades < 90 && grades > 84)
        {
            overallGrade = "A";
        }
        else if(grades < 85 && grades > 79)
        {
            overallGrade = "A-";
        }
        else if(grades < 80 && grades > 74)
        {
            overallGrade = "B+";
        }
        else if(grades < 75 && grades > 69)
        {
            overallGrade = "B";
        }
        else if(grades < 70 && grades > 64)
        {
            overallGrade = "B-";
        }
        else if(grades < 65 && grades > 59)
        {
            overallGrade = "C+";
        }
        else if(grades < 60 && grades > 54)
        {
            overallGrade = "C";
        }
        else if(grades < 55 && grades > 49)
        {
            overallGrade = "C-";
        }
        else if(grades < 50)
        {
            overallGrade = "FAIL";
        }  
        
        return overallGrade;
    }
    
}
