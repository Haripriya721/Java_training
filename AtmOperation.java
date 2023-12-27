package com.atm;
import java.util.*;
public class AtmOperation {
	 private static double balance = 0; // Initial balance
	    private static  int PIN = 1234; // ATM PIN
	    
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        
	        System.out.print("Enter your PIN: ");
	        int enteredPIN = scanner.nextInt();
	        
	        if (enteredPIN == PIN) {
	            int choice;

	            do {
	                System.out.println("\nATM Operations:");
	                System.out.println("1. Check Balance");
	                System.out.println("2. Deposit");
	                System.out.println("3. Withdraw");
	                System.out.println("4. Change PIN");
	                System.out.println("5. Exit");
	                System.out.print("Enter your choice: ");
	                choice = scanner.nextInt();

	                switch (choice) {
	                    case 1:
	                        checkBalance();
	                        break;
	                    case 2:
	                        deposit(scanner);
	                        break;
	                    case 3:
	                        withdraw(scanner);
	                        break;
	                    case 4:
	                        changePIN(scanner);
	                        break;
	                    case 5:
	                        System.out.println("Thank you for using the ATM. have a nice day!");
	                        break;
	                    default:
	                        System.out.println("Invalid choice. Please enter a valid option.");
	                }
	            } while (choice != 5);
	        } else {
	            System.out.println("Incorrect PIN. Access denied.");
	        }
	        
	        scanner.close();
	    }

	    private static void checkBalance() {
	        System.out.println("Your balance is: $" + balance);
	    }

	    private static void deposit(Scanner scanner) {
	        System.out.print("Enter the amount to deposit: $");
	        double amount = scanner.nextDouble();
	        if (amount <= 0) {
	            System.out.println("Invalid amount. Deposit amount must be greater than zero.");
	        } else {
	            balance += amount;
	            System.out.println("Deposit successful. Your new balance is: $" + balance);
	        }
	    }

	    private static void withdraw(Scanner scanner) {
	        System.out.print("Enter the amount to withdraw: $");
	        double amount = scanner.nextDouble();
	        if (amount <= 0) {
	            System.out.println("Invalid amount. Withdrawal amount must be greater than zero.");
	        } else if (amount > balance) {
	            System.out.println("Insufficient funds. Your current balance is: $" + balance);
	        } else {
	            balance -= amount;
	            System.out.println("Withdrawal successful. Your new balance is: $" + balance);
	        }
	    }

	    private static void changePIN(Scanner scanner) {
	        System.out.print("Enter your current PIN: ");
	        int currentPIN = scanner.nextInt();
	        
	        if (currentPIN == PIN) {
	            System.out.print("Enter your new PIN: ");
	            PIN = scanner.nextInt();
	            System.out.println("PIN changed successfully.");
	        } else {
	            System.out.println("Incorrect PIN. PIN change failed.");
	        }
	    }
	}


