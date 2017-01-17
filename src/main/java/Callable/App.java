package Callable;

import java.util.concurrent.*;

/**
 * Created by Nagendra on 17-01-2017.
 */
public class App {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> submit = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {

                return ProcessCallable.getCall();
            }
        });

        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println(submit.get());
    }

}
