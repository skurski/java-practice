package com.skurski.algo.recursion;

public class Boxes {

    private static class Box {
        boolean key = false;
        String name;
        Box item;

        public Box(String itemName) {
            this.name = itemName;
        }
    }

    private void findKey(Box box) {
        if (box.key == true) {
            System.out.println("Box: " + box.name
                    + " was searched and contains a key");
            return;
        }

        System.out.println("Box: " + box.name + " was searched.");
        findKey(box.item);
    }

    public static void main(String[] args) {
        Box box1 = new Box("box1");
        Box box2 = new Box("box2");
        Box box3 = new Box("box3");
        Box box4 = new Box("box4");
        Box box5 = new Box("box5");
        Box box6 = new Box("box6");
        Box box7 = new Box("box7");
        Box box8 = new Box("box8");
        Box box9 = new Box("box9");

        box1.item = box2;
        box2.item = box3;
        box3.item = box4;
        box4.item = box5;
        box5.item = box6;
        box5.key = true;
        box6.item = box7;
        box7.item = box8;
        box9.item = null;

        new Boxes().findKey(box1);
    }
}
