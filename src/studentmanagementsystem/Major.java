/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanagementsystem;

/**
 *
 * @author Samuel Pearson 25302305
 */
public abstract class Major  {    
    //This class is about what Major the student is taking
    private String mName, degree;    
    
    public Major(String degree, String mName)
    {
        
        this.degree = degree;
        this.mName = mName;
    }          
    
    public String getMName() { return mName; } 
    
    public String getDegree() { return degree; }       
    
    
    public void setMName(String newMajName) { this.mName = newMajName; }
    
    public void setDegree(String newDegree) { this.degree = newDegree; }   
       
    
    
    
    
}
