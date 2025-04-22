/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author brook
 */
public class RegistrationTest {

    @Test
    void testCheckUserNameValid() {
        Registration registration = new Registration();
        assertTrue(registration.checkUserName("kyle_1"));
        assertTrue(registration.checkUserName("valid_"));
    }

    @Test
    void testCheckUserNameInvalid() {
        Registration registration = new Registration();
        assertFalse(registration.checkUserName("kyle!!!!!"));
        assertFalse(registration.checkUserName("toolongusername"));
    }

    @Test
    void testCheckPasswordComplexityValid() {
        Registration registration = new Registration();
        assertTrue(registration.checkPasswordComplexity("P@sswOrd123"));
        assertTrue(registration.checkPasswordComplexity("Ch&sec@ke99!"));
    }

    @Test
    void testCheckPasswordComplexityInvalid() {
        Registration registration = new Registration();
        assertFalse(registration.checkPasswordComplexity("password"));
    }

    @Test
    void testCheckCellphoneNumberValid() {
        Registration registration = new Registration();
        assertTrue(registration.checkCellphoneNumber("+27821234567"));
        assertTrue(registration.checkCellphoneNumber("+27123"));
        assertTrue(registration.checkCellphoneNumber("+27838968976"));
    }

    @Test
    void testCheckCellphoneNumberInvalid() {
        Registration registration = new Registration();
        assertFalse(registration.checkCellphoneNumber("0821234567"));
        assertFalse(registration.checkCellphoneNumber("08966553"));
    }

  
}

public class LoginTest {

    @Test
    void testLoginUserSuccessful() {
        Login login = new Login("testuser", "TestPass1!");
        assertTrue(login.loginUser("testuser", "TestPass1!"));
    }

    @Test
    void testLoginUserIncorrectCredentials() {
        Login login = new Login("testuser", "TestPass1!");
        assertFalse(login.loginUser("wronguser", "TestPass1!"));
        assertFalse(login.loginUser("testuser", "wrongpass"));
        assertFalse(login.loginUser("wronguser", "wrongpass"));
    }

    @Test
    void testReturnLoginStatusSuccessful() {
        Login login = new Login("testuser", "TestPass1!");
        assertEquals("Welcome testuser, it is great to see you again.", login.returnLoginStatus(true, "testuser"));
    }

    @Test
    void testReturnLoginStatusFailed() {
        Login login = new Login("testuser", "TestPass1!");
        assertEquals("Username or password incorrect, please try again.", login.returnLoginStatus(false, "anyuser"));
    }
}
