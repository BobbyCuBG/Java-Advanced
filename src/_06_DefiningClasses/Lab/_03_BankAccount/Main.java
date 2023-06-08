package _06_DefiningClasses.Lab._03_BankAccount;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<BankAccount> accountHolders = new ArrayList<>();
        DecimalFormat df = new DecimalFormat("##.##");
        String input = sc.nextLine();
        while (!"End".equals(input)) {
            String command = input.split("\\s+")[0];

            switch (command) {
                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    accountHolders.add(bankAccount);
                    System.out.println("Account ID" + bankAccount.getId() + " created");
                    break;
                case "Deposit":
                    int idNumber = Integer.parseInt(input.split("\\s+")[1]);
                    double amount = Double.parseDouble(input.split("\\s+")[2]);

                    if (idNumber > accountHolders.size()) {
                        System.out.println("Account does not exist");
                    } else {
                        accountHolders.get(idNumber - 1).deposit(amount);
                        System.out.printf("Deposited %s to ID%d%n", df.format(amount), idNumber);
                    }
                    break;
                case "SetInterest":
                    double interestRate = Double.parseDouble(input.split("\\s+")[1]);
                    BankAccount.setInterestRate(interestRate);
                    break;
                case "GetInterest":
                    int id = Integer.parseInt(input.split("\\s+")[1]);
                    int years = Integer.parseInt(input.split("\\s+")[2]);

                    if (id > accountHolders.size()) {
                        System.out.println("Account does not exist");
                    } else {
                        System.out.printf("%.2f%n", accountHolders.get(id - 1).getInterest(years));
                    }
                    break;
            }
            input = sc.nextLine();
        }
    }
}
