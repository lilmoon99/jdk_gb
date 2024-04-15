package org.lilmoon;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.util.ArithmeticUtils;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        ArrayList<Integer> integers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));

        DescriptiveStatistics statistics = new DescriptiveStatistics();
        for (Integer integer : integers) {
            statistics.addValue((double) integer);
        }

        System.out.println("Min: " + statistics.getMin());
        System.out.println("Max: " + statistics.getMax());
        System.out.println("Sum: " + statistics.getSum());
        System.out.println("Arithmetic mean: " + statistics.getMean());


        System.out.println(ArithmeticUtils.factorial(5));
        System.out.println(ArithmeticUtils.gcd(68,40));
        System.out.println(ArithmeticUtils.isPowerOfTwo(33));
    }
}