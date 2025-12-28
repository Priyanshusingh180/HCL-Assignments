class CurrentAccount extends Account {

    public CurrentAccount(int accountNumber, String name, double balance) {
        super(accountNumber, name, balance);
    }

    @Override
    public void calculateInterest() {
        // No interest for current account
    }
}