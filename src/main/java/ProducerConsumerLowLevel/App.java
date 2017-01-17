package ProducerConsumerLowLevel;

/**
 * Created by Nagendra on 17-01-2017.
 */
public class App {

    private static ProducerConsumer producerConsumer = new ProducerConsumer();

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producerConsumer.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producerConsumer.consume();
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
}
