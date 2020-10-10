package com.skurski.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamBasics {

    private static final String[] NAMES = new String[]{
            "Jarek", "Pawel", "Aga", "Piotrek", "Zoska", "Adam",
            "Monika", "Juduty", "Kaska", "Ola", "Marcin", "Sebastian",
            "Weronika", "Jan", "Halina", "Jozef", "Krzysztof", "Aureliusz",
            "Alex", "Nikita"
    };

    public static String stringGenerator() {
        Random random = new Random();
        return NAMES[random.nextInt(NAMES.length - 1)];
    }

    public static void main(String[] args) throws IOException {
        Stream<String> strs = Stream.of("one", "two");
        List<String> namesList = Arrays.asList(NAMES);
        strs = namesList.stream();
        Stream<String> intStream = Arrays.stream(NAMES);

        intStream.forEach(i -> System.out.println(i));

        Stream<Integer> ints = Stream.iterate(0, n -> n + 2).limit(100);
        ints.forEach(e -> System.out.print(e + " "));

        Stream<String> streamStrs = Stream.generate(StreamBasics::stringGenerator).limit(10);
        streamStrs.forEach(e -> System.out.println(e));

        IntStream.range(1, 10).filter(n -> n % 2 == 1).forEach(System.out::print);
        System.out.println();

        strs.filter(s -> s.startsWith("J"))
                .map(String::toLowerCase)
                .sorted()
                .findFirst()
                .ifPresentOrElse(System.out::println, () -> System.out.println("no J"));

        try {
            Files.list(Paths.get("."))
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Stream<String> text = Files.lines(Paths.get("text.txt"));
            text.sorted()
                    .filter(s -> s.length() < 3)
                    .forEach(System.out::println);
            text.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            List<String> words = Files.lines(Paths.get("text.txt"))
                    .sorted()
                    .map(String::toUpperCase)
                    .collect(Collectors.toList());
            words.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }


        Stream<String> dataStream = Files.lines(Paths.get("employees.txt"));
        Map<String, Integer> map = new HashMap<>();

        dataStream.map(line -> line.split(","))
                .filter(line -> line.length == 4)
                .filter(line -> Integer.parseInt(line[3]) < 5000)
                .sorted((prev, next) -> {
                    if (Integer.parseInt(prev[3]) < Integer.parseInt(next[3])) {
                        return -1;
                    } else if (Integer.parseInt(prev[3]) > Integer.parseInt(next[3])) {
                        return 1;
                    } else {
                        return 0;
                    }
                })
                .forEach(e -> System.out.println(e[0] + " " + e[1] + " " + e[2] + " " + e[3]));
        dataStream.close();

        map.forEach((k, v) -> System.out.println(k + " " + v));

//        collect(Collectors.toMap(line -> line[1], line -> Integer.parseInt(line[3])));
    }
}
