package lesson12;

public class InterrupApp {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
//            boolean isInterrupted = false;

            for (int i =0; i<5; i++){
                if (Thread.currentThread().isInterrupted() ){
                    break;
                }
                System.out.println(i+1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    //isInterrupted = true;
                    Thread.currentThread().interrupt(); //concurrency in practice
                }
            }
        });

        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
