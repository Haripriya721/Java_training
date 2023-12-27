package com.labQuestion;

import java.util.Scanner;


abstract class BankAccount {
 protected double balance;

 public BankAccount(double initialBalance) {
     this.balance = initialBalance;
 }

 // Abstract methods to be implemented by subclasses
 public abstract void deposit(double amount);

 public abstract void withdraw(double amount);

 public double getBalance() {
     return balance;
 }
}

//Subclass SavingsAccount
class SavingsAccount extends BankAccount {
 private double interestRate;

 public SavingsAccount(double initialBalance, double interestRate) {
     super(initialBalance);
     this.interestRate = interestRate;
 }

 @Override
 public void deposit(double amount) {
     balance += amount;
     System.out.println("Deposit of $" + amount + " into savings account. Current balance: $" + balance);
 }

 @Override
 public void withdraw(double amount) {
     if (balance - amount >= 0) {
         balance -= amount;
         System.out.println("Withdrawal of $" + amount + " from savings account. Current balance: $" + balance);
     } else {
         System.out.println("Insufficient funds in savings account. Current balance: $" + balance);
     }
 }
}

//Subclass CurrentAccount
class CurrentAccount extends BankAccount {
 private double overdraftLimit;

 public CurrentAccount(double initialBalance, double overdraftLimit) {
     super(initialBalance);
     this.overdraftLimit = overdraftLimit;
 }

 @Override
 public void deposit(double amount) {
     balance += amount;
     System.out.println("Deposit of $" + amount + " into current account. Current balance: $" + balance);
 }

 @Override
 public void withdraw(double amount) {
     if (balance - amount >= -overdraftLimit) {
         balance -= amount;
         System.out.println("Withdrawal of $" + amount + " from current account. Current balance: $" + balance);
     } else {
         System.out.println("Withdrawal amount exceeds overdraft limit. Current balance: $" + balance);
     }
 }
}

public class Main {
	 public static void main(String[] args) {
	     // Creating a SavingsAccount object
	     SavingsAccount savingsAccount = new SavingsAccount(1000, 0.05);
	     System.out.println("Savings Account Balance: $" + savingsAccount.getBalance());
	     savingsAccount.deposit(500);
	     savingsAccount.withdraw(2000);

	     // Creating a CurrentAccount object
	     CurrentAccount currentAccount = new CurrentAccount(2000, 1000);
	     System.out.println("\nCurrent Account Balance: $" + currentAccount.getBalance());
	     currentAccount.deposit(1000);
	     currentAccount.withdraw(3000);
	 }

}

