package lesson1;

public abstract class User {
    private int id;
    private String name;
    private int age;

    public User() {

    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public User(int id) {
        this(id, "default name");
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getAgeBefore18() {
        if (age >= 18) {
            return 0;
        } else {
            return 18 - age;
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }

    public abstract void doAction();

}
