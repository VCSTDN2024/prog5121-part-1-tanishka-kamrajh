/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.st10473692_formative1_part2;

import java.util.Scanner;
import javax.swing.*;
import java.util.*;

/**
 * ST10473692
 * @author Tanishka Kamrajh
 */

// The Main class acts as the presntation of this chatapp.
// It has both JOptionPane and Console Logging, to aid in a more user-friendly display but also showcase the backend allowing for a clear overview of the application.

public class Main {
    public static void main(String[] args) {
        ArrayList<Message> sentMessageList = new ArrayList<>();
        Login _login = new Login();
        
        JOptionPane.showMessageDialog(null, "Welcome to Quickchat Registration.");
        System.out.println("Welcome to Quickchat Registration.");
        
        //Registration ,displayed with JOptionPane to create a more real app display.
        String firstName = JOptionPane.showInputDialog("Enter First Name:");
        System.out.println("First Name entered: " + firstName);
        
        String lastName = JOptionPane.showInputDialog("Enter Last Name:");
        System.out.println("Last Name entered: " + lastName);
        
        String username = JOptionPane.showInputDialog("Enter Username (must contain '_' and <= 5 chars):"); //(GeeksforGeeks, 2025)
        System.out.println("Username entered: " + username);
        
        String password = JOptionPane.showInputDialog("Enter Password (8+ chars, upper, lower, number, special):"); //(GeeksforGeeks, 2025)
        System.out.println("Password entered: " + password);
        
        String phone = JOptionPane.showInputDialog("Enter Cell Phone Number (+27xxxxxxxxx):"); //(GeeksforGeeks, 2025)
        System.out.println("Cellphone number entered: " + phone);
    
        // Register user
        boolean registered = _login.registerUser(firstName, lastName, username, password, phone);
        
        if (!registered) {
            JOptionPane.showMessageDialog(null, "Registration failed. Program will exit.");
            System.out.println("Registration failed. Program exited.");
            return;  //stop the program
        }
        
        
        //Login
        // Start of the user logging in. 
        JOptionPane.showMessageDialog(null, "Welcome to Quickchat Login.");
        System.out.println("Welcome to Quickchat Login.");
        
        String loginUsername = JOptionPane.showInputDialog("Enter Username:");
        System.out.println("Login Username: " + loginUsername);
        
        String loginPassword = JOptionPane.showInputDialog("Enter Password:");
        System.out.println("Login Password: " + loginPassword);
        
        String loginPhone = JOptionPane.showInputDialog("Enter Cell Phone Number:");
        System.out.println("Login Phone Number: " + loginPhone);
        
        // Call loginUser from login class. 
        if (!_login.loginUser(loginUsername, loginPassword, loginPhone)) {
            // Message of the login status.
            JOptionPane.showMessageDialog(null, _login.returnLoginStatus());
            System.out.println(_login.returnLoginStatus());
            return;
        }
        
        // Welcome user to quickchat only if the login is successful.
        JOptionPane.showMessageDialog(null, "Welcome to Quickchat.");
        System.out.println("Welcome to Quickchat.");
        
        JOptionPane.showMessageDialog(null, _login.returnLoginStatus());
        System.out.println(_login.returnLoginStatus());
        
        int totalMessages = Integer.parseInt(JOptionPane.showInputDialog("Enter number of messages you want to send: "));
        System.out.println("Total messages to send: " + totalMessages);
        
        int sentMessages = 0;  //(W3Schools, 2025)
        boolean running = true; //(W3Schools, 2025)
        
        
        // Creates layout of 'Menu' and pops up as a JOptionPane.
        //(W3Schools, 2025)
        while (running) {
            String menuMessage = "QuickChat Menu:\n\n" 
                    + "1) Send Message\n" 
                    + "2) Show Recently Sent Messages\n" 
                    + "3) Quit\n"
                    + "Select an option: ";  //(GeeksforGeeks, 2025),(W3Schools, 2025)
            
            String scanner = JOptionPane.showInputDialog(null, menuMessage, "QuickChat Menu", JOptionPane.QUESTION_MESSAGE);
            System.out.println("Menu option selected: " + scanner);
            
            if (scanner == null) break;
            
            // Allows user to choose actions and recieve accurate messages. 
            switch (scanner.trim()) {
                case "1":
                    for (int i = sentMessages; i < totalMessages; i++) { // (W3School, 2025), (GeeksforGeeks, 2025).
                        Message msg = new Message("+27718693002", "Hi Mike, can you join us for dinner tonight");
                        String recipient = JOptionPane.showInputDialog("Enter recipient number (+countrycode and 10 digits max): ");
                        if (recipient == null || recipient.trim().isEmpty()) continue;
                        
                        String text = JOptionPane.showInputDialog("Enter message (max 250 characters): ");
                    if (text == null || text.length() > 250) {
                        JOptionPane.showMessageDialog(null, "Please enter a message of less than 250 characters.");
                        continue;
                    }
                    
                    String status = msg.SentMessage(recipient, text);
                    if (!status.equals("Message successfully sent.")) {
                        JOptionPane.showMessageDialog(null, status);
                        continue;
                    }
                    
                    String messageID = msg.getMessageID();
                    String messageHash = msg.createMessageHash(text, messageID.substring(0, 2), i);
                        
                    String action = JOptionPane.showInputDialog("Choose action (Send/Disregard/Store): ");
                    if (action == null) continue;
                    
                    String jsonOutput = "{\n \"MessageID\": \"" + messageID + "\",\n " + "\"MessageHash\": \"" + 
                            messageHash + "\",\n " + "\"Recipient\": \"" + recipient + "\",\n " + "\"Message\": \"" + text + "\"\n}";
                       
                    // offers the three actions to determine what happens to the message.
                        switch (action.toLowerCase()) {
                            case "send":
                                sentMessageList.add(msg);
                                JOptionPane.showMessageDialog(null, jsonOutput, "Message Sent", JOptionPane.INFORMATION_MESSAGE);
                                System.out.println("Message sent:\n" + jsonOutput);
                                break;
                            case "store":
                                msg.storeMessages();
                                sentMessageList.add(msg);
                                JOptionPane.showMessageDialog(null, jsonOutput, "Message Stored", JOptionPane.INFORMATION_MESSAGE);
                                System.out.println("Message stored:\n" + jsonOutput);
                                break;
                            case "disregard": 
                                JOptionPane.showMessageDialog(null, "Message discarded.");
                                System.out.println("Message discarded.");
                                continue;
                            default:
                                JOptionPane.showMessageDialog(null, "Invalid action.");
                                System.out.println("Invalid action entered.");
                                continue;
                        }
                        
                        sentMessages++;
                        
                        if (sentMessages == totalMessages) {
                            JOptionPane.showMessageDialog(null, "All " + sentMessages + " messages have been sent.", "Limited Reached", JOptionPane.INFORMATION_MESSAGE);
                            System.out.println("All messages sent.");
                            break;
                        }
                    } 
                    break;
                
                    case "2":
                        JOptionPane.showMessageDialog(null, "Coming Soon."); 
                        System.out.println("Coming Soon.");
                        
                        if (sentMessageList.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "No messages sent yet.");
                            System.out.println("No messages sent yet, to display.");
                        } else {
                            StringBuilder builder = new StringBuilder();
                            for (Message m : sentMessageList) {
                                String detail = m.printMessages();
                                builder.append(detail).append("\n\n");
                                System.out.println(detail);
                            }
                            JOptionPane.showMessageDialog(null, builder.toString(), "Recently Sent Messages:", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break; //(Datacamp, 2025).
                    
                    case "3":
                        JOptionPane.showMessageDialog(null, "Thank you for using QuickChat!");
                        System.out.println("User exited QuickChat.");
                        running = false;
                        break;
                        
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid option. Please enter 1,2, or 3.");
                        System.out.println("Invalid menu option.");
                }
            }
        }
    }
