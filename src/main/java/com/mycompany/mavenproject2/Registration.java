/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
//https://www.w3schools.com/java/java_intro.asp
//https://www.w3schools.com/java/java_output.asp
//https://www.w3schools.com/java/java_variables.asp
//Author:Google Gemeni
//Date:2025
//Title:ChayGPT-4(Feb Version)[Large LAnguage Model]
//https://gemini.google.com/app

package com.mycompany.mavenproject2;
import java.util.Scanner;
/**
 *
 * @author brook
 */
public class Registration {
    private String registeredUsername;
    private String registeredPassword;

    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity(String password) {
        if (password.length() < 8) return false;
        boolean hasUpperCase = false;
        boolean hasNumber = false;
        boolean hasSpecialChar = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpperCase = true;
            if (Character.isDigit(c)) hasNumber = true;
            String specialChars = "!@#$%^&*(),.?\":{}|<>";
            if (specialChars.contains(String.valueOf(c))) hasSpecialChar = true;
        }
        return hasUpperCase && hasNumber && hasSpecialChar;
    }

    public boolean checkCellphoneNumber(String cellNumber) {
        // Regular expression for South African international format (+27 followed by 0 to 7 digits)
        return cellNumber.matches("^\\+27\\d{0,7}$");
    }

    public String registerUser(String username, String password, String cellNumber) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        if (!checkCellphoneNumber(cellNumber)) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }

        this.registeredUsername = username;
        this.registeredPassword = password;
        return "Registration successful!";
    }

    public String getRegisteredUsername() {
        return registeredUsername;
    }

    public String getRegisteredPassword() {
        return registeredPassword;
    }
}

public class Login {
    private String storedUsername;
    private String storedPassword;

    public Login(String username, String password) {
        this.storedUsername = username;
        this.storedPassword = password;
    }

    public boolean loginUser(String username, String password) {
        return this.storedUsername != null && this.storedUsername.equals(username) && this.storedPassword != null && this.storedPassword.equals(password);
    }

    public String returnLoginStatus(boolean loginSuccess, String username) {
        if (loginSuccess) {
            return "Welcome " + username + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Registration registrationSystem = new Registration();

        System.out.println("--- Registration ---");
        System.out.print("Enter your username for registration: ");
        String regUsername = scanner.nextLine();
        System.out.print("Enter your password for registration: ");
        String regPassword = scanner.nextLine();
        System.out.print("Enter your South African cell phone number (e.g., +27xxxxxxxxx): ");
        String regCellNumber = scanner.nextLine();

        String registrationResult = registrationSystem.registerUser(regUsername, regPassword, regCellNumber);
        System.out.println(registrationResult);

        System.out.println("\n--- Login ---");
        String registeredUsername = registrationSystem.getRegisteredUsername();
        String registeredPassword = registrationSystem.getRegisteredPassword();

        if (registeredUsername != null && registeredPassword != null) {
            Login loginSystem = new Login(registeredUsername, registeredPassword);
            System.out.print("Enter your username to log in: ");
            String loginUsername = scanner.nextLine();
            System.out.print("Enter your password to log in: ");
            String loginPassword = scanner.nextLine();

            boolean loginSuccess = loginSystem.loginUser(loginUsername, loginPassword);
            String loginMessage = loginSystem.returnLoginStatus(loginSuccess, loginUsername);
            System.out.println(loginMessage);
        } else {
            System.out.println("No user registered successfully. Login cannot proceed.");
        }

               System.out.println();
    }
    
