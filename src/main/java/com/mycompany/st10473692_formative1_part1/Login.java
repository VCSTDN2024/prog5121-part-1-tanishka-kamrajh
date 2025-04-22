/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.st10473692_formative1_part1;

import java.util.Scanner;

/**
 * ST10473692
 * @author Tanishka Kamrajh
 */

// The Login class is the central place which holds both the business and data.
// It handles the checks, registration and login function of the user.

public class Login {
    public Login(User newUser) {
        user = newUser;
    }

    private User user;
    boolean isLoggedIn = false;
    
    // Check if username has a underscore (_) and is no more than 5 characters.
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5; 
    }
    
    // Check if password meets complexity rules.
    public boolean checkPasswordComplexity(String password) {
        return password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*[0-9].*") && password.matches(".*[!@#$%^&*()].*");  //(Chua, E.H., 2012).
    }
    
    // Check if the phone number is the correct length and contains South Africas international country code.
    public boolean checkCellPhoneNumber(String phone) {
        // Implement the AI tool to create a regular expression-bassed cell phone checker.
        return phone.matches("^\\+27[0-9]{9}$");          // (Woodward,2024).
        // Regex is used to keep the code clean and concise.
        // As it doesnt call for multiple if-statements and loops to check the phone numbers validity.
    }
    
    // Register the user. 
    public boolean registerUser() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        // Implementing if else statements to check if what the users data is correct.
        // Asks for the username and checks if it is correct.
            System.out.print("Enter Username: ");
            String username = scanner.nextLine();
            if (checkUserName(username)) {
                System.out.println("Username successfully captured.");
            } else {
                System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.");
            } 
            // (W3schools, 2025).

            // Asks for the password and checks if it is correct.
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();
            if (checkPasswordComplexity(password)) {
                System.out.println("Password successfully captured.");
            } else {
                System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
            }
             // (W3schools, 2025).

            // Asks for the phone number and checks if it is correct.
            System.out.print("Enter SA Cell Phone Number: ");
            String phone = scanner.nextLine();
            if(checkCellPhoneNumber(phone)) {
                System.out.println("Cell phone number successfully added.");
            } else {
                System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
            }
             // (W3schools, 2025).
        
        user = new User(firstName, lastName, username, password, phone);
        return true;
    }
    
    // Verify that the login details entered match the login details stored when the user register.
    public boolean loginUser(String username, String password) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter Username to Login: ");
        String enteredUsername = scanner.nextLine();  // (GeeksforGeeks, 2018).
        
        System.out.print("Enter Password: ");
        String enteredPassword = scanner.nextLine();  // (GeeksforGeeks, 2018).
        
        System.out.print("Enter Phone Number: ");
        String enteredPhone = scanner.nextLine();  // (GeeksforGeeks, 2018).
            
        return loginUser(enteredUsername, enteredPassword, enteredPhone);

}

    public boolean loginUser(String username, String password, String phone) {
        if (user != null && user.getUsername().equals(username) && user.getPassword().equals(password) && user.getCellPhoneNumber().equals(phone)) {
            // (Marino, 2016).
            isLoggedIn = true; // (Warren and Revier, 2023), (Learn Microsoft, 2025).
            System.out.println("Login successful.");
        } else {
            isLoggedIn = false; // (Warren and Revier, 2023), (Learn Microsoft, 2025).
            System.out.println("Login failed. Username, password, or phone number is incorrect.");
        }
        return isLoggedIn;
    }

    //Return the login status message.
    public String returnLoginStatus() {
        if (isLoggedIn) { // (Warren and Revier, 2023), (Learn Microsoft, 2025).
            return "Welcome " + user.getFirstName() + " " + user.getLastName() + ",it is great to see you again.";
    } else {
            return "Username, password, or phone number is incorrect, please try again.";
        }
    }
    
}
