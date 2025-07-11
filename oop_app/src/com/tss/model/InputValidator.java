package com.tss.model;

public class InputValidator {

	public String validateUsername(String username) {
		String commonValidation = commonValidation(username, 3, 20, "Username");
		if (!commonValidation.equals("Valid")) {
			return commonValidation;
		}
		return "Valid Username";
	}

	public String validatePassword(String password) {
		String commonValidation = commonValidation(password, 8, 30, "Password");
		if (!commonValidation.equals("Valid")) {
			return commonValidation;
		}
		return "Valid Password";
	}

	public String validateEmail(String email) {
		String commonValidation = commonValidation(email, 5, 50, "Email");
		if (!commonValidation.equals("Valid")) {
			return commonValidation;
		}
		if (!email.contains("@") || !email.contains(".")) {
			return "Invalid Email: Must contain '@' and '.'";
		}
		return "Valid Email";
	}

	private String commonValidation(String input, int minLength, int maxLength, String fieldName) {
		if (input == null || input.isEmpty()) {
			return "Invalid " + fieldName + ": Cannot be null or empty.";
		}
		if (input.length() < minLength || input.length() > maxLength) {
			return "Invalid " + fieldName + ": Length must be between " + minLength + " and " + maxLength + ".";
		}
		return "Valid";
	}
}
