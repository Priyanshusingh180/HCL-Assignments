class SavingsAccount extends Account {

    public SavingsAccount(int accountNumber, String name, double balance) {
        super(accountNumber, name, balance);
    }

    @Override
    public void calculateInterest() {
        balance += balance * 0.04;
    }
}