package lesson4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class IterableApp {
    public static void main(String[] args) {
        List<String> list = List.of("one", "two", "three");

        list = new ArrayList<>(list);
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            System.out.println(str);
        }

        System.out.println();

        //remove if <4
        iterator = list.iterator();
        while (iterator.hasNext()){
            String str = iterator.next();
            if (str.length() < 4){
                iterator.remove();
            }
        }

        list.add("aa");

        list.removeIf(x -> x.length() < 4);

        list.stream()
                .filter(x -> x.length() > 4)
                .map(x -> x.length())
                .forEach(x -> System.out.println(x));

        System.out.println(list);

        String s = "asc";
        s = s.toUpperCase();
        System.out.println(s);

    }
}
