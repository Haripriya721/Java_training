package com.labQuestion;

public class IntegerOddException {

	public static void main(String[] args) {
	        try {
	            checkEvenNumber(4); // This will not throw an exception
	            checkEvenNumber(7); // This will throw an exception
	        } catch (OddNumberException e) {
	            System.out.println(e.getMessage());
	        }
	    }

	    public static void checkEvenNumber(int number) throws OddNumberException {
	        if (number % 2 != 0) {
	            throw new OddNumberException("Exception: Odd number detected!!!! ");
	        } else {
	        	int square =number*number;
	            System.out.println("Square of number: " + square);
	        }
	    }
	}


	// Custom unchecked exception class for odd numbers
	class OddNumberException extends RuntimeException {
	    public OddNumberException(String message) {
	        super(message);
	    }
	}