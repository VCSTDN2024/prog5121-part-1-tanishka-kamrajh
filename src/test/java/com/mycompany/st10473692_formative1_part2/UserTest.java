/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.st10473692_formative1_part2;

import com.mycompany.st10473692_formative1_part2.User;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * ST10473692
 * @author Tanishka Kamrajh
 */
public class UserTest {
     private User user;

    @Before
    public void setUp() {
        user = new User("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
    }

    @Test
    public void testGetFirstName() {
        assertEquals("Kyle", user.getFirstName());
    }

    @Test
    public void testGetLastName() {
        assertEquals("Smith", user.getLastName());
    }

    @Test
    public void testGetUsername() {
        assertEquals("kyl_1", user.getUsername());
    }

    @Test
    public void testGetPassword() {
        assertEquals("Ch&&sec@ke99!", user.getPassword());
    }

    @Test
    public void testGetCellPhoneNumber() {
        assertEquals("+27838968976", user.getCellPhoneNumber());
    }

    @Test
    public void testRegisterUserAlwaysReturnsTrue() {
        assertTrue(user.registerUser());
    }
}

    
   

   