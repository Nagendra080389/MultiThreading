package ProducerConsumerExample;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Nagendra on 17-01-2017.
 */
public class Processor {

    private LinkedList<Integer> list = new LinkedList<>();
    private final int LIMIT = 10;
    private Object lock = new Object();

    public void produce() throws InterruptedException{
        int value = 0;
        while (true) {
            synchronized (lock) {

                while (list.size() == LIMIT){
                    lock.wait();
                }

                list.add(value++);
            }
        }
    }

    public void consume() throws InterruptedException{

        Random random = new Random();

        while (true) {
            synchronized (lock) {
                while (list.size() == 0){
                    lock.wait();
                }
                lock.notify();

                System.out.print("List Size is: " + list.size());
                Integer integer = list.removeFirst();
                System.out.println("; value is : " + integer);
                lock.notify();
            }
            Thread.sleep(random.nextInt(1000));
        }


    }
}
