package lesson14;

public class Calculator {

    public int sum(int a, int b) {
        return a + b;
    }

    public int multiply(int a, int b) throws InterruptedException {
        Thread.sleep(2000);
        return a * b;
    }

    public int division(int a, int b) {
        return a / b;
    }
}
