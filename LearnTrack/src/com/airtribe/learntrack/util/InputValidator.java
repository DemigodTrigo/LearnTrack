package com.airtribe.learntrack.util;

public class InputValidator {

    private InputValidator(){
    }

    public static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    public static boolean isValidEmail(String email) {

        if (isNullOrEmpty(email)) {
            return false;
        }

        return email.contains("@") && email.contains(".");
    }

    public static boolean isPositiveNumber(int number) {
        return number > 0;
    }

}
