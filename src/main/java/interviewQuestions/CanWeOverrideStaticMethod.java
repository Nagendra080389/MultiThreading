package interviewQuestions;

import com.sun.istack.internal.NotNull;

import java.util.TreeMap;

public class CanWeOverrideStaticMethod {

    public static void main(String[] args) throws InterruptedException {
        Thread t1= new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Work Done");
            }
        });

        t1.start();

        t1.join();
        t1.sleep(1000);
        t1.yield();

       // t1.start();
    }
}