package ProducerConsumerLowLevel;

import java.util.Scanner;

/**
 * Created by Nagendra on 17-01-2017.
 */
public class ProducerConsumer {

    public void produce() throws InterruptedException{
        synchronized (this){
            System.out.println("Producer thread running....");
            wait();
            System.out.println("Producer thread resumed");
        }
    }

    public void consume() throws InterruptedException{
        Thread.sleep(2000);
        Scanner scanner = new Scanner(System.in);
        synchronized (this){
            System.out.println("Waiting for the return key to be pressed....");
            scanner.nextLine();
            System.out.println("Return key pressed");
            notify();
        }

    }

}
