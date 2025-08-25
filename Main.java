package Project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {
            System.out.println("\n=== Simple Banking System ===");
            System.out.println("1. Create Account");
            System.out.println("2. View Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Check Balance");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    int accNum = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    System.out.print("Enter Holder Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Initial Deposit: ");
                    double deposit = sc.nextDouble();
                    bank.createAccount(accNum, name, deposit);
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    accNum = sc.nextInt();
                    Account acc = bank.getAccount(accNum);
                    System.out.println(acc != null ? acc : "Account not found.");
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    accNum = sc.nextInt();
                    acc = bank.getAccount(accNum);
                    if (acc != null) {
                        System.out.print("Enter amount to deposit: ");
                        double amt = sc.nextDouble();
                        acc.deposit(amt);
                        System.out.println("Deposit successful.");
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    accNum = sc.nextInt();
                    acc = bank.getAccount(accNum);
                    if (acc != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double amt = sc.nextDouble();
                        if (acc.withdraw(amt))
                            System.out.println("Withdrawal successful.");
                        else
                            System.out.println("Insufficient balance.");
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter Account Number: ");
                    accNum = sc.nextInt();
                    acc = bank.getAccount(accNum);
                    if (acc != null)
                        System.out.println("Balance: ₹" + acc.getBalance());
                    else
                        System.out.println("Account not found.");
                    break;

                case 6:
                    bank.saveAccounts();
                    System.out.println("Exiting... Goodbye!");
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}

