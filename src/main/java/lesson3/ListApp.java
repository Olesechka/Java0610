package lesson3;

import java.util.ArrayList;
import java.util.List;

public class ListApp {

    public static void main(String[] args) {
        int[] array = new int[10];
        //массив с элементами меньше 5
        List<Integer> list = new ArrayList<>();
        for (int x : array) {
            if (x < 5) {
                list.add(x);
            }
        }
    }
}
