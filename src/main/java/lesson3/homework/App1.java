package lesson3.homework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class App1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("asss");
        list.add("asss");
        list.add("daa");
        list.add("dddd");
        list.add("sss");
        list.add("ss");
        list.add("sss");
        list.add("ggggg");
        list.add("gdgdg");
        list.add("dgdgd");
        list.add("ff");
        list.add("ff");

        //первый вариант подсчитать количество уникальных элементов
        long n = list.stream().distinct().count();

        System.out.println(list.size()); //всего элементов

        System.out.println(n); //уникальных элементов

        //второй вариант подсчитать количество уникальных элементов
        HashSet<String> uniqueList = new HashSet<>();
        uniqueList.addAll(list);
        System.out.println(uniqueList.size()); //уникальных элементов

        System.out.println();

        //подсчитаем сколько раз встречается каждое слово
        int count;
        Collections.addAll(list);

        for (String i: uniqueList) {
            count = Collections.frequency(list, i);
            System.out.println(i + " встречается в списке " + count + " раз(а).");

        }
    }

}
