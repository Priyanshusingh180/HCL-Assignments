import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {
            System.out.println("\n1.Create Account 2.Deposit 3.Withdraw 4.Balance 5.Exit");
            int ch = sc.nextInt();

            if (ch == 1) {
                System.out.print("Account No: ");
                int accNo = sc.nextInt();
                System.out.print("Name: ");
                sc.nextLine();
                String name = sc.nextLine();
                System.out.print("Initial Balance: ");
                double bal = sc.nextDouble();
                System.out.print("1.Savings 2.Current: ");
                int type = sc.nextInt();

                Account acc = (type == 1) ?
                        new SavingsAccount(accNo, name, bal) :
                        new CurrentAccount(accNo, name, bal);

                bank.addAccount(acc);
                System.out.println("Account Created");

            } else if (ch == 2) {
                System.out.print("Account No: ");
                int accNo = sc.nextInt();
                Account acc = bank.getAccount(accNo);
                if (acc != null) {
                    System.out.print("Amount: ");
                    acc.deposit(sc.nextDouble());
                    bank.saveToFile();
                }

            } else if (ch == 3) {
                System.out.print("Account No: ");
                int accNo = sc.nextInt();
                Account acc = bank.getAccount(accNo);
                if (acc != null) {
                    System.out.print("Amount: ");
                    if (!acc.withdraw(sc.nextDouble())) {
                        System.out.println("Insufficient Balance");
                    }
                    bank.saveToFile();
                }

            } else if (ch == 4) {
                System.out.print("Account No: ");
                int accNo = sc.nextInt();
                Account acc = bank.getAccount(accNo);
                if (acc != null) {
                    System.out.println("Balance: " + acc.getBalance());
                }

            } else {
                break;
            }
        }
        sc.close();
    }
}