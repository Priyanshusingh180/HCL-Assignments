import java.util.Scanner;

// Interface for banking operations
interface Banking {
    void deposit(double amount);
    void withdraw(double amount);
    void checkBalance();
}

// Interface for customer details
interface Customer {
    void displayDetails();
}

// BankAccount class implementing multiple interfaces
class BankAccount implements Banking, Customer {
    private int accNo;
    private String name;
    private double balance;

    BankAccount(int accNo, String name, double balance) {
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Invalid deposit amount");
        balance += amount;
        System.out.println("Amount Deposited Successfully");
    }

    public void withdraw(double amount) {
        if (amount > balance)
            throw new ArithmeticException("Insufficient Balance");
        balance -= amount;
        System.out.println("Amount Withdrawn Successfully");
    }

    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

    public void displayDetails() {
        System.out.println("Account No: " + accNo);
        System.out.println("Customer Name: " + name);
    }
}

public class BankMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            BankAccount acc = new BankAccount(101, "Rahul", 5000);
            acc.displayDetails();
            acc.deposit(2000);
            acc.withdraw(1000);
            acc.checkBalance();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

