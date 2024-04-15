package org.lilmoon;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = Lists.newArrayList(5,6,5,2,1,7);
        Set<String> strings1 = Sets.newHashSet("incentive",
                "stubborn",
                "reach",
                "opinion",
                "extend");
        Set<String> strings2 = Sets.newHashSet("familiar",
                "technique",
                "strip",
                "hypothesize",
                "teenager",
                "extend");
//        String str1 = "Hello my dear!";
//        ImmutableList<Character> characters = Lists.charactersOf(str1);
//        System.out.println(characters);
//         System.out.println(Lists.partition(list,2));;

        System.out.println(Sets.union(strings1,strings2));
        System.out.println(Sets.intersection(strings1,strings2));
        System.out.println(Sets.symmetricDifference(strings1,strings2));
    }
}