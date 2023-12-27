package com.labQuestion;



import java.util.ArrayList;
import java.util.List;

// Account interface
interface Account {
    void deposit(double amount);

    void withdraw(double amount);

    double calculateInterest();

    double getBalance();
}

// SavingsAccount class implementing Account interface
class SA implements Account {
    private double balance;
    private double interestRate;

    public SA(double initialBalance, double interestRate) {
        this.balance = initialBalance;
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds");
        }
    }

    @Override
    public double calculateInterest() {
        return balance * interestRate;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    public void addInterest() {
        balance += calculateInterest();
    }
}

// CurrentAccount class implementing Account interface
class CA implements Account {
    private double balance;
    private double overdraftLimit;

    public CA(double initialBalance, double overdraftLimit) {
        this.balance = initialBalance;
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (balance + overdraftLimit >= amount) {
            balance -= amount;
        } else {
            System.out.println("Exceeds overdraft limit");
        }
    }

    @Override
    public double calculateInterest() {
        return 0; // Current account does not earn interest
    }

    @Override
    public double getBalance() {
        return balance;
    }

    public void applyOverdraftFee() {
        balance -= 20; // Example of unique method for CurrentAccount
    }
}

// Bank class
class Bank {
    private List<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}

// Main class for testing
public class Banking {



    public static void main(String[] args) {
        Bank bank = new Bank();

        // Create and add accounts to the bank
        Account savingsAccount = new SA(1000, 0.05);
        Account currentAccount = new CA(500, 100);
        bank.addAccount(savingsAccount);
        bank.addAccount(currentAccount);

        // Demonstrate operations on accounts
        for (Account account : bank.getAccounts()) {
            System.out.println("Initial balance: " + account.getBalance());
            account.deposit(200);
            System.out.println("After depositing $200: " + account.getBalance());
            account.withdraw(300);
            System.out.println("After withdrawing $300: " + account.getBalance());
            System.out.println("Interest earned: " + account.calculateInterest());
            if (account instanceof SA) {
                ((SA) account).addInterest(); // Additional method for SavingsAccount
                System.out.println("After adding interest: " + account.getBalance());
            } else if (account instanceof CurrentAccount) {
                ((CA) account).applyOverdraftFee(); // Additional method for CurrentAccount
                System.out.println("After applying overdraft fee: " + account.getBalance());
            }
            System.out.println();
        }
    }
}