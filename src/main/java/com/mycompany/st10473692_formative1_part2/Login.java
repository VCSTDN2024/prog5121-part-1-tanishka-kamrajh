/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.st10473692_formative1_part2;

import java.util.Scanner; 
import java.util.ArrayList;

/**
 * ST10473692
 * @author Tanishka Kamrajh
 */

// The Login class is the central place which holds both the business and data.
// It handles the checks, registration and login function of the user.

public class Login {
    private User[] _users = new User[100];
    private int _user_count = 0;
    private User _logged_in_user = null;

    // Check if username contains an underscore and is 5 characters or fewer
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // Check password for minimum length, uppercase, lowercase, number, and special character
    public boolean checkPasswordComplexity(String password) {
        return password.length() >= 8 &&
               password.matches(".*[A-Z].*") &&
               password.matches(".*[a-z].*") &&
               password.matches(".*[0-9].*") &&
               password.matches(".*[!@#$%^&*()].*"); // (Chua, E.H., 2012)
    }

    // Validate South African international phone number format using regex
    public boolean checkCellPhoneNumber(String phone) {
        return phone.matches("^\\+27\\d{9}$"); // (Woodward, 2024)
    }

    // Register a new user with validation checks
    public boolean registerUser(String first_name, String last_name, String username, String password, String phone) {
        if (!checkUserName(username)) {
            System.out.println("Username is not correctly formatted.");
            return false;
        }

        if (!checkPasswordComplexity(password)) {
            System.out.println("Password is not correctly formatted.");
            return false;
        }

        if (!checkCellPhoneNumber(phone)) {
            System.out.println("Cell phone number incorrectly formatted.");
            return false;
        }

        if (_user_count < _users.length) {
            _users[_user_count++] = new User(first_name, last_name, username, password, phone);
            System.out.println("Registration successful.");
            return true;
        } else {
            System.out.println("User storage is full.");
            return false;
        }
    }

    // Attempt to log in by matching credentials
    public boolean loginUser(String username, String password, String phone) {
        for (int i = 0; i < _user_count; i++) {
            User u = _users[i];
            if (u.getUsername().equals(username) &&
                u.getPassword().equals(password) &&
                u.getCellPhoneNumber().equals(phone)) {
                _logged_in_user = u;
                System.out.println("Login successful.");
                return true;
            }
        }
        System.out.println("Login failed. Username, password, or phone number is incorrect.");
        return false;
    }

    // Return welcome or failure message based on login status
    public String returnLoginStatus() {
        if (_logged_in_user != null) { // (Warren and Revier, 2023), (Learn Microsoft, 2025)
            return "Welcome " + _logged_in_user.getFirstName() + " " + _logged_in_user.getLastName() + 
                   ", it is great to see you again.";
        } else {
            return "Username, password, or phone number is incorrect, please try again.";
        }
    }

    // Helper to check if a user is currently logged in
    public boolean isLoggedIn() {
        return _logged_in_user != null;
    }

    // Get the currently logged in user
    public User getLoggedInUser() {
        return _logged_in_user;
    }
}
