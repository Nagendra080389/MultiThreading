package ReentrantLockMechanism;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Nagendra on 17-01-2017.
 */
public class Runner {

    private int count = 0;

    private Lock lock = new ReentrantLock();

    private void incrementCount(){
        for (int i=0; i < 10000 ; i++){
            count++;
        }
    }

    public void firstThread(){
        lock.lock();
        try {
            incrementCount();
        }
        finally {
            lock.unlock();
        }

    }

    public void secondThread(){
        lock.lock();
        try {
            incrementCount();
        }
        finally {
            lock.unlock();
        }
    }

    public void finished(){
        System.out.println("Count is : " + count);
    }
}
