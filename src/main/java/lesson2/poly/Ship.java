package lesson2.poly;

public class Ship extends Transport implements Swimmable{
    public int getWaterline() {
        return waterline;
    }

    public void setWaterline(int waterline) {
        this.waterline = waterline;
    }

    int waterline;

    @Override
    void load(){
        System.out.println("Погрузка корабля");
    }

    @Override
    public void swim() {
        System.out.println("Корабль плывет по воде");
    }
}
