package lesson2.poly;

public class TransportApp {
    public static void main(String[] args) {
        Transport[] transports = new Transport[]{new Cater(), new Ship(), new Bus()}; //is a
        for (Transport transport : transports) {
            transport.load();

            if (transport instanceof Swimmable) {
                System.out.println("Эта штука плавает");
                Swimmable swimmable = (Swimmable)transport;
                swimmable.swim();
            }
            if (transport instanceof Bus) {
                Bus bus = (Bus) transport;
                System.out.println("Маршрут " + bus.getMarshroute());
            }
         }
    }
}
