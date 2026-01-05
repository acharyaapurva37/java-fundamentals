package ATMSimulator.src.com.app;

public class User {
    private String userName;
    private int atmPin;
    private Account account;

    public User(String name, int pin, Account account){
        this.userName= name;
        this.atmPin = pin;
        this.account = account;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAtmPin() {
        return atmPin;
    }
    public Account getAccount(){
        return  account;
    }

}
