package com.skurski.streams;

import java.util.*;

public class Student {
    private static String[] MOVIES_LIBRARY = new String[]{
            "Siedem", "Harry Potter", "Zly", "Smerfy", "Psy", "South Park", "Symetria", "Ocaleni", "Godfather"
    };

    public static List<Student> STUDENTS = Arrays.asList(
            new Student("Peter", true, "Finance", "Cracow"),
            new Student("John", false, "Finance", "Cracow"),
            new Student("Weronika", false, "Finance", "London"),
            new Student("Angelika", true, "Finance", "London"),
            new Student("Kaska", true, "IT", "London"),
            new Student("Olga", true, "IT", "New York"),
            new Student("Monika", true, "IT", "New York"),
            new Student("Aga", true, "IT", "New York"),
            new Student("Patrycja", true, "Strategy", "New York"),
            new Student("Damian", true, "Strategy", "Baghdad"),
            new Student("Grzegorz", true, "Strategy", "Baghdad")
    );

    private String name;
    private boolean teacher;
    private String department;
    private String city;
    private List<String> movies = new ArrayList<>();

    public Student(String name, boolean teacher) {
        this.name = name;
        this.teacher = teacher;
    }

    public Student(String name, boolean teacher, String department, String city) {
        this.name = name;
        this.teacher = teacher;
        this.department = department;
        this.city = city;

        Random random = new Random();
        movies.add(MOVIES_LIBRARY[random.nextInt(MOVIES_LIBRARY.length - 1)]);
        movies.add(MOVIES_LIBRARY[random.nextInt(MOVIES_LIBRARY.length - 1)]);
        movies.add(MOVIES_LIBRARY[random.nextInt(MOVIES_LIBRARY.length - 1)]);
    }

    public String getName() {
        return name;
    }

    public boolean isTeacher() {
        return teacher;
    }

    public String getDepartment() {
        return department;
    }

    public String getCity() {
        return city;
    }

    public List<String> getMovies() {
        return movies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return teacher == student.teacher &&
                name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, teacher);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", teacher=" + teacher +
                ", department='" + department + '\'' +
                ", city='" + city + '\'' +
                ", movies=" + movies +
                '}';
    }
}

