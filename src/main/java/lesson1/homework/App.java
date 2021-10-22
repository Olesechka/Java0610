package lesson1.homework;

public class App {

    public static void main(String[] args) {
        Cat cat = new Cat();
        Robot robot = new Robot();
        Person person = new Person();


        Jumpable[] jumpers = new Jumpable[]{cat, robot, person};
        for (Jumpable jumper : jumpers){
           Wall wall = new Wall(jumper);
        }

        System.out.println();

        Runnable[] runners = new Runnable[]{cat, robot, person};
        for (Runnable runner : runners){
            Treadmill treadmill = new Treadmill(runner);
        }

    }

}
