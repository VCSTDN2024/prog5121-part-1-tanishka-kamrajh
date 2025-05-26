/**
 * ST10473692
 * @author Tanishka Kamrajh
 */

package com.mycompany.st10473692_formative1_part2;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {

    private Login instance;

    @Before
    public void setUp() {
        instance = new Login();
        instance.registerUser("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
    }

    @Test
    public void testCheckUserName() {
        assertTrue(instance.checkUserName("kyl_1"));
    }

    @Test
    public void testCheckUserNameInvalid() {
        assertFalse(instance.checkUserName("kyle!!!!!!!"));
    }

    @Test
    public void testCheckPasswordComplexity() {
        assertTrue(instance.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    @Test
    public void testCheckPasswordComplexityInvalid() {
        assertFalse(instance.checkPasswordComplexity("password"));
    }

    @Test
    public void testCheckCellPhoneNumber() {
        assertTrue(instance.checkCellPhoneNumber("+27838968976"));
    }

    @Test
    public void testCheckCellPhoneNumberInvalid() {
        assertFalse(instance.checkCellPhoneNumber("08966553"));
    }

    @Test 
    public void testRegisterUser_Success() {
        boolean result = instance.registerUser("Anna", "Lee", "ann_1", "Passw0rd@", "+27821234567");
        assertTrue(result);
    }
    
    @Test
    public void testRegisterUser_InvalidPhone() {
        boolean result = instance.registerUser("Anna", "Lee", "ann_1", "Passw0rd@", "0821234567");
        assertFalse(result);
    }
    
    @Test
    public void testLoginUser_Valid() {
        assertTrue(instance.loginUser("kyl_1", "Ch&&sec@ke99!", "+27838968976"));
    }

    @Test
    public void testLoginUser_Invalid() {
        assertFalse(instance.loginUser("kyle!!!!!!!", "password", "08966553"));
    }

    @Test
    public void testReturnLoginStatus_LoggedIn() {
        instance.loginUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        String expected = "Welcome Kyle Smith, it is great to see you again.";
        assertEquals(expected, instance.returnLoginStatus());
    }
    
    @Test
    public void testReturnLoginStatus_NotLoggedIn() {
        String expected = "Username, password, or phone number is incorrect, please try again.";
        assertEquals(expected, instance.returnLoginStatus());
    }
}