public class Test {

    public static void main(String[] args){

        // Create BankAccount objects
        BankAccount account1 = new BankAccount(1000, 500);
        BankAccount account2 = new BankAccount(2000, 1000);
        BankAccount account3 = new BankAccount(3000, 1500);

        // Display Total Accounts
        BankAccount.displayTotalAccounts();

        // Deposit
        account1.deposit(200);
        account2.deposit(200);
        account3.deposit(300);

        // Withdraw
        account1.withdrawChecking(100);
        account1.withdrawSaving(100);

        account2.withdrawChecking(3000);
        account2.withdrawSaving(200);

        account3.withdrawChecking(300);
        account3.withdrawSaving(2000);

        // Display total balance in all accounts
        account1.displayTotal();
        account2.displayTotal();
        account3.displayTotal();

    }
    
}
