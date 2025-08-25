package Project;

import java.io.*;
import java.util.*;

public class Bank {
    private Map<Integer, Account> accounts = new HashMap<>();
    private final String FILE_NAME = "accounts.txt";

    public Bank() {
        loadAccounts();
    }

    public void createAccount(int accNum, String name, double initialDeposit) {
        if (accounts.containsKey(accNum)) {
            System.out.println("Account already exists.");
            return;
        }
        accounts.put(accNum, new Account(accNum, name, initialDeposit));
    }

    public Account getAccount(int accNum) {
        return accounts.get(accNum);
    }

    public void saveAccounts() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(accounts);
        } catch (IOException e) {
            System.out.println("Error saving accounts.");
        }
    }

    @SuppressWarnings("unchecked")
    private void loadAccounts() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            accounts = (Map<Integer, Account>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading accounts.");
        }
    }
}
