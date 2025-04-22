/**
 * ST10473692
 * @author Tanishka Kamrajh
 */

package com.mycompany.st10473692_formative1_part1;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {

    private Login instance;

    @Before
    public void setUp() {
        User user = new User("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        instance = new Login(user);
    }

    @Test
    public void testCheckUserName() {
        System.out.println("checkUserName");
        String username = "kyl_1";
        assertTrue(instance.checkUserName(username));
    }

    @Test
    public void testCheckUserNameInvalid() {
        System.out.println("checkUserNameInvalid");
        String username = "kyle!!!!!!!";
        assertFalse(instance.checkUserName(username));
    }

    @Test
    public void testCheckPasswordComplexity() {
        System.out.println("checkPasswordComplexity");
        String password = "Ch&&sec@ke99!";
        assertTrue(instance.checkPasswordComplexity(password));
    }

    @Test
    public void testCheckPasswordComplexityInvalid() {
        System.out.println("checkPasswordComplexityInvalid");
        String password = "password";
        assertFalse(instance.checkPasswordComplexity(password));
    }

    @Test
    public void testCheckCellPhoneNumber() {
        System.out.println("checkCellPhoneNumber");
        String phone = "+27838968976";
        assertTrue(instance.checkCellPhoneNumber(phone));
    }

    @Test
    public void testCheckCellPhoneNumberInvalid() {
        System.out.println("checkCellPhoneNumberInvalid");
        String phone = "08966553";
        assertFalse(instance.checkCellPhoneNumber(phone));
    }

    @Test
    public void testRegisterUser() {
        assertTrue(instance.registerUser());
    }

    @Test
    public void testLoginUser() {
        System.out.println("loginUser");
        String username = "kyl_1";
        String password = "Ch&&sec@ke99!";
        assertTrue(instance.loginUser(username, password));
    }

    @Test
    public void testLoginUserInvalid() {
        System.out.println("loginUserInvalid");
        String username = "kyle!!!!!!!";
        String password = "password";
        assertFalse(instance.loginUser(username, password));
    }

    @Test
    public void testReturnLoginStatus() {
        System.out.println("returnLoginStatus");
        instance.registerUser();
        instance.loginUser("kyl_1", "Ch&&sec@ke99!");
        String expected = "Welcome Kyle, Smith it is great to see you.";
        String result = instance.returnLoginStatus();
        assertEquals(expected, result);
    }
}