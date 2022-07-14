import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to FirstPopovoBank");
        System.out.println("We are here to support you ;)");

        String accept = "";
        char option = '\0';
        BankAccount bankAccount = null;
        do {
            showMenu();
            option = scan.nextLine().charAt(0);
            try {
                switch (option) {
                    case 'A':
                        bankAccount = createAnAccount(scan);
                        break;
                    case 'B':
                        if (bankAccount != null) {
                            System.out.println("Your current balance is: "+bankAccount.getBalance());
                        }
                        break;
                    case 'C':
                        Deposit(scan,bankAccount);
                        break;
                    case 'D':
                        Withdraw(scan,bankAccount);
                        break;
                    case 'E':
                        previousAmount(bankAccount,scan);
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Do you want to continue");
            accept = scan.nextLine();
        } while (!accept.equals("No"));

    }

    private static void previousAmount(BankAccount bankAccount, Scanner scan) {
        System.out.println("Which previous transaction do you want to check (Deposit/Withdraw");
        String transactionType = scan.nextLine();
        if (bankAccount != null) {
            System.out.println(bankAccount.getPrevious(transactionType));
        }
    }

    private static void Withdraw(Scanner scan, BankAccount bankAccount) {
        System.out.println("Please enter the desired withdraw amount.");
        int withdrawAmount = Integer.parseInt(scan.nextLine());
        if (bankAccount != null) {
            bankAccount.withdraw(withdrawAmount);
        }
    }

    private static void Deposit(Scanner scan,BankAccount bankAccount) {
        System.out.println("Please enter the desired deposit amount.");
        int amount = Integer.parseInt(scan.nextLine());
        if (bankAccount != null) {
            bankAccount.Deposit(amount);
        }
    }

    private static BankAccount createAnAccount(Scanner scan) {
        System.out.println("We need some information to create your bank account. :)");
        System.out.println("Please enter your first and last name:");
        String name = scan.nextLine();
        System.out.println("Enter your preferred ID");
        String id = scan.nextLine();
        System.out.println("Your account is created.");
        return new BankAccount(name, id);
    }

    public static void showMenu() {

        System.out.println("Please select an option");
        System.out.println();
        System.out.println("A.Create Bank Account");
        System.out.println("B.Check Balance");
        System.out.println("C.Deposit");
        System.out.println("D.Withdraw");
        System.out.println("E.See last transaction");
    }
}
