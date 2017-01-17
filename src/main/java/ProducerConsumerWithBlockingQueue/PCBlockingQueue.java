package ProducerConsumerWithBlockingQueue;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Nagendra on 17-01-2017.
 */
public class PCBlockingQueue {


    private static BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(10);

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }

    private static void produce() throws InterruptedException {
        Random random = new Random();
        while (true) {
            blockingQueue.put(random.nextInt(100));
        }

    }

    private static void consume() throws InterruptedException{
        while (true){

            Thread.sleep(100);
            Random random = new Random();

            while (random.nextInt(10) == 0) {
                Integer value = blockingQueue.take();
                System.out.println("Queue Size is: " + blockingQueue.size() + " the consumed value is " + value);
            }
        }

    }
}
