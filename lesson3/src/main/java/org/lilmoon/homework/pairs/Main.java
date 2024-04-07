package org.lilmoon.homework.pairs;

public class Main {
    public static void main(String[] args) {
        Pair<String,Integer> pair = new Pair<>("KEY",1);
        Pair<Object,Exception> strangePair = new Pair<>(new Object(),new NullPointerException());
        Pair<String,String> stringStringPair = new Pair<>("HE HE HE","HO HO HO");
        System.out.println(pair);
        System.out.println(strangePair);
        System.out.println(stringStringPair);
    }
}
