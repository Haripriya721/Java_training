package com.labQuestion;

public class StringvowelExecption {

    public static void main(String[] args) {
        try {
            checkForVowels("Hello");
            checkForVowels("Rhythm"); 
        } catch (NoVowelsException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void checkForVowels(String input) throws NoVowelsException {
        if (!input.matches(".*[aeiouAEIOU].*")) {
            throw new NoVowelsException("Exception:No vowels found in the input string!!!");
        } else {
            System.out.println("Input string is: " + input);
        }
    }
}

class NoVowelsException extends Exception {
    public NoVowelsException(String message) {
        super(message);
    }
}