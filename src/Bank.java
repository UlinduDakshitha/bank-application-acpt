import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] accNumbers = new String[100];
        String[] accNames = new String[100];
        String[] accTypes = new String[100];
        double[] accBalances = new double[100];
        double[] loanAmounts = new double[100];
        String[] loanDescriptions = new String[100];

        int accountCount = 0;
        int choice = 0;

        while (choice != 8) {
            System.out.println("===================================");
            System.out.println("   Console-Based Banking System");
            System.out.println("===================================");
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
                System.out.println("==== Create Account ====");
                System.out.print("Enter Account Holder Name: ");
                sc.nextLine(); // consume newline
                String name = sc.nextLine();

                System.out.print("Enter Account Number: ");
                String accNo = sc.nextLine();

                // check if account number already exists
                boolean exists = false;
                for (int i = 0; i < accountCount; i++) {
                    if (accNumbers[i].equals(accNo)) {
                        exists = true;
                        break;
                    }
                }

                if (exists) {
                    System.out.println("Account number already exists!");
                } else {
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
                    accountCount++;

                    System.out.println("Account created successfully!");
                }
            }

            else if (choice == 2) {
                System.out.println("==== Deposit Money ====");
                System.out.print("Enter Account Number: ");
                sc.nextLine();
                String accNo = sc.nextLine();

                int index = -1;
                for (int i = 0; i < accountCount; i++) {
                    if (accNumbers[i].equals(accNo)) {
                        index = i;
                        break;
                    }
                }

                if (index == -1) {
                    System.out.println("Account not found!");
                } else {
                    System.out.print("Enter Deposit Amount: ");
                    double amount = sc.nextDouble();
                    if (amount > 0) {
                        accBalances[index] = accBalances[index] + amount;
                        System.out.println("Deposit successful! New balance: " + accBalances[index]);
                    } else {
                        System.out.println("Invalid amount!");
                    }
                }
            }

            else if (choice == 3) {
                System.out.println("==== Withdraw Money ====");
                System.out.print("Enter Account Number: ");
                sc.nextLine();
                String accNo = sc.nextLine();

                int index = -1;
                for (int i = 0; i < accountCount; i++) {
                    if (accNumbers[i].equals(accNo)) {
                        index = i;
                        break;
                    }
                }

                if (index == -1) {
                    System.out.println("Account not found!");
                } else {
                    System.out.print("Enter Withdraw Amount: ");
                    double amount = sc.nextDouble();
                    if (amount > 0 && amount <= accBalances[index]) {
                        accBalances[index] = accBalances[index] - amount;
                        System.out.println("Withdrawal successful! New balance: " + accBalances[index]);
                    } else {
                        System.out.println("Invalid amount or insufficient funds!");
                    }
                }
            }

            else if (choice == 4) {
                System.out.println("==== Check Balance ====");
                System.out.print("Enter Account Number: ");
                sc.nextLine();
                String accNo = sc.nextLine();

                int index = -1;
                for (int i = 0; i < accountCount; i++) {
                    if (accNumbers[i].equals(accNo)) {
                        index = i;
                        break;
                    }
                }

                if (index == -1) {
                    System.out.println("Account not found!");
                } else {
                    System.out.println("Account Holder: " + accNames[index]);
                    System.out.println("Account Type: " + accTypes[index]);
                    System.out.println("Balance: " + accBalances[index]);
                }
            }

            else if (choice == 5) {
                System.out.println("==== Apply for Loan ====");
                System.out.print("Enter Account Number: ");
                sc.nextLine();
                String accNo = sc.nextLine();

                int index = -1;
                for (int i = 0; i < accountCount; i++) {
                    if (accNumbers[i].equals(accNo)) {
                        index = i;
                        break;
                    }
                }

                if (index == -1) {
                    System.out.println("Account not found!");
                } else {
                    System.out.print("Enter Loan Amount: ");
                    double loan = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter Loan Description: ");
                    String desc = sc.nextLine();

                    loanAmounts[index] = loan;
                    loanDescriptions[index] = desc;

                    System.out.println("Loan applied successfully!");
                }
            }

            else if (choice == 6) {
                System.out.println("==== View Loan Details ====");
                System.out.print("Enter Account Number: ");
                sc.nextLine();
                String accNo = sc.nextLine();

                int index = -1;
                for (int i = 0; i < accountCount; i++) {
                    if (accNumbers[i].equals(accNo)) {
                        index = i;
                        break;
                    }
                }

                if (index == -1) {
                    System.out.println("Account not found!");
                } else {
                    System.out.println("Loan Amount: " + loanAmounts[index]);
                    System.out.println("Loan Description: " + loanDescriptions[index]);
                }
            }

            else if (choice == 7) {
                System.out.println("==== Transfer Funds ====");
                sc.nextLine();
                System.out.print("Enter Sender Account Number: ");
                String fromAcc = sc.nextLine();

                System.out.print("Enter Receiver Account Number: ");
                String toAcc = sc.nextLine();

                int fromIndex = -1;
                int toIndex = -1;

                for (int i = 0; i < accountCount; i++) {
                    if (accNumbers[i].equals(fromAcc)) {
                        fromIndex = i;
                    }
                    if (accNumbers[i].equals(toAcc)) {
                        toIndex = i;
                    }
                }

                if (fromIndex == -1 || toIndex == -1) {
                    System.out.println("Invalid account number(s)!");
                } else {
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
            }

            else if (choice == 8) {
                System.out.println("Exiting program. Thank you!");
            }

            else {
                System.out.println("Invalid choice!");
            }
            System.out.println();
        }
    }
}