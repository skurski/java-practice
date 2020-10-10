package com.skurski.streams;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.skurski.streams.Student.STUDENTS;

public class Parallel {

    public static void threadsPeek() {
        STUDENTS.stream()
                .parallel()
                .filter(Student::isTeacher)
                .peek(s -> System.out.printf("%s : filter: %s%n", Thread.currentThread().getName(), s.getName()))
                .map(Student::getName)
                .peek(s -> System.out.printf("%s : map: %s%n", Thread.currentThread().getName(), s))
                .collect(Collectors.toList());
    }

    public static void sequential() {
        Instant start = Instant.now();

        Stream.iterate(0, n -> n + 2).limit(1000000).reduce(Integer::sum);

        Instant end = Instant.now();
        Duration d = Duration.between(start, end);
        System.out.printf("%s %d %s %n", "Measure: ", d.toMillis(), "ms in sequential mode.");
    }


    public static void parallel() {
        Instant start = Instant.now();

        Stream.iterate(0, n -> n + 2).parallel().limit(10000).reduce(Integer::sum);

        Instant end = Instant.now();
        Duration d = Duration.between(start, end);
        System.out.printf("%s %d %s %n", "Measure: ", d.toMillis(), "ms in parallel mode.");
    }

    public static void parallelGrouping() {
        ConcurrentMap<String, List<Student>> studentsByCity = STUDENTS.stream()
                .filter(Student::isTeacher)
                .collect(Collectors.groupingByConcurrent(Student::getCity));

        studentsByCity.forEach((k, v) -> System.out.println(k + " => " + v));
    }

    public static void main(String[] args) {
//        sequential();
//        parallel();

        System.out.println();
        threadsPeek();

        System.out.println();
        parallelGrouping();
    }
}
