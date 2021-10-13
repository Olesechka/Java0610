package lesson1.homework;

public class Person implements Jumpable, Runnable {

    public void run() {
        System.out.println("Я человек и я умею бегать, по беговой дорожке так вообще очень круто");
    }

    public void jump() {
        System.out.println("Я человек и я умею прыгать через стены!");
    }
}
