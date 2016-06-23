/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hibernate;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author co075oh
 */
@Entity
@Table (name="EMPLOYEE")
public class Employee implements Serializable {
    @Id
    private int id;
    @Column (name="firstName")
    private String firstName; 
    @Column (name="lastName")
    private String lastName;   
    @Column (name="salary")
    private int salary;  

    // Constructor Methods
    public Employee() {
    }
    
    public Employee(String fname, String lname, int salary) {
        this.firstName = fname;
        this.lastName = lname;
        this.salary = salary;
    }
    
    // Getter and Setter Methods
    public int getId() {
        return id;
    }
    
    public void setId( int id ) {
        this.id = id;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName( String first_name ) {
        this.firstName = first_name;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName( String last_name ) {
        this.lastName = last_name;
    }
    
    public int getSalary() {
        return salary;
    }
    
    public void setSalary( int salary ) {
        this.salary = salary;
    }
}
