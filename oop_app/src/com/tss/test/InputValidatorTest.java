package com.tss.test;

import java.util.Scanner;
import com.tss.model.InputValidator;

public class InputValidatorTest {
    public static void main(String[] args) {

        InputValidator validator = new InputValidator();
        Scanner sc = new Scanner(System.in);

        String usernameInput;
        String usernameResult;
        do {
            System.out.print("Enter username: ");
			 usernameInput = sc.nextLine();
            usernameResult = validator.validateUsername(usernameInput);
            System.out.println("Username Validation: " + usernameResult);
        } while (!usernameResult.equals("Valid Username"));

        String passwordInput;
        String passwordResult;
        do {
            System.out.print("Enter password: ");
            passwordInput = sc.nextLine();
            passwordResult = validator.validatePassword(passwordInput);
            System.out.println("Password Validation: " + passwordResult);
        } while (!passwordResult.equals("Valid Password"));

		String emailInput;
        String emailResult;
        do {
            System.out.print("Enter email: ");
            emailInput = sc.nextLine();
            emailResult = validator.validateEmail(emailInput);
            System.out.println("Email Validation: " + emailResult);
        } while (!emailResult.equals("Valid Email"));

     
    }
}
