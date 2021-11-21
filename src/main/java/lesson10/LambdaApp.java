package lesson10;

import java.util.concurrent.atomic.AtomicInteger;

public class LambdaApp {

    public static void main(String[] args) {
        int i = 11;
        AtomicInteger ai = new AtomicInteger(0);
        ai.incrementAndGet();

        new Thread(() -> System.out.println(ai)).start();

    }
}
