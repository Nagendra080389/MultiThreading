package interviewQuestions;

import java.util.concurrent.Semaphore;

/**
 * Created by Nagendra on 20-01-2017.
 */
public class ThreadTest implements Runnable {

    static Semaphore semaphore = new Semaphore(0);
    public static void main(String[] args) throws InterruptedException {
        semaphore.acquire();
        System.out.println(semaphore);
    }

    private static void testWait() {

    }

    @Override
    public void run() {

    }
}
