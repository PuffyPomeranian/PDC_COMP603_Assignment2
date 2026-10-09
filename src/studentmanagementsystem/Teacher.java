/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanagementsystem;

/**
 *
 * @author Samuel Pearson 25302305
 */
public class Teacher extends Person {
    //This class is for mocking up a new teacher based on the person parent class.
    public enum teacherPosition //Enum for all the teacher positions
    {        
        TEACHING_ASSISTANT,
        LECTURER,
        SENIOR_LECTURER
    };
    
    private teacherPosition position;
    private Course course;
    
    public Teacher(int id, String firstName, String lastName, teacherPosition position, Course course)
    {
        super(id, firstName, lastName);
        this.position = position;
        this.course = course;
    }
    
    public teacherPosition getPosition() { return position; }
    
    public Course getCourse() { return course; }
    
    
    public void setPosition(teacherPosition newPosition) { this.position = newPosition; }
    
    public void setCourse(Course newCourse) { this.course = newCourse; }
    
    @Override
    public String toString()
    {        
        return "ID: "+getId()+"\nFirst Name: "+getFirstName()+"\nLast Name: "+getLastName()+"\nPosition: "+getPosition()+ "\nCourse Taught: "+getCourse().getCode() + "\n";
    }
    
}
