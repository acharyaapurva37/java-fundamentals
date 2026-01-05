package ATMSimulator.src.com.app;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean shouldContinue = true;

        System.out.println("ATM Application Started");

        Account account1 = new Account(123456789L);
        User user1 = new User("Apurva", 3456, account1);

        ATM atm = new ATM();
        atm.setUser(user1);

        System.out.print("Enter PIN: ");
        int pin = sc.nextInt();

        if (!atm.validatePin(pin)) {
            System.out.println("Incorrect PIN. Exiting.");
            sc.close();
            return;
        }

        while (shouldContinue) {
            atm.showMenu();
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmt = sc.nextDouble();
                    atm.depositAmount(depositAmt);
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmt = sc.nextDouble();
                    atm.withdrawAmount(withdrawAmt);
                    break;

                case 4:
                    shouldContinue = false;
                    System.out.println("Thank you for using ATM.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
