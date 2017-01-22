package interviewQuestions;

import com.sun.corba.se.impl.orbutil.concurrent.Mutex;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

/**
 * Created by Nagendra on 20-01-2017.
 */
public class semaphoreTest {

    static LinkedList<Integer> integerLinkedList = new LinkedList<>();
    static Semaphore semaphore = new Semaphore(1);
    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    procude();
                } catch (InterruptedException e) {
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consume();
                } catch (InterruptedException e) {
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }


    private static void procude() throws InterruptedException {
        semaphore.acquire();
        int value = 0;
        while (true) {
            while (integerLinkedList.size() == 10) {
                semaphore.release();
            }
            integerLinkedList.add(value++);
        }

    }

    private static void consume() throws InterruptedException {
        semaphore.acquire();
        while (true) {
            while (integerLinkedList.size() == 0) {
                semaphore.release();
            }
            Integer value = integerLinkedList.removeFirst();
            System.out.println("Size of the List is " + integerLinkedList.size() + " and value removed is " + value);
            semaphore.release();

            Thread.sleep(100);
        }
    }


}
