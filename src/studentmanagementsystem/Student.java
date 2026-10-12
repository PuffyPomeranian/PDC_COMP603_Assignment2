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
    
    private int attendance;    
    
    public Student(int id, String firstName, String lastName)
    {
        super(id, firstName, lastName);
             
    }  
    public Student(int id, String firstName, String lastName, int attendance)
    {
        super(id, firstName, lastName);        
        this.attendance = attendance;
    }
    
               
    
    public int getAttendance() { return attendance; }
    
    
    
    
    public void setAttendance(int newAttendance) { this.attendance = newAttendance; }        
       
}
