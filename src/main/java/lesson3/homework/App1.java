package lesson3.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class App1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>
                (Arrays.asList("мама", "мама", "мыла", "мыла", "раму",
                        "и еще одну раму", "и еще одну раму", "сковородку",
                        "кастрюлю", "тазик", "тазик", "тазик", "тазик"));

        //первый вариант подсчитать количество уникальных элементов
        long n = list.stream().distinct().count();

        System.out.println(list.size()); // - всего элементов в списке

        System.out.println(n); // - уникальных элементов

        //второй вариант подсчитать количество уникальных элементов
        HashSet<String> uniqueList = new HashSet<>();
        uniqueList.addAll(list);
        System.out.println(uniqueList.size()); // - уникальных элементов

        System.out.println();

        //подсчитаем сколько раз встречается каждое слово
        countWords(list);

    }

    public static void countWords(ArrayList<String> arr) {
        int count;
        HashSet<String> uniqueList = new HashSet<>();
        uniqueList.addAll(arr);
        Collections.addAll(arr);

        for (String i : uniqueList) {
            count = Collections.frequency(arr, i);
            System.out.println("\"" + i + "\" встречается в списке " + count + " раз(а).");

        }
    }

}
