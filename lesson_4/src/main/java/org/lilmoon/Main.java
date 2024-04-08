package org.lilmoon;

/*
1. Создайте коллекцию мужских и женских имен с помощью интерфейса List
2. Отсортируйте коллекцию в алфавитном порядке
3. Отсортируйте коллекцию по количеству букв в слове
4. Разверните коллекцию
 */

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(initNames());
        System.out.println("Our List");
        System.out.println(names);
//        System.out.println("Sorted list");
//        Collections.sort(names);
//        System.out.println(names);

//        names.sort((String::compareTo));
//        System.out.println(names);

//        Collections.sort(names,(o1, o2) -> o2.length() - o1.length());
//        System.out.println(names);

//        Collections.reverse(names);
//        System.out.println(names);

//        reverseList(names);

        Set<String> stringSet = new HashSet<>(names);
//        for (String s : stringSet) {
//            System.out.print(s + " ");
//        }
//
//        System.out.println(stringSet.stream().min(String::compareTo).get());


        System.out.println(Collections.max(stringSet,(o1, o2) -> o2.length() - o1.length()));
        stringSet.removeIf(s -> s.contains("A"));
        stringSet.removeIf(s -> s.contains("a"));
        System.out.println(stringSet);

    }

    private static void reverseList(List<String> list) {
        System.out.println("Reverse list");
        ArrayList<String> temp = new ArrayList<>(list.size());
        for (int i = list.size() - 1; i >=0; i--) {
            temp.add(list.get(i));
        }
        System.out.println(temp);
    }

    private static List<String> initNames(){
        return Arrays.asList("Ivan","Maria","Aynur","Elisa","Mark","Elon","Aynur","Elisa");
    }
}