/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanagementsystem;

/**
 *
 * @author Samuel Pearson 25302305
 */
public class Major  {    
    //This class is about what Major the student is taking
    private String mName, degree;
    private Faculty faculty;
    
    public Major(Faculty faculty, String degree, String mName)
    {
        this.faculty = faculty;
        this.degree = degree;
        this.mName = mName;
    }          
    
    public String getMName() { return mName; } 
    
    public String getDegree() { return degree; }
    
    public Faculty getFaculty() { return faculty; }
    
    
    public void setMName(String newMajName) { this.mName = newMajName; }
    
    public void setDegree(String newDegree) { this.degree = newDegree; }
    
    public void setFaculty(Faculty newFaculty) { this.faculty = newFaculty; }    
    
    public String toString()
    {
        return getFaculty()+"\nDegree Name: "+getDegree()+"\nMajor Name: "+getMName();
    }
    
    
}
