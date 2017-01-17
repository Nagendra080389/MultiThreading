package DeadlockSynchronisation;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Nagendra on 17-01-2017.
 */
public class Runner {

    private Account account1 = new Account();
    private Account account2 = new Account();

    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    private void acquireLocks(Lock lock1, Lock lock2) {
        while (true) {
            boolean gotFirstLock = false;
            boolean gotSecondLock = false;

            try {
                gotFirstLock = lock1.tryLock();
                gotSecondLock = lock2.tryLock();
            } finally {
                if (gotFirstLock && gotSecondLock) {
                    return;
                }

                if(gotFirstLock){
                    lock1.unlock();
                }
                if(gotSecondLock){
                    lock2.unlock();
                }
            }
        }
    }

    public void firstThread() throws InterruptedException {

        Random random = new Random();

        acquireLocks(lock1, lock2);

        for (int i = 0; i < 10000; i++) {
            Account.transfer(account1, account2, random.nextInt(100));
        }
        lock1.unlock();
        lock2.unlock();
    }

    public void secondThread() throws InterruptedException {
        Random random = new Random();

        acquireLocks(lock2, lock1);

        for (int i = 0; i < 10000; i++) {
            Account.transfer(account2, account1, random.nextInt(100));
        }
        lock1.unlock();
        lock2.unlock();

    }

    public void finished() {

        System.out.println("Account 1 balance: " + account1.getBalance());
        System.out.println("Account 2 balance: " + account2.getBalance());
        System.out.println("Total balance: " + (account1.getBalance() + account2.getBalance()));
    }
}
