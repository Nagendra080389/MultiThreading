package interviewQuestions;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;

/**
 * Created by Nagendra on 20-01-2017.
 */
public class DeadLock {
    static int value = 0;
    static final Object lock1 = new Object();
    static final Object lock2 = new Object();
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (lock1) {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        synchronized (lock2) {
                            System.out.println("Thread 1");
                        }
                    }
                }

            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {
                    synchronized (lock2) {
                        synchronized (lock1) {
                            System.out.println("Thread 2");
                        }
                    }
                }
            }
        });

        t1.start();
        t2.start();

        long[] deadlockedThreads = ManagementFactory.getThreadMXBean().findDeadlockedThreads();
        ThreadInfo[] threadInfo = ManagementFactory.getThreadMXBean().getThreadInfo(deadlockedThreads);
        for (ThreadInfo info : threadInfo) {
            System.out.println("DeadLocks :" + info.getThreadName() + " lock Name "+info.getLockName());
        }


    }


}
