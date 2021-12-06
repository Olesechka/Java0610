package lesson13;

public class VolatileApp {

    private static volatile boolean isRunning = true;

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            while (isRunning) {
                System.out.println("Still allive");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

        Thread.sleep(2000);
        isRunning = false;
        System.out.println("Stop");

    }
}
