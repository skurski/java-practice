package com.skurski.test;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {

        Random random = new Random();
        String[] names = {"Janek", "Piotr", "Stefan", "Ola", "Aga"};

        List<Person> persons = Arrays.stream(names)
                .map(name -> new Person(random.nextInt(100), name))
                .collect(Collectors.toList());

        persons.forEach(System.out::println);

        System.out.println("--------------------------");
        Comparator<Person> byAge = Comparator.comparing(Person::getAge).thenComparing(Person::getName);
        Collections.sort(persons, byAge);

        persons.forEach(System.out::println);


        System.out.println("--------------------------");
        Collections.sort(persons);
        persons.forEach(System.out::println);

        ExecutorService service = Executors.newFixedThreadPool(5);
        service.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                System.out.println("but maybe it will");
                return null;
            }
        });
        service.shutdown();
//        service.execute(() -> System.out.println("runnable task"));

        Map<Integer, Integer> testMap = Stream.of(1, 2, 3, 4).collect(Collectors.toMap(num -> num, num -> num));
        testMap.put(2, 22);
        System.out.println(testMap.get(2));

        int[] ar = {10, 20, 20, 10, 10, 30, 50, 10, 20};
        int result = sockMerchant(9, ar);
        System.out.println("Number of socks pairs is: " + result);


        String steps = "UDDDUDUU";
        int valleys = countingValleys(8, steps);
        System.out.println("Number of valleys: " + valleys);

        Object o = new Object();

        List<String> list = new ArrayList<>();
        list.add("somestring");
        list.add(new String("some"));
        list.add(o.toString());

        list.clear();
        list = null;

        System.out.println(o);
    }

    static int sockMerchant(int n, int[] ar) {
        Map<Integer, Integer> socksByColor = new HashMap<>();

        for (Integer sock : ar) {
            Integer value = socksByColor.get(sock);
            if (value == null) {
                socksByColor.put(sock, 1);
            } else {
                socksByColor.put(sock, ++value);
            }
        }

        int result = 0;
        for (Map.Entry<Integer, Integer> entry : socksByColor.entrySet()) {
            if (entry.getValue() < 2) {
                continue;
            }

            result += entry.getValue() / 2;
        }

        return result;
    }

    static int countingValleys(int n, String steps) {
        int valleys = 0;
        final int VALLEY_STARTS = -1;

        boolean isValley = false;
        int seaLevel = 0;

        for (int i = 0; i < steps.length(); i++) {
            if (steps.charAt(i) == 'U') {
                seaLevel++;
            } else {
                seaLevel--;
            }

            if (seaLevel == VALLEY_STARTS) {
                isValley = true;
            }

            if (isValley == true) {
                if (seaLevel == 0) {
                    valleys++;
                    isValley = false;
                }
            }
        }

        return valleys;
    }
}
