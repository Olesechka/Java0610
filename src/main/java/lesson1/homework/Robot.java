package lesson1.homework;

public class Robot implements Jumpable, Runnable{
    String name = "robot";

    public String getName() {
        return name;
    }

    public void run() {
        System.out.println("Я робот и я умею бегать, но по беговой дорожке не хочу");
    }

    public void jump() {
        System.out.println("Я робот и не умею прыгать");
    }
}
