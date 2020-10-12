package com.skurski.algo.recursion;

import java.util.HashMap;
import java.util.Map;

public class Numbers {

    private static Map<Integer, Integer> fibMap = new HashMap<>();

    private static void from(int x) {
        if (x <= 0) {
            return;
        }

        System.out.println(x);
        from(x-1);
    }

    private static int factorial(int number) {
        System.out.print(number + " * ");
        if (number == 1) {
            return 1;
        }

        return number * factorial(number-1);
    }

    private static int fibonacii(int num) {
        System.out.println("fibonacii executed for: " + num);
        if (fibMap.get(num) != null) {
            System.out.println("Memorized values");
            return fibMap.get(num);
        }

        if (num <= 1) {
            System.out.println("return base case");
            return num;
        }


        System.out.println("Recursive call");
        int result = fibonacii(num-1) ;
        fibMap.put(num-1, result);
        int secondResult = fibonacii(num -2);
        fibMap.put(num-2, secondResult);

        return result + secondResult;
    }

    public static void main(String[] args) {
        from(25);

        System.out.println();
        System.out.println(factorial(5));

        System.out.println("Fibonacii for 8: " + fibonacii(8));
    }
}
