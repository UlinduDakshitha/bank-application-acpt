import java.util.Scanner;

public class Bank {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] accNumbers = new String[10];
        String[] accNames = new String[10];
        String[] accTypes = new String[10];
        double[] accBalances = new double[10];
        double[] loanAmounts = new double[10];
        String[] loanDescriptions = new String[10];

        int accountCount = 0;
        int choice = 0;

        while (choice != 8) {

            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Apply for Loan");
            System.out.println("6. View Loan Details");
            System.out.println("7. Transfer Funds");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            if (choice == 1) {
                accountCount = createAccount(sc, accNumbers, accNames, accTypes, accBalances, loanAmounts, loanDescriptions, accountCount);
            } else if (choice == 2) {
                depositMoney(sc, accNumbers, accBalances, accountCount);
            } else if (choice == 3) {
                withdrawMoney(sc, accNumbers, accBalances, accountCount);
            } else if (choice == 4) {
                checkBalance(sc, accNumbers, accNames, accTypes, accBalances, accountCount);
            } else if (choice == 5) {
                applyLoan(sc, accNumbers, loanAmounts, loanDescriptions, accountCount);
            } else if (choice == 6) {
                viewLoanDetails(sc, accNumbers, loanAmounts, loanDescriptions, accountCount);
            } else if (choice == 7) {
                transferFunds(sc, accNumbers, accBalances, accountCount);
            } else if (choice == 8) {
                System.out.println("Thank you for using the application!");
            } else {
                System.out.println("Invalid choice!");
            }


        }

    }

    // ================= Methods for Each Feature =================

    public static int createAccount(Scanner sc, String[] accNumbers, String[] accNames, String[] accTypes, double[] accBalances,
                                    double[] loanAmounts, String[] loanDescriptions, int accountCount) {
        System.out.println("Create Account");
        System.out.print("Enter Account Holder Name:");
        sc.next();
        String name = sc.next();

        System.out.print("Enter Account Number: ");
        String accNo = sc.next();

        // Check if account exists
        boolean exists = false;
        for (int i = 0; i < accountCount; i++) {
            if (accNumbers[i].equals(accNo)) {
                exists = true;
                break;
            }
        }

        if (exists) {
            System.out.println("Account number already exists!");
            return accountCount;
        }

        System.out.println("Select Account Type:");
        System.out.println("1. Savings");
        System.out.println("2. Current");
        System.out.println("3. Wanitha Wasana");
        System.out.print("Enter your choice: ");
        int typeChoice = sc.nextInt();

        String type = "Savings";
        if (typeChoice == 2) {
            type = "Current";
        } else if (typeChoice == 3) {
            type = "Wanitha Wasana";
        }

        System.out.print("Enter Initial Deposit: ");
        double balance = sc.nextDouble();

        accNumbers[accountCount] = accNo;
        accNames[accountCount] = name;
        accTypes[accountCount] = type;
        accBalances[accountCount] = balance;
        loanAmounts[accountCount] = 0;
        loanDescriptions[accountCount] = "";

        System.out.println("Account created successfully!");

        return accountCount + 1;
    }

    public static void depositMoney(Scanner sc, String[] accNumbers, double[] accBalances, int accountCount) {
        System.out.println("Deposit Money");
        System.out.print("Enter Account Number: ");
        sc.next();
        String accNo = sc.next();

        int index = findAccount(accNumbers, accNo, accountCount);

        if (index == -1) {
            System.out.println("Account not found!");
            return;
        }

        System.out.print("Enter Deposit Amount: ");
        double amount = sc.nextDouble();

        if (amount > 0) {
            accBalances[index] = accBalances[index] + amount;
            System.out.println("Deposit successful! New balance: " + accBalances[index]);
        } else {
            System.out.println("Invalid amount!");
        }
    }

    public static void withdrawMoney(Scanner sc, String[] accNumbers, double[] accBalances, int accountCount) {
        System.out.println("Withdraw Money");
        System.out.print("Enter Account Number: ");
        sc.next();
        String accNo = sc.next();

        int index = findAccount(accNumbers, accNo, accountCount);

        if (index == -1) {
            System.out.println("Account not found!");
            return;
        }

        System.out.print("Enter Withdraw Amount: ");
        double amount = sc.nextDouble();

        if (amount > 0 && amount <= accBalances[index]) {
            accBalances[index] = accBalances[index] - amount;
            System.out.println("Withdrawal successful! New balance: " + accBalances[index]);
        } else {
            System.out.println("Invalid amount or insufficient funds!");
        }
    }

    public static void checkBalance(Scanner sc, String[] accNumbers, String[] accNames, String[] accTypes,
                                    double[] accBalances, int accountCount) {
        System.out.println("Check Balance");
        System.out.print("Enter Account Number: ");
        sc.next();
        String accNo = sc.next();

        int index = findAccount(accNumbers, accNo, accountCount);

        if (index == -1) {
            System.out.println("Account not found!");
        } else {
            System.out.println("Account Holder: " + accNames[index]);
            System.out.println("Account Type: " + accTypes[index]);
            System.out.println("Balance: " + accBalances[index]);
        }
    }

    public static void applyLoan(Scanner sc, String[] accNumbers, double[] loanAmounts, String[] loanDescriptions, int accountCount) {
        System.out.println(" Apply for Loan");
        System.out.print("Enter Account Number: ");
        sc.next();
        String accNo = sc.nextLine();

        int index = findAccount(accNumbers, accNo, accountCount);

        if (index == -1) {
            System.out.println("Account not found!");
            return;
        }

        System.out.print("Enter Loan Amount: ");
        double loan = sc.nextDouble();
        sc.next();


        loanAmounts[index] = loan;


        System.out.println("Loan applied successfully!");
    }

    public static void viewLoanDetails(Scanner sc, String[] accNumbers, double[] loanAmounts, String[] loanDescriptions, int accountCount) {
        System.out.println("View Loan Details");
        System.out.print("Enter Account Number: ");
        sc.next();
        String accNo = sc.next();

        int index = findAccount(accNumbers, accNo, accountCount);

        if (index == -1) {
            System.out.println("Account not found!");
        } else {
            System.out.println("Loan Amount: " + loanAmounts[index]);

        }
    }

    public static void transferFunds(Scanner sc, String[] accNumbers, double[] accBalances, int accountCount) {
        System.out.println("Transfer Funds");
        sc.next();
        System.out.print("Enter Sender Account Number: ");
        String fromAcc = sc.next();

        System.out.print("Enter Receiver Account Number: ");
        String toAcc = sc.next();

        int fromIndex = findAccount(accNumbers, fromAcc, accountCount);
        int toIndex = findAccount(accNumbers, toAcc, accountCount);

        if (fromIndex == -1 || toIndex == -1) {
            System.out.println("Invalid account number(s)!");
            return;
        }

        System.out.print("Enter Transfer Amount: ");
        double amount = sc.nextDouble();

        if (amount > 0 && amount <= accBalances[fromIndex]) {
            accBalances[fromIndex] = accBalances[fromIndex] - amount;
            accBalances[toIndex] = accBalances[toIndex] + amount;
            System.out.println("Transfer successful!");
        } else {
            System.out.println("Invalid amount or insufficient funds!");
        }
    }

    // Helper Method
    public static int findAccount(String[] accNumbers, String accNo, int accountCount) {
        for (int i = 0; i < accountCount; i++) {
            if (accNumbers[i].equals(accNo)) {
                return i;
            }
        }
        return -1;
    }
}