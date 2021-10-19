package lesson3.homework;

import java.util.ArrayList;
import java.util.HashSet;

public class App {
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


        long n = list.stream().distinct().count();

        System.out.println(list.size());

        System.out.println(n);


        HashSet<String> uniqueList = new HashSet<>();
        uniqueList.addAll(list);
        System.out.println(uniqueList.size());

    }

}
