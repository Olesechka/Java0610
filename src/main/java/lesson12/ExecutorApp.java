package lesson12;

import java.util.concurrent.*;

public class ExecutorApp {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService executorService = Executors.newScheduledThreadPool(10);
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> System.out.println(Thread.currentThread().getName()));
        executorService.execute(() -> System.out.println(Thread.currentThread().getName()));
        executorService.execute(() -> System.out.println(Thread.currentThread().getName()));

        Future<?> future = executorService.submit(()-> System.out.println("smth"));

        Future<String> stringFuture = executorService.submit(new MyCallable());

        System.out.println(stringFuture.get());

        executorService.shutdown();
        //если не вызвать shutdown() приложение никогда не завершится, потому что потоки будут продолжать ждать задачи

//        executorService.shutdownNow();


    }

    private static class MyCallable implements Callable<String> {

        @Override
        public String call() throws Exception {
            return "string from callable";
        }
    }
}
