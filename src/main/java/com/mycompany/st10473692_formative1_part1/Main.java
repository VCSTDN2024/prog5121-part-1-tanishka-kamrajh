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

// The Main class acts as the presntation of this chatapp.

public class Main {
    public static void main(String[] args) {
        User _user = new User("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        Scanner scanner = new Scanner(System.in);
        Login _login = new Login(_user);
        
        // Call registerUser from login class.
        _login.registerUser();
        
        // Start of the user logging in. 
        System.out.println("\nLogin");
        // Call loginUser from login class. 
        _login.loginUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        
        // Message of the login status.
        System.out.println("\n" + _login.returnLoginStatus());
        
        scanner.close();
    }
    
}
