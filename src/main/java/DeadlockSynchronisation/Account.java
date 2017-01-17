package DeadlockSynchronisation;

/**
 * Created by Nagendra on 17-01-2017.
 */
public class Account {

    private int balance = 10000;

    public void deposit(int amount){
        balance += amount;
    }

    public void withdrawl(int amount){
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }

    public static void transfer (Account acc1, Account acc2, int amount){
        acc1.withdrawl(amount);
        acc2.deposit(amount);
    }
}
