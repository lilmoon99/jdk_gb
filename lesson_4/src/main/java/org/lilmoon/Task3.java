package org.lilmoon;

import java.util.*;

public class Task3 {
    public static void main(String[] args) {

        Map<String, String> phoneBook = new HashMap<>();
        phoneBook.put("911", "Emergency");
        phoneBook.put("311", "Fire fighters");
        phoneBook.put("89911944602", "Aynur");
        phoneBook.put("222","Police");
        phoneBook.put("444","Gas service");






        Set<String> keySet = phoneBook.keySet();
        String minPhoneNumber = Collections.min(keySet, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() - o2.length() == 0) return o1.compareTo(o2);
                else return o1.length() - o2.length();
            }
        });
//        System.out.println(phoneBook.get(minPhoneNumber));

        Collection<String> values = phoneBook.values();
        System.out.println(values);
        String maxValue = String.valueOf(values.stream().max((o1, o2) -> o1.length() - o2.length()).get());
        for (Map.Entry<String, String> stringStringEntry : phoneBook.entrySet()) {
            if (stringStringEntry.getValue().equals(maxValue)){
                System.out.println(stringStringEntry);
            }
        }
        System.out.println(maxValue);
    }
}
