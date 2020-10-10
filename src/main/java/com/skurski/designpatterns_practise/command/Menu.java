package com.skurski.designpatterns_practise.command;

import java.util.LinkedHashMap;
import java.util.Map;

public class Menu {

    private Map<String, Command> commands = new LinkedHashMap<>();

    public void register(String name, Command command) {
        commands.put(name, command);
    }

    public void show() {
        commands.forEach((k, v) -> v.execute());
    }
}
