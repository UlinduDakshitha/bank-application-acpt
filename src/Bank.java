import java.util.Scanner;
public class Bank {
    public static void main(String[] args) {
Scanner sc=new Scanner(System.in);

int[] accountNumber=new int[10];
double[] accountBalance=new double[10];
String[] accountHolderNames=new String[10];
int[] accountTypes=new int[10];
double[] loanAmounts=new double[10];
String[] loanDescriptions=new String[10];

        int choice = 0;

while(choice!=0 && choice!=8){

    System.out.println("Welcome To the Bank:");
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

}

    }
    public static void createAccount(){
        System.out.print("What type account you want");

    }
}
