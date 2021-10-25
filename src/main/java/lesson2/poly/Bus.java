package lesson2.poly;

public class Bus extends Transport{

    public String getMarshroute() {
        return marshroute;
    }

    String marshroute;

    @Override
    void load() {
        System.out.println("Люди ломятся в автобус");
    }
}
