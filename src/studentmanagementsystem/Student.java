/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanagementsystem;

/**
 *
 * @author Samuel Pearson 25302305
 */
public class Student extends Person {
    
    //This method is for mocking up a Student, it is the child class of the parent Person class
    private AssessmentMarks marks;  
    private int attendance;    
    
    public Student(int id, String firstName, String lastName, AssessmentMarks marks)
    {
        super(id, firstName, lastName);
        this.marks = marks;        
    }  
    public Student(int id, String firstName, String lastName, int attendance)
    {
        super(id, firstName, lastName);        
        this.attendance = attendance;
    }
    
    public AssessmentMarks getAssessmentMarks() { return marks; }            
    
    public int getAttendance() { return attendance; }
    
    
    public void setAssessmentMarks(AssessmentMarks newMarks) {this.marks = newMarks; } 
    
    public void setAttendance(int newAttendance) { this.attendance = newAttendance; }
    
    @Override
    public String toString()
    {
        if(getAssessmentMarks() != null)
        {
            String marks = "";
            for(int i = 0; i < getAssessmentMarks().getMarks().size(); i++)
            {
                if(i != getAssessmentMarks().getMarks().size() -1)
                    marks = marks + getAssessmentMarks().getMarks().get(i).toString() + ", ";
                else
                    marks = marks + getAssessmentMarks().getMarks().get(i).toString() + "";
            }
            return "ID: "+getId()+"\nFull Name: "+getFirstName()+" "+getLastName()+"\nCourse Undertaking: "+getAssessmentMarks().getCourse().getCode()+"\nMarks: "+marks + "\n"; 
        }                                       
        else
            return "ID: "+getId()+"\nFull Name: "+getFirstName()+" "+getLastName()+"\nAttendance: "+getAttendance()+"%";
    }    
}
