package ATMSimulator.src.com.app;

public class ATM {

    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    public boolean validatePin(int pin) {
        return pin == user.getAtmPin();
    }

    public void showMenu() {
        System.out.println("Choose an action:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
    }

    public void checkBalance() {
        System.out.println("Current balance: " + user.getAccount().getBalance());
    }

    public void depositAmount(double amount) {
        user.getAccount().deposit(amount);
    }

    public void withdrawAmount(double amount) {
        user.getAccount().withdraw(amount);
    }
}
