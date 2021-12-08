package lesson13;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public class CyclicApp {

    private static Random random = new Random();

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

        for (int i = 0; i < 5; i++) {
            int w = i + 1;
            new Thread(() -> {
                try {
                    System.out.println(w + " готовится");
                    Thread.sleep(random.nextInt(5) * 1000);
                    System.out.println(w + " готов");
                    cyclicBarrier.await();

                    System.out.println(w + " поехал");
                    Thread.sleep(random.nextInt(5) * 1000);
                    System.out.println(w + " доехал");
                    cyclicBarrier.await();

                    System.out.println("Гонка закончилась");

                } catch (Exception e) {

                }

            }).start();
        }
    }
}
