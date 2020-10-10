package com.skurski.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.skurski.streams.Student.STUDENTS;

public class AggregateOperations {

    public static void employeesStreamFromFile() throws IOException {
        Stream<String> lines = Files.lines(Paths.get("employees.txt"));
        Map<String, Integer> employees = lines
                .map(line -> line.split(","))
                .filter(line -> line.length == 4)
                .collect(Collectors.toMap(line -> line[1], line -> Integer.parseInt(line[3])));

        employees.forEach((k, v) -> System.out.println(k + " : " + v));

        Integer earningsSum = employees.entrySet()
                .stream()
                .map(entry -> entry.getValue())
                .reduce(0, (prev, next) -> prev + next);  // use mapToInt and sum() operations instead

        System.out.println("Sum: " + earningsSum);
    }

    public static void optionalResult() {
        Student student = new Student("Adam", true);
        Optional<Student> st1 = Optional.ofNullable(student);

        Student defaultStudent = new Student("John", false);

        String name = st1.orElse(defaultStudent).getName();
        System.out.println(name);
    }

    public static void groupingByCity() {
        Map<String, List<Student>> studentsByCity = STUDENTS.stream().collect(Collectors.groupingBy(Student::getCity));
        studentsByCity.forEach((k, v) -> System.out.println(k + ": " + v));
    }

    public static void groupingByCityAndDepartment() {
        Map<String, Map<String, List<Student>>> cityAndDepStudents =
                STUDENTS.stream()
                        .collect(Collectors.groupingBy(Student::getCity, Collectors.groupingBy(Student::getDepartment)));

        cityAndDepStudents.forEach((k, v) -> System.out.println(k + " : " + v));
    }

    public static void partitioningByTeacher() {
        Map<Boolean, List<Student>> byTeacherPartStudets = STUDENTS.stream()
                .collect(Collectors.partitioningBy(Student::isTeacher));

        byTeacherPartStudets.forEach((k, v) -> System.out.println(k + " => " + v));
    }

    public static void partitioningAndGrouping() {
        Map<Boolean, Map<String, List<Student>>> byTeacherAndCityStudents = STUDENTS.stream()
                .collect(Collectors.partitioningBy(Student::isTeacher, Collectors.groupingBy(Student::getCity)));

        byTeacherAndCityStudents.forEach((k, v) -> System.out.println(k + " => " + v));
    }

    public static void customCollector() {
        // collect students name in one string
        Supplier<StringBuilder> supplier = StringBuilder::new;
        BiConsumer<StringBuilder, Student> accumulator = (sb, stud) -> sb.append(stud.getName()).append(", ");
        BiConsumer<StringBuilder, StringBuilder> combiner = (sb1, sb2) -> sb1.append(sb2.toString());

        StringBuilder studentsName = STUDENTS.stream()
                .collect(supplier, accumulator, combiner);

        System.out.println(studentsName);
    }

    private static void moviesFlatMap() {
        HashSet<String> movies = STUDENTS.stream()
                .flatMap(student -> student.getMovies().stream())
                .collect(HashSet::new, (set, movie) -> set.add(movie), (set1, set2) -> set1.addAll(set2));

        System.out.println(movies);
    }

    private static void integers() {
        IntStream intStream = IntStream.rangeClosed(5, 15);

        OptionalInt max = intStream.max();
        System.out.println("Max: " + max.getAsInt());

        List<Integer> even = IntStream.iterate(0, i -> i + 2)
                .limit(50)
                .collect(ArrayList::new, (array, i) -> array.add(i), (ar1, ar2) -> ar1.addAll(ar2));

        even.forEach(n -> System.out.print(n + ","));
    }

    public static void main(String[] args) throws IOException {
        // FILE STREAM
        System.out.println("--- FILE STREAM ---");
        employeesStreamFromFile();

        // OPTIONAL
        System.out.println("--- OPTIONAL ---");
        optionalResult();

        // GROUPING
        System.out.println();
        System.out.println("--- GROUPING BY ---");
        groupingByCity();

        System.out.println();
        System.out.println("--- GROUPING BY ---");
        groupingByCityAndDepartment();

        // PARTITIONING
        System.out.println();
        System.out.println("--- PARTITIONING ---");
        partitioningByTeacher();

        System.out.println();
        System.out.println("--- PARTITIONING AND GROUPING ---");
        partitioningAndGrouping();

        // CUSTOM COLLECTOR
        System.out.println();
        System.out.println("--- CUSTOM COLLECTOR ---");
        customCollector();

        // FLAT MAP
        System.out.println();
        System.out.println("--- FLAT MAP ---");
        moviesFlatMap();

        System.out.println();
        integers();
    }
}
