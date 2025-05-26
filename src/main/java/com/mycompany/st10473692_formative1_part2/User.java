/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.st10473692_formative1_part2;

/**
 * ST10473692
 * @author Tanishka Kamrajh 
 */

// The User class keeps track of the user's details: first name, last name, username, password, and cell phone number.

public class User {
    String _firstName;
    String _lastName;
    String _username;
    String _password;
    String _cellPhoneNumber;
    // (Chua, E.H., 2012).
    
    public User(String firstName, String lastName, String username, String password, String cellPhoneNumber) {
        _firstName = firstName;
        _lastName = lastName;        
        _username = username;
        _password = password;   
        _cellPhoneNumber = cellPhoneNumber;   
        // (Chua, E.H., 2012).
    }
    
    // Implementing getters.
    // This implementation will allow easy access to the user's information from the other classes.
    public String getFirstName() {
        return _firstName;
    }
    
    public String getLastName() {
        return _lastName;
    }
    
    public String getUsername() {
        return _username;
    }
    
    public String getPassword() {
        return _password;
    }
    
    public String getCellPhoneNumber() {
        return _cellPhoneNumber;
    }
    
    public boolean registerUser() {
        return true;
    }
}
