import java.io.*;
import java.util.*;

class Bank {
    private static final String FILE_NAME = "accounts.txt";
    private Map<Integer, Account> accounts = new HashMap<>();

    public Bank() {
        loadFromFile();
    }

    public void addAccount(Account acc) {
        accounts.put(acc.accountNumber, acc);
        saveToFile();
    }

    public Account getAccount(int accNo) {
        return accounts.get(accNo);
    }

    public void saveToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Account acc : accounts.values()) {
                pw.println(acc.toFileString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int accNo = Integer.parseInt(data[0]);
                String name = data[1];
                double bal = Double.parseDouble(data[2]);
                String type = data[3];

                Account acc;
                if (type.equals("SavingsAccount")) {
                    acc = new SavingsAccount(accNo, name, bal);
                } else {
                    acc = new CurrentAccount(accNo, name, bal);
                }
                accounts.put(accNo, acc);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}