/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanagementsystem;

/**
 *
 * @author Samuel Pearson 25302305
 */
public abstract class Person {
    
    //This class is the base class for a Person all classes for People refer back to this base abstract class
    private int id;
    private String firstName, lastName;
    
    public Person(int id, String firstName, String lastName)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        
    }
    
    public int getId() { return id; }
    
    public String getFirstName() { return firstName; }
    
    public String getLastName() { return lastName; }
    
    
    public void setId(int newId) { this.id = newId; }
    
    public void setFirstName(String newFirstName) { this.firstName = newFirstName; }
    
    public void setLastName(String newLastName) { this.lastName = newLastName; }
    
    public String toString()
    {
        return "ID: "+getId()+"\nFirst Name: "+getFirstName()+"\nLast Name: "+getLastName();
    }
    
}
