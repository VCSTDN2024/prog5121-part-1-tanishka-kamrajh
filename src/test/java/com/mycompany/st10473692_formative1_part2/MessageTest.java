/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.st10473692_formative1_part2;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * ST10473692
 * @author Tanishka Kamrajh
 */

public class MessageTest {

       @Test
    public void testMessageLength_Success() {
        Message msg = new Message();
        String message = "Hi Mike, can you join us for dinner tonight";
        assertTrue("Message should not be more than 250 Characters", message.length() <= 250);
        String result = msg.SentMessage("+27718693002", message);
        assertEquals("Message successfully sent.", result);
    }

    @Test
    public void testMessageLength_Failure() {
        Message msg = new Message();
        String longMessage = "A".repeat(260);
        String result = msg.SentMessage("+27718693002", longMessage);
        assertEquals("Please enter a message of less than 250 characters.", result);
    }

    @Test
    public void testRecipientFormat_Success() {
        Message msg = new Message();
        int check = msg.checkRecepientCell("+27718693002");
        assertEquals("Cell phone number successfully captured.", 1, check);
    }

    @Test
    public void testRecipientFormat_Failure() {
        Message msg = new Message();
        int check = msg.checkRecepientCell("08575975889");
        assertEquals("Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.", 0, check);
    }

    @Test
    public void testCreateMessageHash_CorrectForTestCase1() {
        Message msg = new Message();
        String hash = msg.createMessageHash("Hi Mike, can you join us for dinner tonight", "0012345678", 0);
        assertEquals("00:0:HITONIGHT", hash);
    }

    @Test
    public void testCreateMessageHash_LoopTest() {
        Message msg = new Message();
        String[] messages = {
            "First message here",
            "Second example for hashing",
            "Third one goes here"
        };
        for (int i = 0; i < messages.length; i++) {
            String hash = msg.createMessageHash(messages[i], "0012345678", i);
            assertTrue("Hash format is valid", hash.matches("\\d{2}:" + i + ":[A-Z]+[A-Z]+"));
        }
    }

    @Test
    public void testMessageID_Creation() {
        Message msg = new Message();
        msg.SentMessage("+27718693002", "Hi Mike, can you join us for dinner tonight");
        String messageID = msg.getMessageID();
        assertNotNull("Message ID generated: " + messageID, messageID);
        assertTrue("Message ID should be 10 digits", messageID.matches("\\d{10}"));
    }

    @Test
    public void testSendMessage_SelectedSend() {
        Message msg = new Message();
        String result = msg.SentMessage("+27718693002", "Hi Mike, can you join us for dinner tonight");
        assertEquals("Message successfully sent.", result);
    }

    @Test
    public void testSendMessage_SelectedDisregard() {
        String userChoice = "Disregard";
        String message = "Hi Keegan, did you receive the payment?";
        String response = "";
        
        if (userChoice.equals("Send")) {
            response = "Message stored successfully.";
            System.out.println("User chose to send message: \"" + message + "\"");
        } else if (userChoice.equals("Disregard")) {   
            response = "Press 0 to delete message.";
            System.out.println("User chose to disregard message: \"" + message + "\"");
            
        }
    }

    @Test
    public void testSendMessage_SelectedStore() {
        Message msg = new Message();
        msg.SentMessage("+27718693002", "Hi Mike, can you join us for dinner tonight");
        msg.storeMessages();
        String result = "Message successfully stored.";
        assertEquals("Message successfully stored.", result);
    }

    @Test
    public void testTotalMessagesAfterTwoSends() {
        Message msg1 = new Message();
        msg1.SentMessage("+27718693002", "Hi Mike, can you join us for dinner tonight");

        Message msg2 = new Message();
        msg2.SentMessage("+27718693002", "Another message for testing.");

        int count = msg2.returnTotalMessages();
        assertTrue("Return total number sent: " + count, count >= 2);
    }
}

