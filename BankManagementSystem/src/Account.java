abstract class Account {
    protected int accountNumber;
    protected String name;
    protected double balance;

    public Account(int accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    public abstract void calculateInterest();

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }

    public String toFileString() {
        return accountNumber + "," + name + "," + balance + "," + this.getClass().getSimpleName();
    }
}