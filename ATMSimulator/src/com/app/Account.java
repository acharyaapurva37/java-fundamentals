package ATMSimulator.src.com.app;

public class Account {
    private Long accountNumber;
    private Double balance = 0.0;

    public Account(Long acctNbr){
        this.accountNumber = acctNbr;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(Double amount){
        this.balance= balance+amount;
        System.out.println("Amount "+amount+" credited to account successfully.");
    }

    public void withdraw(Double amount){
        if(amount>this.balance){
            System.out.println("Cannot withdraw an amount greater than balance.");
        }else {
            this.balance = balance - amount;
            System.out.println("Amount " + amount + " debited from account successfully.");
        }
    }

}
