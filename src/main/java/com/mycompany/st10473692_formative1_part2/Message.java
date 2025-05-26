/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.st10473692_formative1_part2;

/**
 * ST10473692
 * @author Tanishka Kamrajh
 */

import java.util.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Message {

    public Message(String string, String hi_Mike_can_you_join_us_for_dinner_tonigh) {
    }
    private static int _message_count = 0;
    private static final JSONArray _stored_messages = new JSONArray(); //(Oracle,2015).

    private String _message_id;
    private int _message_number;
    private String _recipient;
    private String _message;
    private String _message_hash;
    
    // Load existing messages from the JSON to ensure unique counting (JSONParser, 2023).
    static {
        try (FileReader reader = new FileReader("messages.json")) {
            JSONParser parser = new JSONParser(); //(GeeksforGeeks, 2019).
            Object obj = parser.parse(reader);
            JSONArray loadedMessages = (JSONArray) obj; //(Oracle, 2015).
            _stored_messages.addAll(loadedMessages); 
            _message_count = _stored_messages.size(); // Shows real-time count.
        } catch (IOException | ParseException e) {
            // If the file does not exist or cannot be parsed then just continue with empty storage.
        }
    }

    //Check if the message ID is actually 10-digits.
    public boolean checkMessageID(String id) {
        return id.matches("\\d{10}");
    } //(Datacamp, 2025).

    // Check that the phone number begins with a '+' and is max 13 characters long (Woodward, 2024). 
    public int checkRecepientCell(String recipient) {
        if (recipient.startsWith("+") && recipient.length() <= 13 && recipient.substring(1).matches("\\d+")) {
            return 1;
        }
        return 0;
    }

    // Creates a message hash: first 2 of ID, message count, and first+last word (custom format) asked for.
    public String createMessageHash(String message, String message_id, int message_num) {
        String[] words = message.trim().split("\\s+");
        String first = words[0];
        String last = words[words.length - 1];
        String prefix = message_id.substring(0, 2);
        return (prefix + ":" + message_num + ":" + first + last).toUpperCase();
    } //(W3Schools, 2025).

    // Sends a message only after verifying that the recipient and content is correct.
    public String SentMessage(String recipient, String message) {
        if (checkRecepientCell(recipient) == 0) {
            return "Invalid recipient.";
        }
        if (message.length() > 250) 
            return "Please enter a message of less than 250 characters.";

        _message_count++;
        _message_id = String.format("%010d", new Random().nextInt(1_000_000_000));
        _message_number = _message_count;
        _recipient = recipient;
        _message = message;
        _message_hash = createMessageHash(message, _message_id, _message_number);

        return "Message successfully sent.";
    }

    //Prints the message details for review.
    public String printMessages() {
        return "Message ID: " + _message_id + "\n" +
               "Message Hash: " + _message_hash + "\n" +
               "Recipient: " + _recipient + "\n" +
               "Message: " + _message + "\n";
    }
    
    //Returns the current messages unique ID.
    public String getMessageID() {
        return _message_id;
    }

    //Return the total number of messages sent so far.
    public int returnTotalMessages() {
        return _message_count; //(W3Schools, 2025).
    }

    // Store the current message into the JSON file for permanent record
    public void storeMessages() {
        
    // Method to generate and store JSON messages.
    // Developed with guidance from: 
    // JSON.simple Encoding Examples, https://code.google.com/archive/p/json-simple/wikis/EncodingExamples.wiki
    // Accessed: 18 May 2025
    // Attribution: The JSON encoding logic was created using the JSON.simple project examples.
        
        JSONObject json = new JSONObject();
        json.put("MessageID", _message_id);
        json.put("MessageHash", _message_hash);
        json.put("Recipient", _recipient);
        json.put("Message", _message);
        _stored_messages.add(json);

        try (FileWriter file = new FileWriter("messages.json")) {
            file.write(_stored_messages.toJSONString().replace("},", "},\n")); // pretty print format, (more readable).
            file.flush();
            System.out.println("Message saved to messages.json (JSON file).");
        } catch (IOException e) {
            System.out.println("Error saving to JSON.");
        }
        
    }
    public Message() {
        
    }
}
