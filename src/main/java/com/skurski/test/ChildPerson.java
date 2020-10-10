package com.skurski.test;

import java.util.List;

public class ChildPerson extends Person {

    public ChildPerson(int age, String name) {
        super(age, name);
    }

    public <T> void checkThis(List<T> list) {

    }

}
