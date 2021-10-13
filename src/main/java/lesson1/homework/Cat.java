package lesson1.homework;

public class Cat implements Jumpable, Runnable{

    public void run(){
        System.out.println("Я кошка и я не люблю бегать, особенно по беговым дорожкам!");
    }

    public void jump(){
        System.out.println("Я кошка и я умею прыгать через стены");
    }

}
