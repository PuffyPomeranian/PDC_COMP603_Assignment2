/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanagementsystem;

/**
 *
 * @author Samuel Pearson 25302305
 */
public class Faculty {
    
    //Base class of the university is Faculty, it is the start of the building block to which Major and Course build off of
    
    private String fName, location;
    
    public Faculty(String fName, String location)
    {
        this.fName = fName;
        this.location = location;
    }
    
    public String getFName() { return fName; }    
    
    public String getLocation() { return location; }
    
    
    public void setName(String newFacultyName) { this.fName = newFacultyName; }    
    
    public void setLocation(String newLoc) { this.location = newLoc; }
    
    public String toString()
    {
        return "Faculty Name: " + this.getFName() + "\nFaculty Location: " + this.getLocation();
    }    
}
