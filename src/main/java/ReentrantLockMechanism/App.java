package ReentrantLockMechanism;

/**
 * Created by Nagendra on 17-01-2017.
 */
public class App {

    private static Runner runner = new Runner();

    public static void main(String[] args) throws InterruptedException {
        Thread t1= new Thread(new Runnable() {
            @Override
            public void run() {
                runner.firstThread();
            }
        });


        Thread t2= new Thread(new Runnable() {
            @Override
            public void run() {
                runner.secondThread();
            }
        });


        t1.start();
        t2.start();

        t1.join();
        t2.join();

        runner.finished();
    }

}
