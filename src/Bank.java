import java.util.Scanner;
public class Bank {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] accNumbers = new String[10];
        String[] accNames = new String[10];
        String[] accTypes = new String[10];
        double[] accBalances = new double[10];
        double[] loanAmounts = new double[10];

        int accountCount = 0;
        int choice = 0;

        while (choice != 8) {

            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Apply Loan");
            System.out.println("6. View Loan Details");
            System.out.println("7. Transfer Money");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            if (choice == 1) {
                accountCount = createAccount(sc, accNumbers, accNames, accTypes, accBalances, loanAmounts, accountCount);
            } else if (choice == 2) {
                depositMoney(sc, accNumbers, accBalances, accountCount);
            } else if (choice == 3) {
                withdrawMoney(sc, accNumbers, accBalances, accountCount);
            } else if (choice == 4) {
                checkBalance(sc, accNumbers, accNames, accTypes, accBalances, accountCount);
            } else if (choice == 5) {
                applyLoan(sc, accNumbers, loanAmounts, accountCount);
            } else if (choice == 6) {
                viewLoan(sc, accNumbers, loanAmounts, accountCount);
            } else if (choice == 7) {
                transferMoney(sc, accNumbers, accBalances, accountCount);
            } else if (choice == 8) {
                System.out.println("Thank you!...");
            } else {
                System.out.println("can't find");
            }
        }
    }


    public static int createAccount(Scanner sc, String[] accNumbers, String[] accNames,
                                    String[] accTypes, double[] accBalances, double[] loanAmounts, int count) {

        System.out.println("Create Account");
        System.out.print("Enter Account Number: ");
        String accNo = sc.next();

        for (int i = 0; i < count; i++) {
            if (accNumbers[i].equals(accNo)) {
                System.out.println("Account already exists!");
                return count;
            }
        }

        System.out.print("Enter Name:");
        String name = sc.next();

        System.out.println("Select Type: 1.Savings  2.Current");
        int t = sc.nextInt();
        String type;

        if (t == 1) {
            type = "Savings";
        } else if (t == 2) {
            type = "Current";
        } else {
            type = "Savings";
        }

        System.out.print("Enter First Deposit: ");
        double balance = sc.nextDouble();

        accNumbers[count] = accNo;
        accNames[count] = name;
        accTypes[count] = type;
        accBalances[count] = balance;
        loanAmounts[count] = 0;

        System.out.println("Account create sucsessful!!");
        return count + 1;
    }

    public static void depositMoney(Scanner sc, String[] accNumbers, double[] accBalances, int count) {
        System.out.println("Deposit Money");
        System.out.print("Enter Account Number: ");
        String accNo = sc.next();

        int index = findAccount(accNumbers, accNo, count);
        if (index == -1) {
            System.out.println("Account not found");
            return;
        }

        System.out.print("Enter Amount:");
        double amount = sc.nextDouble();
        accBalances[index] += amount;

        System.out.println(" New Balance: " + accBalances[index]);
    }

    public static void withdrawMoney(Scanner sc, String[] accNumbers, double[] accBalances, int count) {
        System.out.println("Withdraw Money");
        System.out.print("Enter Account Number: ");
        String accNo = sc.next();

        int index = findAccount(accNumbers, accNo, count);
        if (index == -1) {
            System.out.println("Account not found!");
            return;
        }

        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();

        if (amount <= accBalances[index]) {
            accBalances[index] -= amount;
            System.out.println("New Balance:" + accBalances[index]);
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    public static void checkBalance(Scanner sc, String[] accNumbers, String[] accNames, String[] accTypes,
                                    double[] accBalances, int count) {
        System.out.println("Check Balance");
        System.out.print("Enter Account Number: ");
        String accNo = sc.next();

        int index = findAccount(accNumbers, accNo, count);
        if (index == -1) {
            System.out.println("Account not found!");
        } else {
            System.out.println("Name: " + accNames[index]);
            System.out.println("Type: " + accTypes[index]);
            System.out.println("Balance: " + accBalances[index]);
        }
    }

    public static void applyLoan(Scanner sc, String[] accNumbers, double[] loanAmounts, int count) {
        System.out.println(" Apply Loan ");
        System.out.print("Enter Account Number: ");
        String accNo = sc.next();

        int index = findAccount(accNumbers, accNo, count);
        if (index == -1) {
            System.out.println("Account not found!");
            return;
        }

        System.out.print("Enter Loan Amount: ");
        double loan = sc.nextDouble();
        loanAmounts[index] = loan;

        System.out.println("Loan applied successfully!");
    }

    public static void viewLoan(Scanner sc, String[] accNumbers, double[] loanAmounts, int count) {
        System.out.println(" View Loan");
        System.out.print("Enter Account Number: ");
        String accNo = sc.next();

        int index = findAccount(accNumbers, accNo, count);
        if (index == -1) {
            System.out.println("Account not found!");
        } else {
            System.out.println("Loan Amount: " + loanAmounts[index]);
        }
    }

    public static void transferMoney(Scanner sc, String[] accNumbers, double[] accBalances, int count) {
        System.out.println("Transfer Money");
        System.out.print("Enter Sender Account Number: ");
        String from = sc.next();

        System.out.print("Enter Receiver Account Number: ");
        String to = sc.next();

        int i1 = findAccount(accNumbers, from, count);
        int i2 = findAccount(accNumbers, to, count);

        if (i1 == -1 || i2 == -1) {
            System.out.println("Invalid account(s)!");
            return;
        }

        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();

        if (amount <= accBalances[i1]) {
            accBalances[i1] -= amount;
            accBalances[i2] += amount;
            System.out.println("Transfer successful!");
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public static int findAccount(String[] accNumbers, String accNo, int count) {
        for (int i = 0; i < count; i++) {
            if (accNumbers[i].equals(accNo)) {
                return i;
            }
        }
        return -1;
    }
}
