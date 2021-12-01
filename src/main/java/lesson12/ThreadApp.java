package lesson12;

public class ThreadApp {

    private static class MyRunnable implements Runnable{
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            }catch (InterruptedException e){
                e.printStackTrace();
                throw new RuntimeException();
            }
            System.out.println("Do smth");
        }
    }


    private static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("Do smth");
        }
    }

    public static void main(String[] args) {
        Runnable task = new MyRunnable();
        Thread thread = new Thread(task);
        Thread threadAnother = new Thread(new MyRunnable());
        thread.start();
        Thread thread2 = new MyThread();
        thread2.start();

        Thread thread3 = new Thread(() -> System.out.println("Do smth"));

        try{
            thread3.join(3000); //дождались
        }catch (InterruptedException e){
            e.printStackTrace(); //не смогли
        }
    }
}
