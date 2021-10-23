package lesson3.homework;

import java.util.*;

public class PhoneBook {

    static Map<String, String> lastNameAndTelephone = new HashMap<>();

    public static void main(String[] args) {

        add("89138889913", "Иванов");
        add("89138889913", "Иванов");
        add("89138885504", "Иванов");
        add("89998114476", "Петров");
        add("89996664437", "Сидоров");
        add("89996664441", "Сидоров");
        add("89996664475", "Сидоров");

        get(lastNameAndTelephone, "Сидоров");

    }

    public static void get(Map<String, String> map, String lastName) {

//        Set<String> setPhone = map.keySet();
//        for (String k : setPhone) {
//            if (map.get(k).equals(lastName)) {
//                System.out.println(k);
//            }

        for (Map.Entry<String, String> entry : map.entrySet())
            if (entry.getValue().equals(lastName)) {
                System.out.println(entry.getKey());
            }

    }

    public static Map<String, String> add(String phone, String lastName) {
        lastNameAndTelephone.put(phone, lastName);
        return lastNameAndTelephone;
    }
}
