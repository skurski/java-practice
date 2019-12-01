package com.skurski.collections;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ListExample {

    private static final String[] NAMES = new String[]{
            "Jarek", "Pawel", "Aga", "Piotrek", "Zoska", "Adam",
            "Monika", "Juduty", "Kaska", "Ola", "Marcin", "Sebastian",
            "Weronika", "Jan", "Halina", "Jozef", "Krzysztof", "Aureliusz"
    };

    public static void main(String[] args) {
        Stream<String> strs = Stream.of("one", "two");
        List<String> namesList = Arrays.asList(NAMES);
        strs = namesList.stream();
        Stream<String> intStream = Arrays.stream(NAMES);
    }
}
