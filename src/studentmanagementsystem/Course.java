/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanagementsystem;

/**
 *
 * @author Samuel Pearson 25302305
 */
public class Course {    
    //This class sets up the course which students attend
    private Major major;
    private String code, crsName;
    private int credits;
    private double fees;
    
    public Course(Major major, String code, String crsName, int credits, double fees)
    {
        this.major = major;
        this.code = code;
        this.crsName = crsName;
        this.credits = credits;
        this.fees = fees;
    }        
    
    public Major getMajor() { return major; }
    
    public String getCode() { return code; }
    
    public String getCrsName() { return crsName; }
    
    public int getCredits() { return credits; }
    
    public double getFees() { return fees; }             
    
    
    public void setMajor(Major newMaj) { this.major = newMaj; }
    
    public void setCode(String newCode) { this.code = newCode; }
    
    public void setCrsName(String newCourseName) { this.crsName = newCourseName; }
    
    public void setCredits(int newCredits) { this.credits = newCredits; }
    
    public void setFees(double newFees) {this.fees = newFees; }    
    
    public String toString()
    {
        return getMajor()+"\nCourse Code: "+ this.getCode() + "\nCourse Name: "+ this.getCrsName() + "\nCredits: " + this.getCredits() + "\nFees: " + this.getFees();
    }
    
}
