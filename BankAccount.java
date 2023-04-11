import java.util.Random;
import java.util.ArrayList;

public class BankAccount {
    private double checkingBalance;
    private double savingBalance;
    private double totalBalance;
    private String accountNumber;
    public static int numberOfAccounts = 0;
    public static ArrayList<String> allAccountNumbers = new ArrayList<String>();
    public static double totalBalanceAllAccounts = 0;

    public BankAccount(double checkingBalanceParam, double savingBalanceParam){
        this.checkingBalance = checkingBalanceParam;
        this.savingBalance = savingBalanceParam;
        this.accountNumber = setAccountNumber();
        this.totalBalance = this.checkingBalance + this.savingBalance;
        System.out.println("\n----------New Account----------");
        System.out.println("\nYour account number is: " + this.accountNumber);
        totalBalanceAllAccounts += this.checkingBalance + this.savingBalance;
        numberOfAccounts++;
    }

    // Getters & Setters

    public double getCheckingBalance(){
        return this.checkingBalance;
    }

    public double getSavingBalance(){
        return this.savingBalance;
    }

    public String getAccountNumber(){
        return this.accountNumber;
    }

    private String setAccountNumber(){
        Random rand = new Random();
        String accountNumber = "";
        for(int i = 0; i < 10; i++){
            accountNumber += rand.nextInt(10);
        }
        if(allAccountNumbers.contains(accountNumber)){
            return setAccountNumber();
        }else{
            return accountNumber;
        }
    }

    // Methods

    public void deposit(double depositAmount){
        System.out.println("\n----------Deposit----------");
        System.out.println("\nPlease enter which account you want to deposit to (checking/saving):");
        String account = System.console().readLine();
        if(account.equals("checking") || account.equals("Checking")){
            this.checkingBalance += depositAmount;
            System.out.println("\nDeposit successful.");
            System.out.println("Your new checking balance is: $" + this.checkingBalance);
        }else if(account.equals("saving") || account.equals("Saving")){
            this.savingBalance += depositAmount;
            System.out.println("\nDeposit successful.");
            System.out.println("Your new saving balance is: $" + this.savingBalance);
        }else{
            System.out.println("Invalid account type, please try again.");
            this.deposit(depositAmount);
        } 
    }

    public void withdrawChecking(double withdrawAmount){
        System.out.println("\n----------Withdraw Checking----------");
        if(withdrawAmount <= this.checkingBalance){
            this.checkingBalance -= withdrawAmount;
            System.out.println("\nWithdraw successful.");
            System.out.println("Your new checking balance is: $" + this.checkingBalance);
        }else{
            System.out.println("\nInsufficient funds, please try again.");
        }
    }

    public void withdrawSaving(double withdrawAmount){
        System.out.println("\n----------Withdraw Saving----------");
        if(withdrawAmount <= this.savingBalance){
            this.savingBalance -= withdrawAmount;
            System.out.println("\nWithdraw successful.");
            System.out.println("Your new saving balance is: $" + this.savingBalance);
        }else{
            System.out.println("\nInsufficient funds, please try again.");
        }
    }

    public void displayTotal(){
        System.out.println("\n----------Display Total----------");
        System.out.println("\nTotal balance in account: $" + this.totalBalance);
        System.out.println("\nTotal in checking: $" + this.checkingBalance);
        System.out.println("\nTotal in saving: $" + this.savingBalance);
        System.out.println("\nTotal balance in all accounts: $" + totalBalanceAllAccounts);
    }

    public static void displayTotalAccounts(){
        System.out.println("\n----------Display Total Accounts----------");
        System.out.println("\nTotal number of accounts: " + numberOfAccounts);
    }
}