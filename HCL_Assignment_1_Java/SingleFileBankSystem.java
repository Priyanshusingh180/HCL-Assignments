import java.util.ArrayList;
import java.util.Scanner;

// Custom Exception Classes
class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

// Bank Account Class
class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private String accountType;
    private double balance;
    
    public BankAccount(String accountNumber, String accountHolderName, 
                      String accountType, double initialDeposit) throws InvalidAmountException {
        if(initialDeposit < 0) {
            throw new InvalidAmountException("Initial deposit cannot be negative!");
        }
        
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.accountType = accountType;
        this.balance = initialDeposit;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public String getAccountHolderName() {
        return accountHolderName;
    }
    
    public String getAccountType() {
        return accountType;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void deposit(double amount) throws InvalidAmountException {
        if(amount <= 0) {
            throw new InvalidAmountException("Deposit amount must be positive!");
        }
        this.balance += amount;
    }
    
    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
        if(amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be positive!");
        }
        
        if(amount > balance) {
            throw new InsufficientFundsException("Insufficient funds! Available balance: " + balance);
        }
        
        this.balance -= amount;
    }
    
    public void displayAccountDetails() {
        System.out.println("\n=== Account Details ===");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Type: " + accountType);
        System.out.println("Current Balance: $" + balance);
        System.out.println("=======================");
    }
}

// Main Bank Management System Class
public class SingleFileBankSystem {
    private static ArrayList<BankAccount> accounts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int accountCounter = 1000;
    
    public static void main(String[] args) {
        int choice;
        
        do {
            System.out.println("\n=== Bank Management System ===");
            System.out.println("1. Create New Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Display Account Details");
            System.out.println("6. Display All Accounts");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch(choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    displayAccountDetails();
                    break;
                case 6:
                    displayAllAccounts();
                    break;
                case 7:
                    System.out.println("Thank you for using our Bank Management System!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while(choice != 7);
        
        scanner.close();
    }
    
    private static void createAccount() {
        System.out.println("\n=== Create New Account ===");
        
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter initial deposit amount: $");
        double initialDeposit = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        
        System.out.print("Enter account type (Savings/Current): ");
        String accountType = scanner.nextLine();
        
        String accountNumber = "ACC" + accountCounter++;
        
        try {
            BankAccount newAccount = new BankAccount(accountNumber, name, accountType, initialDeposit);
            accounts.add(newAccount);
            System.out.println("Account created successfully!");
            System.out.println("Your Account Number: " + accountNumber);
        } catch (InvalidAmountException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private static BankAccount findAccount(String accountNumber) {
        for(BankAccount account : accounts) {
            if(account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
    
    private static void depositMoney() {
        System.out.println("\n=== Deposit Money ===");
        
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        
        BankAccount account = findAccount(accountNumber);
        if(account == null) {
            System.out.println("Account not found!");
            return;
        }
        
        System.out.print("Enter amount to deposit: $");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        
        try {
            account.deposit(amount);
            System.out.println("Amount deposited successfully!");
            System.out.println("New Balance: $" + account.getBalance());
        } catch (InvalidAmountException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private static void withdrawMoney() {
        System.out.println("\n=== Withdraw Money ===");
        
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        
        BankAccount account = findAccount(accountNumber);
        if(account == null) {
            System.out.println("Account not found!");
            return;
        }
        
        System.out.print("Enter amount to withdraw: $");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        
        try {
            account.withdraw(amount);
            System.out.println("Amount withdrawn successfully!");
            System.out.println("New Balance: $" + account.getBalance());
        } catch (InvalidAmountException | InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private static void checkBalance() {
        System.out.println("\n=== Check Balance ===");
        
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        
        BankAccount account = findAccount(accountNumber);
        if(account == null) {
            System.out.println("Account not found!");
            return;
        }
        
        System.out.println("Account Balance: $" + account.getBalance());
    }
    
    private static void displayAccountDetails() {
        System.out.println("\n=== Display Account Details ===");
        
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        
        BankAccount account = findAccount(accountNumber);
        if(account == null) {
            System.out.println("Account not found!");
            return;
        }
        
        account.displayAccountDetails();
    }
    
    private static void displayAllAccounts() {
        System.out.println("\n=== All Bank Accounts ===");
        
        if(accounts.isEmpty()) {
            System.out.println("No accounts found!");
            return;
        }
        
        System.out.println("Total Accounts: " + accounts.size());
        System.out.println("--------------------------------------------------------");
        System.out.printf("%-15s %-20s %-15s %-10s\n", 
                         "Account No.", "Holder Name", "Account Type", "Balance");
        System.out.println("--------------------------------------------------------");
        
        for(BankAccount account : accounts) {
            System.out.printf("%-15s %-20s %-15s $%-9.2f\n",
                            account.getAccountNumber(),
                            account.getAccountHolderName(),
                            account.getAccountType(),
                            account.getBalance());
        }
        System.out.println("--------------------------------------------------------");
    }
}